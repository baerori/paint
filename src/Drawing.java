import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/*
* How to use arraylists : https://www.w3schools.com/java/java_arraylist.asp
* How to use Serialisation https://www.baeldung.com/java-serialization

*/

public class Drawing extends JPanel implements MouseMotionListener, MouseListener  {
    protected Color c;
    protected static ArrayList<Figure> list = new ArrayList<Figure>();
    protected String nameFigure;
    protected int x;
    protected int y;

    public Drawing(){
        this.setBackground(Color.white);
        this.addMouseListener(this);      //Interactions with the mouse
        this.setColor(Color.black);         //initialisation of the drawing's parameters
        this.setNameFigure("Ellipse");
        //Rectangle rect1 = new Rectangle(100, 100, Color.blue);
        //rect1.this(this.getGraphics());
    }



    //setters
    public void setColor(Color c) {
        this.c = c;
    }
    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }

    //autres fonctions non implémentées encore
    public void getList(){};
    public void mouseClicked(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){

    }
    public void mousePressed(MouseEvent e){
        x = e.getX();
        y = e.getY();
        //création de la bonne figure
        switch (nameFigure){
            case "Square":
                Square s = new Square();
                s.origin.x=x;
                s.origin.y=y;
                s.c=this.c;
                list.add(s);
                break;
            case "Circle":
                Circle c = new Circle();
                c.origin.x=x;
                c.origin.y=y;
                c.c=this.c;
                list.add(c);
                break;
            case "Rectangle":
                Rectangle r = new Rectangle();
                r.origin.x=x;
                r.origin.y=y;
                r.c=this.c;
                list.add(r);
                break;
            case "Ellipse":
                Ellipse el = new Ellipse();
                el.origin.x=x;
                el.origin.y=y;
                el.c=this.c;
                list.add(el);
        }
        System.out.println("A1 : Nb="+list.size()+", "+list); /////////////////////////////////////////DEBUG
    }
    public void mouseReleased(MouseEvent e){
        x = e.getX();
        y = e.getY();
        switch (nameFigure){
            case "Square":
                list.get(list.size()-1).setBoundingBox(Math.max(Math.abs(list.get(list.size()-1).origin.getX()-x), Math.abs(list.get(list.size()-1).origin.getY()-y)),Math.max(Math.abs(list.get(list.size()-1).origin.getX()-x), Math.abs(list.get(list.size()-1).origin.getY()-y)));
                //récupérer la plus grande variation sur un axe
                break;
            case "Circle":
                list.get(list.size()-1).setBoundingBox(Math.max(Math.abs(list.get(list.size()-1).origin.getX()-x), Math.abs(list.get(list.size()-1).origin.getY()-y)),Math.max(Math.abs(list.get(list.size()-1).origin.getX()-x), Math.abs(list.get(list.size()-1).origin.getY()-y)));
                break;
            case "Rectangle":
                list.get(list.size()-1).setBoundingBox(Math.abs(list.get(list.size()-1).origin.getY()-y),Math.abs(list.get(list.size()-1).origin.getX()-x));
                break;
            case "Ellipse":
                list.get(list.size()-1).setBoundingBox(Math.abs((list.get(list.size()-1).origin.getX()-x)), Math.abs(list.get(list.size()-1).origin.getY()-y));
        }
        list.get(list.size()-1).draw(this.getGraphics());
        System.out.println("A2 : Nb="+list.size()+", "+list); /////////////////////////////////////////DEBUG
    }


    public void paintComponent(){}
    public void recallDrawing(){}


    //overrindings
    @Override
    public void mouseDragged(MouseEvent e) {

        System.out.println("Mouse Dragged: " + e.getX() + " , " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // TODO Auto-generated method stub
        System.out.println("Mouse Moved: " + e.getX() + " , " + e.getY());

    }

    public void saveFigures() throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("yourfile.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        for(Figure f : this.list){
            objectOutputStream.writeObject(this.list);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public void openFile() throws IOException, ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream("yourfile.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        this.list  = (ArrayList<Figure>) objectInputStream.readObject();
        objectInputStream.close();

        for(Figure f : this.list){
            f.draw(this.getGraphics());
        }

    }

}