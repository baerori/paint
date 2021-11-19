import java.io.Serializable;
import java.awt.*;
import java.awt.Graphics;

public class Square extends Rectangle {

    public Square(){} //pas besoin d'initialiser x et y à 0, c'est déjà les valeurs d'initialisation par défaut
    public Square(int edge, Color c){this.width=edge;this.length=edge;this.c=c;}

    public void setBoundingBox(int heightBB, int widthBB){
        //setting the boundingbox while drawing : keeping the sign of each edge, but choosing the highest value for, dragged with the mouse :
        if(Math.abs(widthBB) > Math.abs(heightBB)){
            this.setWidth(widthBB);
            this.setLenght(Math.abs(widthBB)*Integer.signum(heightBB));
        }else{
            this.setLenght(heightBB);
            this.setWidth(Math.abs(heightBB)*Integer.signum(widthBB));
        }
    }
    public String toString(){return "Square : Edge width="+this.width+", origin="+this.origin+"." ;}
}
