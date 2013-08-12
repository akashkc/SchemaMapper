package Schema;
import Entity.*;
import Configuration.*;
import Connection.*;
import java.sql.*;
import java.util.*;
import ResultsetExecuter.*;

import QueryGenerator.MySqlSchemaQuery;
import ResultsetExecuter.*;
import SchemaKeywords.*;

/**
 * User: Akash
 */

import Constants.*;
import Query.*;
import Utility.SchemaUtils;

public class MySqlSchema extends SchemaConnection implements Schema {

    private Configuration configuration;
    private SchemaQuery mySqlSchemaQuery = null;
    public MySqlSchema(Configuration configuration)
    {
        this.configuration = configuration;
        mySqlSchemaQuery = new MySqlSchemaQuery(configuration);
    }

    /**
     * Get the current Schema Name
     * @return SchemaName
     */
    public String getSchemaName()
    {
        return SchemaName.MySql;
    }

    public Configuration getSchemaConfiguration()
    {
        return this.configuration;
    }

    /**
     * Get My SqlDDL Schema Details
     * @return database
     */
    public Database getDatabaseSchema()
    {
        // TODO : Getting Database Detail
        ResultSet resultSet;
        Connection connection = null;
        Database database = new Database(this.configuration.getConnectionConfig().getDatabaseName());
        Map<String,ResultSet> resultSetMap = new HashMap<String, ResultSet>();
        try
        {
            connection = getConnectionInstance(this.configuration);

            // get the query for the default whether it is requested or not.
            String query = QueryRequest.getRequestedQuery(mySqlSchemaQuery,QueryRequestType.Table);
            resultSet = getQueryResultSet(connection,query);
            resultSetMap.put(HashMapKey.Table , resultSet);

            if (this.configuration.getSchemaRequestType().getIsColumn())
            {
                ResultSet columnResultSet = null;
                String getColumnQuery = QueryRequest.getRequestedQuery(mySqlSchemaQuery, QueryRequestType.Column);
                columnResultSet = getQueryResultSet(connection,getColumnQuery);
                resultSetMap.put(HashMapKey.Column , columnResultSet);
            }
            if (this.configuration.getSchemaRequestType().getIsIndex())
            {
                ResultSet indexResultSet = null;
                String getIndexQuery = QueryRequest.getRequestedQuery(mySqlSchemaQuery, QueryRequestType.Index);
                indexResultSet = getQueryResultSet(connection,getIndexQuery);
                resultSetMap.put(HashMapKey.Index , indexResultSet);
            }

            // if request for view, put view resultset in resultSetMap
            if (this.configuration.getSchemaRequestType().getIsView())
            {
                ResultSet viewResultSet = null;
                String getViewQuery = QueryRequest.getRequestedQuery(mySqlSchemaQuery,QueryRequestType.View);
                viewResultSet = getQueryResultSet(connection,getViewQuery);
                resultSetMap.put(HashMapKey.View,viewResultSet);
            }

            // if request for view, put view resultset in resultSetMap
            if (this.configuration.getSchemaRequestType().getIsTrigger())
            {
                ResultSet triggerResultSet = null;
                String getTriggerQuery = QueryRequest.getRequestedQuery(mySqlSchemaQuery,QueryRequestType.Trigger);
                triggerResultSet = getQueryResultSet(connection,getTriggerQuery);
                resultSetMap.put(HashMapKey.Trigger,triggerResultSet);
            }


            if(this.configuration.getSchemaRequestType().getIsStoredProcedure())
            {
                ResultSet storedProcedureResultSet = null;
                String getStoredProcedureQuery = QueryRequest.getRequestedQuery(mySqlSchemaQuery,QueryRequestType.StoredProcedure);
                storedProcedureResultSet = getQueryResultSet(connection,getStoredProcedureQuery);
                resultSetMap.put(HashMapKey.StoredProcedure,storedProcedureResultSet);
            }


            database = ResultsetExecution.getDatabaseBaseEntityBasedOnResultset(resultSetMap ,this.configuration.getSchemaRequestType());
            System.out.print(database.toString());
            return database;

            //List<String> listItem = ResultsetExecution.getResultsetItems(resultSet,MySql.TABLE_NAME);
            //System.out.println(listItem);
            //database = SchemaUtils.setTablesinDatabaseEntity(database,listItem);
        }
        catch (SQLException ex)
        {

        }
        catch (Exception ex)
        {
             System.out.println(ex.toString());
        }
        finally {
            if (connection != null)
            {
                try
                {
                    connection.close();
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        }
        return new Database();
    }
}
