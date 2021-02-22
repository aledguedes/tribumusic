/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tribumusic.dao;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

/**
 *
 * @author alexa
 */
public class DataSourse {
    private String hostname;
    private String username;
    private String password;
    private String database;
    private Connection connection;

    public DataSourse() {
        try{
            hostname = "localhost";
            database = "tribumusic";
            username = "tribumusic";
            password = "ale123";
            String URL= "jdbc:msql://"+hostname+":3306/"+database;
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(URL, username, password);
            System.out.println("DataSource - Connected");
            
        }
        catch(SQLException ex){
            System.out.println("Erro ao Conectar - "+ex.getMessage());
        }
    }
    public Connection getConnection(){
        return this.connection; 
    }
}
