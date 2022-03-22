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
import model.Order;
import model.Project;
import model.Sector;

/**
 *
 * @author admin
 */
public class ListDBContext extends DBContext {

    public ArrayList<Land> getLands(int pageindex, int pagesize) {
        ArrayList<Land> lands = new ArrayList<>();
        try {
            String sql = "select LandID,LandName,SectorID,SectorName,ProjectID,ProjectName,Acreage,Price from\n"
                    + "(select a.LandID,a.LandName,a.SectorID,a.SectorName,a.ProjectID,P.ProjectName,a.Acreage,a.Price,ROW_NUMBER() over (order by LandID asc) as row_index from\n"
                    + "(\n"
                    + "select LandID,LandName,l.SectorID,s.SectorName,s.ProjectID,Acreage,s.Price from Land l join Sector s \n"
                    + "on s.SectorID=l.SectorID\n"
                    + "group by LandID,LandName,l.SectorID,s.SectorName,s.ProjectID,Acreage,s.Price) a left join Project p\n"
                    + "on a.ProjectID=p.ProjectID\n"
                    + "group by a.LandID,a.LandName,a.SectorID,a.SectorName,p.ProjectID,a.ProjectID,a.Acreage,P.ProjectName,a.Price\n"
                    + ") m\n"
                    + "WHERE row_index >= (? -1)*? + 1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
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

    public ArrayList<Sector> getSectors() {
        ArrayList<Sector> sectors = new ArrayList<>();
        try {
            String sql = "select s.SectorID,s.SectorName,s.Price,s.ProjectID,p.ProjectName from Sector s join Project p\n"
                    + "on s.ProjectID=p.ProjectID\n"
                    + "group by s.SectorID,s.SectorName,s.ProjectID,p.ProjectID,p.ProjectName,s.Price";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Sector s = new Sector();
                s.setId(rs.getInt("SectorID"));
                s.setName(rs.getString("SectorName"));
                s.setPrice(rs.getFloat("Price"));
                s.setPid(rs.getInt("ProjectID"));
                s.setPname(rs.getString("ProjectName"));
                sectors.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sectors;
    }

    public ArrayList<Sector> getSectors(int pageindex, int pagesize) {
        ArrayList<Sector> sectors = new ArrayList<>();
        try {
            String sql = "select SectorID,SectorName,Price,ProjectID,ProjectName from\n"
                    + "(\n"
                    + "select s.SectorID,s.SectorName,s.Price,s.ProjectID,p.ProjectName,ROW_NUMBER() over (order by SectorID asc) as row_index from Sector s join Project p\n"
                    + "                         on s.ProjectID=p.ProjectID\n"
                    + "                         group by s.SectorID,s.SectorName,s.ProjectID,p.ProjectID,p.ProjectName,s.Price) m\n"
                    + "						 WHERE row_index >= (? -1)*? + 1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Sector s = new Sector();
                s.setId(rs.getInt("SectorID"));
                s.setName(rs.getString("SectorName"));
                s.setPrice(rs.getFloat("Price"));
                s.setPid(rs.getInt("ProjectID"));
                s.setPname(rs.getString("ProjectName"));
                sectors.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sectors;
    }

    public ArrayList<Project> getProjects() {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            String sql = "select ProjectID,ProjectName from Project";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Project s = new Project();
                s.setId(rs.getInt("ProjectID"));
                s.setName(rs.getString("ProjectName"));
                projects.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    public ArrayList<Project> getProjects(int pageindex, int pagesize) {
        ArrayList<Project> projects = new ArrayList<>();
        try {
            String sql = "select ProjectID,ProjectName from\n"
                    + "(select ProjectID,ProjectName,ROW_NUMBER() over (order by ProjectID asc) as row_index from Project) m\n"
                    + "WHERE row_index >= (? -1)*? + 1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Project s = new Project();
                s.setId(rs.getInt("ProjectID"));
                s.setName(rs.getString("ProjectName"));
                projects.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return projects;
    }

    public ArrayList<Sector> getSectors(Project project) {
        ArrayList<Sector> sectors = new ArrayList<>();
        try {
            String sql = "select SectorID,ProjectID from Sector \n"
                    + "where ProjectID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, project.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Sector s = new Sector();
                s.setId(rs.getInt("SectorID"));
                s.setPid(rs.getInt("ProjectID"));
                sectors.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sectors;
    }

    public ArrayList<Land> getLands(Sector s) {
        ArrayList<Land> lands = new ArrayList<>();
        try {
            String sql = "select landID,SectorID from Land\n"
                    + "where SectorID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, s.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Land l = new Land();
                l.setId(rs.getInt("LandID"));
                l.setSid(rs.getInt("SectorID"));
                lands.add(l);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lands;
    }

    public Project getProject(int id) {
        try {
            String sql = "select ProjectID,ProjectName from Project where ProjectID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Project s = new Project();
                s.setId(rs.getInt("ProjectID"));
                s.setName(rs.getString("ProjectName"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Sector getSector(int id) {
        try {
            String sql = "select SectorID,SectorName,ProjectID,Price from Sector where SectorID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Sector s = new Sector();
                s.setId(rs.getInt("SectorID"));
                s.setName(rs.getString("SectorName"));
                s.setPid(rs.getInt("ProjectID"));
                s.setPrice(rs.getFloat("Price"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Sector> getSectors2(Project project) {
        ArrayList<Sector> sectors = new ArrayList<>();
        try {
            String sql = "select SectorID,SectorName from Sector \n"
                    + "where ProjectID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, project.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Sector s = new Sector();
                s.setId(rs.getInt("SectorID"));
                s.setName(rs.getString("SectorName"));
                sectors.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sectors;
    }

    public Land getLand(int id) {
        try {
            String sql = "select a.LandID,a.LandName,a.SectorID,a.SectorName,a.ProjectID,P.ProjectName,a.Acreage,a.Price from\n"
                    + "(\n"
                    + "select LandID,LandName,l.SectorID,s.SectorName,s.ProjectID,Acreage,s.Price from Land l  join Sector s \n"
                    + "on s.SectorID=l.SectorID\n"
                    + "group by LandID,LandName,l.SectorID,s.SectorName,s.ProjectID,Acreage,s.Price) a left join Project p\n"
                    + "on a.ProjectID=p.ProjectID\n"
                    + "where LandID=?\n"
                    + "group by a.LandID,a.LandName,a.SectorID,a.SectorName,p.ProjectID,a.ProjectID,a.Acreage,P.ProjectName,a.Price";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Land l = new Land();
                l.setId(rs.getInt("LandID"));
                l.setName(rs.getString("LandName"));
                l.setSid(rs.getInt("SectorID"));
                l.setAcreage(rs.getFloat("Acreage"));
                l.setPid(rs.getInt("ProjectID"));
                l.setPrice(rs.getFloat("Price"));
                return l;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Order> getOrders(int pageindex, int pagesize) {
        ArrayList<Order> Orders = new ArrayList<>();
        try {
            String sql = "select id,LandID,Date,StartPrice,EndPrice,Income from (\n"
                    + "select id,LandID,Date,StartPrice,EndPrice,Income,ROW_NUMBER() over (order by id asc) as row_index from [Orders]) m\n"
                    + "WHERE row_index >= (? -1)*? + 1 AND row_index <= ? * ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, pageindex);
            stm.setInt(2, pagesize);
            stm.setInt(3, pageindex);
            stm.setInt(4, pagesize);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setId(rs.getInt("id"));
                o.setLid(rs.getInt("LandID"));
                o.setDate(rs.getDate("Date"));
                o.setStartPrice(rs.getFloat("StartPrice"));
                o.setEndPrice(rs.getFloat("EndPrice"));
                o.setIncome(rs.getFloat("Income"));
                Orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Orders;
    }

    public int getLandID() {
        try {
            String sql = "select max(LandID) as ID from Land";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int x = rs.getInt("ID");
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getSectorID() {
        try {
            String sql = "select max(SectorID) as ID from Sector";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int x = rs.getInt("ID");
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int getProjectID() {
        try {
            String sql = "select max(ProjectID) as ID from Project";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                int x = rs.getInt("ID");
                return x;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public int countLand() {
        try {
            String sql = "SELECT COUNT(*) as Total FROM Land";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int countSector() {
        try {
            String sql = "SELECT COUNT(*) as Total FROM Sector";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int countProject() {
        try {
            String sql = "SELECT COUNT(*) as Total FROM Project";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int countOrders() {
        try {
            String sql = "SELECT COUNT(*) as Total FROM Orders";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("Total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

}
