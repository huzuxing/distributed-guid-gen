package com.id.generate.convertor;

import com.id.generate.entity.Guid;
import com.id.generate.entity.GuidMeta;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class GuidConvertorImpl implements GuidConvertor {

    public long convert(Guid guid, GuidMeta guidMeta) {

        long ret = 0;

        ret |= guid.getSequence();

        ret |= guid.getMachine() << guidMeta.getMachineBitsStartPos();

        ret |= guid.getTime() << guidMeta.getTimeBitsStartPos();

        return ret;
    }

    public Guid reconvert(long guid, GuidMeta guidMeta) {

        Guid ret = new Guid();

        ret.setSequence(guid & guidMeta.getSequenceBitMask());

        ret.setMachine(guid >>> guidMeta.getMachineBitsStartPos() & guidMeta.getMachineIdBitMask());

        ret.setTime(guid >>> guidMeta.getTimeBitsStartPos() & guidMeta.getTimeBitMask());

        return ret;
    }
}
