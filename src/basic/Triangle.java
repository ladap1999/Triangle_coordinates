package basic;

public class Triangle {
    private double AB;
    private double BC;
    private double CA;
    private Coordinates A;
    private Coordinates B;
    private Coordinates C;
    private double perimeter;
    private final double delta = 0.0001;

    public void setA(Coordinates a) {
        A = a;
    }

    public void setB(Coordinates b) {
        B = b;
    }

    public void setC(Coordinates c) {
        C = c;
    }

    private double calcLength(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2));
    }

    public double getAB() {
        AB = calcLength(A.getX(), A.getY(), B.getX(), B.getY());
        return AB;
    }

    public double getBC() {
        BC = calcLength(B.getX(), B.getY(), C.getX(), C.getY());
        return BC;
    }

    public double getCA() {
        CA = calcLength(C.getX(), C.getY(), A.getX(), A.getY());
        return CA;
    }

    protected void isTriangleEquilateral() {
        if (AB == BC && AB == CA || checkTriangleSides(AB, BC, CA)) {
            System.out.println("Triangle IS 'Equilateral'");
        } else {
            System.out.println("Triangle IS NOT 'Equilateral'");
        }
    }

    protected boolean checkTriangleSides(double ab, double bc, double ca) {
        return ab - bc <= delta && ab - bc > 0
                || bc - ca <= delta && bc - ca > 0
                || ca - ab <= delta && ca - ab > 0;
    }

    protected void isTriangleIsosceles() {
        if (AB == BC || BC == CA || CA == AB) {
            System.out.println("Triangle IS 'Isosceles'");
        } else {
            System.out.println("Triangle IS NOT 'Isosceles'");
        }
    }

    protected void isTriangleRight() {
        if (checkRightTriangle(AB, BC, CA)
                || checkRightTriangle(BC, CA, AB)
                || checkRightTriangle(CA, AB, BC)) {
            System.out.println("Triangle IS 'Right'");
        } else {
            System.out.println("Triangle IS NOT 'Right'");
        }
    }

    protected boolean checkRightTriangle(double a, double b, double c) {
        double squareOfCathetuses = Math.pow(a, 2) + Math.pow(b, 2);
        double squareOfHypotenuse = Math.pow(c, 2);
        double subtraction = squareOfHypotenuse - squareOfCathetuses;

        if (squareOfCathetuses == squareOfHypotenuse) {
            return true;
        } else return subtraction > 0 && subtraction <= delta;
    }

    protected void getPerimeter() {
        perimeter = AB + BC + CA;
        System.out.println("Perimeter: " + perimeter);
    }

    protected void getEvenNumber() {
        System.out.println("Parity numbers in range from 0 to triangle perimeter:");
        for (int i = 0; i < perimeter; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }

    protected void isTriangle() {
        if (A.getX() == B.getX() && A.getY() == B.getY()
                && B.getX() == C.getX() && B.getY() == C.getY()) {
            System.out.println("It is not a triangle. It is a dot!!! Try again.");
            System.exit(0);
        } else if (A.getX() == B.getX() && A.getY() == B.getY()
                || B.getX() == C.getX() && B.getY() == C.getY()
                || C.getX() == A.getX() && C.getY() == A.getY()) {
            System.out.println("It is not a triangle. It is a straight!!! Try again.");
            System.exit(0);
        }
    }
}