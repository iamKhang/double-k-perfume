package org.lehoangkhang.doublekperfume.service;

import org.lehoangkhang.doublekperfume.entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(String id);
    public boolean addProduct(Product product);
    public boolean updateProduct(Product product);
    public void deleteProduct(String id);
    // Cập nhật trạng thái ngưng bán
    public void updateAvailable(String id, Boolean isAvailable);
    // Lấy sản phẩm còn bán
    public List<Product> getAvailableProducts();
}
