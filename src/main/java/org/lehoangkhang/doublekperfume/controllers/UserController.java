package org.lehoangkhang.doublekperfume.controllers;

import org.lehoangkhang.doublekperfume.entity.Brand;
import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.entity.Role;
import org.lehoangkhang.doublekperfume.entity.User;
import org.lehoangkhang.doublekperfume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setRole(new Role(1L, "ROLE_USER", "Người dùng có quyền xem sản phẩm"));
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        user.setEnabled(true);
        userService.addUser(user);


        return "redirect:/";
    }
}
