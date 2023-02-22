package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.JdbcUserMealRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static edu.tampa.open_pet3.services.UserMealTestData.*;
import static edu.tampa.open_pet3.services.UserTestData.ADMIN_ID;
import static edu.tampa.open_pet3.services.UserTestData.USER_ID;
import static org.junit.Assert.*;

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
        UserMeal userMeal=new UserMeal(15, LocalDateTime.now(),"comanchi",5000);
        userMeal=userMealRepository.save(userMeal,USER_ID);
        assertMatch(userMealRepository.getAll(USER_ID), List.of(OBJ2,userMeal));
    }

    @Test
    public void delete() {
        userMealRepository.delete(15,100001);
    }

    @Test
    public void get() {
    }

    @Test
    public void index() {
    }

    @Test
    public void getBetweenDateTimes() {
    }

    @Test
    public void deleteAll() {

    }

    @Test
    public void update() {

    }
}