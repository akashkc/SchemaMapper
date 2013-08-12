/**
 * User: Akash
 */
package Tests;
import Entity.*;
import org.junit.*;
import Configuration.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import Constants.*;
import Schema.*;

public class MySqlSchemaTest {
    private MySqlSchema mySqlSchema = null;
    private Configuration configuration = null;

    @Before
    public void setUp()
    {
        mySqlSchema = new MySqlSchema(configuration);
    }

    @Test
    public void ShouldReturnMySqlSchemaName()
    {
        // Arrange
        final String expectedSchemaName = SchemaName.MySql;

        // Act
        String output = mySqlSchema.getSchemaName();

        // Assert
        assertEquals(expectedSchemaName, output);
    }

   @Test
   public void GetDatabaseShouldReturnDatabaseTypeInstance()
   {
        Database databaseSchema = mySqlSchema.getDatabaseSchema();
        assertThat(databaseSchema,is(Database.class));
   }

    @After
    public void tearDown()
    {
        mySqlSchema = null;
    }
}
