package exercise;

public class Segment {
    private Point point1;
    private Point point2;

    public Segment(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
    }

    public Point getBeginPoint() {
        return point1;
    }

    public Point getEndPoint() {
        return point2;
    }

    public Point getMidPoint() {
        int midX = (point1.getX() + point2.getX()) / 2;
        int midY = (point1.getY() + point2.getY()) / 2;
        return new Point(midX, midY);
    }

    @Override
    public String toString() {
        return "Segment{"
                + "point1="
                + point1
                + ", point2="
                + point2
                + '}';
    }
}

