package Runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Shoot extends AnimatedThing{
    public Shoot() {
        super(-100, 0, "heros", 85,75); //ces valeurs permettent de centrer le shoot sur le BG au démarrage
        this.getSpriteSheet().setViewport(new Rectangle2D(getX(), getY(),75,75)); //je centre la fenêtre du shoot sur un endroit vide de l'image heros

    }

    public void update(long time) { // permet d'actualiser l'image animée
        if (getAttitude()==1) {
            if (getX() < 800 && getToucher() == 0) {
                getSpriteSheet().setX(getX());
                getSpriteSheet().setY(getY());
                spriteSheet.setViewport(new Rectangle2D(6 * getL(), 4.3 * getH(), getL(), getH()));
                setX(getX() + 25);
            }else if (getX()<800 && getToucher() == 1){ //permet de laisser un temps de "recharge" avant de pouvoir encore utiliser la munitiion
                setX(getX()+25);
                getSpriteSheet().setX(-300);
                setY(0);
                getSpriteSheet().setY(getY());
            }else{
                //A la fin du mouvement on fait "disparaître" la balle
                setX(-300);
                getSpriteSheet().setX(getX());
                setY(0);
                getSpriteSheet().setY(getY());
                setAttitude(0);
                setMunitions(1);
                GameScene.setBalles(GameScene.getBalles()+1);
                setToucher(0);
            }
        }

    }


    //Getters
    @Override
    public ImageView getSpriteSheet() {
        return this.spriteSheet;
    }


}
