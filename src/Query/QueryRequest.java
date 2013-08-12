package Query;

/**
 * User: Akash
 */
public class QueryRequest {

    /**
     * Get the query based request type
     * @param schemaQuery
     * @param requestType
     * @return query
     */
    public static String getRequestedQuery(SchemaQuery schemaQuery,String requestType)
    {
        if (requestType.equalsIgnoreCase(QueryRequestType.Column))
            return schemaQuery.ColumnQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Constraint))
            return schemaQuery.ConstraintQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Database))
            return schemaQuery.DatabaseQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Function))
            return schemaQuery.FunctionQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Index))
            return schemaQuery.IndexQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Key))
            return schemaQuery.KeyQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.StoredProcedure))
            return schemaQuery.StoredProcedureQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Table))
            return schemaQuery.TableQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.Trigger))
            return schemaQuery.TriggerQuery();
        else if (requestType.equalsIgnoreCase(QueryRequestType.View))
            return schemaQuery.ViewQuery();
        else return schemaQuery.DatabaseQuery();
    }

}
