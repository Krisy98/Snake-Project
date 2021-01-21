package Gameplay.States;


public interface State {

    void operateEntities();

    void operateControllers();

    void destroy();

    void mainLoop();


}
