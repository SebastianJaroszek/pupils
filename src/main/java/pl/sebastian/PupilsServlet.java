package pl.sebastian;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

//s. 49 prezentacja Dominika

@WebServlet("/pupils/*")
public class PupilsServlet extends HttpServlet {

    private PupilRepository pupilRepository = new InMemoryPupilRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        /*resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");*/
        String requestUri = req.getRequestURI();
        String queryString = req.getQueryString();
        //String suffix = requestUri.replaceFirst(req.getContextPath() + "/", "");
        PrintWriter out = resp.getWriter();
        if (requestUri.endsWith("/pupils")){
            findAll(resp);
        }
        //TODO rozróżnić przypadki przez URI:
        // /pupils - wykorzystać findAll i zrobić z tego HTML
        // /pupils/id - wyciągnąć id i wykorzystać findById (jak nie ma to komunikat "nie znaleziono")
        // /pupils?classNumber=3&classLetter=B - wykorzystać findByClassNumberAncClassLetter
    }

    private void findAll(HttpServletResponse resp) throws IOException {
        List<Pupil> pupils = pupilRepository.findAll();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(pupils));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO usunąć ucznia o id przekazanym w request URI
    }
}
