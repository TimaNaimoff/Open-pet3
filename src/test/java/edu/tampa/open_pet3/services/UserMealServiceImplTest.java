package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.jdbc.JdbcUserMealRepository;
import edu.tampa.open_pet3.repositories.jpa.JpaUserMealRepository;
import edu.tampa.open_pet3.repositories.jpa.JpaUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

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
    private UserMealServiceImpl userMealRepository;
    @Test
    public void filter() {

    }
    @Test
    @Transactional
    public void save() {
        UserMeal userMeal=new UserMeal(10000, LocalDateTime.now(),"comanchi",5000);
        userMealRepository.save(USER_ID,userMeal);
        assertMatch(userMealRepository.index(USER_ID), List.of(OBJ1,userMeal));
    }

    @Test
    @Transactional
    public void delete() {
        userMealRepository.delete(100000,10000);
        assertMatch(userMealRepository.index(100000), new ArrayList<UserMeal>());
    }

    @Test
    public void get() {
        UserMeal userMealer=new UserMeal(10000, LocalDateTime.now(),"blablabla",1000);
        assertMatch(userMealRepository.get(100000,10000),userMealer);
    }

    @Test
    public void index() {
        assertMatch(userMealRepository.index(100000),List.of(new UserMeal(10000, LocalDateTime.now(),"blablabla",1000)));
    }

    @Test
    public void getBetweenDateTimes() {
    }


    @Test
    @Transactional
    public void update() {
        UserMeal userMealer=new UserMeal(10001, LocalDateTime.now(),"Serin",4000);
        userMealRepository.save(100000,userMealer);
        UserMeal mealer=userMealRepository.get(100000,10001);
        assertMatch(userMealer,mealer);

    }
}