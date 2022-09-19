package xml;

import java.util.ArrayList;

public class xmlMain {
    public static void main(String[] args){
       ArrayList<String> subjects = new ArrayList<>();
        subjects.add("Chemistry");
        subjects.add("Math");
        School school = new School("Western public school","IV",226,subjects);

        SchoolMarshaller schoolMarshaller = new SchoolMarshaller();
        schoolMarshaller.marshall(school,"mySchool");

        School school2=schoolMarshaller.unMarshaller("mySchool");
        System.out.println(school2);
    }
}
