import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class ScoreServlet extends HttpServlet {
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws 
ServletException, IOException {
 HttpSession session = request.getSession();
 String username = (String) session.getAttribute("username");
 int score =Integer.parseInt(request.getParameter("score"));
 // Logic to calculate score and update database

 try {
 Connection conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/cbp", "root","root");
 // Get user ID based on username
 PreparedStatement getUserId = conn.prepareStatement("SELECT id FROM users WHERE username = ?");
 getUserId.setString(1, username);
 ResultSet rs = getUserId.executeQuery();
 if (rs.next()) {
 int userId = rs.getInt("id");
 // Insert score into scores table
 if(rs.getInt("score")< score)
 {
 PreparedStatement insertScore = conn.prepareStatement("INSERT INTO scores (user_id, score) VALUES (?, ?)");
 insertScore.setInt(1, userId);
 insertScore.setInt(2, score);
 insertScore.executeUpdate();
 insertScore.close();
 }
 }
 rs.close();
 getUserId.close();
 conn.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 response.sendRedirect("score.jsp"); // Redirect to score page
 }
}