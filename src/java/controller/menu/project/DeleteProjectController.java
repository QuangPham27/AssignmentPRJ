/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menu.project;

import dab.LandDBContext;
import dab.ListDBContext;
import dab.ProjectDBContext;
import dab.SectorDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Project;
import model.Sector;
import model.Land;

/**
 *
 * @author admin
 */
public class DeleteProjectController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Project p = new Project();
        p.setId(id);
        ListDBContext db = new ListDBContext();
        ProjectDBContext db1 = new ProjectDBContext();
        SectorDBContext db2 = new SectorDBContext();
        LandDBContext db3 = new LandDBContext();
        ArrayList<Sector> sectors = db.getSectors(p);
        for (int i=0;i<sectors.size();i++){
            Sector s = new Sector();
            s.setId(sectors.get(sectors.size()-1).getId());
            ArrayList<Land> lands = db.getLands(s);
            for (int j=0;j<lands.size();j++){
                db3.deleteLand(lands.get(lands.size()-1));
            }
            db2.deleteSector(s);
        }       
        db1.deleteProject(p);
        response.sendRedirect("/Assignment/menu/project");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}