package geometry;

public class Square extends Rectangle{

    public Square(Point a, Point b){
        super(a, b, Point.distance(a, b));
    }

    public double side(){
        return Point.distance(A, B);
    }

    public Circle circumscribedCircle(){
        Circle res = new Circle(this.center(), this.diagonal()/2);
        return res;
    } 

    public Circle inscribedCircle(){
        Circle res = new Circle(this.center(), this.side()/2);
        return res;
    }

    

}
