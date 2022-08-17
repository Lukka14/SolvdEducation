package vehicles;

import java.util.Objects;

public abstract class Vehicle {
    private String vehicleType;
    private int productionYear;
    private double speed;

    public Vehicle(){}

    public Vehicle(String vehicleType, int productionYear, double speed) {
        this.vehicleType = vehicleType;
        this.productionYear = productionYear;
        this.speed = speed;
    }

    abstract void startEngine();
    abstract void transportPeople(Station stationA,Station stationB);
    abstract void showFullInfo();

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