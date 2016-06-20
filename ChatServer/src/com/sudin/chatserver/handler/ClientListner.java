/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sudin.chatserver.handler;

import com.sudin.chatserver.dao.UserDAO;
import com.sudin.chatserver.dao.impl.UserDAOImpl;
import com.sudin.chatserver.entity.Client;
import com.sudin.chatserver.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author ranji
 */
public class ClientListner extends Thread {

    private Socket client;
    private ClientHandler handler;
    private PrintStream printer;
    private BufferedReader reader;

    public ClientListner(Socket client, ClientHandler handler) throws IOException {
        this.client = client;
        this.handler = handler;
        printer = new PrintStream(client.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }

    @Override
    public void run() {
        try {
            while (!doLogin()) {

            }
        } catch (IOException ioe) {

        }
    }

    private boolean doLogin() throws IOException {
        while(true){
        
        UserDAO userDAO = new UserDAOImpl();
        userDAO.getall();
        printer.println("enter username:");
        String username = reader.readLine();
        printer.println("enter password:");
        String password = reader.readLine();
        User user = userDAO.login(username, password);
        if (user != null) {
            
       
           handler.addclient(new Client(client, username));
            printer.println("welcome");
            
           break;
        }
        else{
           printer.println("thank you visit again");
            break;
//            return false;

//            return true;
        }

//        printer.println("invalid login");
       
        }
    
     return false;
}
}
