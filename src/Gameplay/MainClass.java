package Gameplay;

import Engine.CoreApplication;
import Engine.Graphics.Graphics;
import Engine.Physics.Physics;
import Engine.Physics.PixelPhysics;
import javafx.animation.AnimationTimer;
import javafx.stage.Stage;


public class MainClass extends CoreApplication{

    private State state;
    private AnimationTimer timer;

    private Graphics graphics;
    private Physics physics;


    private void initState(State state){
        this.state = state;

        state.functionalizeEntities();
        state.functionalizeControllers();
    }

    private void removeState(){ state.destroy(); }

    private void mainLoop(){
        state.mainLoop();
    }

    @Override
    public void start(Stage stage) {
        graphics = new Graphics(stage);
        physics = new PixelPhysics();

        // initState(Menu menu)

        timer = new AnimationTimer() {
            @Override public void handle(long now) { mainLoop(); }
        };
    }

    public static void main(String[] args) {
        launch(args);
    }
}
