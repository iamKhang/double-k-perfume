package org.lehoangkhang.doublekperfume.service;


import org.lehoangkhang.doublekperfume.entity.User;

public interface UserService {
    User findByUserName(String userName);

    void addUser(User user);
}
