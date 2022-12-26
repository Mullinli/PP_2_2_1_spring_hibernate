package hiber;

import hiber.config.AppConfig;
import hiber.service.UserService;
import hiber.model.User;
import hiber.model.Car;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);
        userService.add(new User("User1", "Lastname1", "user1@mail.ru"), new Car("BMW", 5));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"), new Car("MERS", 200));

        userService.getUser(1);
        userService.getUser(2);

        User userSearched = userService.getUserByCar("BMW", 5);

        List<User> users = userService.listUsers();

        users.add(userSearched);

        for (User user : users) {
            System.out.println("\nId = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar().getModel() + " " + user.getCar().getSeries());
        }

        context.close();
    }
}
