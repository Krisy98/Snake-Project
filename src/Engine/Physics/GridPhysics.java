package Engine.Physics;

import Engine.Entity.Entity;
import Engine.Entity.Grid;

import java.util.ArrayList;
import java.util.List;

public class GridPhysics extends Physics {

    private List<Grid> grids;

    public GridPhysics(){
        grids = new ArrayList<>();
    }

    /**
     * Create a grid with params and add it to the list of grids
     * @param positionX the X coordinate of the grid
     * @param positionY the Y coordinate of the grid
     * @param width of a case of the grid
     * @param height of a case of the grid
     * @param rowNumber the number of rows of the grid
     * @param columnsNumber the number of columns of the grid
     */
    public void createGrid(Double positionX, Double positionY, Double width, Double height, int rowNumber, int columnsNumber){
        Grid temp = new Grid(positionX, positionY, width, height, rowNumber, columnsNumber);

        grids.add(temp);
    }

    /**
     * Change coordinate to adapt it to the grid system
     * @param entity concerned by the changement
     * @return true if it is successful, false if not
     */
    public boolean adaptEntityToTheGrid(Entity entity){
        List<Double> coordinates;

        coordinates = getCoordinatesForGrid(entity.getXCoordinate(), entity.getYCoordinate());

        if (coordinates == null) return false;

        entity.setXCoordinate(coordinates.get(0));
        entity.setYCoordinate(coordinates.get(1));

        return true;
    }

    /**
     * Test to adapt coordinate to the grid system
     * @param x the X coordinate to test
     * @param y the Y coordinate to test
     * @return Return coordinates corresponding at the grid system if it exist
     */
    private List<Double> getCoordinatesForGrid(Double x, Double y){
        List<Double> coordinates = new ArrayList<>();

        for (Grid grid : grids){
            List<Integer> indexes = grid.getIndexes(x, y);

            if (indexes != null){
                Double xCoordinate = grid.getPositionX() + indexes.get(0)*grid.getWidth();
                Double yCoordinate = grid.getPositionY() + indexes.get(1)*grid.getHeight();

                coordinates.add(xCoordinate);
                coordinates.add(yCoordinate);

                return coordinates;
            }
        }
        return null;
    }

}
