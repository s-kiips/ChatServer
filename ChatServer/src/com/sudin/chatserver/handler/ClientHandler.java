/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.chatserver.handler;

import com.sudin.chatserver.entity.Client;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ranji
 */
public class ClientHandler extends Thread{
    private List<Client> clients=new ArrayList<>();
    public void addclient(Client client){
        clients.add(client);
    }
    public Client  getByUserName(String username){
        for(Client c:clients){
            if(c.getUserName().equalsIgnoreCase(username)){
                return c;
            }
        }
        return null;
    }
    public List<Client> getClients(){
        return clients; 
    }
    
}
