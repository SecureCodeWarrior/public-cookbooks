import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IDS14J_HiddenFields  extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");

        String visible = request.getParameter("visible");
        String hidden = request.getParameter("hidden");

        if (visible != null || hidden != null) {
            out.println("Visible Parameter:");
            out.println(sanitize(visible));
            out.println("<br>Hidden Parameter:");
            out.println(hidden); //bad
            out.println(sanitize(hidden)); //good
        } else {
            out.println("<p>");
            out.print("<form action=\"");
            out.print("SampleServlet\" ");
            out.println("method=POST>");
            out.println("Parameter:");
            out.println("<input type=text size=20 name=visible>");
            out.println("<br>");

            out.println("<input type=hidden name=hidden value=\'a benign value\'>");
            out.println("<input type=submit>");
            out.println("</form>");
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        doGet(request, response);
    }

    // Filter the specified message string for characters
    // that are sensitive in HTML.
    public static String sanitize(String message) {
        // ...
        return "sanitized";
    }
}