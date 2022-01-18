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

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User user1 = new User("Fedr","Fedorov","fgdfg@sdfsd.ds");
      Car car1 = new Car("BMW", 5);
      user1.setEmpCar(car1);
      User user2 = new User("Petr","Petrov","aabbb@sdfsd.ds");
      Car car2 = new Car("AUDI", 8);
      user2.setEmpCar(car2);
      userService.add(user1);
      userService.add(user2);
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }
      List<User> userCar = userService.getUserByCar("BMW",5);
      for (User user : userCar) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Model by Car = " + user.getEmpCar().getModel());
         System.out.println("Series by Car = " + user.getEmpCar().getSeries());
         System.out.println();
      }



      context.close();
   }
}
