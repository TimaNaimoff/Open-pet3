package edu.tampa.open_pet3;

import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.to.UserMealWithExceed;
import edu.tampa.open_pet3.web.meal.UserMealsRestController;
import edu.tampa.open_pet3.web.user.UserAdminRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class SpringMain {
    public static void main(String[] args) {
        try (ConfigurableApplicationContext config = new ClassPathXmlApplicationContext("java/edu/tampa_open_pet3/spring/spring-app.xml");
        ) {
            System.out.println(Arrays.toString(config.getBeanDefinitionNames()));
            UserAdminRestController adminius=config.getBean(UserAdminRestController.class);
            System.out.println(adminius.getAdminus(1,"userName","email","password", Role.ROLE_ADMIN));
            System.out.println();
            UserMealsRestController mealsRestController=config.getBean(UserMealsRestController.class);
            List<UserMealWithExceed>filteredMealsWithExceeded=mealsRestController.getBetween(LocalDate.of(
                    2015, Month.MAY,30), LocalTime.of(7,0),
                    LocalDate.of(2015,Month.MAY,31),LocalTime.of(11,0));

            filteredMealsWithExceeded.forEach(System.out::println);
        }
    }
}
