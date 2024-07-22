package org.lehoangkhang.doublekperfume.controllers;

import org.lehoangkhang.doublekperfume.entity.Brand;
import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.service.BrandService;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping("/list")
    public String listProduct(Model model) {
        List<Product> products = productService.getAllProducts();
        System.out.println(products);
        model.addAttribute("products", products);
        return "admin/pages/listProduct";
    }



    @GetMapping("/edit/{id}")
	public String editProduct(Model model, @PathVariable("id") String id) {
	    Product product = productService.getProductById(id);
        // Hiển thị thông tin sản phẩm
        System.out.println(product.toString());
	    model.addAttribute("product", product);

        List<Brand> brands = brandService.getAllBrands();
        model.addAttribute("brands", brands);
	    return "admin/pages/editProduct";
	}


	
	@PostMapping("/product/edit/save")
	public String saveEdit(@ModelAttribute Product product) {
		if (productService.updateProduct(product)) {
			return "redirect:/admin/product";
		}
		return "admin/pages/editProduct";
	}

    @RequestMapping("/delete/{id}/{isAvailable}")
    public String deleteProduct(@PathVariable("id") String id, @PathVariable("isAvailable") Boolean isAvailable) {
        productService.updateAvailable(id, isAvailable);
        return "redirect:/admin/product/list";
    }


}
