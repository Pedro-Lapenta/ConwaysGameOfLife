package src;

public class DeadState extends GridState{
    public DeadState(int height, int width){
        super(height, width);
    }

    @Override
    public int[][] setState(){
        int[][] state = new int[height][width];

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                state[i][j] = 0; 
            }
        }

        return state;
    }
}
