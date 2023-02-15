package edu.tampa.open_pet3.repositories.mock;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MockUserRepository implements UserRepository {
    private static final Logger LOG= LoggerFactory.getLogger(MockUserRepository.class);
    @Override
    public User save(User user) {
        LOG.info("Save: "+user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete: "+id);
        return false;
    }

    @Override
    public User get(int id) {
        return null;
    }

    @Override
    public User getByMail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }
}
