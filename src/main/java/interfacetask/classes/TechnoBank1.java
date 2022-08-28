package interfacetask.classes;

import interfacetask.extra.Bank;
import interfacetask.extra.InvalidAmountException;
import interfacetask.interfaces.IMoney;
import interfacetask.interfaces.ITechnobank;

public class TechnoBank1 extends Bank implements ITechnobank {
    final String branch="Technobank branch 1";

    @Override
    public double getTaxRate() {
        return tax;
    }

    public void convertCurrency(String from,String to,double amount){
        if(getBalance(from)-amount<=0) throw new InvalidAmountException("Not enough balance");

            if(from.equalsIgnoreCase("usd")) {
                if (to.equalsIgnoreCase("gel")) {
                    double result=amount * IMoney.usdRateInGEL;
                    depositMoney(new GEL(result - (result * getTaxRate() / 100)));
                }
                else if (to.equalsIgnoreCase("rub")) {
                    double result=amount * IMoney.usdRateInRUB;
                    depositMoney(new RUB(result - (result * getTaxRate() / 100)));
                }
                else throw new IllegalArgumentException("Can not convert "+amount+ " " +from+" to "+to);
                withdrawMoney(amount, from);
            }

            else if(from.equalsIgnoreCase("gel")){
                if (to.equalsIgnoreCase("usd")) {
                    double result = amount/ IMoney.usdRateInGEL ;
                    depositMoney(new USD(result - (result * getTaxRate() / 100)));
                }
                else if (to.equalsIgnoreCase("rub")) {
                    double result=amount * IMoney.usdRateInRUB;
                    depositMoney(new RUB(result - (result * getTaxRate() / 100)));
                }
                else throw new IllegalArgumentException("Can not convert "+amount+ " " +from+" to "+to);
                withdrawMoney(amount, from);
            }

            else if(from.equalsIgnoreCase("rub")) {
                if (to.equalsIgnoreCase("gel")) {
                    double result=amount / IMoney.usdRateInRUB * IMoney.usdRateInGEL;
                    depositMoney(new GEL(result - (result * getTaxRate() / 100)));
                }
                if (to.equalsIgnoreCase("usd")) {
                    double result=amount / IMoney.usdRateInRUB ;
                    depositMoney(new USD(result - (result * getTaxRate() / 100)));
                }
                else throw new IllegalArgumentException("Can not convert "+amount+ " " +from+" to "+to);
                withdrawMoney(amount, from);
            }
            else throw new IllegalArgumentException("Can not convert "+amount+ " " +from+" to "+to);

    }

}
