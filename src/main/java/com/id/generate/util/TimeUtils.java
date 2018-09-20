package com.id.generate.util;

import java.time.Instant;

/**
 * Created by huzuxing on 2018/9/20.
 */
public class TimeUtils {

    public static final long TWEPOCH = 1537459078000l;

    public static long getTime() {

        return Instant.now().toEpochMilli() - TimeUtils.TWEPOCH;
    }

    public static void valideTimestamp(long lastTimestamp, long timestamp) {
        if (timestamp < lastTimestamp) {
            throw new IllegalStateException(String.format("time goes backforward, refused to generate guid for %d milisecond", (timestamp - lastTimestamp)));
        }
    }

    public static long tillNextTime(long lastTimestamp) {

        long timestamp = getTime();
        while (timestamp <= lastTimestamp) {
            timestamp = getTime();
        }
        return timestamp;
    }
}
