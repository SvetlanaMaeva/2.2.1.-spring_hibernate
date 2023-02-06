package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("Ivan", "Ivanov", "van@ya.ru", new Car("Volkswagen", 3333333)));
        userService.add(new User("Petya", "Kukushka", "pet@ya.ru", new Car("Lada", 123)));
        userService.add(new User("Sasha", "M", "san@ya.ru", new Car("Honda", 8888)));
        System.out.println("=============");
        System.out.println(userService.getUser("Volkswagen", 3333333));
        System.out.println("=============");


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        List<Car> cars = userService.listCar();
        for (Car car : cars) {
            System.out.println("Id = " + car.getId());
            System.out.println("Model = " + car.getModel());
            System.out.println("Series = " + car.getSeries());
            System.out.println();
        }
        context.close();
    }
}
