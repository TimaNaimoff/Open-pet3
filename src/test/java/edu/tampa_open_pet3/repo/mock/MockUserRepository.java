package edu.tampa_open_pet3.repo.mock;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

//@Repository
public class  MockUserRepository implements UserRepository {
    private static final Logger LOG= LoggerFactory.getLogger(MockUserRepository.class);
    @PostConstruct
    public void postConstruct(){
        LOG.info("POST CONSTRUCT");
    }
    @PreDestroy
    public void preDestroy(){
        LOG.info("PRE DESTROY");
    }

    @Override
    public User save(User user) {
        LOG.info("Save: "+user);
        return user;
    }

    @Override
    public boolean delete(int id) {
        LOG.info("Delete: "+id);
        return id!=0;
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
