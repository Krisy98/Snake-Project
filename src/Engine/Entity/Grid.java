package Engine.Entity;

import java.util.ArrayList;
import java.util.List;

public class Grid {

    private List<Double> coordinates;
    private List<Double> size;
    private int rowNumber;
    private int columnsNumber;

    public Grid(Double positionX, Double positionY, Double width, Double height, int rowNumber, int columnsNumber){
        coordinates = new ArrayList<>();
        coordinates.add(positionX);
        coordinates.add(positionY);

        size = new ArrayList<>();
        size.add(width);
        size.add(height);

        this.rowNumber = rowNumber;
        this.columnsNumber = columnsNumber;
    }

    /**
     * Return the corresponding indexes from the coordinates
     * @param x is the X coordinate
     * @param y is the Y coordinate
     * @return a list of indexes
     */
    public List<Integer> getIndexes(Double x, Double y){
        List<Integer> indexes = new ArrayList<>();
        for (int nbRow=0; nbRow<rowNumber; nbRow++){
            for (int nbColumn=0; nbColumn<columnsNumber; nbColumn++){
                if (getPositionX() + nbRow*getWidth() < x && x < getPositionX() + (nbRow+1)*getWidth() &&
                getPositionY() + nbColumn*getHeight() < y && y < getPositionY() + (nbColumn + 1)*getHeight()){
                    indexes.add(nbRow);
                    indexes.add(nbColumn);
                    return indexes;
                }
            }
        }
        return null;
    }

    public Double getWidth(){ return this.size.get(0); }

    public Double getHeight(){ return this.size.get(1); }

    public Double getPositionX(){ return coordinates.get(0); }

    public Double getPositionY(){ return coordinates.get(1); }

    public int getRowNumber(){ return this.rowNumber; }

    public int getColumnsNumber(){ return this.columnsNumber; }

}
