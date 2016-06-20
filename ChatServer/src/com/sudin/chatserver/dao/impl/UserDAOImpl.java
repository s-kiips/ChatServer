/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.chatserver.dao.impl;

import com.sudin.chatserver.dao.UserDAO;
import com.sudin.chatserver.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranji
 */
public class UserDAOImpl implements UserDAO{

    @Override
    public User login(String userName, String password) {
        for(User u:getall()){
//            System.out.println(u.toString());
            if(u.getUserName().equalsIgnoreCase(userName) && u.getPassword().equals(password));
            return u;
        }
        return null;
    }

    @Override
    public List<User> getall() {
    List<User> users =new ArrayList<>();
    users.add(new User(1, "sudin", "ranjitkar", true));
    users.add(new User(2, "sudeen", "ranjit", false));
     return users;
    }
    
}
