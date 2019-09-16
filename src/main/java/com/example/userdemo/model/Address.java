package com.example.userdemo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String street;

    private String suite;

    private String city;

    private String zipCode;

    private Double latitude;

    private Double longitude;

    @OneToOne(mappedBy = "address")
    private User user;
}
