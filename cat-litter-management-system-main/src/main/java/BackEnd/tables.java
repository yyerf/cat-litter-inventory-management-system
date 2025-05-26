package BackEnd;

import java.sql.*;
import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try 
        {
            con=ConnectionProvider.getCon();
            st=con.createStatement();
            //querry 
            st.executeUpdate(
    "CREATE TABLE users (" +
    "name VARCHAR(200), " +
    "username VARCHAR(200), " +
    "password VARCHAR(50), " +
    "securityQuestion VARCHAR(500), " +
    "answer VARCHAR(200), " +
    "address VARCHAR(200), " +
    "status VARCHAR(20)" + ")"
);
            st.executeUpdate(
    "CREATE TABLE products (" +
    "productId INT PRIMARY KEY AUTO_INCREMENT, " +
    "name VARCHAR(200), " +
    "scent VARCHAR(100), " +
    "stocks INT, " +
    "price INT, " +
    "lastRestock DATE" + ")"
);

            st.executeUpdate(
    "CREATE TABLE sales (" +
    "saleId INT PRIMARY KEY AUTO_INCREMENT, " +
    "buyerName VARCHAR(200), " +
    "purchaseDate DATE, " +
    "productId INT, " +
    "quantityBought INT, " +
    "paymentMode VARCHAR(100), " +
    "totalSales INT, " +
    "FOREIGN KEY (productId) REFERENCES products(productId) " + ")"
);
            JOptionPane.showMessageDialog(null, "Table Created Successfully");

        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                con.close();
                st.close();
            } catch (Exception e) {
            }
        }
    }
}
