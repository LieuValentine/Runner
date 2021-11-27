package Runner;

import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.util.ArrayList;

public abstract class AnimatedThing {

    //Attributs
    private double l;
    private double h;
    private double x;
    private double y;
    public ImageView spriteSheet;
    private int pv=5; //point de vie
    private int munitions = 1; // indique si la balle en question est disponible
    private int score = 0; //score du joueur : pour gagner il faut atteindre 100 pts
    private int score_victoire = 999; //score pour gagner le jeu (<1000)


    private int attitude = 0; //0 = run, 1 = run and shoot, 2 = jump, 3 = jump and shoot, 4 = fly, 5 = fly and shoot
    private int index=0;
    private double duration = 20;
    private int indexmax = 5;
    private double offset = 30;
    private int fly = 0; //1 = le héros vole , 0 = le héros vole pas
    private int index_fly =0; //on le crée pour pouvoir shooter en lévitation tout en conservant l'index pour finir le saut quand on appuie sur DOWN
    private int index_JS = 0; //indique l'index de jump and Shoot pour pouvoir effectuer tout le saut
    private int toucher = 0; // vaut 1 si une balle a touché un ennemi et 0 sinon
    private int foe_touche = 0; //vaut 1 si le héros à déjà été touché par l'ennemi


    //constructeur
    public AnimatedThing(double x, double y, String filename, double l, double h) {
        this.l=l;
        this.h=h;
        this.x=x;
        this.y=y;

        Image thisSpringSheet = new Image("/Images/"+filename+".png"); // Attribue à Image l'image animée (notre Hero)
        this.spriteSheet=new ImageView(thisSpringSheet); // création de l'image à voir
        this.spriteSheet.setX(x);
        this.spriteSheet.setY(y);
        spriteSheet.setViewport( new Rectangle2D(x,y,l,h)); // Rectangle2D crée un cadre 2D sur spritesheet, partant de (v,v1) et longueur v3 et de hauteur v4
    }
    //Méthode



    //Setter
    public void setX(double x) {this.x = x;}
    public void setY(double y) {this.y = y;}
    public void setIndex(int index) {this.index = index;}
    public void setAttitude(int attitude){this.attitude = attitude;}
    public void setIndexmax(int indexmax){this.indexmax = indexmax;}
    public void setFly(int fly){this.fly = fly;}
    public void setIndex_fly(int index_fly){this.index_fly= index_fly;}
    public void setIndex_JS(int index_JS){this.index_JS=index_JS;}
    public void setPv(int pv){this.pv=pv;}
    public void setMunitions(int munitions){this.munitions = munitions;}
    public void setScore(int score){this.score = score;}
    public void setToucher(int toucher){this.toucher = toucher;}
    public void setFoe_touche(int foe_touche){this.foe_touche = foe_touche;}

    //Getter
    public double getX() {return x;}
    public double getY() {return y;}
    public int getIndex() {return index;}
    public int getAttitude(){return attitude;}
    public int getIndexmax(){return indexmax;}
    public double getL(){return l;}
    public double getH(){return h;}
    public int getFly(){return fly;}
    public int getIndex_fly(){return index_fly;}
    public int getIndex_JS(){return index_JS;}
    public int getPv(){return pv;}
    public int getMunitions(){return this.munitions;}
    public int getScore(){return this.score;}
    public int getToucher(){return this.toucher;}
    public int getFoe_touche(){return this.foe_touche;}
    public int getScore_victoire(){return this.score_victoire;}



    //les abstract
    public abstract ImageView getSpriteSheet();
    abstract public void update(long time);

}