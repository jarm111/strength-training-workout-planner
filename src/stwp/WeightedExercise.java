package stwp;
/**
 *
 * @author Jarmo Syvälahti
 */
public class WeightedExercise extends Exercise {
    private double weight;

    public WeightedExercise(String name, String description, int sets, int repetitions, double weight) {
        super(name, description, sets, repetitions);
        this.weight = weight;
    }
    
    @Override
    public String toString() {
        return this.getName() + ", "
                + "sets: " + this.getSets() + ", "
                + "reps: " + this.getRepetitions() + ", "
                + "weight: " + this.weight + " kg"
                + System.getProperty("line.separator")
                + this.getDescription();
    }
}
