package org.lehoangkhang.doublekperfume.controllers;

import org.lehoangkhang.doublekperfume.entity.Brand;
import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.entity.Role;
import org.lehoangkhang.doublekperfume.entity.User;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.lehoangkhang.doublekperfume.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        user.setRole(new Role(1L, "USER", "Người dùng có quyền xem sản phẩm"));

        user.setEnabled(true);
        userService.addUser(user);
        System.out.println("Mật khẩu đã được mã hóa: " + new BCryptPasswordEncoder().encode("1"));

        return "redirect:/";
    }

    //    Thông tin chi tiết sản phẩm
    @RequestMapping("/product-detail/{id}")
    public String productDetail(Model model, @PathVariable("id") String id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "user/pages/productDetailPage";
    }

}
