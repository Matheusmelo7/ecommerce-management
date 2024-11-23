package br.com.ecommerce_management.model;

import br.com.ecommerce_management.controller.costumer.CostumerDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "COSTUMERS")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CostumersEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "costumerSequence", sequenceName = "costumersSeq", allocationSize = 1)
    @Column(name = "ID_COSTUMER")
    private Long idCostumer;

    @Column(name = "NAME")
    private String name;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "PASSWORD")
    private String pass;

    @Column(name = "CREATE_AT")
    @CreationTimestamp
    private LocalDateTime createAt;

    @OneToMany
    private List<OrderCostumerEntity> orderCostumerEntity;


    public CostumerDTO toDTO() {
        return CostumerDTO.builder()
                .id(this.idCostumer)
                .name(this.name)
                .email(this.email)
                .pass(this.pass)
                .phone(this.phone)
                .createAt(this.createAt)
                .build();
    }
}
