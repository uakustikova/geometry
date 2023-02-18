package geometry;

public class Main {

    class EcholocationManager {

    }

    static int performEcholocation (final EcholocationManager manager) throws IllegalArgumentException /* Your code goes here */ {
        // Your code goes here
        return 0;
    }
    public static void main(String[] args) {
        Point a = new Point(3, 5);
        Point b = new Point(4, 9);
        double res =  Point.distance(a, b);
        System.out.println(res);
        //    Ellipse ellipse = new Ellipse(new Point(3,0), new Point(-3,0), 2);
        //    Point result = ellipse.center();
        //    System.out.println(result.toString());
        //   Ellipse x1 =  new Ellipse(new Point(397.1514877930149, 59.61289566128971), new Point(-740.2527059811499, 724.1431031149737), 0.575260017598499);
        //     double e1 = x1.perimeter();
        //     System.out.println(e1);
        Ellipse x2 = new Ellipse(new Point(987.7056978160488, 761.2996667693276), new Point(38.12078710708238, 840.3256140750821), 0.34399417881258987);
        x2.scale(-1.716866);    
        double e2 = x2.perimeter();
        System.out.println(e2);

        
        //Rectangle got = new Rectangle(new Point(-808.644757124122, -716.5966534486008), new Point(-509.9036672045347, -149.0120207644154), 720.3923674466708);
        // Expected: got.vertices().get(0).x() returned value -68.8526530202974
        // Got: got.vertices().get(0).x() returned value 33.742000433063936
        // System.out.println(got.vertices().get(0));
        // System.out.println(got.vertices().get(1));
        // System.out.println(got.vertices().get(2));
        // System.out.println(got.vertices().get(3));

        Triangle tr = new Triangle(new Point(-55.270402921605296, 575.9608663831959), new Point(103.89891550049265, 446.25432148524146), new Point(407.06837011958805, -587.9678522498584));
        System.out.println(tr.circumscribedCircle().center());
        // -671.3180582807855
    }
    
}
