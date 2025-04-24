package src;

public class UnitTesting {

    //Any live cell with 0 or 1 live neighbors becomes dead, because of underpopulation
    int[][] predictedUnderpopulation = {
                                        {0, 0, 0},
                                        {0, 0, 0},
                                        {0, 0, 0}
                                       };
               
    //Any live cell with more than 3 live neighbors becomes dead, because of overpopulation
    int[][] predictedOverpopulation = {
                                        {1, 0, 0},
                                        {1, 0, 0},
                                        {1, 1, 1}
                                       };

    //Any live cell with 2 or 3 live neighbors stays alive, because its neighborhood is just right
    int[][] predictedSurvival = {
                                        {0, 0, 0},
                                        {1, 1, 0},
                                        {0, 0, 0}
                                       };   
     
    //Any dead cell with exactly three living neighbors becomes alive due to reproduction.
    int[][] predictedReproduction = {
                                        {0, 0, 0},
                                        {0, 1, 0},
                                        {0, 0, 0}
                                       }; 

    public void unitTests() {

        // Test Underpopulation
        SettedState underpopulation = new SettedState("TestStates/Underpopulation.txt");
        if (java.util.Arrays.deepEquals(underpopulation.nextState(underpopulation.setState()), predictedUnderpopulation)) {
            System.out.println("PASSED: underpopulation");
        } else {
            System.out.println("ERROR: underpopulation");
            System.out.println("Expected: ");
            underpopulation.printGrid(predictedUnderpopulation);
            System.out.println("Actual: ");
            underpopulation.printGrid(underpopulation.nextState(underpopulation.setState()));
        }

        // Test Overpopulation
        SettedState overpopulation = new SettedState("TestStates/Overpopulation.txt");
        if (java.util.Arrays.deepEquals(overpopulation.nextState(overpopulation.setState()), predictedOverpopulation)) {
            System.out.println("PASSED: overpopulation");
        } else {
            System.out.println("ERROR: overpopulation");
            System.out.println("Expected: ");
            overpopulation.printGrid(predictedOverpopulation);
            System.out.println("Actual: ");
            overpopulation.printGrid(overpopulation.nextState(overpopulation.setState()));
        }

        // Test Survival
        SettedState survival = new SettedState("TestStates/Survival.txt");
        if (java.util.Arrays.deepEquals(survival.nextState(survival.setState()), predictedSurvival)) {
            System.out.println("PASSED: survival");
        } else {
            System.out.println("ERROR: survival");
            System.out.println("Expected: ");
            survival.printGrid(predictedSurvival);
            System.out.println("Actual: ");
            survival.printGrid(survival.nextState(survival.setState()));
        }

        // Test Reproduction
        SettedState reproduction = new SettedState("TestStates/Reproduction.txt");
        if (java.util.Arrays.deepEquals(reproduction.nextState(reproduction.setState()), predictedReproduction)) {
            System.out.println("PASSED: reproduction");
        } else {
            System.out.println("ERROR: reproduction");
            System.out.println("Expected: ");
            reproduction.printGrid(predictedReproduction);
            System.out.println("Actual: ");
            reproduction.printGrid(reproduction.nextState(reproduction.setState()));
        }
    }
    
}