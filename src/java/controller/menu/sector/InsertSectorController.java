/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menu.sector;

import dab.ListDBContext;
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

/**
 *
 * @author admin
 */
public class InsertSectorController extends HttpServlet {

   

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
        ListDBContext db = new ListDBContext();
        ArrayList<Project> projects = db.getProjects();
        request.setAttribute("projects", projects);
        request.getRequestDispatcher("/menu/sector/insertSector.jsp").forward(request, response);
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
        Sector s = new Sector();
        ListDBContext db = new ListDBContext();
        SectorDBContext db1 = new SectorDBContext();
        int id = db.getSectors().size();
        s.setId(id+1);
        String name = request.getParameter("name");
        s.setName(name);
        float price = Float.parseFloat(request.getParameter("price"));
        s.setPrice(price);
        int pid = Integer.parseInt(request.getParameter("pid"));
        Project p = db.getProject(pid);
        s.setPid(pid);
        s.setPname(p.getName());
        db1.insertSector(s);
        response.sendRedirect("/Assignment/menu/sector");
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
