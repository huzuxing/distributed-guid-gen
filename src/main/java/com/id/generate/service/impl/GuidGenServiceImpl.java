package com.id.generate.service.impl;

import com.id.generate.convertor.GuidConvertor;
import com.id.generate.convertor.GuidConvertorImpl;
import com.id.generate.entity.Guid;
import com.id.generate.entity.GuidMeta;
import com.id.generate.entity.MachineIdProviderType;
import com.id.generate.service.GuidGenService;
import com.id.generate.util.PropertyUtils;
import com.id.generate.util.TimeUtils;

import javax.annotation.PostConstruct;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class GuidGenServiceImpl implements GuidGenService {

    private long sequence = -1l;

    private long lastTimeStamp = -1l;

    private GuidConvertor guidConvertor;

    private GuidMeta guidMeta;

    private ReentrantLock lock = new ReentrantLock();

    public GuidGenServiceImpl() {
        init();
    }

    public void init() {
        guidConvertor = new GuidConvertorImpl();
        guidMeta = new GuidMeta(10, 12, 40);
        machineIdProviderType = Integer.valueOf(PropertyUtils.get("machineIdProviderType"));
        switch (machineIdProviderType) {
            case 0:
                this.machineId = Integer.valueOf(PropertyUtils.get("machineId"));
                break;
            case 1:
                break;
        }
    }


    public long genGuid() throws Exception {
        Guid guid = new Guid();
        guid.setMachine(machineId);
        try {
            lock.lock();
            long timestamp = TimeUtils.getTime();
            TimeUtils.valideTimestamp(lastTimeStamp, timestamp);
            if (timestamp == lastTimeStamp) {
                sequence = (sequence + 1) & guidMeta.getSequenceBits();
                if (0 == sequence) {
                    timestamp = TimeUtils.tillNextTime(lastTimeStamp);
                }
            }
            else {
                sequence = 0;
            }
            lastTimeStamp = timestamp;
            guid.setSequence(sequence);
            guid.setTime(timestamp);
            return guidConvertor.convert(guid, guidMeta);
        } catch (Exception e) {
            throw new Exception(e);
        } finally {
            if (lock.isLocked()) {
                lock.unlock();
            }
        }
    }

    public Guid expGuid(long id) {
        return guidConvertor.reconvert(id, guidMeta);
    }

    private int machineIdProviderType;

    private long machineId;

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
