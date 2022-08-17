package interfacetask.classes;

import interfacetask.interfaces.Money;

import java.util.Objects;

public class RUB implements Money {
    private double money;
    private final String currencyName="RUB";

    public RUB() {
        money=0;
    }
    public RUB(double money) {
        this.money = money;
    }

    public void setMoney(double money){this.money=money;}

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
        RUB rub = (RUB) o;
        return Double.compare(rub.money, money) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, currencyName);
    }
}
