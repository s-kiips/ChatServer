/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.chatserver.dao;

import com.sudin.chatserver.entity.User;
import java.util.List;

/**
 *
 * @author ranji
 */
public interface UserDAO {
    User login(String userName, String password);
    List<User> getall();
}
