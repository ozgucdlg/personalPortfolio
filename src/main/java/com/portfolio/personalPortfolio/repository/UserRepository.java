package com.portfolio.personalPortfolio.repository;

import com.portfolio.personalPortfolio.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
