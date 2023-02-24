package edu.tampa.open_pet3.repositories;

import edu.tampa.open_pet3.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository {
    User save(User user);
    boolean delete(int id);
    User get(int id);
    User getByMail(String email);
    List<User> getAll();

}
