package stwp;
/**
 *
 * @author Jarmo Syvälahti
 */
public class DbAccess implements DbInterface {
    
    private final int NAME_INDEX = 0;
    private final int DESCRIPTION_INDEX = 1;
    
    @Override
    public int fetchLength() {
        return MockDb.EXERCISEARRAY.length;
    }
    @Override
    public int fetchWLength() {
        return MockDb.WEIGHTEDEXERCISEARRAY.length;
    }
    @Override
    public String[] fetchNames() {
        String[] names = new String[MockDb.EXERCISEARRAY.length];
        for (int i = 0; i < MockDb.EXERCISEARRAY.length; i++) {
            names[i] = MockDb.EXERCISEARRAY[i][NAME_INDEX];
        }
        return names;
    }
    @Override
    public String[] fetchWNames() {
        String[] names = new String[MockDb.WEIGHTEDEXERCISEARRAY.length];
        for (int i = 0; i < MockDb.WEIGHTEDEXERCISEARRAY.length; i++) {
            names[i] = MockDb.WEIGHTEDEXERCISEARRAY[i][NAME_INDEX];
        }
        return names;
    }
    @Override
    public String fetchName(int index) {
        return MockDb.EXERCISEARRAY[index][NAME_INDEX];
    }
    @Override
    public String fetchWName(int index) {
        return MockDb.WEIGHTEDEXERCISEARRAY[index][NAME_INDEX];
    }
    @Override
    public String fetchDescription(int index) {
        return MockDb.EXERCISEARRAY[index][DESCRIPTION_INDEX];
    }
    @Override
    public String fetchWDescription(int index) {
        return MockDb.WEIGHTEDEXERCISEARRAY[index][DESCRIPTION_INDEX];
    }
}
