package stwp;
/**
 *
 * @author Jarmo Syvälahti
 */
public interface IO_Interface {
    public void output(String text);
    public void output(double number);
    public void output(Object object);
    
    public String inputText();
    public double inputDouble();
    public int inputInt();
}
