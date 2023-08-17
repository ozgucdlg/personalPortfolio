package com.portfolio.personalPortfolio.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;

    @Column(name="userName")
    private String userName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="phneNumber")
    private String phoneNumber;

    @Column(name="email")
    private String email;




}
