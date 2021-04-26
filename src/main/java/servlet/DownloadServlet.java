package main.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import java.util.Objects;


@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Content-Disposition", "attachment; filename=\"test.jpg\"");
        resp.setContentType("application/jpg");
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        try (ServletOutputStream outputStream = resp.getOutputStream();
             InputStream stream = DownloadServlet.class.getClassLoader().getResourceAsStream("test.jpg")) {
            byte[] b = Objects.nonNull(stream) ? new byte[stream.available()] : new byte[1];
            stream.read(b);
            outputStream.write(b);
        }
    }
}
