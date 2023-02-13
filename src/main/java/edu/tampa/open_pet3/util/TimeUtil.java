package edu.tampa.open_pet3.util;

import java.time.LocalTime;

public class TimeUtil {
    public static boolean isBetween(LocalTime lt, LocalTime startTime, LocalTime endTime){
          return lt.compareTo(startTime)>=0&&lt.compareTo(endTime)<=0;
    }
}
