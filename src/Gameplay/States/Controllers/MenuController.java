package Gameplay.States.Controllers;

import Engine.Events.Controllers.Controller;
import Gameplay.Entity;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import java.util.LinkedList;

public class MenuController extends Controller {

    LinkedList<Entity> entities;
    EventHandler<MouseEvent> moveEventHandler;
    EventHandler<MouseEvent> clickEventHandler;

    public MenuController(LinkedList entities) {
        this.entities = entities;

        initEventHandlers();
    }

    @Override
    public void initEventHandlers() {
        /*
        moveEventHandler = new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {

                for (Entity entity : entities){
                    Bounds bounds = entity.getImage().getBoundsInParent();

                    if (bounds.contains(new Point2D(event.getX(), event.getY())) && isOriginalSize(entity)){

                        System.out.println("TOUCHE");

                        entity.setWidth(entity.getWidth() + entity.getWidth()/10);
                        entity.setHeight(entity.getHeight() + entity.getHeight()/30);

                    }
                }

            }
        };

    */


    }

    private boolean isOriginalSize(Entity entity){
        return (entity.getWidth().equals(entity.getOriginalWidth()) &&
                entity.getHeight().equals(entity.getOriginalHeight()));
    }

    public EventHandler getMoveEventHandler(){ return this.moveEventHandler; }

    public EventHandler getClickEventHandler(){ return this.clickEventHandler; }
}
