package Entity;
import com.google.code.morphia.annotations.*;
/**
 * User: asus
 * Date: 6/20/13
 * Time: 10:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Index {

   private String Name;

    public String getName() {
        return this.Name;
    }

    public void setName(String name)
    {
        this.Name = name;
    }

}
