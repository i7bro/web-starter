package main.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import main.java.dto.CountryDto;
import main.java.service.CountryService;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@WebServlet("/country")
public class CountryServlet extends HttpServlet {

    private final CountryService countryService = CountryService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        CountryDto byId = countryService.findById(code);
        resp.setContentType("text/html");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        try (PrintWriter writer = resp.getWriter()) {
            writer.write(String.format("<h3>%s</h3>", byId.getCode()));
            writer.write("<br/>");
            writer.write(String.format("<span>%s</span>", byId.getDescription()));
        }
    }
}
