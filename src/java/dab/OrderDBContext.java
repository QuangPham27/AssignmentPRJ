/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dab;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author admin
 */
public class OrderDBContext extends DBContext{
    public void insertOrder(Order o){
        String sql = "insert into Orders([id],[LandID],[Date],[StartPrice],[EndPrice],[Income]) values (?,?,?,?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, o.getId());
            stm.setInt(2, o.getLid());
            stm.setDate(3, o.getDate());
            stm.setFloat(4, o.getStartPrice());
            stm.setFloat(5, o.getEndPrice());
            stm.setFloat(6, o.getIncome());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(OrderDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
