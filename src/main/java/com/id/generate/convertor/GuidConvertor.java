package com.id.generate.convertor;

import com.id.generate.entity.Guid;
import com.id.generate.entity.GuidMeta;

/**
 * Created by huzuxing on 2018/9/20.
 */
public interface GuidConvertor {

    long convert(Guid guid, GuidMeta guidMeta);

    Guid reconvert(long guid, GuidMeta guidMeta);
}
