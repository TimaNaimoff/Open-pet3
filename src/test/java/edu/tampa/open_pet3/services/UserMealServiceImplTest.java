package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.jdbc.JdbcUserMealRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static edu.tampa.open_pet3.services.UserMealTestData.*;
import static edu.tampa.open_pet3.services.UserTestData.USER_ID;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring_db.xml"
}
)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/scripts.sql",config=@SqlConfig(encoding="UTF-8"))
public class UserMealServiceImplTest {

    @Autowired
    private JdbcUserMealRepository userMealRepository;
    @Test
    public void filter() {

    }

    @Test
    public void save() {
        UserMeal userMeal=new UserMeal(11, LocalDateTime.now(),"comanchi",5000);
        userMeal=userMealRepository.save(userMeal,USER_ID);
        assertMatch(userMealRepository.getAll(USER_ID), List.of(OBJ1,userMeal));
    }

    @Test
    public void delete() {
        userMealRepository.delete(100000,10000);
        assertMatch(userMealRepository.getAll(100000), new ArrayList<UserMeal>());
    }

    @Test
    public void get() {
        UserMeal userMealer=new UserMeal(10000, LocalDateTime.now(),"blablabla",1000);
        assertMatch(userMealer,userMealRepository.get(100000,10000));
    }

    @Test
    public void index() {
        assertMatch(userMealRepository.getAll(100000),List.of(new UserMeal(10000, LocalDateTime.now(),"blablabla",1000)));
    }

    @Test
    public void getBetweenDateTimes() {
    }


    @Test
    public void update() {
        UserMeal userMealer=new UserMeal(10001, LocalDateTime.now(),"Serin",4000);
        userMealRepository.save(userMealer,100000);
        UserMeal mealer=userMealRepository.get(100000,10001);
        assertMatch(userMealer,mealer);

    }
}