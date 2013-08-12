package Tests.Utility;

/**
 * User: Akash
 */

import org.junit.*;
import static org.junit.Assert.*;

import Configuration.*;
import Constants.*;
import Query.*;
import Utility.*;
public class SchemaUtilsTest {

    Configuration config = null;
    @Before
    public void setUp()
    {
        config = new Configuration();

        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.setDatabaseName("test");
        connectionConfig.setPort("3306");
        connectionConfig.setServerName("localhost");

        Credential credential = new Credential();
        credential.setUsername("user");
        credential.setPassword("password");

        DriverConfig driverConfig = new DriverConfig();
        driverConfig.setDriverName("com.mysql.jdbc.Driver");
        driverConfig.setDriverUrl("jdbc:mysql");

        config.setConnectionConfig(connectionConfig);
        config.setCredential(credential);
        config.setDriverConfig(driverConfig);
        config.setRequestType(QueryRequestType.Table);
        config.setSchemaType(SchemaName.MySql);
    }

    @Test
    public void getMySqlConnectionString()
    {
        // Arrange
        final String expectedConnectionString = "jdbc:mysql://localhost:3306/test?user=user&password=password";

        // Act
        String output = SchemaUtils.getConnectionString(config);

        // Assert
        assertEquals(expectedConnectionString , output);
    }

    @After
    public void tearDown()
    {

    }

}
