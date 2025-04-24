package src;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SettedState extends GridState {
    private String filePath;

    public SettedState(String filePath) {
        super(0, 0);
        this.filePath = filePath;
        initializeDimensions(filePath);
    }

    private void initializeDimensions(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                height++;
                if (width == 0) {
                    width = line.trim().length();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public int[][] setState() {
        int[][] grid = new int[height][width];
    
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                for (int col = 0; col < line.length(); col++) {
                    grid[row][col] = Character.getNumericValue(line.charAt(col));
                }
                row++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return grid;
    }
    

}
