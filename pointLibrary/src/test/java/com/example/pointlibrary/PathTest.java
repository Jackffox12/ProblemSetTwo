package com.example.pointlibrary;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void length() {
        Point[] points = new Point[] {new Point(0,0), new Point(3,4)};
        Path path = new Path(points);
        assertEquals(5, Path.totalDistance(), 0.00001);

    }

    @Test
    public void setTarget() {
    }
}