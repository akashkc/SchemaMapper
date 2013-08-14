package Tests.QueryGeneratorTests;

/**
 * User: Akash
 */
import Configuration.*;
import Query.*;

import QueryGenerator.MySqlSchemaQuery;
import org.junit.*;
import static org.junit.Assert.*;
public class MySqlQueryTests {

    Configuration config = null;
    SchemaQuery mySqlSchemaQuery = null;

    @Before
    public void setUp()
    {
        config = new Configuration();
        ConnectionConfig connectionConfig = new ConnectionConfig();
        connectionConfig.setDatabaseName("test");
        config.setConnectionConfig(connectionConfig);

        mySqlSchemaQuery = new MySqlSchemaQuery(config);

    }

    /**
     * Test whether table returning query should be same with expected query
     */
    @Test
    public void getTableNameQueryOfGivenDatabase()
    {
        // Arrange
        final String expectedQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = '" +
                                                                        config.getConnectionConfig().getDatabaseName() +
                                                                        "' AND TABLE_TYPE = 'BASE TABLE'";
        // Act
        String result =  mySqlSchemaQuery.TableQuery();

        // Assert
        assertEquals(expectedQuery,result);
    }

    @Test
    public void getColumnNameAndTableNameOfDatabase()
    {
        // Arrange
        final String expectedQuery = "SELECT TABLE_NAME, COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_SCHEMA = '" +
                config.getConnectionConfig().getDatabaseName() + "'";
        // Act
        String result =  mySqlSchemaQuery.ColumnQuery();

        // Assert
        assertEquals(expectedQuery,result);
    }

    @Test
    public void ViewQueryShouldReturnCorrectQuery()
    {
        final String expectedQuery = "SELECT TABLE_NAME FROM INFORMATION_SCHEMA.VIEWS WHERE TABLE_SCHEMA = '" +
                config.getConnectionConfig().getDatabaseName() + "'";
        String actualQuery = mySqlSchemaQuery.ViewQuery();
        assertEquals(expectedQuery,actualQuery);
    }

    @Test
    public void StoredProcedureQueryShouldReturnsCorrectQuery()
    {
        final String expectedQuery = "SELECT ROUTINE_NAME FROM INFORMATION_SCHEMA.ROUTINES WHERE ROUTINE_SCHEMA = '" +
                config.getConnectionConfig().getDatabaseName() +
                "' AND ROUTINE_TYPE = 'PROCEDURE'";
        String actualQuery = mySqlSchemaQuery.StoredProcedureQuery();
        assertEquals(expectedQuery,actualQuery);
    }

    @Test
    public void TriggerQueryShouldReturnsCorrectQuery()
    {
        final String expectedQuery = "SELECT EVENT_OBJECT_TABLE, TRIGGER_NAME FROM INFORMATION_SCHEMA.TRIGGERS WHERE TRIGGER_SCHEMA = '" +
                config.getConnectionConfig().getDatabaseName() + "'";
        String actualQuery = mySqlSchemaQuery.TriggerQuery();
        assertEquals(expectedQuery,actualQuery);
    }

    @After
    public void tearDown()
    {
        config = null;
        mySqlSchemaQuery = null;
    }
}
