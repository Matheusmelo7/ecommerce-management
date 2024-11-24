package br.com.ecommercemanagement.model;

import br.com.ecommercemanagement.controller.costumer.CostumerDTO;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "COSTUMERS")
@Getter
@Setter
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
                .phone(this.phone)
                .createAt(this.createAt)
                .build();
    }
}
