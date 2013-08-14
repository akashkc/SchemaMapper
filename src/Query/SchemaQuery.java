package Query;

/**
 * User: Akash
 */
public interface SchemaQuery {

    public String DatabaseQuery();

    public String ColumnQuery();

    public String ConstraintQuery();

    public String FunctionQuery();

    public String IndexQuery();

    public String KeyQuery();

    public String StoredProcedureQuery();

    public String TableQuery();

    public String TriggerQuery();

    public String ViewQuery();
}
