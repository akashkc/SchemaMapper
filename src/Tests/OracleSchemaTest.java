package Tests;
import Entity.*;
import Configuration.*;
/**
 * User: Akash
 */
import org.junit.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import Constants.*;
import Schema.*;


public class OracleSchemaTest {

    private OracleSchema oracleSchema = null;
    private Configuration configuration = null;
    @Before
    public void setUp()
    {
        oracleSchema = new OracleSchema(configuration);

    }

    @Test
    public void shouldReturnOracleSchemaName()
    {
        // Arrange
        final String expectedOracleSchemaName = SchemaName.Oracle;

        // Act
        String output =  oracleSchema.getSchemaName();

        // Assert
        assertEquals(expectedOracleSchemaName,output);

    }

    @Test
    public void getDatabaseShouldReturnDatabaseInstanceType()
    {
        Database databaseSchema = oracleSchema.getDatabaseSchema();

        assertThat(databaseSchema,is(Database.class));
    }

    @After
    public void tearDown()
    {
          oracleSchema = null;
    }
}
