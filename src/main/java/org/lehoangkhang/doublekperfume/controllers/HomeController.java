package org.lehoangkhang.doublekperfume.controllers;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductService productService;

    @RequestMapping
    public String home(Model model) {
        List<Product> products = productService.getAvailableProducts();
        // System.out.println(products);
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

    // Vào trang quản lý
    @GetMapping("/admin")
    public String admin() {
        return "admin/pages/adminPage";
    }

    // Vào trang tất cả sản phẩm
    @GetMapping("/products")
    public String products(Model model,
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            // Sản phẩm có bán chạy hay không
            @RequestParam(name = "bestSeller", required = false, defaultValue = "false") Boolean bestSeller, 
            // Lấy theo thương hiệu
            @RequestParam(name = "brand", required = false) String brand
            ) {
        List<Product> products = productService.getProductsByPage(page-1);
        int totalPage = productService.getNumberOfPages();
        model.addAttribute("products", products);
        // Page hiện tại
        int currentPage = page;
        model.addAttribute("currentPage", currentPage); // Thêm list này vào model
        model.addAttribute("totalPage", totalPage); // Thêm list này vào model
        return "user/pages/productsPage";
    }
}
