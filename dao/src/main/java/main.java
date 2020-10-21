import java.sql.*;

public class main {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/oleg_schema";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;

//        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL, "root", "root");
        statement = connection.createStatement();
        String sql= "SELECT * FROM user;";

        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getInt("name"));
        }
        resultSet.close();
        connection.close();
        statement.close();

    }
}
