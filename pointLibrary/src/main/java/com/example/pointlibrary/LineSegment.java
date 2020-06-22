package com.example.pointlibrary;

public class LineSegment {
    private Point point1;
    private Point point2;

    public LineSegment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public Point[] subDivide(int subSegments) {
        Point[] pointsExpected = new Point[subSegments - 1];
        double point1x = point1.getX();
        double point1y = point1.getY();
        double point2x = point2.getX();
        double point2y = point2.getY();
        double counter = 1;
        double xDist = point2x - point1x;
        double yDist = point2y - point1y;
        for (int i = 0; i < subSegments-1; i++) {
            double xpoint = (point1x + (counter / subSegments) * xDist);
            double ypoint = (point1y + (counter / subSegments) * yDist);

            pointsExpected[i]=new Point(xpoint,ypoint);
            counter++;
        }
        return pointsExpected;
    }





}
