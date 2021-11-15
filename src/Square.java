import java.io.Serializable;
import java.awt.*;
import java.awt.Graphics;

public class Square extends Rectangle {

    public Square(){} //pas besoin d'initialiser x et y à 0, c'est déjà les valeurs d'initialisation par défaut
    public Square(int edge, Color c){
        this.width=edge;
        this.length=edge;
        this.c=c;
    }

    public void setWidth(int i){this.width = i;this.length = i;}
    public void setLenght(int i){this.width = i;this.length = i;}

    public void setBoundingBox(int edge){this.length=edge;this.width=edge;}

    public void draw(Graphics g) {
        g.setColor(this.c);
        g.fillRect(this.origin.x, this.origin.y, this.width, this.length);
    }

    public String toString(){
        return "Square : Edge width="+this.width+", origin="+this.origin+"." ;
    }
}
