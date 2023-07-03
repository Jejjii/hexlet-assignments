package exercise;

import java.util.List;

public class Cottage implements Home {
    private double area;
    private int floorСount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorСount = floorCount;
    }

    public int getFloorСount() {
        return floorСount;
    }

    @Override
    public String nameOfObj() {
        return "Cottage";
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home anotherObj) {
        if (this.getArea() < anotherObj.getArea()) {
            return -1;
        } else if (this.getArea() == anotherObj.getArea()) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return getFloorСount() + " этажный коттедж площадью " + getArea() + " метров";
    }



}
