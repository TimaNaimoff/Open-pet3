package edu.tampa.open_pet3.web.user;

import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAdminRestController {

    private UserService userService;
    @Autowired
    public UserAdminRestController(UserService userService){
        this.userService=userService;
    }
    public  User getAdminus(Integer id, String userName, String email,String password,Role role){
        return new User(id,userName,email,password,role);
    }
    public void delete(int userId){
        userService.delete(userId);
    }

}
