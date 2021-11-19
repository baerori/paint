import java.io.Serializable;
import java.awt.*;

public class Rectangle extends Figure {
    protected int length;
    protected int width;
    //color is defined by the parent's class
    //constructors
    public Rectangle(){} //not mandatory to initialise x et y to 0, it's already the initialisation values
    public Rectangle(int px, int py, Color c){this.width=px;this.length=py;this.c=c;}
    //setters
    public int getWidth(){return this.width;}
    public int getLenght(){return this.length;}
    //getters
    public void setWidth(int i){this.width = i;}
    public void setLenght(int i){this.length = i;}
    public void setBoundingBox(int heightBB, int widthBB){this.width=heightBB;this.length=widthBB;}
    public void draw(Graphics g) {
        g.setColor(this.c);
        if (this.width > 0) {
            if (this.length > 0) {
                g.drawRect(this.origin.x, this.origin.y, this.length, this.width);
            } else {
                g.drawRect(this.origin.x + this.length, this.origin.y, Math.abs(this.length), Math.abs(this.width));
            }
        } else {
            if (this.length > 0) {
                g.drawRect(this.origin.x, this.origin.y + this.width, Math.abs(this.length), Math.abs(this.width));
            } else {
                g.drawRect(this.origin.x + this.length, this.origin.y + this.width, Math.abs(this.length), Math.abs(this.width));
            }
        }
    }
    public double getPerimeter(){return (2*(this.width)+2*(this.length));}
    public double getSurface(){return ((this.width)*(this.length));}
    //toString
    public String toString(){return "Rectangle : Width="+this.width+", Lenght="+this.length+",Color :"+this.c+", Surface="+ this.getSurface()+", Perimeter="+this.getPerimeter()+", origin="+this.origin+"." ;}
}
