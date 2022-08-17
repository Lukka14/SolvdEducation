package vehicles;

public class Station {
    private  People[] peopleOnStation;
    private String stationName;

    public  Station(){
        stationName="station";
    }
    public Station(String stationName, int n){
        this.stationName=stationName;
        createArray(n);
    }

    void createArray(int n){
        peopleOnStation=new People[n];
    }

    public void makeStationEmpty(){
        peopleOnStation=null;
    }

    public People getPeopleOnStation(int index) {
        return peopleOnStation[index];
    }
    public People[] getAllPeopleOnStation() {
        return peopleOnStation;
    }

    public void setPeopleOnStation(People peopleOnStation,int index) {
        this.peopleOnStation[index] = peopleOnStation;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void showPeopleOnStation(){
        if(peopleOnStation==null || peopleOnStation.length==0){
            System.out.println("There are no people on "+stationName);
            return;
        }
        System.out.println("People on " + stationName + ": ");
        for (People person : peopleOnStation) {
            System.out.println("name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Weight: " + person.getWeight());
            System.out.println();
        }
    }
}
