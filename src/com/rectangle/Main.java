package com.rectangle;

public class Main {
    public static void main(String[] args) {
        Point pos = new Point(-1, 1);
        Point size = new Point(3, 4);

        MyRectangle rcl1 = new MyRectangle( pos,size);
        MyRectangle rcl2 = new MyRectangle(new Point(0,3),new Point(3,3));

        System.out.println(rcl1.checkCollision(rcl2));

    }
}
