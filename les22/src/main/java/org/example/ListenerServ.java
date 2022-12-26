package org.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebListener("/*")
public class ListenerServ implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session: " + session);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSession session = se.getSession();
        System.out.println("session destr: " + session);
    }
}

