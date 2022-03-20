/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menu.land;

import dab.ListDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Land;
import model.Project;
import model.Sector;

/**
 *
 * @author admin
 */
public class UpdateLandController extends HttpServlet {



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
        Land l = db.getLand(id); 
        ArrayList<Sector> sectors = db.getSectors();
        request.setAttribute("sectors", sectors);
        ArrayList<Project> projects = db.getProjects();
        request.setAttribute("projects", projects);             
        request.setAttribute("id", id);
        request.setAttribute("name", l.getName());
        request.setAttribute("acreage", l.getAcreage());
        request.setAttribute("pid", l.getPid());
        request.setAttribute("sid", l.getSid());
        request.getRequestDispatcher("/menu/land/updateLand.jsp").forward(request, response);
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
        float acreage = Float.parseFloat(request.getParameter("acreage"));
        int pid = Integer.parseInt(request.getParameter("pid"));
        ListDBContext db = new ListDBContext();
        Land l = db.getLand(id);
        Project p = db.getProject(pid);
        String pname = p.getName();
        request.setAttribute("name", name);
        request.setAttribute("pname", pname);
        request.setAttribute("acreage", acreage);
        request.setAttribute("pid", pid);
        request.setAttribute("sid", l.getSid());
        ArrayList<Sector> sectors = db.getSectors2(p);
        request.setAttribute("sectors", sectors);
        ArrayList<Project> projects = db.getProjects();
        request.setAttribute("projects", projects);
        request.getRequestDispatcher("/menu/land/updateLand2.jsp").forward(request, response);
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
