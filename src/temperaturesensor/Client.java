package temperaturesensor;

/**
 *
 * @author neeraj poudyal
 * I won't touch this class ASSUMING that this class is already there
 * in the system, so  it is closed for modification 
 * I use an indirection ClientTemperatureUpdater instead
 */
public class Client implements IClient{

private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
