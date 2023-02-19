package edu.tampa.open_pet3.services;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.InMemoryUserMealRepository;
import edu.tampa.open_pet3.repositories.MockUserRepository;
import edu.tampa.open_pet3.repositories.UserRepository;
import edu.tampa.open_pet3.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Qualifier("inMemoryUserRepository")
    private MockUserRepository mockUserRepository;
    @Autowired
    public UserServiceImpl(MockUserRepository mockUserRepository){
        this.mockUserRepository=mockUserRepository;
    }
    @Override
    public User save(User user) {
        return mockUserRepository.save(user);
    }

    @Override
    public void delete(int id) throws NotFoundException {
        if(!mockUserRepository.delete(id)){
            throw new NotFoundException("Method:delete,send 0 in argument!");
        }

    }

    @Override
    public User get(int id) throws NotFoundException {
        return mockUserRepository.get(id);
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return mockUserRepository.getByMail(email);
    }

    @Override
    public List<User> getAll() {
        return mockUserRepository.getAll();
    }

    @Override
    public void update(User user) throws NotFoundException {
         mockUserRepository.save(user);
    }

    public UserRepository getUserRepository() {
        return mockUserRepository;
    }

    public void setUserRepository(MockUserRepository mockUserRepository) {
        this.mockUserRepository = mockUserRepository;
    }
}
