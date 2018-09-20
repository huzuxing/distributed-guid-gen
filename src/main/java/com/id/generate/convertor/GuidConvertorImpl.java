package com.id.generate.convertor;

import com.id.generate.entity.Guid;
import com.id.generate.entity.GuidMeta;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class GuidConvertorImpl implements GuidConvertor {
    public long convert(Guid guid, GuidMeta guidMeta) {

        long ret = 0;

        ret |= guid.getMachine();

        ret |= guid.getSequence() << guidMeta.getSequenceBitsStartPos();

        ret |= guid.getTime() << guidMeta.getTimeBitsStartPos();

        return ret;
    }

    public Guid reconvert(long guid, GuidMeta guidMeta) {

        Guid ret = new Guid();

        ret.setMachine(guid & guidMeta.getMachineIdBitMask());

        ret.setSequence(guid >>> guidMeta.getSequenceBitsStartPos() & guidMeta.getSequenceBitMask());

        ret.setTime(guid >>> guidMeta.getTimeBitsStartPos() & guidMeta.getTimeBitMask());

        return ret;
    }
}
