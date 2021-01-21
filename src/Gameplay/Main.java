package Gameplay;

import Engine.CoreApplication;
import Engine.Graphics.Graphics;
import Engine.Physics.Physics;
import Engine.Physics.PixelPhysics;
import Gameplay.States.Menu;
import Gameplay.States.State;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;



public class Main extends CoreApplication{

    private State state;
    private AnimationTimer timer;

    private Graphics graphics;
    private Physics physics;


    private void initState(State state){
        this.state = state;

        state.operateEntities();
        state.operateControllers();
    }

    private void removeState(){ state.destroy(); }

    private void mainLoop(){ state.mainLoop(); }

    @Override
    public void start(Stage stage) {
        Rectangle2D dimension = Screen.getPrimary().getVisualBounds();

        graphics = new Graphics(stage);
        physics = new PixelPhysics();

        graphics.initiation("Snake Project", dimension.getWidth(), dimension.getHeight() - 10);

        initState(new Menu(this.graphics, this.physics));


        graphics.display();

        timer = new AnimationTimer() { @Override public void handle(long now) { mainLoop(); } };
    }

    public static void main(String[] args) { launch(args); }
}
