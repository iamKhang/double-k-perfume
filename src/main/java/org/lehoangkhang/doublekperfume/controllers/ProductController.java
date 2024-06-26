package org.lehoangkhang.doublekperfume.controllers;

import org.lehoangkhang.doublekperfume.entity.Brand;
import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.service.BrandService;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/admin/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @RequestMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
        return "admin/pages/addProduct";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, @RequestParam("images") String[] imagesArray) {
        Set<String> imagesSet = new HashSet<>(Arrays.asList(imagesArray));
        product.setImages(imagesSet);
        productService.addProduct(product);
        return "redirect:/admin/product/add";
    }


}
