import javax.sql.rowset.JdbcRowSetImpl;
import javax.sql.rowset.JdbcRowSet;

public class JdbcRowSet_test
{
    static final String DATABASE_URL = "jdbc:mysql://localhost/books";
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public JdbcRowSet_test() {
        try
        {
            JdbcRowSet rowSet = new JdbcRowSetImpl();
        }

    }
}
