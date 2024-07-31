package org.example.kbservletfrontcontroller.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
    String getView(HttpServletRequest request, HttpServletResponse response) throws IOException;
}