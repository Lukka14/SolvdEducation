package xml;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;

public class XMLMain {
    private static final Logger LOGGER = LogManager.getLogger(XMLMain.class);
    public static void main(String[] args){
       ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Chemistry");
        subjects.add("Math");
        School school = new School("Western public school","IV",226,subjects);

        SchoolMarshaller schoolMarshaller = new SchoolMarshaller();
        schoolMarshaller.marshall(school,"mySchool");

        School school2=schoolMarshaller.unMarshall("mySchool");
        LOGGER.info(school2);
    }
}
