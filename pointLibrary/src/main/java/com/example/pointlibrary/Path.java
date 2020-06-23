package com.example.pointlibrary;

public class Path {

    private static Point[] newPoints;


    public Path(Point[] rawPoints) {
        newPoints = new Point[rawPoints.length];
        for(int i = 0; i<rawPoints.length; i++){
                newPoints[i] = rawPoints[i];
        }

    }

    public static class WayPoint {
        public WayPoint(Point point) {
        }
    }

    /**
     * @return the total length of the path
     */
    public static double totalDistance() {
        double totalDistance = 0;
        for(int i = 0; i<newPoints.length; i++){
            if(i+1>newPoints.length-1){
                break;
            }
            else {
                double point1x = newPoints[i].getX();
                double point1y = newPoints[i].getY();
                double point2x = newPoints[i + 1].getX();
                double point2y = newPoints[i + 1].getY();
                double distance = Math.sqrt(Math.pow(point1x - point2x, 2) + Math.pow(point1y - point2y, 2));
                totalDistance += distance;
            }
        }
        return totalDistance;
    }

    /**
     * @return the closest point to the supplied target point that lies on the path.
     * Note that the closest point will usually be interpolated between the points that originally defined the Path
     */
    public Path.WayPoint setTarget(double distance, Point postion){
        double postionx = postion.getX();
        double postiony = postion.getY();
        int counter = 0;
        int closest = 0;
        for(int i = 0; i<newPoints.length; i++) {
            if(i+1>newPoints.length-1){
                break;
            }
            else {

                double newDistance1 = Math.sqrt(Math.pow(postionx - newPoints[i].getX(), 2) + Math.pow(postiony - newPoints[i].getY(), 2));
                double newDistance2 = Math.sqrt(Math.pow(postionx - newPoints[i + 1].getX(), 2) + Math.pow(postiony - newPoints[i + 1].getY(), 2));
                double trueDistance1 = distance - newDistance1;
                double trueDistance2 = distance - newDistance2;
                
                if (trueDistance1 < trueDistance2) {
                    closest = i;
                } else {
                    closest = i + 1;

                }
            }
        }
        return new WayPoint(new Point(newPoints[closest].getX(),newPoints[closest].getY()));




    }

   
}

  //  }


