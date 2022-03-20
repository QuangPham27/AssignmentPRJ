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
import model.Sector;

/**
 *
 * @author admin
 */
public class SectorDBContext extends DBContext{
    public void insertSector(Sector s){
        String sql = "insert into Sector([SectorID],[SectorName],[ProjectID],[Price]) values (?,?,?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, s.getId());
            stm.setString(2, s.getName());
            stm.setInt(3, s.getPid());
            stm.setFloat(4, s.getPrice());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SectorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(SectorDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SectorDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateSector(Sector s){
        
    }
    
    public void deleteSector(Sector s){
        String sql = "DELETE Sector\n" +
                        " WHERE [SectorID] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, s.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SectorDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(SectorDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(SectorDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
