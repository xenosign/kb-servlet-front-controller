//package org.example.kbservletfrontcontroller;
//
//import org.example.kbservletfrontcontroller.controller.Controller;
//import org.example.kbservletfrontcontroller.controller.HomeController;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.RequestDispatcher;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//
//@WebServlet(name = "frontControllerServlet", urlPatterns = "/test")
//public class FrontControllerServletOld extends HttpServlet {
//
//    private Map<String, Controller> getMap;
//    private Map<String, Controller> postMap;
//    private static final String PREFIX = "/views/";
//    private static final String SUFFIX = ".jsp";
//    private final HomeController homeController = new HomeController();
//
//    @Override
//    public void init() throws ServletException {
//        getMap = new HashMap<>();
//        postMap = new HashMap<>();
//        getMap.put("/test/home", homeController::getIndex);
//        // 추가적인 URL과 커맨드를 여기에 등록합니다.
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        processRequest(request, response);
//    }
//
//    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        Controller command = getCommand(request);
//        if (command != null) {
//            execute(command, request, response);
//        } else {
//            handle404(request, response);
//        }
//    }
//
//    private void execute(Controller command, HttpServletRequest request, HttpServletResponse response)
//            throws IOException, ServletException {
//        String viewName = command.execute(request, response);
//        if (viewName.startsWith("redirect:")) {
//            response.sendRedirect(viewName.substring("redirect:".length()));
//        } else {
//            handle404(request, response);
//        }
//    }
//
//    private String getCommandName(HttpServletRequest request) {
//        String requestURI = request.getRequestURI();
//        String contextPath = request.getContextPath();
//        return requestURI.substring(contextPath.length());
//    }
//
//    private Controller getCommand(HttpServletRequest request) {
//        String commandName = getCommandName(request);
//        Controller command;
//        if (request.getMethod().equalsIgnoreCase("GET")) {
//            command = getMap.get(commandName);
//        } else {
//            command = postMap.get(commandName);
//        }
//        return command;
//    }
//
//    private void handle404(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setStatus(HttpServletResponse.SC_NOT_FOUND);
//        RequestDispatcher dispatcher = request.getRequestDispatcher(PREFIX + "404" + SUFFIX);
//        dispatcher.forward(request, response);
//    }
//}
