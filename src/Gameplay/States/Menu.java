package Gameplay.States;

import Engine.Events.Enumerations.MouseEventType;
import Engine.Graphics.Graphics;
import Engine.Physics.Physics;
import Gameplay.Entity;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;

import java.util.LinkedList;

public class Menu implements State {

    private LinkedList<Entity> entities;
    private Graphics graphics;
    private Physics physics;

    public Menu(Graphics graphics, Physics physics){
        this.graphics = graphics;
        this.physics = physics;
        this.entities = new LinkedList<>();
    }

    @Override
    public void operateEntities() {
        createBackground();
        createOptions();
    }

    @Override
    public void operateControllers() {
        graphics.setEventToScene(this.getMoveHandler(), MouseEventType.MOVE);
        graphics.setEventToScene(this.getClickHandler(), MouseEventType.CLICKED);
    }

    @Override
    public void destroy() {
        graphics.setEventToScene(null, MouseEventType.MOVE);
        graphics.setEventToScene(null, MouseEventType.CLICKED);

        graphics.clear();
    }

    @Override
    public void mainLoop() {
        // Nothing
    }

    private void createBackground(){
        Rectangle2D dimension = Screen.getPrimary().getVisualBounds();
        Entity entity = new Entity("menu/background.jpg", 0.0, 0.0);

        entity.setWidth(dimension.getWidth());
        entity.setHeight(dimension.getHeight());

        graphics.toBack(entity.getImage());

        graphics.addImage(entity.getImage());
    }

    private void createOptions(){
        double widthScene = graphics.getWidthScene();
        double heightScene = graphics.getHeightScene();

        double widthSpace = widthScene/3;
        double heightSpace = heightScene/3;

        createAnOption("menu/play.png", widthScene/2 - widthSpace/4, heightSpace/2);
        createAnOption("menu/score.png", widthScene/2 - widthSpace/4, heightSpace);
        createAnOption("menu/credits.png", widthScene/2 - widthSpace/4, heightSpace*3/2);

        for (Entity entity: entities) {
            entity.setWidth(widthSpace/2);
            entity.setHeight(heightSpace/2);

            graphics.addImage(entity.getImage());
        }
    }

    private void createAnOption(String name, Double positionX, Double positionY){
        Entity entity = new Entity(name, positionX, positionY);
        entities.add(entity);
    }

    private EventHandler<MouseEvent> getMoveHandler(){
        return event -> {

            for (Entity entity : entities) {
                Bounds bounds = entity.getImage().getBoundsInParent();

                if (bounds.contains(new Point2D(event.getX(), event.getY())) && (entity.getPath().equals(entity.getOriginalPath()))) {
                    String name = entity.getPath();
                    name = name.substring(0, name.length() - 4) + "Modified.png";

                    entity.setImage(new Image(name));
                }
                else if (!bounds.contains(new Point2D(event.getX(), event.getY())) && !entity.getPath().equals(entity.getOriginalPath()))
                    entity.setImage(new Image(entity.getOriginalPath()));
            }
        };
    }

    private EventHandler<MouseEvent> getClickHandler(){
        return event -> {
            for (Entity entity : entities) {
                Bounds bounds = entity.getImage().getBoundsInParent();

                if (bounds.contains(new Point2D(event.getX(), event.getY()))) {
                    System.out.println("Clicked on !");
                    destroy();
                }
            }
        };
    }

}
