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
        String requestUri = req.getRequestURI();

        String classLetter = req.getParameter("classLetter");
        String classNumber = req.getParameter("classNumber");

        String queryString = req.getQueryString();
        //String suffix = requestUri.replaceFirst(req.getContextPath() + "/", "");
        PrintWriter out = resp.getWriter();
        if (requestUri.endsWith("/pupils") && classLetter == null && classNumber == null) {
            findAll(resp);
        } else if (classLetter != null && classNumber != null) {
            findByClassLetterAndClassNumber(classLetter, classNumber, resp);
        } else {
            int lastSlash = requestUri.lastIndexOf("/");
            String id = requestUri.substring(lastSlash + 1);
            findById(id, resp);
        }
        //TODO rozróżnić przypadki przez URI:
        // /pupils - wykorzystać findAll i zrobić z tego HTML
        // /pupils/id - wyciągnąć id i wykorzystać findById (jak nie ma to komunikat "nie znaleziono")
        // /pupils?classNumber=3&classLetter=B - wykorzystać findByClassNumberAncClassLetter
    }

    private void findById(String id, HttpServletResponse resp) {

    }

    private void createResponse(HttpServletResponse resp, List<Pupil> pupils) throws IOException {
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(pupils));
    }

    private void findByClassLetterAndClassNumber(String classLetter,
                                                 String classNumber, HttpServletResponse resp) throws IOException {
        char letter = classLetter.charAt(0);
        Integer number = Integer.valueOf(classNumber);
        List<Pupil> pupils = pupilRepository.findByClassLetterAndClassNumber(letter, number);
        createResponse(resp, pupils);
    }

    private void findAll(HttpServletResponse resp) throws IOException {
        List<Pupil> pupils = pupilRepository.findAll();
        createResponse(resp, pupils);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //TODO usunąć ucznia o id przekazanym w request URI
    }
}
