
import java.io.Serializable;
import java.awt.*;
import java.awt.Graphics;

public class Ellipse extends Figure {
    //attributes
    protected int semiAxysX;
    protected int semiAxysY;
    //constructors
    public Ellipse(){}
    public Ellipse(int px, int py, Color c){this.semiAxysX=px;this.semiAxysY=py;this.c=c;}
    //getters
    public int getSemiAxysX(){return this.semiAxysX;}
    public int getSemiAxysY(){return this.semiAxysY;}
    //setters
    public void setSemiAxysX(int i){this.semiAxysX = i;}
    public void setSemiAxysY(int i){this.semiAxysY = i;}
    public void setBoundingBox(int semiAxysX, int semiAxysY){this.semiAxysX=semiAxysX;this.semiAxysY=semiAxysY;    }
    public void draw(Graphics g) {
        g.setColor(this.c);
        if (this.semiAxysX > 0) {
            if (this.semiAxysY > 0) {
                g.drawOval(this.origin.x, this.origin.y, this.semiAxysX, this.semiAxysY);
            } else {
                g.drawOval(this.origin.x, this.origin.y+this.semiAxysY, Math.abs(this.semiAxysX), Math.abs(this.semiAxysY));
            }
        } else {
            if (this.semiAxysY > 0) {
                g.drawOval(this.origin.x+this.semiAxysX, this.origin.y, Math.abs(this.semiAxysX), Math.abs(this.semiAxysY));
            } else {
                g.drawOval(this.origin.x + this.semiAxysX, this.origin.y + this.semiAxysY, Math.abs(this.semiAxysX), Math.abs(this.semiAxysY));
            }
        }
    }
    public double getPerimeter(){return (2*Math.PI*Math.sqrt(((this.semiAxysX)^2+(this.semiAxysY)^2)/2));}
    public double getSurface(){return (Math.PI*(this.semiAxysX)*(this.semiAxysX));}
    public String toString(){return "Ellipse : semiAxysX="+this.semiAxysX+", semiAxysY="+this.semiAxysY +", Color="+this.c+", Surface="+ this.getSurface()+", Perimeter="+this.getPerimeter()+", origin="+this.origin+".";}
}
