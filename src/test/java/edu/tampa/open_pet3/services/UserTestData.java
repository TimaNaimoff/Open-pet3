package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;

import java.util.Arrays;

import static edu.tampa.open_pet3.model.AbstractNamedEntity.START_SEQ;
import static org.assertj.core.api.Assertions.assertThat;

public class UserTestData {
    public static final int USER_ID=START_SEQ;
    public static final int ADMIN_ID=START_SEQ+1;

    public static void assertMatch(User expected,User actual){
        assertThat(actual).isEqualToIgnoringGivenFields(expected,"registered","authorities","meals");
    }
    public static void assertMatch(Iterable<User>actual,User...expected){
       assertMatch(actual, Arrays.asList(expected));
    }
    public static void assertMatch(Iterable<User>actual,Iterable<User>expected){
        assertThat(actual).usingElementComparatorIgnoringFields("registered","authorities").isEqualTo(expected);
    }
}
