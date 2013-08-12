package Configuration;

/**
 * User: Akash
 */
public class DriverConfig {

    private String driverName;
    private String driverUrl;

    /**
     * set the driver name
     * @param driverName
     */
    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }


    /**
     * Set the driver Url
     * @param driverUrl
     */
    public void setDriverUrl(String driverUrl) {
        this.driverUrl = driverUrl;
    }

    /**
     * Get the driver name
     * @return driverName
     */
    public String getDriverName() {

        return driverName;
    }

    /**
     * Get the driver Url
     * @return  driverUrl
     */
    public String getDriverUrl() {
        return driverUrl;
    }
}
