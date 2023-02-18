package geometry;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Shape {
    protected Point A;
    protected Point B;
    protected double secondside;

    public Rectangle(Point a, Point b, double number){
        this.A = a;
        this.B = b;
        this.secondside = number;
    }

    @Override
    public Point center() {
        return new Point((A.getX()+B.getX())/2, (A.getY()+B.getY())/2);
    }

    @Override
    public double perimeter() {
        return 2*secondside + 2*Point.distance(A, B);
    }

    @Override
    public double area(){
        return secondside*Point.distance(A, B);
    }

    @Override
    public void translate(final Point newCenter){
        double distX = newCenter.getX() - this.center().getX();
        double distY = newCenter.getY() - this.center().getY();
        this.A = new Point(A.getX()+distX, A.getY()+distY);
        this.B = new Point(B.getX()+distX, B.getY()+distY);
        
    }

    @Override
    public void rotate(final double angle){
        Point cnt = center();
        this.A = this.A.subtract(cnt).rotate(angle).add(cnt);
        this.B = this.B.subtract(cnt).rotate(angle).add(cnt);
    }

    @Override
    public void scale (final double coefficient){
        this.secondside = secondside * Math.abs(coefficient);
        Point cnt = center();
        
        this.A = this.A.subtract(cnt).multiply(coefficient).add(cnt);
        this.B = this.B.subtract(cnt).multiply(coefficient).add(cnt);
    }

    public List<Point> vertices(){
        double angle  = Math.atan((A.getY() - B.getY()) / (A.getX()-B.getX()));
        // Point center = this.center();
        double h = this.secondside / 2;
        Point C = A.add(new Point(-h*Math.sin(angle), h*Math.cos(angle)));
        Point D = B.add(new Point(-h*Math.sin(angle), h*Math.cos(angle)));
        Point E = B.add(new Point(h*Math.sin(angle), -h*Math.cos(angle)));
        Point F = A.add(new Point(h*Math.sin(angle), -h*Math.cos(angle)));
        
        List<Point> result = new ArrayList<Point>();
        if (A.getX() >= B.getX()) {
            result.add(C);
            result.add(D);
            result.add(E);
            result.add(F);
        } else {
            result.add(F);
            result.add(E);
            result.add(D);
            result.add(C);
        }
        
        return result;
        
    }

    public double firstSide (){
        return Point.distance(A, B);
    }

    public double secondSide (){
        return this.secondside;
    }

    public double diagonal (){
        return Math.sqrt(Point.distance(A, B)*Point.distance(A, B) + secondside*secondside);
    }
}
