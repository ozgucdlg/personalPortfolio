package com.portfolio.personalPortfolio.repository;

import com.portfolio.personalPortfolio.entities.Userr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userr, Integer> {
}
