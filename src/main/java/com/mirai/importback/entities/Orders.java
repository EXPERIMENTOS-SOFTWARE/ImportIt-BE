package com.mirai.importback.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="Orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="dni",nullable = false,length = 8)
    private String dni;
    @Column(name="name",nullable = false,length = 50)
    private String name;
    @Column(name="url",nullable = false,length = 10000)
    private String url;
    @Column(name = "tittle",nullable = false,length = 50)
    private String tittle;
    @Column(name="price",nullable = false,length = 20)
    private String price;
    @Column(name="weight",nullable = true,length = 30)
    private String weight;
    @Column(name="amount",nullable = true,length = 20)
    private String amount;
    @Column(name="status",nullable = true,length = 20)
    private String status;
    @Column(name="statusStep",nullable = true,length = 20)
    private int statusStep;
    @Column(name="comision",nullable = true,length = 20)
    private String comision;

    public Orders(long id, String dni, String name, String url, String tittle, String price, String weight, String amount, String status, String comision) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.url = url;
        this.tittle = tittle;
        this.price = price;
        this.weight = weight;
        this.amount = amount;
        this.status = status;
        this.comision = comision;
    }

    public Orders(String status, int statusStep) {
        this.status = status;
        this.statusStep = statusStep;
    }
}