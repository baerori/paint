import javax.swing.*;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.Serializable;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
Docs/forums utilisés
* Javadoc of course
* Pour les clics de souris https://stackoverflow.com/questions/9421574/how-to-use-java-mouseevent-data , https://docs.oracle.com/javase/7/docs/api/java/awt/event/MouseEvent.html
* Pour les dessins des figures : https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics.html
 */

public class Window extends JFrame implements ActionListener{

    protected Drawing draw = new Drawing();
    public void actionPerformed(ActionEvent e){
        String cmd=e.getActionCommand();
        switch (cmd){
            case "Black":
                draw.setColor(Color.black);
                break;
            case "Blue":
                draw.setColor(Color.blue);
                break;
            case "Red":
                draw.setColor(Color.red);
                break;
            case "Green":
                draw.setColor(Color.green);
                break;
            case "Yellow":
                draw.setColor(Color.yellow);
                break;
            case "Pink":
                draw.setColor(Color.pink);
                break;
            case "Magenta":
                draw.setColor(Color.magenta);
                break;
            case "Orange":
                draw.setColor(Color.orange);
                break;
            case "paintPackage.Ellipse":
                draw.setNameFigure("Ellipse");
                break;
            case "paintPackage.Circle":
                draw.setNameFigure("Circle");
                break;
            case "paintPackage.Rectangle":
                draw.setNameFigure("Rectangle");
                break;
            case "paintPackage.Square":
                draw.setNameFigure("Square");
                break;
            case "Authors":
                JOptionPane info = new JOptionPane();
                info.showInternalMessageDialog( info, "Authors : Orion BAËRD, ENSEA",
                        "information",JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Save":
                System.out.print("Save!");
                try {
                    draw.saveFigures();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "Open":
                System.out.print("Open!");
                try {
                    draw.openFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                break;
            case "New":
                Window win = new Window("Paint",800,600);
                break;
            case "Quit":
        }
    }

    public Window(String Title,int x,int y){
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane() ;


        //JmenuBar
        JMenuBar m= new JMenuBar(); //déclaration de la JMenuBar

        //JMenuBar "File"
        JMenu menu1= new JMenu("File");
        JMenuItem open = new JMenuItem("Open") ;
        menu1.add(open);
        open.addActionListener(this);

        JMenuItem newi = new JMenuItem("New") ;
        menu1.add(newi);
        newi.addActionListener(this);

        JMenuItem save = new JMenuItem("Save") ;
        menu1.add(save);
        save.addActionListener(this);
        menu1.addSeparator();

        JMenuItem quit = new JMenuItem("Quit") ;
        menu1.add(quit);
        quit.addActionListener(this);
        //addition of the menu with the JMenuItems
        m.add(menu1);

        //JMenuBar "About us"
        JMenu menu2= new JMenu("About us");
        menu2.addActionListener(this);
        JMenuItem authors = new JMenuItem("Authors");
        menu2.add(authors);
        authors.addActionListener(this);
        m.add(menu2);

        setJMenuBar(m);


        //Jpanel pour les couleurs
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,2));

        JPanel pColor = new JPanel();
        pColor.setLayout(new GridLayout(2,4));

        JButton bblack = new JButton("Black");
        bblack.setBackground(Color.black);
        bblack.setForeground(Color.white);
        bblack.addActionListener(this);
        pColor.add(bblack);

        JButton bred = new JButton("Red");
        bred.setBackground(Color.red);
        pColor.add(bred);
        bred.addActionListener(this);

        JButton bgreen = new JButton("Green");
        bgreen.setBackground(Color.green);
        pColor.add(bgreen);
        bgreen.addActionListener(this);

        JButton bblue = new JButton("Blue");
        bblue.setBackground(Color.blue);
        pColor.add(bblue);
        bblue.addActionListener(this);

        JButton byellow = new JButton("Yellow");
        byellow.addActionListener(this);
        byellow.setBackground(Color.yellow);
        pColor.add(byellow);

        JButton bpink = new JButton("Pink");
        bpink.setBackground(Color.pink);
        bpink.addActionListener(this);
        pColor.add(bpink);

        JButton bmagenta = new JButton("Magenta");
        bmagenta.setBackground(Color.magenta);
        bmagenta.addActionListener(this);
        pColor.add(bmagenta);

        JButton borange = new JButton("Orange");
        borange.setBackground(Color.orange);
        borange.addActionListener(this);
        pColor.add(borange);

        southPanel.add(pColor, "West");

        contentPanel.add(southPanel,"South");

        //JPanel
        JPanel figuresPanel = new JPanel();
        figuresPanel.setLayout(new GridLayout(2,2));

        JButton Bellipse = new JButton("paintPackage.Ellipse");
        Bellipse.addActionListener(this);
        figuresPanel.add(Bellipse);

        JButton Bcircle = new JButton("paintPackage.Circle");
        Bcircle.addActionListener(this);
        figuresPanel.add(Bcircle);

        JButton BRectangle = new JButton("paintPackage.Rectangle");
        BRectangle.addActionListener(this);
        figuresPanel.add(BRectangle);

        JButton Bcarre = new JButton("paintPackage.Square");
        Bcarre.addActionListener(this);
        figuresPanel.add(Bcarre);

        southPanel.add(figuresPanel, "West");


        contentPanel.add(draw, "Center");

        this.setVisible(true);

    }


    public static void main (String args[]){}
}
