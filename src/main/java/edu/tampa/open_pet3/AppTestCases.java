package edu.tampa.open_pet3;

import edu.tampa.open_pet3.model.User;

public class AppTestCases {
    public static final int USER_ID=100001;
    public static final User USER;
    public static final User ADMIN;
    static{
        USER=new User();
        USER.setId(100001);
        USER.setName("Akakiy");
        USER.setEmail("perez123@gmail.com");
        USER.setPassword("zamok123");
        ADMIN=new User();
        ADMIN.setId(100000);
        ADMIN.setName("Peter");
        ADMIN.setEmail("petyakamaz@gmail.com");
        ADMIN.setPassword("kamaz009");
    }
}
