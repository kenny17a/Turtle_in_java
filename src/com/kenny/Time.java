package com.kenny;

public class Time {
    private int minute;
    private int second;
    private int hour;

    public Time(int minute, int second, int hour){

        validate(minute, second, hour);
        this.minute = minute;
        this.second = second;
        this.hour = hour;

    }

    private static void validate(int minute, int second, int hour) {
        validateSecond(second);
        validateMinute(minute);
        validateHour(hour);

    }


    public void setSecond(int second) {
        validateSecond(second);
        this.second = second;
    }


    public static void validateSecond(int second){
        //validate seconds
        if(second < 0 || second > 59) throw new IllegalArgumentException
                (String.format("Second entered is %s, pls enter btw 0 & 59", second) );

    }

    public void setMinute(int minute) {
        validateMinute(minute);
        this.minute = minute;
    }
    private static void validateMinute(int minute) {
        //validate minute
        if(minute < 0 || minute > 59) throw new IllegalArgumentException
                (String.format("Second entered is %s, pls enter btw 0 & 59", minute) );
    }

    public void setHour(int hour) {
        validateHour(hour);
        this.hour = hour;
    }
    private static void validateHour(int hour) {
        //validate hour
        if(hour < 0 || hour > 23) throw new IllegalArgumentException
                (String.format("Hour entered is %s, pls enter btw 0 & 59", hour) );
    }
}
