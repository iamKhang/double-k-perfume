package org.lehoangkhang.doublekperfume.service;

import org.lehoangkhang.doublekperfume.entity.Brand;

import java.util.List;

public interface BrandService {
    public List<Brand> getAllBrands();
    public Brand getBrandById(String id);
    public boolean addBrand(Brand brand);
    public boolean updateBrand(Brand brand);
    public void deleteBrand(String id);
}
