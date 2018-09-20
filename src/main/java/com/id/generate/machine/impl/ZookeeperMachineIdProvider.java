package com.id.generate.machine.impl;

import com.id.generate.machine.MachineIdProvider;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class ZookeeperMachineIdProvider implements MachineIdProvider {

    private long machineId;

    public long getMachineId() {
        return 0;
    }

    public void setMachineId(long machineId) {
        this.machineId = machineId;
    }
}
