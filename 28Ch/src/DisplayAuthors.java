import java.sql.*;
import java.sql.DriverManager;

public class DisplayAuthors
{
    static final String DATABASE_URL = "jdbc:mysql://127.0.0.1:3306/books";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try
        {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "root");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT AuthorID, FirstName, LastName FROM authors");

            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();
            System.out.println("Authors table of Books Database: \n");

            for(int i = 1; i <= numberOfColumns; i++)
            {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
                System.out.println("");
            }

            while (resultSet.next())
            {
                for(int i = 1; i <= numberOfColumns; i++)
                {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                    System.out.println("");
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
