package org.lehoangkhang.doublekperfume.repository;

import org.lehoangkhang.doublekperfume.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer> {
}
