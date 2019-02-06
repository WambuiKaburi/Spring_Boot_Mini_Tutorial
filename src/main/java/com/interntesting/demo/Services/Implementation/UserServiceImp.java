package com.interntesting.demo.Services.Implementation;

import com.interntesting.demo.Models.User;
import com.interntesting.demo.Repositories.UserRepository;
import com.interntesting.demo.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void addUser(User u) {
        userRepository.save(u);
    }

    @Override
    public User updateUser(User u, Long id) {
          findById(u.getId());
//        k.setUserName(u.getUserName());
//        k.setPassword(u.getPassword());
        return userRepository.saveAndFlush(u);
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get(); //So that Optional can get the specific object which is user
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
