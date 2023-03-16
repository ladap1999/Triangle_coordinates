package basic;

import java.util.InputMismatchException;
import java.util.Scanner;

import static utils.PointNames.*;
import static utils.CoordinateNames.*;

public class Menu {
    public void work() {
        Triangle triangle = new Triangle();

        System.out.println("Welcome to basic.Triangle calculator");

        triangle.setA(new Coordinates(
                enterNumber(COORDINATE_X, POINT_A),
                enterNumber(COORDINATE_Y, POINT_A)));

        triangle.setB(new Coordinates(
                enterNumber(COORDINATE_X, POINT_B),
                enterNumber(COORDINATE_Y, POINT_B)));

        triangle.setC(new Coordinates(
                enterNumber(COORDINATE_X, POINT_C),
                enterNumber(COORDINATE_Y, POINT_C)));

        System.out.println("Length of AB is: " + triangle.getAB());
        System.out.println("Length of BC is: " + triangle.getBC());
        System.out.println("Length of CA is: " + triangle.getCA());

        triangle.isTriangle();
        triangle.isTriangleEquilateral();
        triangle.isTriangleIsosceles();
        triangle.isTriangleRight();
        triangle.getPerimeter();
        triangle.getEvenNumber();
    }

    private double enterNumber(char charForPrint, char pointChar) {
        double a = 0;
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Enter coordinate " + charForPrint + " of dot " + pointChar);
                a = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Try to use double value");
            }
        }
        return a;
    }
}
