package Query;

/**
 * User: Akash
 */
public class SchemaRequestType {

    // Default True
    private Boolean isDatabase = true;
    private Boolean isTable = true;


    private Boolean isColumn = false;
    private Boolean isConstraint = false;
    private Boolean isFunction = false;
    private Boolean isIndex = false;
    private Boolean isKey = false;
    private Boolean isStoredProcedure = false;
    private Boolean isTrigger = false;
    private Boolean isView = false;

    public Boolean getIsColumn()
    {
        return this.isColumn;
    }

    public void setIsColumn(Boolean isColumn)
    {
        this.isColumn = isColumn;
    }

    public Boolean getIsConstraint()
    {
        return this.isConstraint;
    }

    public void setIsConstraint(Boolean isConstraint)
    {
        this.isConstraint = isConstraint;
    }

    public Boolean getIsDatabase()
    {
        return this.isDatabase;
    }

    public void setIsDatabase(Boolean isDatabase)
    {
        this.isDatabase = isDatabase;
    }

    /**
     * Get the isTable
     * @return isTable
     */
    public Boolean getIsTable()
    {
        return this.isTable;
    }

    /**
     * Set the isTable
     * @param isTable
     */
    public void setIsTable(Boolean isTable)
    {
        this.isTable = isTable;
    }


    public Boolean getIsFunction()
    {
        return this.isFunction;
    }

    public void setIsFunction(Boolean isFunction)
    {
        this.isFunction = isFunction;
    }


    public Boolean getIsIndex()
    {
        return this.isIndex;
    }

    public void setIsIndex(Boolean isIndex)
    {
        this.isIndex = isIndex;
    }

    /**
     * Gets IsView
     * @return
     */
    public Boolean getIsView()
    {
        return this.isView;
    }

    /**
     * Set IsView
     * @param isView
     */
    public void setIsView(Boolean isView)
    {
        this.isView = isView;
    }

    /**
     * Get isStoredProcedure
     * @return
     */
    public Boolean getIsStoredProcedure()
    {
        return this.isStoredProcedure;
    }

    /**
     * Set isStoredProcedure
     * @param isStoredProcedure
     */
    public void setIsStoredProcedure(Boolean isStoredProcedure)
    {
        this.isStoredProcedure = isStoredProcedure;
    }


    /**
     * Get isTrigger
     * @return
     */
    public Boolean getIsTrigger()
    {
        return this.isTrigger;
    }

    /**
     * Set isTrigger
     * @param isTrigger
     */
    public void setIsTrigger(Boolean isTrigger)
    {
        this.isTrigger = isTrigger;
    }

    // TODO : Mutator and Accessor Implementation of All private Fields

}
