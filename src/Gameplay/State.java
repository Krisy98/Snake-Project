package Gameplay;

import Engine.Entity.Entity;
import Engine.Graphics.Graphics;
import Engine.Physics.Physics;

import java.util.LinkedList;

public abstract class State {

    private LinkedList<Entity> entities;
    private Graphics graphics;
    private Physics physics;

    public State(Graphics graphics, Physics physics){
        this.graphics = graphics;
        this.physics = physics;
    }

    abstract void functionalizeControllers();

    void functionalizeEntities(){

        for (Entity entity: entities) {
            graphics.addImage(entity.getImage());
        }

    }

    abstract void destroy();

    abstract void mainLoop();
}
