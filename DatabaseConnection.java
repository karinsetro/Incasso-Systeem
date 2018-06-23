package ictdelivery.instance;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    
    private Connection con;
    private static DatabaseConnection dbc;
    
    private DatabaseConnection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver Loaded!");
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ict_delivery_db","root","");
            System.out.println("Connection made succesfully!");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static DatabaseConnection getDatabaseConnection()
    {
        if(dbc==null){
            
            dbc = new DatabaseConnection();
        }
        return dbc;
    }
    
    public Connection getConnection(){
        
        return con;
    }
}
