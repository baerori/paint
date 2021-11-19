import java.io.Serializable;
import java.awt.*;
import java.awt.Graphics;

public class Circle extends Ellipse {
    public Circle(){} //pas besoin d'initialiser x et y à 0, c'est déjà les valeurs d'initialisation par défaut
    public Circle(int r, Color c){this.semiAxysX=r;this.semiAxysY=r;this.c=c;}
    public void setBoundingBox(int widthBB, int heightBB){
        //setting the boundingbox while drawing : keeping the sign of each edge, but choosing the highest value for, dragged with the mouse :
        if(Math.abs(widthBB) > Math.abs(heightBB)){
            this.setSemiAxysX(widthBB);
            this.setSemiAxysY(Math.abs(widthBB)*Integer.signum(heightBB));
        }else{
            this.setSemiAxysY(heightBB);
            this.setSemiAxysX(Math.abs(heightBB)*Integer.signum(widthBB));
        }
    }
    public String toString(){return "Circle : radius="+this.semiAxysX+", Color="+this.c+", Surface="+ this.getSurface()+", Perimeter="+this.getPerimeter()+", origin="+this.origin+"." ;}
}
