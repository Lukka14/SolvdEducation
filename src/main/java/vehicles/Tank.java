package vehicles;

import java.util.Objects;

public class Tank extends Plane.Vehicle {
    private String gunType;

    public Tank(){
        super.setvehicleType("Tank");
        super.setproductionYear(2001);
        super.setSpeed(40);
        gunType="125mm";
    }

    public Tank(String gunType, int ProductionYear,int speed){
        this.gunType=gunType;
        super.setSpeed(speed);
        super.setvehicleType("Tank");
        super.setproductionYear(ProductionYear);
    }

    public String getGunType() {
        return gunType;
    }

    public void setGunType(String gunType) {
        this.gunType = gunType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Tank tank = (Tank) o;
        return Objects.equals(gunType, tank.gunType);
    }
    @Override
    public void showFullInfo(){
        System.out.println("Vehicle type: "+super.getvehicleType());
        System.out.println("Vehicle gun type: "+this.gunType);
        System.out.println("Vehicle production year: "+super.getproductionYear());
        System.out.println("Vehicle max speed: "+super.getSpeed());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gunType);
    }

    @Override
    public String toString() {
        return super.getproductionYear() + " " + super.getSpeed() +" "+ gunType;
    }

    @Override
    protected void startEngine() {
        System.out.println("Tank engine has started.");
    }

    @Override
    public void transportPeople(Station stationA, Station stationB) {
        System.out.println("A tank can not transport people.");
    }
}
