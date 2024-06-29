package org.lehoangkhang.doublekperfume.controllers;

import java.util.List;

import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    public String home(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "user/index";
    }

    // Vào trang đăng ký
    @GetMapping("/register")
    public String register() {
        return "user/pages/registerPage";
    }

    // Vào trang đăng nhập
    @GetMapping("/login")
    public String login() {
        return "user/pages/loginPage";
    }
}
