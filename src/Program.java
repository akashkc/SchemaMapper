/**
 * User: Akash
 */
import Entity.*;
import Configuration.*;
import Constants.*;
import Query.*;
import SchemaFactory.*;
import Schema.*;
import Utility.*;

public class Program {

    public static void main(String[] args) throws Exception
    {

        Configuration config = new Configuration();

        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.setDatabaseName("test");
        connectionConfig.setPort("3306");
        connectionConfig.setServerName("localhost");

        Credential credential = new Credential();
        credential.setUsername("root");
        credential.setPassword("");

        SchemaRequestType schemaRequestType = new SchemaRequestType();
        schemaRequestType.setIsTable(true);
        schemaRequestType.setIsColumn(true);
        schemaRequestType.setIsIndex(true);
        schemaRequestType.setIsView(true);
        schemaRequestType.setIsTrigger(true);
        schemaRequestType.setIsStoredProcedure(true);

        // Configuration
        config.setConnectionConfig(connectionConfig);
        config.setCredential(credential);
        config.setSchemaType(SchemaName.MySql);
        config.setSchemaRequestType(schemaRequestType);

        SchemaFactory mySqlSchemaFactory = new MySqlSchemaFactory();

        // Source Database
        Schema mySqlSchema = mySqlSchemaFactory.getSchema(config);
        Database sourceDb = mySqlSchema.getDatabaseSchema();

        // Target Database
        connectionConfig.setDatabaseName("target_test");
        config.setConnectionConfig(connectionConfig);
        Schema targetSchema = mySqlSchemaFactory.getSchema(config);
        Database targetDb = targetSchema.getDatabaseSchema();

        // result of two database comparision
        Database filteredDb = SchemaComparer.CompareDatabase(sourceDb,targetDb);


        System.out.print("THis is me Aksah");
    }
}
