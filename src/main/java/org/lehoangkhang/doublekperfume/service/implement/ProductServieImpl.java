package org.lehoangkhang.doublekperfume.service.implement;

import org.lehoangkhang.doublekperfume.entity.Product;
import org.lehoangkhang.doublekperfume.repository.ProductRepostory;
import org.lehoangkhang.doublekperfume.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServieImpl implements ProductService {

    @Autowired
    private ProductRepostory productRepostory;

    @Override
    public List<Product> getAllProducts() {
        return productRepostory.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return null;
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
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProduct(String id) {

    }
}
