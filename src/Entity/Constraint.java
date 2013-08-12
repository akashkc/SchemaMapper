package Entity;
import com.google.code.morphia.annotations.Entity;

/**
 * User: Akash
 */
@Entity
public class Constraint {

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
