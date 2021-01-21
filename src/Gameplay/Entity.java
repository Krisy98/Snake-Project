package Gameplay;

import java.util.LinkedList;

public class Entity extends Engine.Entities.Entity {

    LinkedList<Double> originalDimension;

    /**
     * Entity's initialisation
     * Index 0 of speed represent X axis
     * Index 1 of speed represent Y axis
     *
     * @param path      is the path of the image file
     * @param positionX is the coordinate on the X axis
     * @param positionY is the coordinate on the Y axis
     */
    public Entity(String path, Double positionX, Double positionY) {
        super(path, positionX, positionY);
    }

    public void setOriginalDimension(Double width, Double height) {
        LinkedList temp = new LinkedList();

        temp.add(width);
        temp.add(height);

        this.originalDimension = temp;
    }

    public Double getOriginalWidth(){ return this.originalDimension.get(0);}

    public Double getOriginalHeight(){ return this.originalDimension.get(1);}

}
