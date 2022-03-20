/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dab;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Land;

/**
 *
 * @author admin
 */
public class ListDBContext extends DBContext{
    public ArrayList<Land> getLands(){
        ArrayList<Land> lands = new ArrayList<>();
        try {
            String sql = "select a.LandID,a.LandName,a.SectorID,a.SectorName,a.ProjectID,P.ProjectName,a.Acreage,a.Price from\n" +
                         "(\n" +
                         "select LandID,LandName,l.SectorID,s.SectorName,s.ProjectID,Acreage,s.Price from Land l join Sector s \n" +
                         "on s.SectorID=l.SectorID\n" +
                         "group by LandID,LandName,l.SectorID,s.SectorName,s.ProjectID,Acreage,s.Price) a full join Project p\n" +
                         "on a.ProjectID=p.ProjectID\n" +
                         "group by a.LandID,a.LandName,a.SectorID,a.SectorName,p.ProjectID,a.ProjectID,a.Acreage,P.ProjectName,a.Price";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Land l = new Land();
                l.setId(rs.getInt("LandID"));
                l.setName(rs.getString("LandName"));
                l.setSid(rs.getInt("SectorID"));
                l.setSname(rs.getString("SectorName"));
                l.setPid(rs.getInt("ProjectID"));
                l.setPname(rs.getString("ProjectName"));
                l.setAcreage(rs.getFloat("Acreage"));
                l.setPrice(rs.getFloat("Price"));
                lands.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lands;
    }
}
