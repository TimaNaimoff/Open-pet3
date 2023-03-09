package edu.tampa.open_pet3;

import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.to.UserMealWithExceed;
import edu.tampa.open_pet3.util.Profiles;
import edu.tampa.open_pet3.web.meal.UserMealsRestController;
import edu.tampa.open_pet3.web.user.UserAdminRestController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static edu.tampa.open_pet3.util.Profiles.*;

public class SpringMain {
    public static void main(String[] args) {
        try (GenericXmlApplicationContext context=new GenericXmlApplicationContext();
             )
        {
            context.getEnvironment().setActiveProfiles(Profiles.POSTGRES, Profiles.DATAJPA);
            context.load("classpath:spring/spring-app.xml","classpath:spring/spring_db.xml");
            context.refresh();
            System.out.println(Arrays.toString(context.getBeanDefinitionNames()));
            UserAdminRestController adminius=context.getBean(UserAdminRestController.class);
            System.out.println(adminius.getAdminus(1,"userName","email","password", Role.ROLE_ADMIN));
            System.out.println();
            UserMealsRestController mealsRestController=context.getBean(UserMealsRestController.class);
//            List<UserMealWithExceed>filteredMealsWithExceeded=mealsRestController.getBetween(LocalDate.of(
//                    2015, Month.MAY,30), LocalTime.of(7,0),
//                    LocalDate.of(2015,Month.MAY,31),LocalTime.of(11,0));
//
//            filteredMealsWithExceeded.forEach(System.out::println);
        }
    }
}
