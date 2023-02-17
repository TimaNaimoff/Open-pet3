package edu.tampa.open_pet3;

import edu.tampa.open_pet3.model.Role;

import java.util.Collections;
import java.util.Set;

public class LoggedUser {
    protected int id=2;
    protected Set<Role> roles= Collections.singleton(Role.ROLE_USER);
    protected boolean enabled = true;
    private static LoggedUser LOGGED_USER=new LoggedUser();
    public static LoggedUser get(){
        return LOGGED_USER;
    }
    public static int id(){
        return get().id;
    }

    public static int getCaloriesPerDay() {
        return 2000;
    }

    public Set<Role> getAuthorities(){
        return roles;
    }
    public boolean isEnabled(){
        return enabled;
    }

}
