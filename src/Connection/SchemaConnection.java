package Connection;

/**
 * User: Akash
 */
import java.sql.*;
import Configuration.*;
import Utility.*;

public abstract class SchemaConnection {

    /**
     * Get the connection instance
     * @param configuration
     * @return Connection instance
     */
    public Connection getConnectionInstance(Configuration configuration) throws SQLException
    {
        Connection connection = DriverManager.getConnection(SchemaUtils.getConnectionString(configuration));;
        return connection;
    }

    public ResultSet getQueryResultSet(Connection connection, String query) throws SQLException
    {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        return resultSet;
    }

}
