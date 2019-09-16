package com.example.userdemo.model;

import javax.persistence.*;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public String catchPhrase;

    public String bs;

    @OneToOne(mappedBy = "company")
    private User user;
}
