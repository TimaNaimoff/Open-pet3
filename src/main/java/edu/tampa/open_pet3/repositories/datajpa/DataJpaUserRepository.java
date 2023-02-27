package edu.tampa.open_pet3.repositories.datajpa;

import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {
    private ProxyUserRepository proxyUserRepository;

    @Autowired
    public DataJpaUserRepository(ProxyUserRepository proxyUserRepository){
        this.proxyUserRepository=proxyUserRepository;
    }
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
        return proxyUserRepository.findAll();
    }
}
