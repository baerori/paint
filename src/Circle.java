import java.io.Serializable;
import java.awt.*;
import java.awt.Graphics;

public class Circle extends Ellipse {

    public Circle(){} //pas besoin d'initialiser x et y à 0, c'est déjà les valeurs d'initialisation par défaut
    public Circle(int r, Color c){
        this.semiAxysX=r;
        this.semiAxysY=r;
        this.c=c;
    }

    public void draw(Graphics g){
        g.setColor(this.c);
        g.fillOval(this.origin.x, this.origin.y, this.semiAxysX, this.semiAxysY);
    }

    public void setBoundingBox(int edge){
        this.semiAxysX=edge/2;
        this.semiAxysY=edge/2;
    }

    public void setSemiAxysX(int r){this.semiAxysX = r; this.semiAxysY = r;}
    public void setSemiAxysY(int r){this.semiAxysX = r; this.semiAxysY = r;}

    public String toString(){
        return "Circle : radius="+this.semiAxysX+", Color="+this.c+", Surface="+ this.getSurface()+", Perimeter="+this.getPerimeter()+", origin="+this.origin+"." ;
    }

}
