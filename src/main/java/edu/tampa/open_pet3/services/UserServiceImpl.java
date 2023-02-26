package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.jpa.JpaUserRepository;
import edu.tampa.open_pet3.repositories.mock.MockUserRepository;
import edu.tampa.open_pet3.repositories.UserRepository;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Qualifier("jpaUserRepository")
    private JpaUserRepository jpaUserRepository;
    @Autowired
    public UserServiceImpl(JpaUserRepository jpaUserRepository){
        this.jpaUserRepository=jpaUserRepository;
    }
    @Override
    public User save(User user) {
        return jpaUserRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if(!jpaUserRepository.delete(id)){
            throw new NotFoundException("Method:delete,send 0 in argument!");
        }

    }

    @Override
    public User get(int id) throws NotFoundException {
        User user = jpaUserRepository.get(id);
        if(user==null)throw new NotFoundException("Entity not found lol!");
        return user;
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return jpaUserRepository.getByMail(email);
    }

    @Override
    public List<User> getAll() {
        return jpaUserRepository.getAll();
    }

    @Override
    public void update(User user) throws NotFoundException {
         jpaUserRepository.save(user);
    }

    public UserRepository getUserRepository() {
        return jpaUserRepository;
    }

    public void setUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }
}
