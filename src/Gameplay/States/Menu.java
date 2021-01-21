package Gameplay.States;

import Engine.Graphics.Graphics;
import Engine.Physics.Physics;
import Gameplay.Entity;
import javafx.geometry.Rectangle2D;
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
        //MenuController controller = new MenuController(entities);

        //graphics.setEventToScene(controller.getMoveEventHandler(), MouseEventType.MOVE);

    }

    @Override
    public void destroy() {

    }

    @Override
    public void mainLoop() {

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
        Double widthScene = graphics.getWidthScene();
        Double heightScene = graphics.getHeightScene();

        Double widthSpace = widthScene/3;
        Double heightSpace = heightScene/3;

        createAnOption("menu/play.png", widthScene/2 - widthSpace/4, heightSpace/2);
        createAnOption("menu/score.png", widthScene/2 - widthSpace/4, heightSpace);
        createAnOption("menu/credits.png", widthScene/2 - widthSpace/4, heightSpace*3/2);

        for (Entity entity: entities) {

            entity.setWidth(widthSpace/2);
            entity.setHeight(heightSpace/2);

            entity.setOriginalDimension(widthSpace/2, heightSpace/2);

            graphics.addImage(entity.getImage());
        }
    }

    private void createAnOption(String name, Double positionX, Double positionY){
        Entity entity = new Entity(name, positionX, positionY);
        entities.add(entity);
    }


}
