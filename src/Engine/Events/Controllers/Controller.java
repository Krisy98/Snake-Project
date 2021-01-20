package Engine.Events.Controllers;

import javafx.event.EventHandler;

public class Controller {

    private EventHandler eventHandler;
    private String name;

    public Controller(String name){ this.name = name; }

    public EventHandler getEventHandler(){ return eventHandler; }

    public void setEventHandler(EventHandler eventHandler){ this.eventHandler = eventHandler; }

    public String getName(){ return this.name; }

}
