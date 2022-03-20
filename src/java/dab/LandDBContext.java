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
import model.Land;

/**
 *
 * @author admin
 */
public class LandDBContext extends DBContext{
    public void insertLand(Land l) {
        String sql = "INSERT INTO [Land]\n" +
                    "           ([LandID]\n" +
                    "           ,[LandName]\n" +
                    "           ,[SectorID]\n" +
                    "           ,[Acreage]\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, l.getId());
            stm.setString(2, l.getSname());
            stm.setInt(3, l.getSid());
            stm.setFloat(4, l.getAcreage());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LandDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(LandDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(LandDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}