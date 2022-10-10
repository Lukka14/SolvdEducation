package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class SchoolMarshaller {
    public void marshall(School school,String fileName){
        try {
            JAXBContext context = JAXBContext.newInstance(School.class);
            Marshaller mar= context.createMarshaller();
            mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            mar.marshal(school, new File(".//src//main//resources//"+fileName+".xml"));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
    public School unMarshall(String fileName){
        try{
            JAXBContext context = JAXBContext.newInstance(School.class);
            return (School) context.createUnmarshaller()
                    .unmarshal(new FileReader(".//src//main//resources//"+fileName+".xml"));
        } catch (JAXBException | FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
