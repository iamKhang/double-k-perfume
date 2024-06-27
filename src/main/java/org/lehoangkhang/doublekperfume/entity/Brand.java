package org.lehoangkhang.doublekperfume.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "brand")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    // Tên chỉ tồn tại duy nhất
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "brand")
    private List<Product> products;
    private String description;
    private String origin;

    @Override
    public String toString() {
        return "Brand{" +
                ", name='" + name + '\'' +
                '}';
    }
}
