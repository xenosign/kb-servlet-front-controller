package org.example.kbservletfrontcontroller.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutController implements Controller {
    public String getView(HttpServletRequest request, HttpServletResponse response) throws IOException {
        return "about";
    }
}