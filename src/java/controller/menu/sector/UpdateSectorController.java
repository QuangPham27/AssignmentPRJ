/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menu.sector;

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

/**
 *
 * @author admin
 */
public class UpdateSectorController extends HttpServlet {



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
        int id = Integer.parseInt(request.getParameter("id"));
        ListDBContext db = new ListDBContext();
        ArrayList<Project> projects = db.getProjects();
        request.setAttribute("projects", projects);
        Sector s = db.getSector(id);
        request.setAttribute("id", id);
        request.setAttribute("name", s.getName());
        request.setAttribute("pid", s.getPid());
        request.setAttribute("price", s.getPrice());
        request.setAttribute("sector", s);
        request.getRequestDispatcher("/menu/sector/updateSector.jsp").forward(request, response);
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
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int pid = Integer.parseInt(request.getParameter("pid"));
        float price = Float.parseFloat(request.getParameter("price"));
        Sector s = new Sector();
        s.setId(id);
        s.setName(name);
        s.setPid(pid);
        s.setPrice(price);
        SectorDBContext db = new SectorDBContext();
        db.updateSector(s);
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
