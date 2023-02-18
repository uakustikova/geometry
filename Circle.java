package geometry;


public class Circle extends Ellipse {

    public Circle(Point center, double radius){
        super(center, center, radius);
    }

    public double radius(){
        return dist;
    }


}
