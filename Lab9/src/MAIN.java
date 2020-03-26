import controller.PersonController;
import entity.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

public class MAIN {
    public static void main(String[] args) {
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyApplicationPU");
            PersonController persons = new PersonController(factory);
            //MovieController movies = new MovieController();

            persons.create(new Person("Francis Ford Coppola"));
            //persons.create("Marlon Brando");
            //persons.create("Al Pacino");
            //persons.create("Cristian Bale");
            //Database.commit();
            //movies.create("The Godfather", persons.findByName("Coppola"));
            //movies.create("Batman", persons.findByName("Bale"));
            Database.commit();

            Database.closeConnection();
        }  catch (NullPointerException e){
            System.out.println(e);
        }

    }
}

