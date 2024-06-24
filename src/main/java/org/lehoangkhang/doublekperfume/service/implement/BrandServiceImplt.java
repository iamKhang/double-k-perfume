package org.lehoangkhang.doublekperfume.service.implement;

import org.lehoangkhang.doublekperfume.entity.Brand;
import org.lehoangkhang.doublekperfume.repository.BrandRepository;
import org.lehoangkhang.doublekperfume.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImplt implements BrandService {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.findAll(
                Sort.by(Sort.Direction.ASC, "name")
        );
    }

    @Override
    public Brand getBrandById(String id) {
        return null;
    }

    @Override
    public boolean addBrand(Brand brand) {
        return false;
    }

    @Override
    public boolean updateBrand(Brand brand) {
        return false;
    }

    @Override
    public void deleteBrand(String id) {

    }
}
