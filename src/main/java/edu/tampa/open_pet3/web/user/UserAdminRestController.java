package edu.tampa.open_pet3.web.user;

import edu.tampa.open_pet3.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserAdminRestController {
    @Autowired
    private UserService userService;
}
