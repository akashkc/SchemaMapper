package Entity;
import com.google.code.morphia.annotations.*;
/**
 * User: asus
 * Date: 6/20/13
 * Time: 10:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Column {

    private String Name;

    public void setName(String name)
    {
        this.Name = name;
    }

    public String getName()
    {
        return this.Name;
    }
}
