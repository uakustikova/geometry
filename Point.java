package geometry;

public class Point {
    private final double x;
    private final double y;

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){ return x;}
    public double getY(){ return y;}

    public double x(){ return x;}
    public double y(){ return y;}

    @Override
    public String toString(){ return "(" + x + " ," + y + ")";}

    public Point add(Point a) {
        return new Point(this.x + a.x, this.y + a.y);
    }

    public Point subtract(Point a){
        return new Point(this.x - a.x, this.y - a.y);
    }

    public Point multiply(double a) {
        return new Point(this.x * a, this.y * a);
    }

    public Point divide(double a){
        if (a==0){throw new ArithmeticException();}
        return new Point(this.x / a, this.y / a);
    }

    public Point rotate(double a) {
        double cs = Math.cos(a);
        double sn = Math.sin(a);
        double rx = this.x*cs - this.y*sn;
        double ry = this.x*sn + this.y*cs;
        return new Point(rx, ry);
    }

    public double length(){
        return Math.sqrt(this.x*this.x + this.y*this.y);
    }

    public static double dotProduct(Point a, Point b){
        return a.x * b.x + a.y * b.y;
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }


}
