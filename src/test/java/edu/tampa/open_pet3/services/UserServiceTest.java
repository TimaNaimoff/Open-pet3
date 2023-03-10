package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.jpa.JpaUserRepository;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

import static edu.tampa.open_pet3.AppTestCases.*;
import static edu.tampa.open_pet3.services.UserTestData.assertMatch;
import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest extends AbstractTests{
//    @PersistenceContext
//    private EntityManager em;
//    JpaUserRepository userService=new JpaUserRepository(em);
    @Autowired
    private UserServiceImpl userService;
//    @Autowired
//    private CacheManager cacheManager;

//    @Before
//    public void setUp() throws Exception {
//                cacheManager.getCache("users").clear();
//            }
    @Test
    @Transactional
    public void save() {
        User user=new User("Smalala","jeronn@gmail.com","tartar009");
        User created=userService.save(user);
        user.setId(created.getId());
        assertMatch(userService.getAll(),user,USER,ADMIN);
    }

    @Test
    @Transactional
    public void delete() {
        userService.delete(USER_ID);
        assertMatch(userService.getAll().get(0),ADMIN);
    }
    @Test(expected= NotFoundException.class)
    public void getNotFound()throws Exception{
        userService.get(1);
    }
    @Test
    public void get() {
        User user=userService.get(USER_ID);
        Assert.assertEquals(USER,user);
     }

    @Test
    public void getByEmail() {
    }

    @Test
    public void getAll() {
        List<User>all=userService.getAll();
        assertMatch(all,new User[]{USER,ADMIN});
    }

    @Test
    public void update() {

    }
}