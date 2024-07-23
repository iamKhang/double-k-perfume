package org.lehoangkhang.doublekperfume.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    private String barcode;
    private String name;
    @Column(columnDefinition = "TEXT")
    private String description;
    private double price;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> images;
    @ManyToOne
    @JoinColumn(name = "brand_name")
    private Brand brand;
    //    Giới tính
    private String sex;
    //    Tầng hương
    @Column(name = "top_notes")
    private String topNotes;
    @Column(name = "middle_notes")
    private String middleNotes;
    @Column(name = "base_notes")
    private String baseNotes;
    // Nhóm hương
    @Column(name = "perfume_scent")
    private String perfumeScent;
    
    
    //    Dung tích
    @Column(name = "volume")
    private int volume;
    // Phong cách
    @Column(name = "style")
    private String style;

    // Còn bán
    @Column(name = "is_available")
    private Boolean isAvailable;

    // Sản phẩm bán chạy
    @Column(name = "is_best_seller")
    private Boolean isBestSeller;

    // Số lượng sản phẩm còn lại
    @Column(name = "quantity")
    private int quantity;

    // Số lượng sản phẩm đã bán
    @Column(name = "sold_quantity")
    private int soldQuantity;
    

    @Override
    public String toString() {
        return "Product{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", brand='" + brand + '\'' +
                ", sex=" + sex +
                ", topNotes='" + topNotes + '\'' +
                ", middleNotes='" + middleNotes + '\'' +
                ", baseNotes='" + baseNotes + '\'' +
                ", volume=" + volume +
                '}';
    }


    public String[] getImagesArray() {
        if (images != null) {
            return images.toArray(new String[0]);
        }
        return new String[0]; // Trả về một mảng rỗng nếu không có hình ảnh
    }
}
