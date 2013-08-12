package Entity;
import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Embedded;

import java.util.List;

/**
 * User: asus
 * Date: 6/20/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Table {

    private String Name;

    @Embedded
    private List<Column> Columns;

    @Embedded
    private List<Constraint> Constraints;

    @Embedded
    private List<Index> Indexes;

    @Embedded
    private List<Key> Keys;

    @Embedded
    private List<Trigger> Triggers;

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }

    public List<Column> getColumn()
    {
        return this.Columns;
    }

    public void setColumn(List<Column> columns)
    {
        this.Columns = columns;
    }

    public List<Constraint> getConstraint()
    {
        return this.Constraints;
    }

    public void setConstraint(List<Constraint> constraints)
    {
        this.Constraints = constraints;
    }

    public List<Index> getIndexes()
    {
        return this.Indexes;
    }

    public void setIndexes(List<Index> indexes)
    {
        this.Indexes = indexes;
    }

    public List<Key> getKeys()
    {
        return this.Keys;
    }

    public void setKeys(List<Key> keys)
    {
        this.Keys = keys;
    }

    public List<Trigger> getTrigger()
    {
        return this.Triggers;
    }

    public void setTriggers(List<Trigger> triggers)
    {
        this.Triggers = triggers;
    }

}


