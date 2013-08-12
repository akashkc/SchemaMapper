package Utility;
import Constants.*;
import Configuration.*;
import Entity.*;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Akash
 */
public class SchemaUtils {

    /**
     * Get the schema Driver based on requested schema type
     * @param requestedSchemaType
     * @return SchemaDriver
     */
    public static String getSchemaDriver(String requestedSchemaType)
    {
        if(requestedSchemaType.equalsIgnoreCase(SchemaName.SqlServer))
            return Driver.MsSqlServer;
        else if (requestedSchemaType.equalsIgnoreCase(SchemaName.MySql))
            return Driver.MySql.DriverName;
        else if (requestedSchemaType.equalsIgnoreCase(SchemaName.Oracle))
            return Driver.Oracle;
        else return "";
    }

    public static String getConnectionString(Configuration config)
    {
        // Get database detail
        String database = config.getConnectionConfig().getDatabaseName();
        String server = config.getConnectionConfig().getServerName();
        String port = config.getConnectionConfig().getPort();
        String instance = config.getConnectionConfig().getInstance();

        // Get User Credentials
        String userName = config.getCredential().getUsername();
        String password = config.getCredential().getPassword();

        String schemaType = config.getSchemaType();

        StringBuilder connectionStrBuilder = new StringBuilder();

        if (schemaType.equalsIgnoreCase(SchemaName.MySql))
        {
            // jdbc:mysql://localhost:3306/db_student? user=username&password=password
            connectionStrBuilder.append(Driver.MySql.DriverUrl);
            connectionStrBuilder.append("://");
            connectionStrBuilder.append(server);
            connectionStrBuilder.append(":");
            connectionStrBuilder.append(port);
            connectionStrBuilder.append("/");
            connectionStrBuilder.append(database);
            connectionStrBuilder.append("?");
            connectionStrBuilder.append("user=");
            connectionStrBuilder.append(userName);
            connectionStrBuilder.append("&");
            connectionStrBuilder.append("password=");
            connectionStrBuilder.append(password);
        }
        else if (schemaType.equalsIgnoreCase(SchemaName.SqlServer))
        {
             // TODO : To make connection string for SQL SERVER
        }
        else if (schemaType.equalsIgnoreCase(SchemaName.Oracle))
        {
            // TODO : Make connection string for Oracle
        }
        return connectionStrBuilder.toString();
    }

    /**
     * Set the tablenames in the Database Entity
     * @param database
     * @param listTableNames
     * @return
     */
    public static Database setTablesinDatabaseEntity(Database database, List<String> listTableNames)
    {
        List<Table> listTables = new ArrayList<Table>();
        for (String tableName : listTableNames)
        {
            Table table = new Table();
            table.setName(tableName);
            listTables.add(table);
        }
        database.setTable(listTables);
        return database;

    }

}
