package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface UserService {
    User save(User user);
    void delete(int id)throws NotFoundException;
    User get(int id)throws NotFoundException;
    User getByEmail(String email)throws NotFoundException;
    List<User>getAll();
    void update(User user)throws NotFoundException;
}
