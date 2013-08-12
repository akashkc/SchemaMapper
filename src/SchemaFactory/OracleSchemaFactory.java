package SchemaFactory;

/**
 * User: Akash
 */
import Schema.*;
import Configuration.*;
public class OracleSchemaFactory implements SchemaFactory {

    public Schema getSchema(Configuration configuration)
    {
        return new OracleSchema(configuration);
    }
}
