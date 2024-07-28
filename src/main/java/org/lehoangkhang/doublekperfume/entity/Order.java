package org.lehoangkhang.doublekperfume.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    private String id;
    private LocalDateTime orderDate;
    private String status;
    private String paymentMethod;
    private String total;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
    @OneToMany(mappedBy = "order")
    private Set<OrderDetail> orderDetails;
    private String address;
    private String phone;
    private String note;
}
