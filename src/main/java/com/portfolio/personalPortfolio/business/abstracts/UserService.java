package com.portfolio.personalPortfolio.business.abstracts;


import com.portfolio.personalPortfolio.entities.User;

import java.util.List;

public interface UserService  {

    List<User> getAll();
    User add(User user);
    User getById(int id);
    void delete(int id);
    User update(User user);

}
