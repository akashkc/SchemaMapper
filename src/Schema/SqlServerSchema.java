package Schema;
import Entity.*;
import Configuration.*;
import Connection.*;
/**
 * User: Akash
 */
import Constants.*;
import Query.*;
import QueryGenerator.SqlServerSchemaQuery;

public class SqlServerSchema extends SchemaConnection implements Schema{

    private Configuration configuration;
    private SchemaQuery schemaQuery = null;
    public SqlServerSchema(Configuration configuration)
    {
        this.configuration = configuration;
        schemaQuery = new SqlServerSchemaQuery();
    }

    public String getSchemaName()
    {
        return SchemaName.SqlServer;
    }
    public Configuration getSchemaConfiguration()
    {
        return this.configuration;
    }

    public Database getDatabaseSchema()
    {
        // TODO : Getting Database Detail
        try
        {
            String query = QueryRequest.getRequestedQuery(schemaQuery, this.configuration.getRequestType());
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery(query);
        }
        catch (Exception ex)
        {
        }


        return new Database();
    }
}
