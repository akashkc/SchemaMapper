package Entity;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Embedded;
import java.sql.*;
import java.util.List;

/**
 * User: Akash
 */
@Entity("Database")
public class Database {



    public Database()
    {
        this("");
    }

    public Database(String name)
    {
        this.Name = name;
    }
    @Embedded
    private String Name;

    @Embedded
    private List<Table> Tables;

    @Embedded
    private List<View> Views;

    @Embedded
    private List<StoredProcedure> StoredProcedures;

    @Embedded
    private Function Function;

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

    public List<Table> getTable()
    {
        return this.Tables;
    }

    public void setTable(List<Table> tables)
    {
        this.Tables = tables;
    }

    /***
     * Get the list of views
     * @return List
     */
    public List<View> getView()
    {
        return this.Views;
    }

    /**
     * Set the list of views
     * @param views
     */
    public void setView(List<View> views)
    {
        this.Views = views;
    }

    public List<StoredProcedure> getStoredProcedure()
    {
        return this.StoredProcedures;
    }

    public void setStoredProcedure(List<StoredProcedure> storedProcedures)
    {
        this.StoredProcedures = storedProcedures;
    }

    public Function getFunction()
    {
        return this.Function;
    }

    public void setFunction(Function function)
    {
        this.Function = function;
    }





}
