package fominskiy;

import fominskiy.persist.ExcData;
import fominskiy.repository.DataRepository;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {
    private DataRepository dataRepository;

    @Override
    public void init() throws ServletException {
        this.dataRepository = new DataRepository(1000);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // При запросе с клиента просим опросить файл и обновить список dataList
        try {
            dataRepository.rdFromExcel();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Чертим таблицу
        PrintWriter writer = response.getWriter();
        writer.println("<table>");
        writer.println("<tr>");
        writer.println("<th>Номер</th>");
        writer.println("<th>Значение</th>");
        writer.println("</tr>");

        // Заполняем поля
        for (ExcData u: dataRepository.findAll()) {
            writer.println("<tr>");
            writer.println("<td>" + u.getFirstColumn() + "</td>");
            writer.println("<td>" + u.getSecondColumn() + "</td>");
            writer.println("</tr>");
        }
        writer.println("</table>");
    }
}
