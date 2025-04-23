package src;

import java.util.Random;

public class GridState {
    Random random = new Random();

    public int height;
    public int width;
    protected int[][] grid;

    public GridState(int height, int width) {
        this.height = height;
        this.width = width;
        this.grid = new int[height][width];
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int[][] setState() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (random.nextFloat(1) > 0.9){
                    grid[i][j] =  1;
                }
                else {
                    grid[i][j] = 0;
                }
            }
        }
        return grid;
    }

    public void printGrid(int[][] grid) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 0){
                    System.out.print(".");
                }
                else {
                    System.out.print("■");
                }
            }
            System.out.println();
        }
    }

    public void printTempGrid(){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }

    public int countNeighbors(int x, int y, int[][] grid) {
        int neighborsAmount = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                int neighborX = x + i;
                int neighborY = y + j;

                if (neighborX >= 0 && neighborX < height && neighborY >= 0 && neighborY < width) {
                    neighborsAmount += grid[neighborX][neighborY];
                }                
            }
        }

        return neighborsAmount;
    }

    public int[][] nextState(int[][] grid) {
        int[][] newGrid = new int[height][width];

        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                int numOfNeighbors = countNeighbors(i, j, grid);
                
                //Any live cell with 0 or 1 live neighbors becomes dead, because of underpopulation
                if(grid[i][j] == 1 && numOfNeighbors < 2){
                    newGrid[i][j] = 0;
                }
                //Any live cell with 2 or 3 live neighbors stays alive, because its neighborhood is just right
                if(grid[i][j] == 1 && numOfNeighbors == 2 || numOfNeighbors == 3){
                    newGrid[i][j] = 1;
                }
                //Any live cell with more than 3 live neighbors becomes dead, because of overpopulation
                if(grid[i][j] == 1 && numOfNeighbors > 3){
                    newGrid[i][j] = 0;
                }
                //Any dead cell with exactly 3 live neighbors becomes alive, by reproduction
                if(grid[i][j] == 0 && numOfNeighbors == 3){
                    newGrid[i][j] = 1;
                }
            }
        }
        return newGrid;
    }

    public void playGame(int repetitions) {
        int[][] grid = setState();
        int[][] tempGrid = grid;
        int loopCount = 0;

        System.out.print("\033[H"); // Move cursor to top-left
        System.out.print("Conway's Game of Life: ");
    
        for (int i = 0; i != repetitions; i--) {
            System.out.print("\033[H"); // Move cursor to top-left

            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            printGrid(grid);            // Overwrites the previous frame
    
            grid = nextState(grid);
    
            try {
                Thread.sleep(200); // Delay between frames
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
    

    //TODO -> CREATE UNIT TESTS
}