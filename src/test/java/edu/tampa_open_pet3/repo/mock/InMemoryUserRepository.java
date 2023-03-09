package edu.tampa_open_pet3.repo.mock;

import edu.tampa.open_pet3.model.Role;
import edu.tampa.open_pet3.model.User;
import edu.tampa.open_pet3.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//@Repository("inMemoryUserRepository")
public class InMemoryUserRepository implements UserRepository {
    private Map<Integer,User> repository=new ConcurrentHashMap<>();
    private AtomicInteger counter=new AtomicInteger();
    public static final int USER_ID=1;
    public static final int ADMIN_ID=2;
    {
        save(new User(1,"Timur","suponev53@gmail.com","666", Role.ROLE_ADMIN));
        save(new User(1,"Rumilla","sepen1@gmail.com","777", Role.ROLE_USER));
        save(new User(1,"Serpantina","usuapo21@gmail.com","111", Role.ROLE_USER));

    }
    @Override
    public User save(User user) {
        if(user.isNew()){
            user.setId(counter.incrementAndGet());
        }
        return repository.put(user.getId(),user);
    }

    @Override
    public boolean delete(int id) {
        return repository.remove(id)!=null;
    }

    @Override
    public User get(int id) {
        return repository.get(id);
    }

    @Override
    public User getByMail(String email) {
        Objects.requireNonNull(email);
        return repository.values().stream().filter(e -> e.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return (List<User>)repository.values();
    }
}
