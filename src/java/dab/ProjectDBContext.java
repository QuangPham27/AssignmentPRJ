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
import model.Project;

/**
 *
 * @author admin
 */
public class ProjectDBContext extends DBContext{
    public void insertProject(Project p) {
        String sql = "insert into Project([ProjectID],[ProjectName]) values (?,?)";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, p.getId());
            stm.setString(2, p.getName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void deleteProject(Project p) {
        String sql = "DELETE Project\n" +
                        " WHERE [ProjectID] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(1, p.getId());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void updateProject(Project p) {
        String sql = "UPDATE [Project]\n" +
                        "   SET [ProjectName] = ?\n" +
                        " WHERE [ProjectID] = ?";
        PreparedStatement stm = null;
        try {
            stm = connection.prepareStatement(sql);
            stm.setInt(2, p.getId());
            stm.setString(1, p.getName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            if(stm != null)
                try {
                    stm.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(connection != null)
                try {
                    connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ProjectDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
