import java.sql.Connection;
import java.sql.Statement;

public class DbUtil {

    public static final String INSERT_INTO_FEEDBACKS = "INSERT INTO feedbacks(id, message, consumer_id, producer_id) VALUES (-43, '" + Common.FEEDBACK_TEXT + "', 6, 21)";
    public static final String DELETE_FROM_FEEDBACKS = "delete from feedbacks";

    public static void execute(String sql) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = java.sql.DriverManager.getConnection("jdbc:postgresql://localhost:5432/t", "admin", "root");
            Statement statement = connection.createStatement();
            statement.execute(sql);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
