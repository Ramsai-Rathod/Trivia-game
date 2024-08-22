import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class LoginServlet extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
    PrintWriter out= response.getWriter();
 String username = request.getParameter("username");
 String password = request.getParameter("password");
 // JDBC code to validate user from database
 try {
 Connection conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/cbp", "root", 
"root");
 PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
 stmt.setString(1, username);
 stmt.setString(2, password);
 ResultSet rs = stmt.executeQuery();
 if (rs.next()) {
 // Valid user, set session attribute
 HttpSession session = request.getSession();
 session.setAttribute("username", username);
 response.sendRedirect("question.html"); // Redirect to question page
 } else {
   String s="You have entered wrong credentials/may not have the account please check and try again";
    out.println("<h3>");
    out.println(s);
    out.println("</h3>");
    out.println("<a href=\"http://localhost:8080/cbp/login.html\">Login</a>");
    out.println("<a href=\"http://localhost:8080/cbp/Register.html\">Register</a>");

 response.sendRedirect("login.html"); // Redirect to login page if invalid
 }
 rs.close();
 stmt.close();
 conn.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
}