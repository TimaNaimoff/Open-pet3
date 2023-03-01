package edu.tampa.open_pet3.repositories.datajpa;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {
    private static final Sort SORT_NAME_EMAIL = Sort.by("email","name");

    @Autowired
    private ProxyUserRepository proxyUserRepository;

    @Override
    public User save(User user) {
        return proxyUserRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return proxyUserRepository.delete(id)!=0;
    }

    @Override
    public User get(int id) {
        return proxyUserRepository.getOne(id);
    }

    @Override
    public User getByMail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return proxyUserRepository.findAllMeals();
    }
}
