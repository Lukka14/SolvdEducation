package interfacetask.classes;

import interfacetask.interfaces.IFly;
import interfacetask.interfaces.ISwim;
import interfacetask.interfaces.IRun;


public class Duck implements IFly,ISwim,IRun {

    public boolean canFly() {
        return true;
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public void run() {
        System.out.println("Duck is running!");
    }
}
