package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.JdbcUserRepositoryImpl;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;
import java.util.stream.Collectors;

import static edu.tampa.open_pet3.AppTestCases.*;
import static edu.tampa.open_pet3.services.UserTestData.assertMatch;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration({
        "classpath:spring/spring-app.xml",
        "classpath:spring/spring_db.xml"
}
)
@RunWith(SpringJUnit4ClassRunner.class)
@Sql(scripts = "classpath:db/scripts.sql",config=@SqlConfig(encoding="UTF-8"))
public class UserServiceTest {
    @Autowired
    private JdbcUserRepositoryImpl userService;
    @Test
    public void save() {
        User user=new User("Smalala","jeronn@gmail.com","tartar009");
        User created=userService.save(user);
        user.setId(created.getId());
        assertMatch(userService.getAll(),USER,ADMIN,user);
    }

    @Test
    public void delete() {
        userService.delete(USER_ID);
        assertMatch(userService.getAll(),ADMIN);
    }
    @Test(expected= NotFoundException.class)
    public void getNotFound()throws Exception{
        userService.get(1);
    }
    @Test
    public void get() {
        User user=userService.get(USER_ID);
        System.out.println(user);
        Assert.assertEquals(USER,user);
        assertThat(user).isEqualToIgnoringGivenFields(USER,"registered","authorities");
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