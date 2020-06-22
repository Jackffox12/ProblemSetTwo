package com.example.pointlibrary;

public class Main {
    public static void main(String[] args){
        System.out.println("My name is Jack Fox.");
        Point a = new Point(1,2);
        System.out.println(a.getX());
        System.out.println(a.distanceFromOrgin());
        System.out.println(a.getQuadrant());


        Point point1 = new Point(0,0);
        Point point2 = new Point(0,0);
        LineSegment lineSegment = new LineSegment(point1,point2);
        Point[] pointsActual = lineSegment.subDivide(5);
        for(int i = 0; i<pointsActual.length; i++){
            System.out.println(pointsActual[i]);
        }

    }
}