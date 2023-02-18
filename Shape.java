package geometry;

public abstract class Shape {
    
    public abstract Point center();
    public abstract double perimeter ();
    public abstract double area ();

    public abstract void translate (final Point newCenter);
    public abstract void rotate (final double angle);
    public abstract void scale (final double coefficient);

}
