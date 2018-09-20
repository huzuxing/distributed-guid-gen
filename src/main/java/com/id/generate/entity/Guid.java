package com.id.generate.entity;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class Guid implements java.io.Serializable{

    private static final long serialVersionUID = -1171341852822032556L;

    private long machine;

    private long sequence;

    private long time;

    public Guid(long machine, long sequence, long time) {
        super();
        this.machine = machine;
        this.sequence = sequence;
        this.time = time;
    }

    public Guid() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public long getMachine() {
        return machine;
    }

    public void setMachine(long machine) {
        this.machine = machine;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Guid{" +
                "machine=" + machine +
                ", sequence=" + sequence +
                ", time=" + time +
                '}';
    }
}
