package org.lehoangkhang.doublekperfume.repository;

import java.util.List;

import org.lehoangkhang.doublekperfume.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostory extends JpaRepository<Product, String> {

    List<Product> findByIsAvailable(boolean b);
    // Lấy danh sách sản phẩm, có phân trang
    Page<Product> findAll(Pageable pageable);
    // Trả về số trang, mỗi trang có 20 sản phẩm
    Page<Product> findAllByIsAvailable(boolean b, Pageable pageable);

}
