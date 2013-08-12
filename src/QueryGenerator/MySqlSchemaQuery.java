package QueryGenerator;
import Configuration.*;
import Query.SchemaQuery;
import SchemaKeywords.*;

/**
 * User: Akash
 */
public class MySqlSchemaQuery implements SchemaQuery {

    Configuration configuration = null;
    String database = "";

    public MySqlSchemaQuery(Configuration configuration)
    {
        this.configuration = configuration;
        database = this.configuration.getConnectionConfig().getDatabaseName();
    }

    public String DatabaseQuery()
    {
        return "";
    }

    /**
     * Get the query for retrieving columns of given database.
     * @return query
     * @author Akash
     */
    public String ColumnQuery()
    {
        StringBuilder columnQueryBuilder = new StringBuilder();
        columnQueryBuilder.append(SchemaKeywords.SqlDDL.SELECT).append(" ");
        columnQueryBuilder.append(MySql.TABLE_NAME).append(", ");
        columnQueryBuilder.append(MySql.COLUMN_NAME).append(" ");
        columnQueryBuilder.append(SchemaKeywords.SqlDDL.FROM).append(" ");
        columnQueryBuilder.append(MySql.INFORMATION_SCHEMA).append(".").append(MySql.COLUMNS).append(" ");
        columnQueryBuilder.append(SchemaKeywords.SqlDDL.WHERE).append(" ");
        columnQueryBuilder.append(MySql.TABLE_SCHEMA);
        columnQueryBuilder.append(" = ");
        columnQueryBuilder.append("'");
        columnQueryBuilder.append(database);
        columnQueryBuilder.append("'").append(" ");
        return columnQueryBuilder.toString();
    }

    public String ConstraintQuery()
    {
        return "";
    }

    public String FunctionQuery()
    {
        return "";
    }

    /**
     * Get the query for retrieving the index of given database.
     * @return query
     * @author Akash
     */
    public String IndexQuery()
    {
        StringBuilder indexQueryBuilder = new StringBuilder();
        indexQueryBuilder.append(SchemaKeywords.SqlDDL.SELECT).append(" ");
        indexQueryBuilder.append(MySql.TABLE_NAME).append(", ");
        indexQueryBuilder.append(MySql.COLUMN_NAME).append(", ");
        indexQueryBuilder.append(MySql.CONSTRAINT_NAME).append(" ");
        indexQueryBuilder.append(SchemaKeywords.SqlDDL.FROM).append(" ");
        indexQueryBuilder.append(MySql.INFORMATION_SCHEMA).append(".").append(MySql.KEY_COLUMN_USAGE).append(" ");
        indexQueryBuilder.append(SchemaKeywords.SqlDDL.WHERE).append(" ");
        indexQueryBuilder.append(MySql.TABLE_SCHEMA);
        indexQueryBuilder.append(" = ");
        indexQueryBuilder.append("'");
        indexQueryBuilder.append(database);
        indexQueryBuilder.append("'");
        return indexQueryBuilder.toString();
    }

    public String KeyQuery()
    {
        return "";
    }

    /**
     * Get the query for retrieving Routines/StoredProcedures
     * @return query
     * @author Akash
     */
    public String StoredProcedureQuery(){

        StringBuilder routineQueryBuilder = new StringBuilder();
        routineQueryBuilder.append(SchemaKeywords.SqlDDL.SELECT).append(" ");
        routineQueryBuilder.append(MySql.RoutinesColumn.ROUTINE_NAME).append(" ");
        routineQueryBuilder.append(SchemaKeywords.SqlDDL.FROM).append(" ");
        routineQueryBuilder.append(MySql.INFORMATION_SCHEMA).append(".").append(MySql.ROUTINES).append(" ");
        routineQueryBuilder.append(SchemaKeywords.SqlDDL.WHERE).append(" ");
        routineQueryBuilder.append(MySql.RoutinesColumn.ROUTINE_SCHEMA);
        routineQueryBuilder.append(" = ");
        routineQueryBuilder.append("'");
        routineQueryBuilder.append(database);
        routineQueryBuilder.append("'").append(" ");
        routineQueryBuilder.append(CommonSqlKeyword.AND).append(" ");
        routineQueryBuilder.append(MySql.RoutinesColumn.ROUTINE_TYPE);
        routineQueryBuilder.append(" = ");
        routineQueryBuilder.append("'");
        routineQueryBuilder.append(MySql.RoutinesTypeValue.PROCEDURE);
        routineQueryBuilder.append("'");

        return routineQueryBuilder.toString();
    }

    /**
     * Get the query for retrieving tables of given database.
     * @return query
     * @author Akash
     */
    public String TableQuery()
    {
        StringBuilder tableQueryBuilder = new StringBuilder();
        tableQueryBuilder.append(SchemaKeywords.SqlDDL.SELECT).append(" ");
        tableQueryBuilder.append(MySql.TABLE_NAME).append(" ");
        tableQueryBuilder.append(SchemaKeywords.SqlDDL.FROM).append(" ");
        tableQueryBuilder.append(MySql.INFORMATION_SCHEMA).append(".").append(MySql.TABLES).append(" ");
        tableQueryBuilder.append(SchemaKeywords.SqlDDL.WHERE).append(" ");
        tableQueryBuilder.append(MySql.TABLE_SCHEMA);
        tableQueryBuilder.append(" = ");
        tableQueryBuilder.append("'");
        tableQueryBuilder.append(database);
        tableQueryBuilder.append("'").append(" ");
        tableQueryBuilder.append(CommonSqlKeyword.AND).append(" ");
        tableQueryBuilder.append(MySql.TABLE_TYPE);
        tableQueryBuilder.append(" = ");
        tableQueryBuilder.append("'");
        tableQueryBuilder.append(MySql.TableTypeValue.BASE_TABLE);
        tableQueryBuilder.append("'");
        return tableQueryBuilder.toString();
    }

    /**
     * Get the query for retrieving triggers of given database.
     * @return query
     * @author Akash
     */
    public String TriggerQuery()
    {
        StringBuilder triggerQueryBuilder = new StringBuilder();
        triggerQueryBuilder.append(SchemaKeywords.SqlDDL.SELECT).append(" ");
        triggerQueryBuilder.append(MySql.TriggersColumns.EVENT_OBJECT_TABLE).append(", ");
        triggerQueryBuilder.append(MySql.TriggersColumns.TRIGGER_NAME).append(" ");
        triggerQueryBuilder.append(SchemaKeywords.SqlDDL.FROM).append(" ");
        triggerQueryBuilder.append(MySql.INFORMATION_SCHEMA).append(".").append(MySql.TRIGGERS).append(" ");
        triggerQueryBuilder.append(SchemaKeywords.SqlDDL.WHERE).append(" ");
        triggerQueryBuilder.append(MySql.TriggersColumns.TRIGGER_SCHEMA);
        triggerQueryBuilder.append(" = ");
        triggerQueryBuilder.append("'");
        triggerQueryBuilder.append(database);
        triggerQueryBuilder.append("'");
        return triggerQueryBuilder.toString();
    }

    /**
     * Get the query for retrieving all views in the given database
     * @return query
     * @author Akash
     */
    public String ViewQuery()
    {
        StringBuilder viewQueryBuilder = new StringBuilder();
        viewQueryBuilder.append(SchemaKeywords.SqlDDL.SELECT).append(" ");
        viewQueryBuilder.append(MySql.TABLE_NAME).append(" ");
        viewQueryBuilder.append(SchemaKeywords.SqlDDL.FROM).append(" ");
        viewQueryBuilder.append(MySql.INFORMATION_SCHEMA).append(".").append(MySql.VIEWS).append(" ");
        viewQueryBuilder.append(SchemaKeywords.SqlDDL.WHERE).append(" ");
        viewQueryBuilder.append(MySql.TABLE_SCHEMA);
        viewQueryBuilder.append(" = ");
        viewQueryBuilder.append("'");
        viewQueryBuilder.append(database);
        viewQueryBuilder.append("'");
        return viewQueryBuilder.toString();
    }
}
