package Engine.Graphics;

import Engine.Entity.Text;
import Engine.Events.EventManager;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class Graphics extends EventManager {

    private Stage stage;
    private Group root;

    public Graphics(Stage stage){
        this.stage = stage;
        this.root = new Group();

        super.setRoot(this.root);
    }

    /**
     * Initialisation of the graphic scene with params
     * @param title of the window
     * @param width of the scene
     * @param height of the scene
     */
    public void initiation(String title, Double width, Double height){
        Scene scene = new Scene(this.root);

        this.stage.setScene(scene);
    }

    /**
     * Add a ImageView to the graphic scene
     * @param image is the element to add
     */
    public void addImage(ImageView image){
        this.root.getChildren().add(image);
    }

    /**
     * Remove a element to the scene
     * @param node the element to remove
     */
    public void remove(Node node){
        this.root.getChildren().remove(node);
    }

    /**
     * Open a window to show the graphic scene
     */
    public void display(){ this.stage.show(); }

    /**
     * Allow to display only the specified part of the imageView
     * @param imageView that will incur operation
     * @param op1 first parameter's quotient of the Rectangle2D
     * @param op2 second parameter's quotient of the Rectangle2D
     * @param op3 third parameter's quotient of the Rectangle2D
     * @param op4 fourth parameter's quotient of the Rectangle2D
     */
    public void showPartImage(ImageView imageView, Double op1, Double op2, Double op3, Double op4){
        Image temp = imageView.getImage();

        Double width = temp.getWidth();
        Double height = temp.getHeight();

        Rectangle2D viewport = new Rectangle2D(width*op1, height*op2, width*op3, height*op4);

        imageView.setViewport(viewport);
    }

    public void rotate(ImageView image){
        // TODO
    }

    public void setWidth(ImageView image, Double width){ image.setFitWidth(width); }

    public void setHeight(ImageView image, Double height){ image.setFitWidth(height); }

    public void setTypeFace(Text text, String fontName){ text.setTypeFace(fontName); }

    protected Group getRoot(){ return this.root; }

}
