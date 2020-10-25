import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;

public class OccupantInCol {

    private Object occupant;
    private int colIndex;

    OccupantInCol(Object object, int col) {
        this.occupant = object;
        this.colIndex = col;
    }

    public void setOccupant(Object object) {
        this.occupant = object;
    }

    public Object getOccupant() {
        return occupant;
    }

    public void setCol(int col){
        this.colIndex = col;
    }

    public int getCol() {
        return colIndex;
    }
}