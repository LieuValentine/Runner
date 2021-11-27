package Runner;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Shoot2 extends AnimatedThing{ //Comme on utilise la même image, on est obligé de créer une autre classe (identique à Shoot) pour afficher les 2 balles en même temps

    public Shoot2() {
        super(-100, 0, "heros", 85,75); //ces valeurs permettent de centrer le shoot sur le BG au démarrage
        this.getSpriteSheet().setViewport(new Rectangle2D(getX(), getY(),75,75)); //je centre la fenêtre du shoot sur un endroit vide de l'image heros

    }

    public void update(long time) { // permet d'actualiser l'image animée
        if (getAttitude()==1){
            if(getX()<800 && getToucher()==0){
                getSpriteSheet().setX(getX());
                getSpriteSheet().setY(getY());
                spriteSheet.setViewport(new Rectangle2D( 6*getL(), 4.3*getH(), getL(), getH()));
                setX(getX()+25);
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


