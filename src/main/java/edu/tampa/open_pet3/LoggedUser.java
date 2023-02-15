package edu.tampa.open_pet3;

import edu.tampa.open_pet3.model.Role;

import java.util.Set;

public class LoggedUser {
    protected int id;
    protected Set<Role> roles;
    protected boolean enabled;

    public int getId(){
        return id;
    }

}
