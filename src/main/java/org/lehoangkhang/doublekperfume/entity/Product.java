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
    @ElementCollection
    private Set<String> images;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;
    //    Xuất xứ
    private String origin;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    //    Loại da
    @Column(name = "skin_type")
    private String skinType;
    //    Mùi hương
    @Column(name = "top_notes")
    private String topNotes;
    @Column(name = "middle_notes")
    private String middleNotes;
    @Column(name = "base_notes")
    private String baseNotes;
    //    Hướng dẫn sử dụng
    @Column(name = "how_to_use")
    private String howToUse;
    //    Nhà chế tác
    @Column(name = "creator")
    private String creator;
    //    Dung tích
    @Column(name = "volume")
    private int volume;

    @Override
    public String toString() {
        return "Product{" +
                "barcode='" + barcode + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", images=" + images +
                ", brand='" + brand + '\'' +
                ", origin='" + origin + '\'' +
                ", sex=" + sex +
                ", skinType='" + skinType + '\'' +
                ", topNotes='" + topNotes + '\'' +
                ", middleNotes='" + middleNotes + '\'' +
                ", baseNotes='" + baseNotes + '\'' +
                ", howToUse='" + howToUse + '\'' +
                ", creator='" + creator + '\'' +
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
