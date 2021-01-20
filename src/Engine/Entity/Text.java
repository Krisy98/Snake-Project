package Engine.Entity;

import javafx.scene.text.Font;

public class Text {

    private javafx.scene.text.Text text;

    public Text(String string){
        text = new javafx.scene.text.Text(string);
    }

    public void setText(String string){ this.text.setText(string); }

    public javafx.scene.text.Text getText() { return text; }

    public void setSize(double size){
        String fontName = this.text.getFont().getName(); // we keep the actual typeFace
        Font font = new Font(fontName, size);

        this.text.setFont(font);
    }

    public void setPosition(Double positionX, Double positionY){
        this.text.setX(positionX);
        this.text.setY(positionY);
    }

    public Double getPositionX(){ return this.text.getX(); }

    public Double getPositionY(){ return this.text.getY(); }

    public void setTypeFace(String fontName){
        double size = this.text.getFont().getSize();
        Font font = new Font(fontName, size);

        this.text.setFont(font);
    }

}
