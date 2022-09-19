package connection;

import connection.dao.jdbc.AnimalDAO;
import connection.model.Animal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import xml.School;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Animal pet=new Animal(4L,"fox",21.1F);
        AnimalDAO petDAO = new AnimalDAO();
        petDAO.remove(4L);
        petDAO.create(pet);
        petDAO.update(new Animal(4L,"dog",1.4F));

        List<Animal> pets=petDAO.getAll();
        pets.forEach(System.out::println);

        School school = new School();
    }
}
