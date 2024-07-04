import java.sql.*;
import java.util.*;

public class PostComment {
    public static void main(String[] args){
        String jdbcUrl = "jdbc:mysql://localhost:3306/user_db";
        String username = "username";
        String password = "password";

        Connection connection = null;
        PreparedStatement ps = null;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your comment: ");
        String comment = sc.nextLine();

        try{
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            String sqlQuery = "INSERT INTO comments (commentt) VALUES (?)";
            ps = connection.prepareStatement(sqlQuery);
            ps.setString(1, comment);
            int rows = ps.executeUpdate();

            if(rows > 0){
                System.out.println("Comment Posted Successfully!!");
            }
            else{
                System.out.println("Failed to Post Comment!");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(ps != null){
                    ps.close();
                }
                if(connection != null){
                    connection.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
