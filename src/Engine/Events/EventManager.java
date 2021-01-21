package Engine.Events;

import Engine.Entities.Entity;
import Engine.Events.Controllers.Controller;
import Engine.Events.Enumerations.KeyEventType;
import Engine.Events.Enumerations.MouseEventType;
import javafx.event.EventHandler;
import javafx.scene.Group;

public abstract class EventManager {

    private Group root;

    /**
     * Add a event to the graphic scene of type KeyEventType
     * If you want remove the event, set controller at null
     * @param eventHandler contains operations for each event released
     * @param type define the event action
     */
    public void setEventToScene(EventHandler eventHandler, KeyEventType type){
        switch (type){
            case PRESSED:
                this.root.getScene().setOnKeyPressed(eventHandler);
                break;
            case RELEASED:
                this.root.getScene().setOnKeyReleased(eventHandler);
                break;
        }
    }

    /**
     * Add a event to the graphic scene of type MouseEventType
     * If you want remove the event, set controller at null
     * @param eventHandler contains operations for each event released
     * @param type define the event action
     */
    public void setEventToScene(EventHandler eventHandler, MouseEventType type){
        switch (type){
            case RELEASED:
                this.root.getScene().setOnMouseReleased(eventHandler);
                break;
            case CLICKED:
                this.root.getScene().setOnMouseClicked(eventHandler);
                break;
            case MOVE:
                this.root.getScene().setOnMouseMoved(eventHandler);
                break;
        }
    }

    /**
     * Add a event to the entity of type KeyEventType
     * If you want remove the event, set controller at null
     * @param entity is the entity concern by the action
     * @param eventHandler contains operations for each event released
     * @param type define the event action
     */
    public void setEvent(Entity entity, EventHandler eventHandler, KeyEventType type){
        switch (type){
            case PRESSED:
                entity.getImage().setOnKeyPressed(eventHandler);
                break;
            case RELEASED:
                entity.getImage().setOnKeyReleased(eventHandler);
                break;
        }
    }

    /**
     * Add a event to the entity of type MouseEventType
     * If you want remove the event, set controller at null
     * @param entity is the entity concern by the action
     * @param eventHandler contains operations for each event released
     * @param type define the event action
     */
    public void setEvent(Entity entity, EventHandler eventHandler, MouseEventType type){
        switch (type){
            case RELEASED:
                entity.getImage().setOnMouseReleased(eventHandler);
                break;
            case CLICKED:
                entity.getImage().setOnMouseClicked(eventHandler);
                break;
            case MOVE:
                entity.getImage().setOnMouseMoved(eventHandler);
                break;
        }
    }

    protected void setRoot(Group root){ this.root = root; }

}
