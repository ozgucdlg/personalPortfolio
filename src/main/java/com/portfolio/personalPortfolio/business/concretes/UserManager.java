package com.portfolio.personalPortfolio.business.concretes;

import com.portfolio.personalPortfolio.business.abstracts.UserService;
import com.portfolio.personalPortfolio.entities.Userr;
import com.portfolio.personalPortfolio.entities.Userr;
import com.portfolio.personalPortfolio.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class UserManager implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Userr> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Userr add(Userr user) {
        return userRepository.save(user);
    }

    @Override
    public Userr getById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Userr update(Userr user) {
    return userRepository.save(user);
    }
}
