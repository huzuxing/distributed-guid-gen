package com.id.generate.entity;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class GuidMeta {

    private long machineBits;

    private long sequenceBits;

    private long timeBits;

    public GuidMeta(long machineBits, long sequenceBits, long timeBits) {
        super();
        this.machineBits = machineBits;
        this.sequenceBits = sequenceBits;
        this.timeBits = timeBits;
    }

    public long getMachineBits() {
        return machineBits;
    }

    public void setMachineBits(long machineBits) {
        this.machineBits = machineBits;
    }

    public long getSequenceBits() {
        return sequenceBits;
    }

    public void setSequenceBits(long sequenceBits) {
        this.sequenceBits = sequenceBits;
    }

    public long getTimeBits() {
        return timeBits;
    }

    public void setTimeBits(long timeBits) {
        this.timeBits = timeBits;
    }

    public long getSequenceBitsStartPos() {
        return machineBits;
    }
    public long getTimeBitsStartPos() {
        return machineBits + sequenceBits;
    }

    public long getMachineIdBitMask() {
        return -1l^(-1l << machineBits);
    }

    public long getSequenceBitMask() {
        return -1l^(-1l << sequenceBits);
    }

    public long getTimeBitMask() {
        return -1l^(-1l << timeBits);
    }
}
