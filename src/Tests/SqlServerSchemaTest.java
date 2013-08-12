package Tests;
import Entity.*;
import Configuration.*;

/**
 * User: Akash
 */

import Constants.*;
import Schema.*;
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class SqlServerSchemaTest {

    private SqlServerSchema sqlServerSchema = null;
    private Configuration configuration = null;
    @Before
    public void setUp()
    {
        sqlServerSchema = new SqlServerSchema(configuration);
    }
    @Test
    public void shouldReturnSqlSchemaName()
    {
        // Arrange
        final String sqlSchemaName =  SchemaName.SqlServer;

        // Act
        String output = sqlServerSchema.getSchemaName();

        // Assert
        assertEquals(sqlSchemaName,output);
    }

    @Test
    public void getDatabaseSchemaShouldReturnDatabaseInstanceType()
    {
       Database databaseSchema = sqlServerSchema.getDatabaseSchema();
       assertThat(databaseSchema,is(Database.class));
    }

    @After
    public void tearDown()
    {
          sqlServerSchema = null;
    }
}
