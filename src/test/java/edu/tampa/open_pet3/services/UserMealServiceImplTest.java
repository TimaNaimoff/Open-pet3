package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.UserMeal;
import edu.tampa.open_pet3.repositories.jpa.JpaUserMealRepository;
import edu.tampa.open_pet3.repositories.jpa.JpaUserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;
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


public class UserMealServiceImplTest extends AbstractTests{
    @Autowired
    private UserMealServiceImpl userMealRepository;
//    @Autowired
//    private CacheManager cacheManager;
//    @Before
//    public void setUp() throws Exception {
//        cacheManager.getCache("meals").clear();
    //}
    @Test
    public void filter() {

    }
    @Test
    @Transactional
    public void save() {
        UserMeal userMeal=new UserMeal(10000, LocalDateTime.now(),"comanchik",5000);
        userMealRepository.save(USER_ID,userMeal);
        assertMatch(userMealRepository.index(USER_ID), List.of(userMeal));
    }

    @Test
    @Transactional
    public void delete() {
//        System.out.println(userMealRepository.get(10000,100000));
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
    @Transactional
    public void update() {
        UserMeal userMealer=new UserMeal(10000, LocalDateTime.now(),"Serin",4000);
        userMealRepository.save(100000,userMealer);
        UserMeal mealer=userMealRepository.get(10000,100000);
        assertMatch(userMealer,mealer);

    }
}