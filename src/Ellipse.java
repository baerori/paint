
import java.io.Serializable;
import java.awt.*;
import java.awt.Graphics;

public class Ellipse extends Figure {
    protected int semiAxysX;
    protected int semiAxysY;


    //constructeurs
    public Ellipse(){} //pas besoin d'initialiser x et y à 0, c'est déjà les valeurs d'initialisation par défaut
    public Ellipse(int px, int py, Color c){
        this.semiAxysX=px;
        this.semiAxysY=py;
        this.c=c;
    }

    //setters
    public void setSemiAxysX(int i){this.semiAxysX = i;}
    public void setSemiAxysY(int i){this.semiAxysY = i;}

    //getters
    public int getSemiAxysX(){return this.semiAxysX;}
    public int getSemiAxysY(){return this.semiAxysY;}

    public void setBoundingBox(int semiAxysX, int semiAxysY){
        this.semiAxysX=semiAxysX;
        this.semiAxysY=semiAxysY;
    }

    public void draw(Graphics g){
        g.setColor(this.c);
        g.fillOval(this.origin.x, this.origin.y, 2*this.semiAxysX, 2*this.semiAxysY);
    }
    public double getPerimeter(){
        return (2*Math.PI*Math.sqrt(((this.semiAxysX)^2+(this.semiAxysY)^2)/2));
    }

    public double getSurface(){
        return (Math.PI*(this.semiAxysX)*(this.semiAxysX));
    }

    //toString
    public String toString(){
        return "Ellipse : semiAxysX="+this.semiAxysX+", semiAxysY="+this.semiAxysY +", Color="+this.c+", Surface="+ this.getSurface()+", Perimeter="+this.getPerimeter()+", origin="+this.origin+".";
    }
}
