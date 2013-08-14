package Entity;
import com.google.code.morphia.annotations.Entity;
/**
 * User: Akash
 */
@Entity
public class View {

    private String Name;

    public String getName()
    {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }
}
