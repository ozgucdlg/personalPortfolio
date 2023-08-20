package com.portfolio.personalPortfolio.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="pdfTable")
@AllArgsConstructor
@NoArgsConstructor
public class PdfFile {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="fileName")
    private String fileName;

    @Lob
    private byte[] content;

}
