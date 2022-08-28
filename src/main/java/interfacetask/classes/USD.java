package interfacetask.classes;

import interfacetask.interfaces.IMoney;

public class USD implements IMoney {
    private double money;
    private static final String currencyName="USD";

    public USD() {
        money=0;
    }
    public USD(double money) {
        this.money = money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public double getMoney() {
        return money;
    }

    @Override
    public String getCurrencyName() {
        return currencyName;
    }

    @Override
    public String toString() {
        return String.valueOf(money);
    }



}
