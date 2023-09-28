package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepo repo;

    public UserService(UserRepo repo){
        this.repo = repo;
    }
    public Iterable<User> getAll(){return repo.findAll();}
    public void add(User data){repo.save(data);}
    public void del(Long id){repo.deleteById(id);}

    public Optional<User> getById(Long id){return repo.findById(id);}

}
