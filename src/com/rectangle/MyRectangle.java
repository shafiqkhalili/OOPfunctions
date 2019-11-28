package com.rectangle;

public class MyRectangle {
    private Point size;
    private Point position;

    public MyRectangle() {
    }

    /**
     * @param size
     * @param position
     */
    public MyRectangle(Point position, Point size) {
        this.size = size;
        this.position = position;
    }

    public double calculateArea() {
        return position.getX() * position.getY();
    }

    public double calculatePerimeter() {
        return (size.getX() * 2) + (size.getY() * 2);
    }

    public Point getSize() {
        return size;
    }

    public void setSize(Point size) {
        this.size = size;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "MyRectangle{" +
                "size=" + size +
                ", position=" + position +
                '}';
    }

    private Point getBottomRight() {
        double x = position.getX() + size.getX();
        double y = position.getY() - size.getY();

        return new Point(x,y);
    }

    public boolean checkCollision(MyRectangle rct) {
        Point topLeft1 = this.position;
        Point topLeft2 = rct.position;
        Point bottomRight1 = this.getBottomRight();
        Point bottomRight2 = rct.getBottomRight();

        //is one rectangle left of the other
        if (bottomRight1.getX() < topLeft2.getX()){
            return false;
        }
        if (bottomRight2.getX() <topLeft1.getX()){
            return  false;
        }

        //If one rectangle is above the other
        if (bottomRight1.getY() > topLeft2.getY()){
            return  false;
        }
        if (bottomRight2.getY() > topLeft1.getY()){
            return  false;
        }
        return true;
    }

    public boolean checkCollision2(MyRectangle rct) {
        /**
         int R1TopRightY = (int)rctngl1.y;
         int R1BottomLeftY =  (int)(rctngl1.y-rctngl1.height);
         int R1TopRightX = (int)Double.sum(rctngl1.x,rctngl1.width);
         int R1BottomLeftX = (int)rctngl1.x;

         int R2TopRightY = (int)rct.y;
         int R2BottomLeftY = (int)(rct.y-rct.height);
         int R2TopRightX = (int)Double.sum(rct.x,rct.width);
         int R2BottomLeftX = (int)rct.x;

         if (R1TopRightY < R2BottomLeftY || R1BottomLeftY > R2TopRightY) {
         return false;
         }
         if (R1TopRightX < R2BottomLeftX || R1BottomLeftX > R2TopRightX) {
         return false;
         }
         **/

        int R1TopRightX = (int) Double.sum(this.position.getX(), this.size.getX());
        int R1TopLeftX = (int) this.position.getX();
        int R1TopLeftY = (int) this.position.getY();
        int R1BottomLeftY = (int) (this.position.getY() - this.size.getY());

        int R2TopRightX = (int) Double.sum(rct.position.getX(), rct.size.getX());
        int R2TopLeftX = (int) rct.position.getX();
        int R2TopLeftY = (int) rct.position.getY();
        int R2BottomLeftY = (int) (rct.position.getY() - rct.size.getY());

        if (R1TopRightX < R2TopRightX && R1TopRightX > R2TopLeftX &&
                R1TopLeftY < R2TopLeftY && R1TopLeftY > R2BottomLeftY) {
            return true;
        }
        if (R1TopLeftX < R2TopRightX && R1TopLeftX > R2TopLeftX &&
                R1TopLeftY < R2TopLeftY && R1TopLeftY > R2BottomLeftY) {
            return true;
        }

        return false;
    }

}
