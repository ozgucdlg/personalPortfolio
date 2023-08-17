package com.portfolio.personalPortfolio.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity

@Data
@Table(name="userr")
public class Userr {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="id")
    private int Id;

    @Column(name="userName")
    private String userName;

    @Column(name="lastName")
    private String lastName;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @Column(name="message")
    private String message;




}
