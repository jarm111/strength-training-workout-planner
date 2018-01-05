package stwp;
/**
 *
 * @author Jarmo Syvälahti
 */
public class Workout {
    private String name;
    private int index = 0;
    private Exercise[] exercises = new Exercise[12];
    
    public Workout(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }
    
    public int getExercisesLength() {
        return exercises.length;
    }

    public Exercise[] getExercises() {
        return exercises;
    }
    
    public void addToExercises(Exercise exercise) {
        this.exercises[this.index] = exercise;
        this.index++;
    }
    
    public void removeFromExercises(int toRemove) {
        if (toRemove >= 0 && this.index > toRemove) {
            for (int i = 0; i < index; i++) {
                exercises[toRemove + i] = exercises[toRemove + i +1];
            }
            this.index--;
        }
    }
}
