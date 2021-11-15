import java.io.Serializable;

public class Point implements Serializable{
    protected int x;
    protected int y;

    //constructeurs
    public Point(){} //pas besoin d'initialiser x et y à 0, c'est déjà les valeurs d'initialisation par défaut
    public Point(int a, int b){this.x = a; this.y=b;}

    //setters
    public void setX(int i){this.x = i;}
    public void setY(int i){this.y = i;}

    //getters
    public int getX(){return this.x;}
    public int getY(){return this.y;}

    //toString
    public String toString(){
        return "("+this.x+","+this.y+")" ;
    }
}
