package pl.sebastian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/pupils/*")
public class PupilsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");*/
        //TODO rozróżnić przypadki przez URI:
        // /pupils - wykorzystać findAll i zrobić z tego HTML
        // /pupils/id - wyciągnąć id i wykorzystać findById (jak nie ma to komunikat "nie znaleziono")
        // /pupils?classNumber=3&classLetter=B - wykorzystać findByClassNumberAncClassLetter
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO usunąć ucznia o id przekazanym w request URI
    }
}
