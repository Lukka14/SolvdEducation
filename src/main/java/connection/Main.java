package connection;

import connection.dao.jdbcimpl.*;
import connection.dao.mybatisimpl.AnimalDAO;
import connection.dao.mybatisimpl.PetDAO;
import connection.model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
//        Animal pet=new Animal(4L,"fox",21.1F);
//        AnimalDAO petDAO = new AnimalDAO();
//        petDAO.remove(4L);
//        petDAO.create(pet);
//        petDAO.update(new Animal(4L,"dog",1.4F));
//
//        List<Animal> pets=petDAO.getAll();
//        pets.forEach(System.out::println);
//
//        AnimalDAO animalDAO = new AnimalDAO();
//
//        Animal animal = animalDAO.getById(2L);
//        System.out.println("animal = " + animal);

//        Pet pet = sqlSession.selectOne("Pet.getById",1);
//        System.out.println("pet = " + pet);

//    -------------------------------------

//        Profession profession = new Profession(1L,"Developer",1900L);
//        ProfessionDAO professionDAO = new ProfessionDAO();
//        professionDAO.create(profession);
//
//        Flag flag = new Flag(1L,"red white","Georgia flag");
//        FlagDAO flagDAO = new FlagDAO();
//        flagDAO.create(flag);
//
//        Country country = new Country(1L,"Germany","Heidelberg",1L);
//        CountryDAO countryDAO = new CountryDAO();
////        countryDAO.create(country);
//
//        Car car = new Car(1L,"BMW","E35",3800L,1L,1L);
//        CarDAO carDAO = new CarDAO();
////        carDAO.create(car);
//
//        System.out.println(carDAO.getAll());
//
//        People people = new People(1L,"lUKA","Tskhomelidze",1L,1L,1L);
//        PeopleDAO peopleDAO = new PeopleDAO();
////        peopleDAO.create(people);
//        List<People> peopleList = peopleDAO.getAll();
//        peopleList.stream().forEach( (ppl -> System.out.println(ppl.toString())) );

        PetDAO petDAO = new PetDAO();
        System.out.println( petDAO.getById(1L) );


    }
}
