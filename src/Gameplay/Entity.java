package Gameplay;


public class Entity extends Engine.Entities.Entity {

    private String originalPath;

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

        this.originalPath = super.getImage().getImage().impl_getUrl();
    }

    public String getOriginalPath(){ return this.originalPath; }


}
