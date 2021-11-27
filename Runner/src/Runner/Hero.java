package Runner;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;

public class Hero extends AnimatedThing {
    static int indique_clignotement = 0; // pour faire clignoter : 0 = il disparaît, 1 = il réapparaît
    static int index_clignotement =0; //pour conserver le mouvement pendant qu'on clignote
    static int indique_position = 0; //pour Fly !
    private static int previous_attitude ; //juste pour éviter un bug sur le clignotement


    public Hero() {
        super(100, 245, "heros", 85,100); //ces valeurs permettent de centrer le héros sur le BG
        this.getSpriteSheet().setViewport(new Rectangle2D(getX(),getY(),75,100)); //dimensions données par le sujet
        super.setPv(5); //le héros à 5 vies
    }


    //Méthodes
    public void update(long time) { // permet d'actualiser l'image animée

        //Clignoter (après s'être fait toucher par un ennemi)
        if (getAttitude()==6){
            setIndexmax(3);
            if(index_clignotement==getIndexmax()){
                index_clignotement=0;
                setAttitude(previous_attitude);
            }else{
                if (indique_clignotement==0){
                    spriteSheet.setViewport(new Rectangle2D( -300, 0, 1, 1));
                    index_clignotement= index_clignotement+1;
                    indique_clignotement =1;
                }else{
                    spriteSheet.setViewport(new Rectangle2D( getIndex() * getL(), 0, getL(), getH()));
                    index_clignotement= index_clignotement+1;
                    indique_clignotement =0;
                }
            }

        }

        //Fly and Shoot !
        if (getAttitude()==5){
            setIndexmax(3);
            if(getIndex_fly()==getIndexmax()){
                setIndex_fly(0);
                setAttitude(4); //On retourne à l'état de lévitation
            }else{
                if (getIndex_fly()==0 || getIndex_fly()==1){
                    spriteSheet.setViewport(new Rectangle2D( 0, 4.9*getH(), getL(), getH()));
                    setIndex_fly(getIndex_fly()+1);
                }else{
                    spriteSheet.setViewport(new Rectangle2D( getL(), 4.9*getH(), getL(), getH()));
                    setIndex_fly(getIndex_fly()+1);
                }

            }
        }
        //Fly !
        if (getAttitude()==4){
            double effet_levitation = 1.5 ;
            if (getFly()==1){
                if (indique_position ==0){
                    getSpriteSheet().setY(getY()+effet_levitation);
                    indique_position = 1;
                }
                if (indique_position ==1) {
                    getSpriteSheet().setY(getY() + 2*effet_levitation);
                    indique_position = 2;
                }
                if (indique_position ==2) {
                    getSpriteSheet().setY(getY() + effet_levitation);
                    indique_position = 3;
                }
                if (indique_position ==3) {
                    getSpriteSheet().setY(getY() - effet_levitation);
                    indique_position = 4;
                }else{
                    getSpriteSheet().setY(getY());
                    indique_position = 0;
                }
                spriteSheet.setViewport(new Rectangle2D( 0, 1.6*getH(), getL(), getH()));
            }else{
                setAttitude(2); //on retourne au mouvement du saut
            }
        }

        //Jump and shoot !
        if (getAttitude() == 3) {
            setIndexmax(14);
            int newindex3 = getIndex();
            if (getIndex_JS() == 3) {
                setAttitude(2);
            }else if (newindex3 == getIndexmax()){
                setIndex(0);
                setAttitude(0);
            }
            else{
                setIndex(newindex3 +1);
            }
            getSpriteSheet().setX(100); //Pour modifier la position du héros sur le BG (ca ne sert à rien de juste changer la valeur de x par le setX car one n'agit pas sur la fenêtre)
            if (newindex3 == 0 || newindex3 == 14){
                getSpriteSheet().setY(245);
                setY(245);
            }else if(newindex3 == 1 || newindex3 == 13){
                getSpriteSheet().setY(190);
                setY(190);
            }else if(newindex3 == 2 || newindex3 == 12){
                getSpriteSheet().setY(160);
                setY(160);
            }else if(newindex3 == 3 || newindex3 == 11){
                getSpriteSheet().setY(140);
                setY(140);
            }else if(newindex3 == 4 || newindex3 == 10){
                getSpriteSheet().setY(120);
                setY(120);
            }else if(newindex3 == 5 || newindex3 == 9){
                getSpriteSheet().setY(100);
                setY(100);
            }else if(newindex3 == 6 || newindex3 == 8){
                getSpriteSheet().setY(80);
                setY(80);
            }else if(newindex3==7){
                getSpriteSheet().setY(60);
                setY(60);
            }
            if(newindex3 == 0 || newindex3 == 1 || newindex3 == 2 || newindex3 == 3 || newindex3 ==4|| newindex3 == 5 || newindex3 == 6 || newindex3 ==7){
                spriteSheet.setViewport(new Rectangle2D(0, 4.9*getH(), getL(), getH())); // On affiche la nouvelle position du Hero à chaque appel de update (on bouge l'image sur la fenêtre)
            }else if(newindex3 == 8 || newindex3 == 9 || newindex3 == 10|| newindex3 == 11 || newindex3 ==12|| newindex3 == 13 || newindex3 == 14){
                spriteSheet.setViewport(new Rectangle2D( getL(), 4.9*getH(), getL(), getH())); // On affiche la nouvelle position du Hero à chaque appel de update
            }
            setIndex_JS(getIndex_JS()+1);
        }

        //Jump !
        if (getAttitude() == 2) {
            setIndexmax(14);
            int newindex2 = getIndex(); //Index permet de pointer les 6 positions différentes de notre Hero
            if (newindex2 == getIndexmax()) {
                setIndex(0);
                setAttitude(0);
            }
            else{
                setIndex(newindex2 +1);
            }
            getSpriteSheet().setX(100); //Pour modifier la position du héros sur le BG (ca ne sert à rien de juste changer la valeur de x par le setX car one n'agit pas sur la fenêtre)
            if (newindex2 == 0 || newindex2 == 14){
                getSpriteSheet().setY(245);
                setY(245);
            }else if(newindex2 == 1 || newindex2 == 13){
                getSpriteSheet().setY(190);
                setY(190);
            }else if(newindex2 == 2 || newindex2 == 12){
                getSpriteSheet().setY(160);
                setY(160);
            }else if(newindex2 == 3 || newindex2 == 11){
                getSpriteSheet().setY(140);
                setY(140);
            }else if(newindex2 == 4 || newindex2 == 10){
                getSpriteSheet().setY(120);
                setY(120);
            }else if(newindex2 == 5 || newindex2 == 9){
                getSpriteSheet().setY(100);
                setY(100);
            }else if(newindex2 == 6 || newindex2 == 8){
                getSpriteSheet().setY(80);
                setY(80);
            }else if(newindex2==7){
                getSpriteSheet().setY(60);
                setY(60);
            }
            if(newindex2 == 0 || newindex2 == 1 || newindex2 == 2 || newindex2 == 3 || newindex2 ==4|| newindex2 == 5 || newindex2 == 6 || newindex2 ==7){
                spriteSheet.setViewport(new Rectangle2D(0, 1.6*getH(), getL(), getH())); // On affiche la nouvelle position du Hero à chaque appel de update (on bouge l'image sur la fenêtre)
            }else if(newindex2 == 8 || newindex2 == 9 || newindex2 == 10|| newindex2 == 11 || newindex2 ==12|| newindex2 == 13 || newindex2 == 14){
                spriteSheet.setViewport(new Rectangle2D( getL(), 1.6*getH(), getL(), getH())); // On affiche la nouvelle position du Hero à chaque appel de update
            }
        }


        //Run and Shoot !
        if (getAttitude()==1){
            setIndexmax(5);
            int newindex1 = (getIndex()); //Index permet de pointer les 6 positions différentes de notre Hero
            if (newindex1 == getIndexmax()) {
                setAttitude(0);
            }else{
                setIndex(newindex1 + 1);
            }
            setX(100);
            setY(245);
            spriteSheet.setViewport(new Rectangle2D(getIndex() * getL(), 3.3*getH(), getL()-7, getH())); //le 3.3*getH() - 7 c'est parce que dans l'une des images on voit le pied de la position suivante. Donc on réduit la largeur de la fenêtre
        }

        //Run !
        if(getAttitude()==0){
            setIndexmax(5);
            int newindex = getIndex(); //Index permet de pointer les 6 positions différentes de notre Hero
            if (newindex == getIndexmax()) {
                setIndex(0);
            } else {
                setIndex(newindex + 1);
            }
            setX(100);
            setY(245);
            spriteSheet.setViewport(new Rectangle2D(getIndex() * getL(), 0, getL(), getH())); // On affiche la nouvelle position du Hero à chaque appel de update (on bouge l'image)
        }

    }


    //Setters
    public void setPrevious_attitude(int pa){this.previous_attitude=pa;}

    //Getters
    @Override
    public ImageView getSpriteSheet() {
        return this.spriteSheet;
    }

    public int getPrevious_attitude(){return this.previous_attitude;}

}