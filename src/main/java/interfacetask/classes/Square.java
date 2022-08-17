package interfacetask.classes;

import java.awt.*;

public class Square extends Rectangle {
    public Square(){}
    public Square(double a){
        super(a,a);
    }
    @Override
    public void setA(double a){
        super.setA(a);
        super.setB(a);
    }
    @Override
    public double getA(){
        return super.getA();
    }

}
