package org.lehoangkhang.doublekperfume.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "order_detail")
@NoArgsConstructor
@Getter
public class OrderDetail {
    @Id
    @ManyToOne
    @JoinColumn(name = "product_barcode")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    private int quantity;
    private double price;
    private double discount;

    private double total;

    /**
     * Tính tổng tiền của sản phẩm
     */
    public void calculateTotal() {
        this.total = this.quantity * this.price * (1 - this.discount);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
