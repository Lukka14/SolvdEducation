package interfacetask.classes;

import interfacetask.interfaces.IFigure;

import java.util.Objects;

public class Rectangle implements IFigure {
    private double a;
    private double b;

    public Rectangle() {}

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double getP() {
        return 2*(a+b);
    }

    @Override
    public double getS() {
        return a*b;
    }

    @Override
    public double getD() {
        return Math.sqrt(a*a+b*b);
    }

    // Getters & setters

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.a, a) == 0 && Double.compare(rectangle.b, b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    @Override
    public String toString() {
        return "a = " + a + "\n"+
                "b = " + b+ "\n"+
                "P = "+ getP()+"\n"+
                "S = " +getS()+"\n"+
                "D = "+getD();
    }
}
