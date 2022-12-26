package org.example;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/cars")
public class CarsServlet extends HttpServlet {
    Cars cars = new Cars();

    @Override
    public void init(ServletConfig config) throws ServletException {
        cars.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().println("<h2>Cars</h2>");
        String id = req.getParameter("id");
        resp.getOutputStream().println("<h2>Select Car: " + cars.getCars(id) + "</h2>");
        HttpSession session = req.getSession(true);
        long lastAccessedTime = session.getLastAccessedTime();
        Cookie cookie = new Cookie("Last_Session", String.valueOf(lastAccessedTime));
        resp.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String model = req.getParameter("model");
        resp.getOutputStream().println("<h2>" + cars.setCars(id, model) + "</h2>");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        resp.getOutputStream().println("<h2>" + cars.deleteCars(id) + "</h2>");
    }
}
