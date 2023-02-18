package geometry;

import java.util.ArrayList;
import java.util.List;

public class Ellipse extends Shape {
    protected Point a; //фокус 1
    protected Point b; //фокус 2 
    protected double dist; //перифокусное расстояние

    public Ellipse(Point a, Point b, double dist){
        this.a = a;
        this.b = b;
        this.dist = dist;
    }

    @Override
    public Point center() {
        return new Point((a.getX() + b.getX())/2, (a.getY() +b.getY())/2);
    }
    
    public double focalDistance () { return Point.distance(this.a, this.b)/2; } //фокальное расстояние
    public double majorSemiAxis () { return focalDistance() + this.dist; }//большая полуось
    public double minorSemiAxis () { 
        double biga = this.majorSemiAxis();
        double c = this.focalDistance();
        return Math.sqrt(biga * biga - c * c);
     } // малая полуось
    
    @Override
    public double perimeter() {
        double major = majorSemiAxis();
        double minor = minorSemiAxis();
        return 4 * (Math.PI*major*minor + (major - minor)*(major - minor)) / (major + minor);
    }

    @Override
    public double area(){
        return Math.PI * majorSemiAxis() * minorSemiAxis();
    }

    @Override
    public void translate (final Point newCenter) {
        Point cnt = this.center();
        double distX = newCenter.getX() - cnt.getX();
        double distY = newCenter.getY() - cnt.getY();
        this.a = new Point(a.getX() + distX, a.getY() + distY);
        this.b = new Point(b.getX() + distX, b.getY() + distY);
    }

    @Override
    public void rotate (final double angle) {
        Point cnt = center();
        this.a = this.a.subtract(cnt).rotate(angle).add(cnt);
        this.b = this.b.subtract(cnt).rotate(angle).add(cnt);
    }

    @Override
    public void scale (final double coefficient) {
        double coeffAbs = Math.abs(coefficient);
        Point cnt = center();
        
        this.a = new Point(
                (a.getX() - cnt.getX()) * coefficient + cnt.getX(), 
                (a.getY() - cnt.getY()) * coefficient + cnt.getY());

        this.b = new Point(
            (b.getX() - cnt.getX()) * coefficient + cnt.getX(), 
            (b.getY() - cnt.getY()) * coefficient + cnt.getY());
        
        this.dist = dist * coeffAbs;
    }

    public List<Point> focuses(){
        List<Point> result = new ArrayList<Point>();
        result.add(a);
        result.add(b);
        return result;
     }

    public double eccentricity(){
        return focalDistance()/majorSemiAxis();
    }

}
