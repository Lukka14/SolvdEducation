package interfacetask.classes;

import interfacetask.interfaces.IFly;
import interfacetask.interfaces.IRun;
import interfacetask.interfaces.ISwim;

public class Dog implements IFly, IRun, ISwim {
    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean swim() {
        return true;
    }

    @Override
    public void run() {
        System.out.println("Dog is running!");
    }
}
