package interfacetask.extra;

import interfacetask.classes.GEL;
import interfacetask.classes.RUB;
import interfacetask.classes.USD;
import interfacetask.interfaces.Money;

public abstract class Bank {
    private USD balanceInUSD;
    private GEL balanceInGEL;
    private RUB balanceInRUB;

    public Bank(){
        balanceInUSD=new USD(0);
        balanceInGEL=new GEL(0);
        balanceInRUB=new RUB(0);
    }

    public Bank(USD balanceInUSD) {
        this.balanceInUSD = balanceInUSD;
    }

    public Bank(GEL balanceInGEL) {
        this.balanceInGEL = balanceInGEL;
    }

    public Bank(RUB balanceInRUB) {
        this.balanceInRUB = balanceInRUB;
    }

    public Bank(USD balanceInUSD, GEL balanceInGEL) {
        this.balanceInUSD = balanceInUSD;
        this.balanceInGEL = balanceInGEL;
    }

    public Bank(GEL balanceInGEL, RUB balanceInRUB) {
        this.balanceInGEL = balanceInGEL;
        this.balanceInRUB = balanceInRUB;
    }

    public Bank(USD balanceInUSD, RUB balanceInRUB) {
        this.balanceInUSD = balanceInUSD;
        this.balanceInRUB = balanceInRUB;
    }

    public Bank(USD balanceInUSD, GEL balanceInGEL, RUB balanceInRUB) {
        this.balanceInUSD = balanceInUSD;
        this.balanceInGEL = balanceInGEL;
        this.balanceInRUB = balanceInRUB;
    }

    public Money withdrawMoney(double money,String currency){
        if(money<=0) throw new InvalidAmountException("Money amount must be more than 0");
        if(currency.equalsIgnoreCase("gel")){
            checkBalance(new GEL(money));
            balanceInGEL.setMoney(balanceInGEL.getMoney()-money);
            return new GEL(money);
        }
        if(currency.equalsIgnoreCase("usd")){
            checkBalance(new USD(money));
            balanceInUSD.setMoney(balanceInUSD.getMoney()-money);
            return new USD(money);
        }
        if(currency.equalsIgnoreCase("rub")){
            checkBalance(new RUB(money));
            balanceInRUB.setMoney(balanceInRUB.getMoney()-money);
            return new RUB(money);
        }
        return new USD(0);
    }

    public void depositMoney(Money money){
        checkValidDeposit(money);
        if(money instanceof GEL){
            balanceInGEL.setMoney(balanceInGEL.getMoney()+money.getMoney());
            ((GEL) money).setMoney(0);
        }
        if(money instanceof USD){
            balanceInUSD.setMoney(balanceInUSD.getMoney()+money.getMoney());
            ((USD) money).setMoney(0);
        }
        if(money instanceof RUB){
            balanceInRUB.setMoney(balanceInRUB.getMoney()+money.getMoney());
            ((RUB) money).setMoney(0);
        }

    }
    public double getBalance(String currency){
        if(currency.equalsIgnoreCase("gel")) return balanceInGEL.getMoney();
        if(currency.equalsIgnoreCase("usd")) return balanceInUSD.getMoney();
        if(currency.equalsIgnoreCase("rub")) return balanceInRUB.getMoney();
        return 0;
    }

    private void checkBalance(Money money){
        if(money instanceof GEL){
            if(balanceInGEL.getMoney()<money.getMoney()){
                throw new InvalidAmountException ("Insufficient Balance");
            }
        }
        if(money instanceof USD){
            if(balanceInUSD.getMoney()<money.getMoney()){
                throw new InvalidAmountException ("Insufficient Balance");
            }
        }
        if(money instanceof RUB){
            if(balanceInRUB.getMoney()<money.getMoney()){
                throw new InvalidAmountException ("Insufficient Balance");
            }
        }
    }

    private void checkValidDeposit(Money money){
        if(money.getMoney()<=0) throw new InvalidAmountException("You must deposit more than 0 " + money.getCurrencyName());
    }

    @Override
    public String toString() {
        return "balanceInUSD = " + Math.round(balanceInUSD.getMoney()*100)/100.0 + " " +new USD().getCurrencyName() +"\n"+
                "balanceInGEL = " + Math.round(balanceInGEL.getMoney()*100)/100.0 + " " +new GEL().getCurrencyName()+"\n"+
                "balanceInRUB = " + Math.round(balanceInRUB.getMoney()*100)/100.0 + " " + new RUB().getCurrencyName();
    }
}
