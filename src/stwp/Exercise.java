package stwp;
/**
 *
 * @author Jarmo Syvälahti
 */
public class Exercise {

    private String name;
    private String description;
    private int sets;
    private int repetitions;

    public Exercise(String name, String description, int sets, int repetitions) {
        this.name = name;
        this.description = description;
        this.sets = sets;
        this.repetitions = repetitions;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getSets() {
        return sets;
    }

    public int getRepetitions() {
        return repetitions;
    }

    @Override
    public String toString() {
        return this.name + ", "
                + "sets: " + this.sets + ", "
                + "reps: " + this.repetitions
                + System.getProperty("line.separator")
                + this.description;
    }
}
