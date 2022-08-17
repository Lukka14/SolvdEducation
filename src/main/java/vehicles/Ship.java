package vehicles;

import java.util.Objects;

public class Ship extends Plane.Vehicle {
    private int rooms;
    @Override
    protected void startEngine() {
        System.out.println("A ship engine has started.");
    }

    @Override
    public void transportPeople(Station stationA,Station stationB){
        People[] people=stationA.getAllPeopleOnStation();
        if(people.length>150){
            System.out.println("A ship can not transport more than 150 people.");
            return;
        }
        for(int i=0;i<people.length;i++){
            stationB.setPeopleOnStation(people[i],i);
        }
        stationA.makeStationEmpty();
        System.out.println(people.length+" people transported with a ship from "+stationA.getStationName()+ " to "+stationB.getStationName());
    }

    @Override
    protected void showFullInfo() {
        System.out.println("Vehicle type: "+super.getvehicleType());
        System.out.println("Vehicle max Speed: "+super.getSpeed());
        System.out.println("Vehicle production year: "+super.getproductionYear());
        System.out.println("Rooms on the vehicle: "+this.rooms);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ship ship = (Ship) o;
        return rooms == ship.rooms;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), rooms);
    }

    @Override
    public String toString() {
        return super.getproductionYear() + " " + super.getSpeed() +" "+ rooms;
    }

    // Getter/setter
    public int getRooms() {
        return rooms;
    }
    public void setRooms(int rooms) {
        this.rooms = rooms;
    }
}
