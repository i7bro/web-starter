package main.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.service.CityService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/cities")
public class CityServlet extends HttpServlet {

    private final CityService cityService = CityService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter printWriter = resp.getWriter()) {
            printWriter.write("<h1>Список городов</h1>");
            printWriter.write("<ul>");
            cityService.findAll().forEach(cityDto -> {
                printWriter.write(
                        String.format("<li>%s<a href='/country?code=%s'>%s</a></li>",
                                cityDto.getDescription(),
                                cityDto.getCountyCode(),
                                cityDto.getCountyCode())
                );
            });
            printWriter.write("</ul>");
        }
    }
}
