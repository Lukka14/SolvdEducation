package enums.myenums;

public enum Directions {
    NORTH("North"),
    SOUTH("South"),
    WEST("West"),
    EAST("East");

    private String dirName;

    Directions(String dirName){
        this.dirName=dirName;
    }

    public static void showAllValues(){
        for(Directions dir: Directions.values()){
            System.out.println(dir);
        }
    }

    // getter & setter
    public String getDirName() {
        return dirName;
    }

    public void setDirName(String dirName) {
        this.dirName = dirName;
    }

}
