package SchemaFactory;

import Schema.Schema;

/**
 * User: Akash
 */

import Configuration.*;
public interface SchemaFactory {

    public Schema getSchema(Configuration configuration);

}
