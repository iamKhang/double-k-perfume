package org.lehoangkhang.doublekperfume.service.implement;

import org.springframework.data.domain.Page;
import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.repository.ProductRepostory;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServieImpl implements ProductService {

    @Autowired
    private ProductRepostory productRepostory;

    @Override
    public List<Product> getAllProducts() {
//        System.out.println(productRepostory.findAll());
        return productRepostory.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepostory.findById(id).orElse(null);
    }

    @Override
    public boolean addProduct(Product product) {
        try {
            productRepostory.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try {
            productRepostory.save(product);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void deleteProduct(String id) {

    }

    @Override
    public void updateAvailable(String id, Boolean isAvailable) {
        try {
            Product product = productRepostory.findById(id).orElse(null);
            product.setIsAvailable(isAvailable);
            productRepostory.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> getAvailableProducts() {
        return productRepostory.findByIsAvailable(true);
    }

    @Override
    public List<Product> getProductsByPage(int page) {
        try{
            Page<Product> productPage = productRepostory.findAll(PageRequest.of(page, 5));
            return productPage.getContent();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int getNumberOfPages() {
        try{
            Page<Product> productPage = productRepostory.findAll(PageRequest.of(0, 5));
            return productPage.getTotalPages();
        }
        catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }
}
