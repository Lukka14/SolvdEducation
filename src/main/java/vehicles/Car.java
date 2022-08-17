package vehicles;

import java.util.Objects;

public class Car extends Vehicle {
    private int tires;  // just wanted to add a new field particularly for this class
    public Car() {
        super.setvehicleType("Car");
        super.setproductionYear(1947);
        super.setSpeed(200);
        tires=4;
    }

    public Car(int ProductionYear,int speed,int tires) {
        super.setSpeed(speed);
        super.setvehicleType("Car");
        super.setproductionYear(ProductionYear);
        this.tires=tires;
    }

    @Override
    public void showFullInfo(){
        System.out.println("Vehicle type: "+super.getvehicleType());
        System.out.println("Vehicle max Speed: "+super.getSpeed());
        System.out.println("Vehicle production year: "+super.getproductionYear());
        System.out.println("Vehicle tire count: "+this.tires);
    }

    public int getTires() {
        return tires;
    }

    public void setTires(int tires) {
        this.tires = tires;
    }

    @Override
    void startEngine(){
        System.out.println("Car engine has started!");;
    }

    @Override
    public void transportPeople(Station stationA,Station stationB){
        People[] people=stationA.getAllPeopleOnStation();
        if(people.length>6){
            System.out.println("A car can not transport more than 6 people.");
            return;
        }
        for(int i=0;i<people.length;i++){
            stationB.setPeopleOnStation(people[i],i);
        }
        stationA.makeStationEmpty();
        System.out.println(people.length+" people transported with a car from "+stationA.getStationName()+ " to "+stationB.getStationName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return tires == car.tires;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), tires);
    }

    @Override
    public String toString() {
        return super.getproductionYear() + " " + super.getSpeed() +" "+ tires;
    }
}
