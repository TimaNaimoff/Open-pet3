package edu.tampa_open_pet3.web.mock;


import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import edu.tampa.open_pet3.web.user.UserAdminRestController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:spring/spring-app.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class UserAdminSpringMockTest {
    @Autowired
    private UserAdminRestController userAdminController;

    @Test
    public void testCreate(){
        userAdminController.getAdminus(null,"Tomiris","tukan@gmail.com","terrophorm1", Role.ROLE_ADMIN);
    }
    @Test
    public void testDelete()throws Exception{
//        throw new NotFoundException("Looser!");
        userAdminController.delete(1);
    }
    @Test(expected= NotFoundException.class)
    public void testDeleteNotFound() throws Exception{
        userAdminController.delete(0);
    }

}
