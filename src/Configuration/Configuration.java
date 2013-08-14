package Configuration;
import Query.*;

/**
 * User: Akash
 */
public class Configuration {
    private ConnectionConfig connectionConfig;
    private Credential credential;
    private DriverConfig driverConfig;
    private String requestType;
    private String schemaType;
    private SchemaRequestType schemaRequestType;


    /**
     * Get the schema request TYpe
     * @return
     */
    public SchemaRequestType getSchemaRequestType()
    {
        return this.schemaRequestType;
    }

    /**
     * Set the schema request type
     * @param schemaRequestType
     */
    public void setSchemaRequestType(SchemaRequestType schemaRequestType)
    {
        this.schemaRequestType = schemaRequestType;
    }



    /**
     * Set connection config
     * @param connectionConfig
     */
    public void setConnectionConfig(ConnectionConfig connectionConfig)
    {
        this.connectionConfig = connectionConfig;
    }

    /**
     * Get connection config
     * @return connectionConfig
     */
    public ConnectionConfig getConnectionConfig()
    {
        return this.connectionConfig;
    }

    /**
     * Set the credential
     * @param credential
     */
    public void setCredential(Credential credential)
    {
        this.credential = credential;
    }

    /**
     * Get the credential
     * @return credential
     */
    public Credential getCredential()
    {
        return this.credential;
    }

    /**
     * Set the driverConfig
     * @param driverConfig
     */
    public void setDriverConfig(DriverConfig driverConfig)
    {
        this.driverConfig = driverConfig;
    }

    /**
     * Get the driverConfig
     * @return driverConfig
     */
    public DriverConfig getDriverConfig()
    {
        return this.driverConfig;
    }

    /**
     * Set the requestType
     * @param requestType
     */
    public void setRequestType(String requestType)
    {
        this.requestType = requestType;
    }

    /**
     * Get the request type
     * @return requestType
     */
    public String getRequestType()
    {
        return this.requestType;
    }

    /**
     * Get the schemaType
     * @return SchemaType
     */
    public String getSchemaType()
    {
        return this.schemaType;
    }

    /**
     * Set the schemaType
     * @param schemaType
     */
    public void setSchemaType(String schemaType)
    {
        this.schemaType = schemaType;
    }




}
