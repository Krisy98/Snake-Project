package Engine.Physics;

import Engine.Entity.Entity;
import Engine.Entity.Text;
import javafx.geometry.Bounds;
import java.util.ArrayList;
import java.util.List;

public abstract class Physics {

    /**
     * Check collision from a list of entities
     * @param entities list of entities to test
     * @return a list of couple of entities collided
     */
    public List<List<Entity>> checkCollision(List<Entity> entities){
        List<List<Entity>> collided = new ArrayList<>();

        for (Entity entity : entities) {
            for (Entity otherEntity : entities) {
                if (entity != otherEntity && checkCollisionBetweenEntity(entity, otherEntity)) {
                    List<Entity> temp = new ArrayList<>();

                    temp.add(entity);
                    temp.add(otherEntity);

                    collided.add(temp);
                }
            }
        }
        return collided;
    }

    /**
     * Test if two entities are collide
     * @param entity the first entity
     * @param otherEntity the second entity
     * @return true if these entities are collided, if not return false
     */
    private boolean checkCollisionBetweenEntity(Entity entity, Entity otherEntity){
        Bounds bounds = entity.getImage().getBoundsInLocal();

        return bounds.intersects(otherEntity.getImage().getBoundsInLocal());
    }

    /**
     * This method change coordinates of a entity thanks to his speed
     * This method don't look if the entity can move
     * @param entity is the entity to move
     */
    public void move(Entity entity){
        Double res = plus(entity.getSpeedX(), entity.getXCoordinate());
        entity.setXCoordinate(res);

        res = plus(entity.getSpeedY(), entity.getYCoordinate());
        entity.setYCoordinate(res);
    }

    public void setPosition(Entity entity, Double positionX, Double positionY){
        entity.setXCoordinate(positionX);
        entity.setYCoordinate(positionY);
    }

    /**
     * Change coordinates of the Text with speed
     * @param text to incur the action
     * @param speedX speed in the X axis
     * @param speedY spped in the Y axis
     */
    public void moveText(Text text, Double speedX, Double speedY){
        Double x = text.getPositionX();
        Double y = text.getPositionY();

        text.setPosition(x + speedX, y + speedY);
    }

    /**
     * Replace coordinates with parameters
     * @param text to incur the action
     * @param positionX coordinate in the X axis to replace
     * @param positionY coordinate in the Y axis to replace
     */
    public void setPositionText(Text text, Double positionX, Double positionY){
        text.setPosition(positionX, positionY);
    }

    public void setSpeed(Entity entity, Double speedX, Double speedY){
        entity.setSpeedX(speedX);
        entity.setSpeedY(speedY);
    }

    /**
     * Change the size of the text
     * @param text that will incur action
     * @param size that will replace text's size
     */
    public void resize(Text text, Double size){ text.setSize(size); }

    /**
     * Calculate two variables of Double type and return the result
     * @param a first variable to add
     * @param b second variable to add
     * @return the result of an addition of a and b
     */
    private Double plus(Double a, Double b){
        return a + b;
    }

}
