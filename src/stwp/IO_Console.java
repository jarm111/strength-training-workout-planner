package stwp;

/**
 *
 * @author Jarmo Syvälahti
 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class IO_Console implements IO_Interface {

    private Scanner scanner = new Scanner(System.in);
    private final int DEFAULT_INPUT_INT = -999999;
    private final double DEFAULT_INPUT_DOUBLE = -999999.99;

    @Override
    public void output(String text) {
        System.out.println(text);
    }

    @Override
    public void output(double number) {
        System.out.println(number);
    }

    @Override
    public void output(Object object) {
        System.out.println(object);
    }

    @Override
    public String inputText() {
        String text = "";
        do {
            text = scanner.nextLine();
            if (!text.equals("")) {
                return text;
            }
            this.output("Please input text!");
        } while (true);
    }

    @Override
    public double inputDouble() {
        double number = DEFAULT_INPUT_DOUBLE;
        do {
            try {
                number = scanner.nextDouble();
            } catch (InputMismatchException e) {
                this.output("Please input a decimal number!");
            }
            scanner.nextLine();
        } while (number == DEFAULT_INPUT_DOUBLE);
        return number;
    }

    @Override
    public int inputInt() {
        int number = DEFAULT_INPUT_INT;
        do {
            try {
                number = scanner.nextInt();
            } catch (InputMismatchException e) {
                this.output("Please input an integer number!");
            }
            scanner.nextLine();
        } while (number == DEFAULT_INPUT_INT);
        return number;
    }
}
