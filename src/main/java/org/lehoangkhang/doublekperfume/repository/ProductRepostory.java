package org.lehoangkhang.doublekperfume.repository;

import org.lehoangkhang.doublekperfume.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepostory extends JpaRepository<Product, String> {

}
