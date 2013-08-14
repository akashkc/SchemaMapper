package Schema;
import Entity.*;
import Configuration.*;
import Connection.*;
import Query.*;
/**
 * User: Akash
 */

import Constants.*;
import QueryGenerator.OracleSchemaQuery;

public class OracleSchema extends SchemaConnection implements Schema {


    Configuration configuration;
    SchemaQuery schemaQuery = null;
    public OracleSchema(Configuration configuration)
    {
        this.configuration = configuration;
        schemaQuery = new OracleSchemaQuery();
    }

    public String getSchemaName()
    {
        return SchemaName.Oracle;
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

            String query = QueryRequest.getRequestedQuery(schemaQuery,this.configuration.getRequestType());
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
