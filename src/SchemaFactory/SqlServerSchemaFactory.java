package SchemaFactory;

/**
 * User: Akash
 */
import Schema.*;
import Configuration.*;

public class SqlServerSchemaFactory implements SchemaFactory {

    public Schema getSchema(Configuration configuration)
    {
        return new SqlServerSchema(configuration);
    }

}
