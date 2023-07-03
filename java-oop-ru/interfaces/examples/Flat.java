package exercise;

public class Flat implements Home {
    private double area;
    private int floor;
    private double balconyArea;
    public Flat(double area,double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public String nameOfObj() {
        return "Flat";
    }

    @Override
    public double getArea(double area, double balconyArea) {
        return area * balconyArea;
    }

    @Override
    public int compareTo(Home anotherObj) {
        return 1;
    }

    @Override
    public String toString() {
        return "s";
    }
}
