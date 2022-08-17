package vehicles;

import java.util.Objects;

public class Plane extends Vehicle {
    int wings;

    public Plane(){
        super.setvehicleType("Plane");
        super.setproductionYear(2012);
        super.setSpeed(1000);
        wings=2;
    }

    public Plane(int ProductionYear,int speed,int wings){
        super.setSpeed(speed);
        super.setvehicleType("Car");
        super.setproductionYear(ProductionYear);
        this.wings=wings;
    }

    @Override
    public void showFullInfo(){
        System.out.println("Vehicle type: "+super.getvehicleType());
        System.out.println("Vehicle max speed: "+super.getSpeed());
        System.out.println("Vehicle production year: "+super.getproductionYear());
        System.out.println("Vehicle wing count: "+this.wings);
    }

    public int getWings() {
        return wings;
    }

    public void setWings(int wings) {
        this.wings = wings;
    }

    @Override
    protected void startEngine(){
        System.out.println("Plane engine has started.");
    }
    @Override
    public void transportPeople(Station stationA,Station stationB){
        People[] people=stationA.getAllPeopleOnStation();
        if(people.length>40){
            System.out.println("A plane can not transport more than 40 people.");
            return;
        }
        for(int i=0;i<people.length;i++){
            stationB.setPeopleOnStation(people[i],i);
        }
        stationA.makeStationEmpty();
        System.out.println(people.length+" people transported with a plane from "+stationA.getStationName()+ " to "+stationB.getStationName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Plane plane = (Plane) o;
        return wings == plane.wings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wings);
    }

    @Override
    public String toString() {
        return super.getproductionYear() + " " + super.getSpeed() +" "+ wings;
    }

    public abstract static class Vehicle {
       private String vehicleType;
       private int productionYear;
       private double speed;

        public Vehicle(){}

        public Vehicle(String vehicleType, int productionYear, double speed) {
            this.vehicleType = vehicleType;
            this.productionYear = productionYear;
            this.speed = speed;
        }

        protected abstract void startEngine();
        protected abstract void transportPeople(Station stationA, Station stationB);
        protected abstract void showFullInfo();

        public String getvehicleType() {
            return vehicleType;
        }

        public void setvehicleType(String vehicleType) {
            this.vehicleType = vehicleType;
        }

        public int getproductionYear() {
            return productionYear;
        }

        public void setproductionYear(int productionYear) {
            this.productionYear = productionYear;
        }

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vehicle vehicle = (Vehicle) o;
            return productionYear == vehicle.productionYear && Double.compare(vehicle.speed, speed) == 0 && Objects.equals(vehicleType, vehicle.vehicleType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(vehicleType, productionYear, speed);
        }

        @Override
        public String toString() {
            return productionYear + " " + speed;
        }


    }
}
