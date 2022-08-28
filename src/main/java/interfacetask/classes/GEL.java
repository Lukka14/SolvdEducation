package interfacetask.classes;

import interfacetask.interfaces.IMoney;

import java.util.Objects;

public class GEL implements IMoney {
    private double money;
    private final String currencyName="GEL";


    public GEL(){
        money=0;
    }
    public GEL(double money){
        this.money=money;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GEL gel = (GEL) o;
        return Double.compare(gel.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, currencyName);
    }
}
