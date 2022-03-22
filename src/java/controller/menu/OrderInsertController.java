/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.menu;

import dab.LandDBContext;
import dab.ListDBContext;
import dab.OrderDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Land;
import model.Order;

/**
 *
 * @author admin
 */
public class OrderInsertController extends HttpServlet {


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
        Land land = db.getLand(id);
        request.setAttribute("land", land);
        request.getRequestDispatcher("/menu/order/orderInsert.jsp").forward(request, response);
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
        ListDBContext db = new ListDBContext();
        int id = db.countOrders()+1;
        int lid = Integer.parseInt(request.getParameter("lid"));
        Land l = new Land();
        l.setId(lid);
        float startPrice = Float.parseFloat(request.getParameter("startprice"));
        float endPrice = Float.parseFloat(request.getParameter("endprice"));
        long millis = System.currentTimeMillis();
        Date date = new Date(millis);
        float income = endPrice-startPrice;
        Order o = new Order();
        o.setId(id);
        o.setLid(lid);
        o.setDate(date);
        o.setStartPrice(startPrice);
        o.setEndPrice(endPrice);
        o.setIncome(income);
        OrderDBContext db1 = new OrderDBContext();
        db1.insertOrder(o);
        LandDBContext db2 = new LandDBContext();
        db2.deleteLand(l);
        response.sendRedirect("/Assignment/menu/land");
        
        
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
