import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/*
* How to use arraylists : https://www.w3schools.com/java/java_arraylist.asp
* How to use Serialisation https://www.baeldung.com/java-serialization
* File chooser JAVA : https://mkyong.com/swing/java-swing-jfilechooser-example/

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
        this.addMouseMotionListener(this);
        this.setColor(Color.black);         //initialisation of the drawing's parameters
        this.setNameFigure("Ellipse");
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
        switch (this.nameFigure){
            case "Square":
                list.get(list.size()-1).setBoundingBox(x-list.get(list.size()-1).origin.getX(), y-list.get(list.size()-1).origin.getY());
                //Square : choosing the biggest variation on one axis for setting the edge
                break;
            case "Circle":
                list.get(list.size()-1).setBoundingBox(x-list.get(list.size()-1).origin.getX(),y-list.get(list.size()-1).origin.getY());
                break;
            case "Rectangle":
                list.get(list.size()-1).setBoundingBox(y-list.get(list.size()-1).origin.getY(),x-list.get(list.size()-1).origin.getX());
                break;
            case "Ellipse":
                list.get(list.size()-1).setBoundingBox((x-list.get(list.size()-1).origin.getX()), y-list.get(list.size()-1).origin.getY());
        }
        paintComponent(this.getGraphics());
        System.out.println("A2 : Nb="+list.size()+", "+list); /////////////////////////////////////////DEBUG
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g); // to clear the drawing
        for(Figure f : this.list){
            f.draw(g);
        }
    }
    public void recallDrawing(){}

    //overrindings
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        switch (this.nameFigure){
            case "Square":
                list.get(list.size()-1).setBoundingBox(x-list.get(list.size()-1).origin.getX(), y-list.get(list.size()-1).origin.getY());
                //Square : choosing the biggest variation on one axis for setting the edge
                break;
            case "Circle":
                list.get(list.size()-1).setBoundingBox(x-list.get(list.size()-1).origin.getX(),y-list.get(list.size()-1).origin.getY());
                break;
            case "Rectangle":
                list.get(list.size()-1).setBoundingBox(y-list.get(list.size()-1).origin.getY(),x-list.get(list.size()-1).origin.getX());
                break;
            case "Ellipse":
                list.get(list.size()-1).setBoundingBox((x-list.get(list.size()-1).origin.getX()), y-list.get(list.size()-1).origin.getY());
        }
        paintComponent(this.getGraphics());
    }

    public void mouseMoved(MouseEvent e) {//System.out.println("Mouse Moved: " + e.getX() + " , " + e.getY());
    }

    public void saveFigures() throws IOException, ClassNotFoundException {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Choose a file to save the drawing : ");
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int returnValue = jfc.showSaveDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            if (jfc.getSelectedFile().isFile()) {
                System.out.println("You selected the directory: " + jfc.getSelectedFile());
                FileOutputStream fileOutputStream = new FileOutputStream(jfc.getSelectedFile());
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                for(Figure f : this.list){
                    objectOutputStream.writeObject(this.list);
                }
                objectOutputStream.flush();
                objectOutputStream.close();
            }
        }
    }

    public void openFile() throws IOException, ClassNotFoundException {

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

        int returnValue = jfc.showOpenDialog(null);
        // int returnValue = jfc.showSaveDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jfc.getSelectedFile();
            //System.out.println(selectedFile.getAbsolutePath());
            //JFIleChooser and BufferedImage
            FileInputStream fileInputStream = new FileInputStream(selectedFile.getAbsolutePath());
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        this.list  = (ArrayList<Figure>) objectInputStream.readObject();
        objectInputStream.close();
        paintComponent(this.getGraphics());
        System.out.print(this.list.size());
        }
    }

}