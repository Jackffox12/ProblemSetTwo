package com.example.pointlibrary;

import org.junit.Test;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void totalDistance() {
        Point[] points = new Point[] {new Point(0,0), new Point(10,10), new Point(3,4)};
        Path path = new Path(points);
        assertEquals(23.361680081023838, path.totalDistance(), 0.00001);

    }

    @Test
    public void targetPoint() {
        //Testing for points when position of wayPoints aren't straight
        //Testing for points when position of wayPoints is straight

        Point distancePoint4 = new Point(0,0);
        Point[] points4 = new Point[] {new Point(2,0), new Point(2,1), new Point (3,2), new Point (4,4)};
        Path path4 = new Path(points4);
        Path.WayPoint wayPoint4 = path4.targetPoint(distancePoint4, 1);
        Point expected4 = new Point(4.0,20.0);
        assertEquals(expected4, wayPoint4.point);

        Point distancePoint3 = new Point(2,2);
        Point[] points3 = new Point[] {new Point(0,0), new Point(1,3), new Point (5,4), new Point(4,8), new Point (0,9)};
        Path path3 = new Path(points3);
        Path.WayPoint wayPoint3 = path3.targetPoint(distancePoint3, 6);
        Point expected3 = new Point(4.37,6.53);
        assertEquals(expected3, wayPoint3.point);


        //Testing for points when the distance doesn't reach the first waypoint.
        Point distancePoint2 = new Point(0,0);
        Point[] points2 = new Point[] {new Point(1,1), new Point(2,2), new Point (3,3)};
        Path path2 = new Path(points2);
        Path.WayPoint wayPoint2 = path2.targetPoint(distancePoint2, 0);
        Point expected2 = new Point(1,1);
        assertEquals(expected2, wayPoint2.point);

        //Testing for points when distance exceeds the position of the last waypoint.
        Point distancePoint1 = new Point(1,1);
        Point[] points = new Point[] {new Point(1,1), new Point(2,2), new Point (3,3)};
        Path path = new Path(points);
        Path.WayPoint wayPoint = path.targetPoint(distancePoint1, 10);
        Point expected = new Point(3,3);
        assertEquals(expected, wayPoint.point);





    }
}