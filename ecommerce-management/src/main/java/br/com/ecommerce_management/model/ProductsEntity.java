package br.com.ecommerce_management.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "PRODUCTS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductsEntity {

    @Column(name = "ID_PRODUCT")
    @SequenceGenerator(name = "productSequence", sequenceName = "productSeq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @Id
    private Long idProduct;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private Long price;

    @Column(name = "STOCK_QUANTITY")
    private Long stockQuantity;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private LocalDateTime createdAt;






}
