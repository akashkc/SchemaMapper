package Configuration;

/**
 * User: Akash
 */
public class ConnectionConfig {

    private String serverName;
    private String databaseName;
    private String instance;
    private String port;

    public ConnectionConfig()
    {
       this("", "", "","");
    }

    public ConnectionConfig(String serverName)
    {
        this(serverName, "", "","");
    }
    public ConnectionConfig(String serverName, String databaseName)
    {
        this(serverName, databaseName,"","");
    }
    public ConnectionConfig(String serverName, String databaseName, String instance)
    {
        this(serverName, databaseName,instance,"");
    }

    public ConnectionConfig(String serverName, String databaseName, String instance, String port)
    {
        this.serverName = serverName;
        this.databaseName = databaseName;
        this.instance = instance;
        this.port = port;
    }

    /**
     * Get the server name
     * @return serverName
     */
    public String getServerName()
    {
        return this.serverName;
    }

    /**
     * Set the serverName
     * @param server
     */
    public void setServerName(String server)
    {
        this.serverName = server;
    }

    /**
     * Get the database name
     * @return databaseName
     */
    public String getDatabaseName()
    {
        return this.databaseName;
    }

    /**
     * set the database name
     * @param database
     */
    public void setDatabaseName(String database)
    {
        this.databaseName = database;
    }

    /**
     * Set the instance
     * @param instance
     */
    public void setInstance(String instance)
    {
        this.instance = instance;
    }

    /**
     * Get the instance
     * @return instance
     */
    public String getInstance()
    {
        return this.instance;
    }

    /**
     * Set the port
     * @param port
     */
    public void setPort(String port)
    {
       this.port = port;
    }

    /**
     * Get the port
     * @return port
     */
    public String getPort()
    {
        return this.port;
    }

}
