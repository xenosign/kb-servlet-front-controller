package org.example.kbservletfrontcontroller.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController implements Controller {
    public String getView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "home";
    }
}