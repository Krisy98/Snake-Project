package Engine.Events.Controllers;

import javafx.event.EventHandler;

public abstract class Controller {

    private EventHandler eventHandler;
    //private String name;

    //public Controller(String name){ this.name = name; }

    //public String getName(){ return this.name; }

    public abstract void initEventHandlers();

    public EventHandler getEventHandler(){ return this.eventHandler; }

}
