package edu.tampa_open_pet3.web.mock;

import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import edu.tampa.open_pet3.web.user.UserAdminRestController;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class UserAdminMockTest {
    private static ConfigurableApplicationContext context;
    @Autowired
    private static UserAdminRestController controller;
    @BeforeClass
    public static void beforeClass(){
        context=new ClassPathXmlApplicationContext("spring/spring-app.xml");
        System.out.println("\n"+ Arrays.toString(context.getBeanDefinitionNames())+"\n");
        controller=context.getBean(UserAdminRestController.class);
    }
    @AfterClass
    public static void afterClass(){
        context.close();
    }
    @Test
    public void testCreate()throws Exception{
        controller.getAdminus(null,"Tomaris","tupkanukan@gmail.com","password", Role.ROLE_USER);
    }
    @Test
    public void testDelete()throws Exception{
//        throw new NotFoundException("Looser!");
        controller.delete(1);
    }
    @Test(expected= NotFoundException.class)
    public void testDeleteNotFound() throws Exception{
        controller.delete(0);
    }
}
