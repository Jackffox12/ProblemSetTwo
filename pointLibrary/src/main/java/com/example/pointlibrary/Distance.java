package com.example.pointlibrary;

public class Distance {

    private Point firstpoint;
    private Point point;
    public Distance(Point firstpoint){
            this.firstpoint = firstpoint;
    }

    public double distanceToPoint(Point other) {
        double point1x = firstpoint.getX();
        double point1y = firstpoint.getY();
        double point2x = other.getX();
        double point2y = other.getY();
        double distance = Math.sqrt(Math.pow(point1x - point2x, 2) + Math.pow(point1y - point2y, 2));
        return distance;
    }

    public Point closestPoint(Point[] points) {
        double point1x = firstpoint.getX();
        double point1y = firstpoint.getY();
        Point smalldis = points[0];
        for (int i = 0; i < points.length; i++) {
            double point2x = points[i].getX();
            double point2y = points[i].getY();
            double lastpoint2x = points[i + 1].getX();
            double lastpoint2y = points[i + 1].getY();
            double distance = Math.sqrt(Math.pow(point1x - point2x, 2) + Math.pow(point1y - point2y, 2));
            double lastdistance = Math.sqrt(Math.pow(point1x - lastpoint2x, 2) + Math.pow(point1y - lastpoint2y, 2));
            if (distance < lastdistance) {
                return points[i];
            } else {
                 return points[i + 1];
            }

        }


    }

    public static double doubleBetweenTwoPoints(Point a, Point b){

        double point1x = a.getX();
        double point1y = a.getY();
        double point2x = b.getX();
        double point2y = b.getY();
        double distance = Math.sqrt(Math.pow(point1x - point2x, 2) + Math.pow(point1y - point2y, 2));
        return distance;
    }

    public static Point midPoint(Point a, Point b){
        double point1x = a.getX();
        double point1y = a.getY();
        double point2x = b.getX();
        double point2y = b.getY();
        double xpoint = ((point1x + point2x)/2);
        double ypoint = ((point1y + point2y)/2);

        Point finalMidPoint = new Point(xpoint, ypoint);
        return finalMidPoint;



    }



}



