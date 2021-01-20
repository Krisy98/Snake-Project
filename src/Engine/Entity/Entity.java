package Engine.Entity;

import javafx.scene.image.ImageView;
import java.util.LinkedList;
import java.util.List;

public class Entity {

    private ImageView image;
    private List<Double> speed;

    /**
     * Entity's initialisation
     *  Index 0 of speed represent X axis
     *  Index 1 of speed represent Y axis
     * @param path is the path of the image file
     * @param positionX is the coordinate on the X axis
     * @param positionY is the coordinate on the Y axis
     */
    public Entity(String path, Double positionX, Double positionY){
        image = new ImageView(path);

        image.setX(positionX);
        image.setY(positionY);

        speed = new LinkedList<>();

        speed.add(0.0);
        speed.add(0.0);
    }

    public void setWidth(Double width){ this.image.setFitWidth(width); }

    public void setHeight(Double height){ this.image.setFitHeight(height); }

    public Double getWidth(){ return this.image.getFitWidth(); }

    public Double getHeight(){ return this.image.getFitHeight(); }

    public void setXCoordinate(Double x){ this.image.setX(x); }

    public void setYCoordinate(Double y){ this.image.setY(y); }

    public Double getXCoordinate(){ return this.image.getX(); }

    public Double getYCoordinate(){ return this.image.getY(); }

    public void setSpeedX(Double speedX){ this.speed.set(0, speedX); }

    public void setSpeedY(Double speedY){ this.speed.set(1, speedY); }

    public Double getSpeedX(){ return this.speed.get(0); }

    public Double getSpeedY(){ return this.speed.get(1); }

    public ImageView getImage(){ return this.image; }

}
