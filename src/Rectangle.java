import java.io.Serializable;
import java.awt.*;

public class Rectangle extends Figure {
    protected int length;
    protected int width;
    //color is defined by the parent's class

    //constructeurs
    public Rectangle(){} //not mandatory to initialise x et y to 0, it's already the initialisation values
    public Rectangle(int px, int py, Color c){
        this.width=px;
        this.length=py;
        this.c=c;
    }

    //setters
    public void setWidth(int i){this.width = i;}
    public void setLenght(int i){this.length = i;}

    //getters
    public int getWidth(){return this.width;}
    public int getLenght(){return this.length;}

    public void setBoundingBox(int heightBB, int widthBB){
        this.width=widthBB;
        this.length=heightBB;
    }

    public void draw(Graphics g){
        g.setColor(this.c);
        g.fillRect(this.origin.x, this.origin.y, this.width, this.length);
    }

    public double getPerimeter(){
        return (2*(this.width)+2*(this.length));
    }

    public double getSurface(){
        return ((this.width)*(this.length));
    }

    //toString
    public String toString(){
        return "Rectangle : Width="+this.width+", Lenght="+this.length+",Color :"+this.c+", Surface="+ this.getSurface()+", Perimeter="+this.getPerimeter()+", origin="+this.origin+"." ;
    }
}
