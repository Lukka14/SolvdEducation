package vehicles;

// vehicle theme: what it consists of, vehicle transports people from station A to station B

public class Main {
    public static void main(String[] args) {
	    Vehicle chevrolet = new Car(1963,210,4);
        chevrolet.showFullInfo();

        System.out.println();

        Plane.Vehicle T72=new Tank();
        T72.showFullInfo();

        System.out.println();

        Vehicle F35=new Plane();
        F35.showFullInfo();

        People[] people;
        people=new People[10];
        Station stationA=new Station("Station A",people.length);

        for(int i=0;i< people.length;i++){
            people[i]= new People();
            people[i].setName("Person " + (i+1));
            people[i].setAge((int) (Math.random()*100));
            people[i].setWeight(Math.round(Math.random()*1000)/10.0+50);
            stationA.setPeopleOnStation(people[i],i);
        }

        Station stationB=new Station("Station B",stationA.getAllPeopleOnStation().length);

        Vehicle plane=new Plane();
        System.out.println();
        plane.transportPeople(stationA,stationB);

        System.out.println();
        stationA.showPeopleOnStation();

        System.out.println();
        stationB.showPeopleOnStation();
    }
}
