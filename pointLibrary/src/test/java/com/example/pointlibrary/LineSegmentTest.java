package com.example.pointlibrary;

import org.junit.Test;

import static org.junit.Assert.*;

public class LineSegmentTest {

    public void interpolate(){
        LineSegment ls = new LineSegment(new Point(1,1), new Point(4,5));
        Point actualPoint = ls.interpolate(5);
        Point expectedPoint = new Point(4,5);
        assertEquals(expectedPoint.getX(), actualPoint.getY(), 0.0000001);


    }

    @Test
    public void testInterpolate() {
        LineSegment ls = new LineSegment(new Point(1,1), new Point(4,5));
        Point actualPoint = ls.interpolate(1);
        Point expectedPoint = new Point(4,5);
        assertEquals(expectedPoint.getX(), actualPoint.getY(), 0.0000001);
    }
}