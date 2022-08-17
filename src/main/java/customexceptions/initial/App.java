package customexceptions.initial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//Homework:
//Add 5 collections to the hierarchy.
//Create custom LinkedList with generic.
public class App {
    private static final Logger logger = LogManager.getLogger(App.class);

    public static void main( String[] args ) {
        List<String> arrayList=new ArrayList<>();
        ArrayList<String> arrayList1=new ArrayList<>();
        List<String> linkedList=new LinkedList<>();
        nma(arrayList1);

    }
    public static void nma(ArrayList<String> g){

        return;
    }
}
