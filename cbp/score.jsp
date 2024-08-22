<%@ page import="java.sql.*, java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
 <title>Top Scores</title>
 <link rel="stylesheet" href="./score.css">
</head>
<body>
 <div class="container">
 <h2>Top 5 Scores</h2>
 <table>
 <thead>
 <tr>
 <th>Rank</th>
 <th>Username</th>
 <th>Score</th>
 </tr>
 </thead>
 <tbody>
 <% 
 try {
 Connection conn = 
DriverManager.getConnection("jdbc:mysql://localhost:3306/cbp", "root", 
"root");
 PreparedStatement stmt = conn.prepareStatement("SELECT u.username, s.score FROM scores s INNER JOIN users u ON s.user_id = u.id ORDER BY s.score DESC LIMIT 5");
 ResultSet rs = stmt.executeQuery();
 int rank = 1;
 while (rs.next()) {
 String username = rs.getString("username");
 int score = rs.getInt("score");
 %>
 <tr>
 <td><%= rank++ %></td>
 <td><%= username %></td>
 <td><%= score %></td>
 </tr>
 <% 
 }
 rs.close();
 stmt.close();
 conn.close();
 } catch (SQLException e) {
 e.printStackTrace();
 }
 %>
 </tbody>
 </table>
 </div>
</body>
</html>