package Engine.Events;

import Engine.Entity.Entity;
import Engine.Events.Controllers.Controller;
import Engine.Events.Enumerations.KeyEventType;
import Engine.Events.Enumerations.MouseEventType;
import javafx.scene.Group;

public abstract class EventManager {

    private Group root;

    /**
     * Add a event to the graphic scene of type KeyEventType
     * If you want remove the event, set controller at null
     * @param controller contains operations for each event released
     * @param type define the event action
     */
    public void setEventToScene(Controller controller, KeyEventType type){
        switch (type){
            case PRESSED:
                this.root.getScene().setOnKeyPressed(controller.getEventHandler());
                break;
            case RELEASED:
                this.root.getScene().setOnKeyReleased(controller.getEventHandler());
                break;
        }
    }

    /**
     * Add a event to the graphic scene of type MouseEventType
     * If you want remove the event, set controller at null
     * @param controller contains operations for each event released
     * @param type define the event action
     */
    public void setEventToScene(Controller controller, MouseEventType type){
        switch (type){
            case RELEASED:
                this.root.getScene().setOnMouseReleased(controller.getEventHandler());
                break;
            case CLICKED:
                this.root.getScene().setOnMouseClicked(controller.getEventHandler());
                break;
            case MOVE:
                this.root.getScene().setOnMouseMoved(controller.getEventHandler());
                break;
        }
    }

    /**
     * Add a event to the entity of type KeyEventType
     * If you want remove the event, set controller at null
     * @param entity is the entity concern by the action
     * @param controller contains operations for each event released
     * @param type define the event action
     */
    public void setEvent(Entity entity, Controller controller, KeyEventType type){
        switch (type){
            case PRESSED:
                entity.getImage().setOnKeyPressed(controller.getEventHandler());
                break;
            case RELEASED:
                entity.getImage().setOnKeyReleased(controller.getEventHandler());
                break;
        }
    }

    /**
     * Add a event to the entity of type MouseEventType
     * If you want remove the event, set controller at null
     * @param entity is the entity concern by the action
     * @param controller contains operations for each event released
     * @param type define the event action
     */
    public void setEvent(Entity entity, Controller controller, MouseEventType type){
        switch (type){
            case RELEASED:
                entity.getImage().setOnMouseReleased(controller.getEventHandler());
                break;
            case CLICKED:
                entity.getImage().setOnMouseClicked(controller.getEventHandler());
                break;
            case MOVE:
                entity.getImage().setOnMouseMoved(controller.getEventHandler());
                break;
        }
    }

    protected void setRoot(Group root){ this.root = root; }

}
