package Runner;

import javafx.geometry.Rectangle2D;

import java.util.Random;


public class Calcifer extends staticThing{

    private Random rand = new Random(); //pour pouvoir utiliser les fonctions de random
    private final int maxvitesse = 20;
    private int vitesse = rand.nextInt(maxvitesse) + 5; //la vitesse de l'ennemi varie donc de 5 à 25
    private int hauteur = rand.nextInt(1); //on met la hauteur de calcifer à 0=100 et 1= 150
    private int index = 0;
    private int indexmax = 10 ;
    private int calcifer_toucher = 0; //vaut 1 si le héros a déjà été touché par calcifer

    //Constructeur
    public Calcifer() {
        super(600,100,"calcifer");
    }

    //Méthode
    public void update(long time){
            double calcifer_x;
            if (getX()<-80 || getEtat()==0){
                setEtat(1);
                calcifer_toucher = 0;
                calcifer_x=600;
                vitesse = rand.nextInt(maxvitesse) + 5;
                hauteur = rand.nextInt(1);
            }else {
                calcifer_x = getX() - vitesse; //augmenter vitesse augmente la vitesse de l'ennemi
            }
            int newindex = index;
            if (newindex == indexmax) {
                index=0;
            } else {
                index = newindex+1;
            }
            if (hauteur==0){
                setY(100);
                if (newindex ==0 || newindex == 5){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(100);
                    setY(100);
                }else if (newindex == 1 || newindex == 4){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(92);
                    setY(92);
                }else if (newindex == 2 || newindex ==3){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(85);
                    setY(85);
                }else if (newindex == 6 || newindex == 9){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(108);
                    setY(108);
                }else if (newindex==7 || newindex == 8){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(115);
                    setY(115);
                }
            }else if(hauteur ==1){
                setY(180);
                if (newindex ==0 || newindex == 5){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(180);
                    setY(180);
                }else if (newindex == 1 || newindex == 4){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(172);
                    setY(172);
                }else if (newindex == 2 || newindex ==3){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(165);
                    setY(165);
                }else if (newindex == 6 || newindex == 9){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(188);
                    setY(188);
                }else if (newindex==7 || newindex == 8){
                    getImageView().setX(calcifer_x);
                    getImageView().setY(195);
                    setY(195);
                }
            }
            setX(calcifer_x); //il faut modifier la valeur de X car getSpriteSheet().setX() modifie juste le rendu sur l'image mais pas la valeur de X

    }



    //getters
    public int getCalcifer_toucher(){return this.calcifer_toucher;}

    //setters
    public void setCalcifer_toucher(int calcifer_toucher){this.calcifer_toucher = calcifer_toucher;}

}
