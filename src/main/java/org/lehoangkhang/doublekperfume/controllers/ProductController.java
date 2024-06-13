package org.lehoangkhang.doublekperfume.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/product")
public class ProductController {
//    @RequestMapping
//    public String product() {
//        return "admin/product";
//    }

    @RequestMapping("/add")
    public String addProduct() {
        return "admin/pages/addProduct";
    }
}
