/*
 * Strenght Training Workout Planner
 * 
 * A program for printing out a workout plan for strenght training purposes.
 */
package stwp;

/**
 *
 * @author Jarmo Syvälahti
 */
public class ProgramMain {

    private static IO_Interface io = new IO_Console();
    private static DbInterface dBAccess = new DbAccess();
    private static final int INDEX_TO_DISPLAY_ADDITION = 1;
    private static final int DEFAULT_INPUT_INT = -99999;
    private static final double DEFAULT_INPUT_DOUBLE = -99999.99;

    public static void main(String[] args) {

        io.output("Welcome to Strenght Training Workout Planner!");
        io.output("Input workout name:");
        Workout workout = new Workout(io.inputText());

        main:
        while (true) {
            io.output("Please select an option '1' - '5'");
            io.output("(1) Add an exercise");
            io.output("(2) Add a weighted exercise");
            io.output("(3) Remove an exercise");
            io.output("(4) Print workout");
            io.output("(5) Exit program");

            int choice = io.inputInt();
            switch (choice) {
                case 1:
                    addExercise(workout);
                    break;
                case 2:
                    addWeightedExercise(workout);
                    break;
                case 3:
                    removeExercise(workout);
                    break;
                case 4:
                    printExercises(workout);
                    break;
                case 5:
                    io.output("Exiting...");
                    break main;
                default:
                    io.output("Please input a number between '1' and '5'!");
                    break;
            }
        }
    }

    private static void addExercise(Workout workout) {
        if (checkExercisesIsFull(workout)) {
            return;
        }
        int exerciseSelection = selectExercise();

        workout.addToExercises(new Exercise(dBAccess.fetchName(exerciseSelection),
                dBAccess.fetchDescription(exerciseSelection),
                addNumberOfSets(1, 10), addNumberOfReps(1, 100))
        );
        io.output("New exercise added!");
    }

    private static void addWeightedExercise(Workout workout) {
        if (checkExercisesIsFull(workout)) {
            return;
        }
        int exerciseSelection = selectWeightedExercise();

        workout.addToExercises(new WeightedExercise(dBAccess.fetchWName(exerciseSelection),
                dBAccess.fetchWDescription(exerciseSelection),
                addNumberOfSets(1, 10), addNumberOfReps(1, 100), addAmountOfWeight(0, 1000))
        );
        io.output("New weighted exercise added!");
    }

    private static void removeExercise(Workout workout) {
        if (workout.getIndex() == 0) {
            io.output("No exercises to remove!");
            return;
        }
        int selectionToRemove = DEFAULT_INPUT_INT;
        do {
            io.output("Select an exercise 'number' to remove or '0' to cancel");
            printExercisesNames(workout);
            selectionToRemove = io.inputInt();
        } while (selectionToRemove < 0 || workout.getIndex() < selectionToRemove);
        if (selectionToRemove == 0) {
            return;
        }
        selectionToRemove -= INDEX_TO_DISPLAY_ADDITION;
        workout.removeFromExercises(selectionToRemove);
        io.output("Exercise '" + (selectionToRemove + INDEX_TO_DISPLAY_ADDITION) + "' removed successfully.");
    }

    private static int addNumberOfSets(int min, int max) {
        int numberOfSets = 0;
        do {
            io.output("Input number of sets '" + min + "' - '" + max + "':");
            numberOfSets = io.inputInt();
        } while (numberOfSets < min || max < numberOfSets);
        return numberOfSets;
    }

    private static int addNumberOfReps(int min, int max) {
        int numberOfReps = 0;
        do {
            io.output("Input number of reps '" + min + "' - '" + max + "':");
            numberOfReps = io.inputInt();
        } while (numberOfReps < min || max < numberOfReps);
        return numberOfReps;
    }

    private static double addAmountOfWeight(double min, double max) {
        double amountOfWeight = DEFAULT_INPUT_DOUBLE;
        do {
            io.output("Input decimal number for weights in kg: '" + min + "' - '" + max + "':");
            amountOfWeight = io.inputDouble();
        } while (amountOfWeight < min || max < amountOfWeight);
        return amountOfWeight;
    }

    private static boolean checkExercisesIsFull(Workout workout) {
        if (workout.getExercisesLength() == workout.getIndex()) {
            io.output("Sorry, cannot add exercise, limit reached!");
            return true;
        }
        return false;
    }

    private static int selectExercise() {
        io.output("Select an exercise:");
        printNames(dBAccess.fetchNames());
        int exerciseSelection = DEFAULT_INPUT_INT;
        do {
            io.output("Input the number of exercise to add '" + INDEX_TO_DISPLAY_ADDITION + "' - '" + dBAccess.fetchLength() + "'");
            exerciseSelection = io.inputInt();
        } while (exerciseSelection < INDEX_TO_DISPLAY_ADDITION || dBAccess.fetchLength() < exerciseSelection);
        return exerciseSelection - INDEX_TO_DISPLAY_ADDITION;
    }

    private static int selectWeightedExercise() {
        io.output("Select a weighted exercise:");
        printWNames(dBAccess.fetchWNames());
        int exerciseSelection = DEFAULT_INPUT_INT;
        do {
            io.output("Input the number of exercise to add '" + INDEX_TO_DISPLAY_ADDITION + "' - '" + dBAccess.fetchWLength() + "'");
            exerciseSelection = io.inputInt();
        } while (exerciseSelection < INDEX_TO_DISPLAY_ADDITION || dBAccess.fetchWLength() < exerciseSelection);
        return exerciseSelection - INDEX_TO_DISPLAY_ADDITION;
    }

    private static void printExercisesNames(Workout workout) {
        for (int i = 0; i < workout.getIndex(); i++) {
            io.output("(" + (i + INDEX_TO_DISPLAY_ADDITION) + ") " + workout.getExercises()[i].getName());
        }
    }

    private static void printExercises(Workout workout) {
        io.output("******");
        io.output("Workout name: " + workout.getName());
        for (int i = 0; i < workout.getIndex(); i++) {
            io.output((i + INDEX_TO_DISPLAY_ADDITION) + ". " + workout.getExercises()[i].toString());
        }
        io.output("******");
    }
    private static void printNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            io.output("(" + (i + INDEX_TO_DISPLAY_ADDITION) + ") " + names[i]);
        }
    }
    private static void printWNames(String[] names) {
        for (int i = 0; i < names.length; i++) {
            io.output("(" + (i + INDEX_TO_DISPLAY_ADDITION) + ") " + names[i]);
        }
    }
}
