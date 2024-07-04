import java.sql.*;

public class ViewComment {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/user_db";
        String username = "username";
        String password = "password";

        Connection connection = null;
        Statement stmt = null;
        ResultSet resSet = null;

        System.out.println("comments you entered: ");

        try{
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            stmt  = connection.createStatement();
            resSet = stmt.executeQuery("SELECT * FROM comments");

            while(resSet.next()){
                int id = resSet.getInt("id");
                String comment = resSet.getString("commentt");
                System.out.println("id " + id + ": " + comment);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(resSet != null){
                    resSet.close();
                }
                if(stmt != null){
                    stmt.close();
                }
                if(connection != null){
                    connection.close();
                }
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }
}
