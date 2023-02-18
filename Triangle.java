package geometry;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape {
    private Point A;
    private Point B;
    private Point C;

    public Triangle(Point a, Point b, Point c){
        this.A = a;
        this.B = b;
        this.C = c;
    }

    @Override
    public Point center() {
        return new Point((A.getX()+B.getX()+C.getX())/3, (A.getY()+B.getY()+C.getY())/3);
    }

    @Override
    public double perimeter() {
        return Point.distance(A, B) + Point.distance(B, C) + Point.distance(C, A);
    }

    @Override
    public double area(){
        double p = this.perimeter()/2;
        double sidea = Point.distance(A, B);
        double sideb = Point.distance(B, C);
        double sidec = Point.distance(C, A);
        return Math.sqrt(p*(p-sidea)*(p-sideb)*(p-sidec)); //формула Герона
    }

    @Override
    public void translate(final Point newCenter){
        double distX = newCenter.getX() - this.center().getX();
        double distY = newCenter.getY() - this.center().getY();
        this.A = new Point(A.getX()+distX, A.getY()+distY);
        this.B = new Point(B.getX()+distX, B.getY()+distY);
        this.C = new Point(C.getX()+distX, C.getY()+distY);
        
        
    }

    @Override
    public void rotate(final double angle){
        Point cnt = center();
        
        this.A = A.subtract(cnt).rotate(angle).add(cnt);
        this.B = B.subtract(cnt).rotate(angle).add(cnt);
        this.C = C.subtract(cnt).rotate(angle).add(cnt);
    }

    @Override
    public void scale (final double coefficient){
        Point cnt = center();
        
        this.A = A.subtract(cnt).multiply(coefficient).add(cnt);
        this.B = B.subtract(cnt).multiply(coefficient).add(cnt);
        this.C = C.subtract(cnt).multiply(coefficient).add(cnt);
    }

    public List<Point> vertices(){
        List<Point> result = new ArrayList<Point>();
        result.add(A);
        result.add(B);
        result.add(C);
        return result;
    }

    public Circle circumscribedCircle() {
        double radius = Point.distance(A, B)*Point.distance(B, C)*Point.distance(C, A)/4/this.area(); //abc/4S
        double D = 2*(A.getX()*(B.getY() - C.getY()) + B.getX()*(C.getY()-A.getY()) + C.getX()*(A.getY()-B.getY()));
        
        double a = (
            (A.getY()-B.getY())*(C.getX()*C.getX()+C.getY()*C.getY()) + 
            (B.getY()-C.getY())*(A.getX()*A.getX()+A.getY()*A.getY()) + 
            (C.getY()-A.getY())*(B.getX()*B.getX()+B.getY()*B.getY())
        )/D;
        
        double b = (
            (B.getX()-A.getX())*(C.getX()*C.getX()+C.getY()*C.getY()) + 
            (C.getX()-B.getX())*(A.getX()*A.getX()+A.getY()*A.getY()) + 
            (A.getX()-C.getX())*(B.getX()*B.getX()+B.getY()*B.getY())
        )/D;
        
        Point center  = new Point(a,b);
        Circle result = new Circle(center, radius);
        return result;
    }

    public Circle inscribedCircle(){
        double radius = 2*this.area()/this.perimeter();
        double x = (Point.distance(A, B)*C.getX()+Point.distance(B, C)*A.getX()+
        Point.distance(C, A)*B.getX())/(Point.distance(A, B)+
        Point.distance(B, C)+Point.distance(C, A));
        double y = (Point.distance(A, B)*C.getY()+Point.distance(B, C)*A.getY()+
        Point.distance(C, A)*B.getY())/(Point.distance(A, B)+
        Point.distance(B, C)+Point.distance(C, A));
        Point center = new Point(x,y);
        Circle result = new Circle(center, radius);
        return result;
    }

    public Point orthocenter(){
        double ma = (A.getY()-B.getY())/(A.getX()-B.getX());
        double mb = (A.getY()-C.getY())/(A.getX()-C.getX());
        double m1 = -1/ma;
        double m2 = -1/mb;
        double heightlineAB = C.getY() - m1*C.getX();
        double heightlineAC = B.getY() - m2*B.getX();
        double x = (heightlineAB - heightlineAC)/(m2-m1);
        double y = m1*x + heightlineAB;
        Point orthocenter = new Point(x, y);
        return orthocenter;
    }

    public Circle ninePointsCircle(){
        double x = (this.circumscribedCircle().center().getX() + this.orthocenter().getX())/2;
        double y = (this.circumscribedCircle().center().getY() + this.orthocenter().getY())/2;
        Point center = new Point(x, y);
        double radius = Point.distance(A, B)*Point.distance(B, C)*Point.distance(C, A)/8/this.area();
        Circle result = new Circle(center, radius);
        return result;
    }
}
