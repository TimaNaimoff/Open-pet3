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
import static org.junit.Assert.assertEquals;

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
    public void save() {
        UserMeal userMeal=new UserMeal(10000, LocalDateTime.now(),"comanchik",5000);
        userMealRepository.save(USER_ID,userMeal);
        assertMatch(userMealRepository.index(USER_ID), List.of(userMeal));
    }

    @Test
    public void delete() {
        System.out.println(userMealRepository.get(10000,100000));
        userMealRepository.delete(10000,100000);
        assertEquals(userMealRepository.index(100000).size(),1);
    }

    @Test
    public void get() {
        UserMeal userMealer=new UserMeal(10000, LocalDateTime.now(),"blablabla",1000);
        assertMatch(userMealRepository.get(10000,100000),userMealer);
    }

    @Test
    public void index() {
        ArrayList<UserMeal>lister=new ArrayList<>();
        lister.add(new UserMeal(10000, null,"blablabla",1000));
//        System.out.println(lister.equals(userMealRepository.index(100000)));
        assertMatch(userMealRepository.index(100000),lister);
    }

    @Test
    public void getBetweenDateTimes() {
    }


    @Test
    public void update() {
        UserMeal userMealer=new UserMeal(10000, LocalDateTime.now(),"Serin",4000);
        userMealRepository.save(100000,userMealer);
        UserMeal mealer=userMealRepository.get(10000,100000);
        assertMatch(userMealer,mealer);

    }
}