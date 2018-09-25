package com.id.generate.service;

import com.id.generate.entity.Guid;

/**
 * Created by huzuxing on 2018/9/20.
 */
public interface GuidGenService {

    long genGuid() throws Exception;

    Guid expGuid(long id);
}
