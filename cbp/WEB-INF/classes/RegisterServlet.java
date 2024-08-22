import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class RegisterServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
   ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    // JDBC code to insert user into database
    try {
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/cbp", "root", "root");
    PreparedStatement stmt = conn.prepareStatement("INSERT INTO users (username,password) VALUES (?, ?)");
    stmt.setString(1, username);
    stmt.setString(2, password);
    stmt.executeUpdate();
    stmt.close();
    conn.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
    response.sendRedirect("login.html"); // Redirect to login page
    }
   }