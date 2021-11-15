import java.io.Serializable;
import java.awt.*;

/*
Answering the 4.2 question :
	method is visible only within the class and its subclasses when using protected
 */

public abstract class Figure implements Serializable{
    protected Color c;
    protected Point origin = new Point();

    public void Figure(){}
    public void Figure(Color col, Point p){}

    public abstract void setBoundingBox(int heightBB, int widthBB);
    public abstract void draw(Graphics g);
    public abstract double getPerimeter();
    public abstract double getSurface();
    public abstract String toString();
}
