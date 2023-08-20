package com.portfolio.personalPortfolio.repository;

import com.portfolio.personalPortfolio.entities.PdfFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdfFileRepository extends JpaRepository<PdfFile, Integer> {

}
