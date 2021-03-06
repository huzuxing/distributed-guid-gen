package com.id.generate.factory;

import com.id.generate.service.GuidGenService;
import com.id.generate.service.impl.GuidGenServiceImpl;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class GuidGenServiceFactory {

    private GuidGenServiceFactory() {
        throw new UnsupportedOperationException("could not init the class, it is single mode");
    }

    private static final GuidGenService genService = GuidGenServiceImpl.getGuidGenService();

    public static GuidGenService idService() {
        return genService;
    }
}
