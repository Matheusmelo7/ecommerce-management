package br.com.ecommercemanagement.model;

import br.com.ecommercemanagement.controller.product.ProductDTO;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_generator")
    @SequenceGenerator(name = "product_generator", sequenceName = "products_seq", allocationSize = 1)
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



    public ProductDTO toDTO (){
        return ProductDTO
                .builder()
                .id(this.idProduct)
                .name(this.name)
                .description(this.description)
                .price(this.price)
                .stockQuantity(this.stockQuantity)
                .createdAt(this.createdAt)
                .build();

    }



}
