package com.portfolio.personalPortfolio.business.abstracts;


import com.portfolio.personalPortfolio.entities.Userr;

import java.util.List;

public interface UserService  {

    List<Userr> getAll();
    Userr add(Userr user);
    Userr getById(int id);
    void delete(int id);
    Userr update(Userr user);

}
