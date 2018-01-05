package stwp;
/**
 *
 * @author Jarmo Syvälahti
 */
public interface DbInterface {
    public int fetchLength();
    public int fetchWLength();
    public String[] fetchNames();
    public String[] fetchWNames();
    public String fetchName(int index);
    public String fetchWName(int index);
    public String fetchDescription(int index);
    public String fetchWDescription(int index);
}
