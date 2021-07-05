package ru.geekbrains.geekbrains;

import ru.geekbrains.geekbrains.persist.Product;
import ru.geekbrains.geekbrains.persist.ProductRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/product/*")
public class ProductServlet extends HttpServlet {

    private ProductRepository productRepository;

    @Override
    public void init() throws ServletException {
        productRepository = (ProductRepository) getServletContext().getAttribute("productRepository");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter wr = resp.getWriter();

        if (req.getPathInfo() == null) {
            List<Product> products = productRepository.findAll();

            wr.println("<table cellspacing=\"2\" border=\"1\" cellpadding=\"5\" width=\"600\">");
            wr.println("<tr>");
            wr.println("<th>ID</th>");
            wr.println("<th>NAME</th>");
            wr.println("</tr>");

            for (Product product : products) {
                wr.println("<tr>");
                wr.println("<td>" + product.getId() + "</td>");
                wr.println("<td>" + "<a href=\"http://localhost:8080" + req.getContextPath() + req.getServletPath() + "/" + product.getId() + "\" target=\"_blank\">" + product.getName() + "</a>" + "</td>");
                wr.println("</tr>");
            }
            wr.println("</table>");
        } else {
            String pathInfo = req.getPathInfo();
            String[] cleanPathInfo =  pathInfo.split("/");
            Long id = Long.valueOf(cleanPathInfo[1]);
            wr.println("ProductId: " + id + "<br>");
            wr.println("ProductName: " + productRepository.findById(id).getName());
        }

    }
}
