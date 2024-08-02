package org.example.kbservletfrontcontroller;

import org.example.kbservletfrontcontroller.controller.AboutController;
import org.example.kbservletfrontcontroller.controller.Controller;
import org.example.kbservletfrontcontroller.controller.HomeController;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/front/*")
public class FrontControllerServlet extends HttpServlet {
    private Map<String, Controller> controllerMap = new HashMap<>();

    @Override
    public void init() throws ServletException {
        controllerMap.put("/", new HomeController());
        controllerMap.put("/about", new AboutController());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        System.out.println("path = " + path);
        Controller controller = controllerMap.get(path);


        if (controller != null) {
            String viewName = controller.getView(request, response);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/" + viewName + ".jsp");
            dispatcher.forward(request, response);
        } else {
            request.getRequestDispatcher("/views/" + "404" + ".jsp").forward(request, response);
        }
    }
}