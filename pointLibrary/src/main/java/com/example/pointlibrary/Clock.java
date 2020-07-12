package com.example.pointlibrary;

public interface Clock {
    double getCurrentTime();
    void reset();
    void setTime(long time);
}
