package exercise;

import java.util.List;

public class Cottage implements Home {
     private double area;
     private int floorСount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorСount = floorCount;
    }

    @Override
    public String nameOfObj() {
        return "Cottage";
    }

    @Override
    public double getArea(double area,double balconyArea) {
        return area * balconyArea;
    }

    @Override
    public int compareTo(Home anotherObj) {
        return 1;
    }


}
