package org.lehoangkhang.doublekperfume.service.implement;

import org.lehoangkhang.doublekperfume.entity.User;
import org.lehoangkhang.doublekperfume.repository.UserRepository;
import org.lehoangkhang.doublekperfume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplt implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }
}
