package Runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Foe extends AnimatedThing{
    private Random rand = new Random(); //pour pouvoir utiliser les fonctions de random
    private final int maxvitesse = 20;
    private int vitesse = rand.nextInt(maxvitesse) + 5; //la vitesse de l'ennemi varie donc de 5 à 25

    //Constructeur
    public Foe(int a) {
        super(500-a, 275, "foe", 74,40); //ces valeurs permettent de centrer l'ennemi sur le BG au démarrage
        //h change la hauteur de la fenêtre de l'ennemi vers le bas
        this.getSpriteSheet().setViewport(new Rectangle2D(getX(),getY(),75,100));
        super.setPv(1);
    }

    //Methode
    public void update(long time) { // permet d'actualiser l'image animée

        setIndexmax(7);
        double foe_x;
        if (getX()<-80 || getPv()==0){
            setPv(1);
            setFoe_touche(0);
            foe_x=650;
            this.vitesse = rand.nextInt(maxvitesse) + 10;
        }else {
            foe_x = getX() - vitesse; //augmenter vitesse augmente la vitesse de l'ennemi
        }
        int newindex = getIndex(); //Index permet de pointer les 6 positions différentes de notre Hero
        if (newindex == getIndexmax()) {
            setIndex(0);

        } else {
            setIndex(newindex + 1);
        }
        if(newindex == 6){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(10, 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 0
        }else if(newindex == 5){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(getL(), 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 1
        }else if(newindex == 4){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(1.85*getL(), 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 2
        }else if(newindex == 3){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(2.6*getL(), 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 3
        }else if(newindex == 2){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(3.3*getL(), 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 4
        }else if(newindex == 1){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(4.2*getL(), 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 5
        }else if(newindex == 0){
            getSpriteSheet().setX(foe_x);
            spriteSheet.setViewport(new Rectangle2D(5.1*getL(), 30, 0.8*getL(), 2*getH())); //Centrer correctement la position d'index 6
        }
        setX(foe_x); //il faut modifier la valeur de X car getSpriteSheet().setX() modifie juste le rendu sur l'image mais pas la valeur de X

    }

    //Getters
    @Override
    public ImageView getSpriteSheet() {
        return this.spriteSheet;
    }

}
