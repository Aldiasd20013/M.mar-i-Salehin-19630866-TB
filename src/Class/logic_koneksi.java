/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Glora
 */
public class logic_koneksi {

    public static String almDir = System.getProperty("user.dir") + "/src/report/";
    public static Connection vkoneksi = null;
    private boolean blnIsConnected = false;
    private String jServer = "localhost:3306";
    private String jDatabase = "pratikum2020";
    private String jUser = "root";
    private String jPassword = "";
    
    public void setServer(String value) {
        jServer = value;
        System.out.println(jServer);
    }
    
    public void setUser(String value){
        jUser = value;
    }
    
    public void setPassword(String value){
        jPassword = value;
    }
    
    public void setDatabase (String value){
        jDatabase = value;
    }
    
    public String getServer() {
        return jServer;
    }
    
    public String getUser() {
        return jUser;
    }
    
    public String getPassword() {
        return jPassword;
    }
    
    public String getDatabase() {
        return jDatabase;
    }
    
    public static Connection getConnection() {
        return vkoneksi;
    }
    
    public boolean isConnected() {
        return blnIsConnected;
    }
    
    private boolean isValidConf() {
        boolean result = false;
        try {
            if (jServer.equals("")
                    || jDatabase.equals("")
                    || jUser.equals(""))
            {
        result = false;
            } else {
                result = true;
            }
    } catch (Exception e) {
        System.out.println(e);
    }
    return result;
    }
    
    public boolean makeConnect() {
        String urlValue = "";
        blnIsConnected = false;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            urlValue = "jdbc:mysql://" + jServer + "/" + jDatabase + "?user=" + jUser + "&password=" + jPassword;
            if (isValidConf()) {
                vkoneksi = DriverManager.getConnection(urlValue);
                blnIsConnected = true;
                System.out.println("Koneksi Seusai Kondisi, ditemukan");           
            }
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal " + e.toString());
            
        } catch (ClassNotFoundException e) {
            System.out.println("jdbc.Driver tidak ditemukan");
        }
        if (blnIsConnected == false) {
            System.out.println("Koneksi Gagal");
        }
        return blnIsConnected;
    }
    
    public void konek() {
        vkoneksi = null;
        makeConnect();
    }
    
    public static int executestatement(String Q) {
        int status = 0;
        try {
            Statement st = getConnection().createStatement();
            status = st.executeUpdate(Q);
        } catch (SQLException ex) {
            Logger.getLogger(logic_koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }
    
    public static ResultSet executeQuery(String SQL) {
        ResultSet rs = null;
        try{
            Statement st = 
                    getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            rs = st.executeQuery(SQL);
        } catch (SQLException ex) {
            Logger.getLogger(logic_koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
    
