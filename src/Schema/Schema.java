package Schema;
import Entity.*;
import Configuration.*;
/**
 * User: Akash
 */
public interface Schema {


    public String getSchemaName();

    public Configuration getSchemaConfiguration();

    public Database getDatabaseSchema();
}
