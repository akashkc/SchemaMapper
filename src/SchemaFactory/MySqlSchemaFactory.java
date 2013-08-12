package SchemaFactory;

/**
 * User: Akash
 */

import Schema.*;
import Configuration.*;
import Constants.*;
public class MySqlSchemaFactory implements SchemaFactory {

    public Schema getSchema(Configuration configuration)
    {
        try {
            Class.forName(Driver.MySql.DriverName);
        }
        catch (ClassNotFoundException ex)
        {

        }
        return new MySqlSchema(configuration);
    }
}
