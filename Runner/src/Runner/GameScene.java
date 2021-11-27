package Runner;
import javafx.animation.AnimationTimer;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.util.ArrayList; // import the ArrayList class
//https://www.w3schools.com/java/java_arraylist.asp pour savoir comment utiliser Arraylist


public class GameScene extends Scene {

    //Attributs
    private Camera camera;
    private static staticThing leftBG;
    private static staticThing rightBG;
    private static staticThing gameover; //fenêtre de game over
    private static staticThing indication; //fenêtre d'indication
    private Hero hero;
    private Foe foe;
    private int slow=0;
    private ArrayList<Foe> Foes;
    private Calcifer calcifer;
    private Shoot shoot1;
    private Shoot2 shoot2;
    private static staticThing heart1;
    private static staticThing heart2;
    private static staticThing heart3;
    private static staticThing heart4;
    private static staticThing heart5;
    private ArrayList<staticThing> Hearts;
    private static int indicateurHeart = 1; //Indique si on a encore des coeur à perdre (pour éviter les erreurs dans le update des staticThings)
    private static staticThing balle1;
    private static staticThing balle2;
    private static int balles = 2 ; //indique combien de balles il reste (donc combien d'affichage de gun il faut mettre)

    //score
    private static ArrayList<staticThing> Centaines;
    private static ArrayList<staticThing> Dizaines;
    private static ArrayList<staticThing> Unites;
    private static int score_centaine = 0;
    private static int score_dizaine = 0;
    private static int score_unite = 0;
    private static staticThing score;
    //Unites
    private static staticThing numero0;
    private static staticThing numero1;
    private static staticThing numero2;
    private static staticThing numero3;
    private static staticThing numero4;
    private static staticThing numero5;
    private static staticThing numero6;
    private static staticThing numero7;
    private static staticThing numero8;
    private static staticThing numero9;
    //Dizaines
    private static staticThing numero00;
    private static staticThing numero11;
    private static staticThing numero22;
    private static staticThing numero33;
    private static staticThing numero44;
    private static staticThing numero55;
    private static staticThing numero66;
    private static staticThing numero77;
    private static staticThing numero88;
    private static staticThing numero99;
    //Centaines
    private static staticThing numero000;
    private static staticThing numero111;
    private static staticThing numero222;
    private static staticThing numero333;
    private static staticThing numero444;
    private static staticThing numero555;
    private static staticThing numero666;
    private static staticThing numero777;
    private static staticThing numero888;
    private static staticThing numero999;

    //Les différentes fenêtres
    private static int changement_fenetre = 1; // 1 = on est sur la fenêtre d'explication et si on appuie sur A, on lance le jeu
                                                // 0 = On est sur le fenêtre de jeu et ça fait rien si on appuie sur A
                                                // 2 = on a perdue toutes les vies donc on est sur la fenêtre de Game Over


    //Constructeur
    public GameScene(Parent parent, double width, double height, boolean depthBuffer) {
        super(parent, width, height, depthBuffer);

        this.heart1 = new staticThing(550,40,"heart");
        this.heart2 = new staticThing(510,40,"heart");
        this.heart3 = new staticThing(470,40,"heart");
        this.heart4 = new staticThing(430,40,"heart");
        this.heart5 = new staticThing(390,40,"heart");
        this.Hearts = new ArrayList<staticThing>();
        this.calcifer = new Calcifer();
        Hearts.add(heart1);
        Hearts.add(heart2);
        Hearts.add(heart3);
        Hearts.add(heart4);
        Hearts.add(heart5);
        this.balle1 = new staticThing(40,45,"balle");
        this.balle2 = new staticThing(55,45,"balle");
        this.leftBG= new staticThing(0,0,"desert"); //création du BackGround de gauche
        this.rightBG= new staticThing(800,0,"desert"); //création du BackGround de droite (desert a une largeur de x=1600, on prend donc 800 par côté)
        this.gameover = new staticThing(0,0,"GameOver");
        this.indication = new staticThing(0,0,"Indication" );
        //Score
        this.Centaines = new ArrayList<staticThing>();
        this.Dizaines = new ArrayList<staticThing>();
        this.Unites = new ArrayList<staticThing>();
        this.score = new staticThing(180,40,"score");
        this.numero000 = new staticThing(290, 50,"0");
        Centaines.add(numero000);
        this.numero00 = new staticThing(310, 50,"0");
        Dizaines.add(numero00);
        this.numero0 = new staticThing(330, 50,"0");
        Unites.add(numero0);
        this.numero111 = new staticThing(290, 50,"1");
        Centaines.add(numero111);
        this.numero11 = new staticThing(310, 50,"1");
        Dizaines.add(numero11);
        this.numero1= new staticThing(330, 50,"1");
        Unites.add(numero1);
        this.numero222 = new staticThing(290, 50,"2");
        Centaines.add(numero222);
        this.numero22 = new staticThing(310, 50,"2");
        Dizaines.add(numero22);
        this.numero2 = new staticThing(330, 50,"2");
        Unites.add(numero2);
        this.numero333 = new staticThing(290, 50,"3");
        Centaines.add(numero333);
        this.numero33 = new staticThing(310, 50,"3");
        Dizaines.add(numero33);
        this.numero3 = new staticThing(330, 50,"3");
        Unites.add(numero3);
        this.numero444 = new staticThing(290, 50,"4");
        Centaines.add(numero444);
        this.numero44 = new staticThing(310, 50,"4");
        Dizaines.add(numero44);
        this.numero4 = new staticThing(330, 50,"4");
        Unites.add(numero4);
        this.numero555 = new staticThing(290, 50,"5");
        Centaines.add(numero555);
        this.numero55 = new staticThing(310, 50,"5");
        Dizaines.add(numero55);
        this.numero5 = new staticThing(330, 50,"5");
        Unites.add(numero5);
        this.numero666 = new staticThing(290, 50,"6");
        Centaines.add(numero666);
        this.numero66 = new staticThing(310, 50,"6");
        Dizaines.add(numero66);
        this.numero6 = new staticThing(330, 50,"6");
        Unites.add(numero6);
        this.numero777 = new staticThing(290, 50,"7");
        Centaines.add(numero777);
        this.numero77 = new staticThing(310, 50,"7");
        Dizaines.add(numero77);
        this.numero7 = new staticThing(330, 50,"7");
        Unites.add(numero7);
        this.numero888 = new staticThing(290, 50,"8");
        Centaines.add(numero888);
        this.numero88 = new staticThing(310, 50,"8");
        Dizaines.add(numero88);
        this.numero8 = new staticThing(330, 50,"8");
        Unites.add(numero8);
        this.numero999 = new staticThing(290, 50,"9");
        Centaines.add(numero999);
        this.numero99 = new staticThing(310, 50,"9");
        Dizaines.add(numero99);
        this.numero9 = new staticThing(330, 50,"9");
        Unites.add(numero9);



        this.hero = new Hero();  // création d'un Hero
        this.shoot1 = new Shoot(); //création d'une balle
        this.shoot2 = new Shoot2(); //création de la 2e balle
        //les ennemis
        this.foe = new Foe(0); //Création d'un ennemi
       // this.Foes = new ArrayList<Foe>(); // Create an ArrayList object of Foe
       // Foes.add(foe); //ajout d'un ennemi dans le tableau



        Camera camera = new Camera(); // Création d'une caméra


        AnimationTimer timer= new AnimationTimer(){ //création d'un Timer qui actualise les affichages
            @Override
            public void handle(long time){

                slow+=1; // Slow permet de ralentir la course du joueur
                if (slow%5==0) { //On divise la vitesse de défilement par 5 (si on veut ralentir les mouvements du héros, on met un chiffre plus grand que 5)
                    hero.update(time); // actualise la position du héros
                    shoot1.update(time);
                    shoot2.update(time);
                    foe.update(time); //Actualise la position de l'ennemi
                    calcifer.update(time); //Actualise la position de Calcifer
                    camera.update(time); // actualise la position de la caméra, mais ça semble useless à notre niveau
                    GameScene.update(time); // actualise le BG (on appelle une méthode static ici d'où la méthode appelée via le nom de la classe)
                    slow=0;

                    //UpdatePoint();
                    Rectangle2D R_hero = new Rectangle2D(hero.getX(), hero.getY(), hero.getL(), hero.getH());
                    Rectangle2D R_foe = new Rectangle2D(foe.getX(), foe.getY(), foe.getL(), foe.getH());
                    Rectangle2D R_shoot1 = new Rectangle2D(shoot1.getX(), shoot1.getY(), shoot1.getL(), shoot1.getH());
                    Rectangle2D R_shoot2 = new Rectangle2D(shoot2.getX(), shoot2.getY(), shoot2.getL(), shoot2.getH());
                    Rectangle2D R_calcifer = new Rectangle2D(calcifer.getX(),calcifer.getY(), 30,33);
                    if(R_hero.intersects(R_foe) && foe.getFoe_touche()==0){ //shoot sur foe
                        hero.setPv(hero.getPv()-1);
                        if(hero.getPv()>-1){
                            Hearts.get(hero.getPv()).setEtat(0);
                        }
                        foe.setFoe_touche(1);
                        if (changement_fenetre ==0){
                            System.out.println("Moins une vie !");
                        }
                        hero.setPrevious_attitude(hero.getAttitude());
                        hero.setAttitude(6);
                        if (hero.getPv()==0) {
                            if (changement_fenetre ==0){
                                System.out.println("Game Over !");
                                changement_fenetre = 2;
                                stop();

                            }
                        }
                        if(hero.getPv()==-1){
                            indicateurHeart=0;
                        }
                    }

                    if(R_hero.intersects(R_calcifer) && calcifer.getCalcifer_toucher()==0){ //shoot sur calcifer
                        hero.setPv(hero.getPv()-1);
                        if(hero.getPv()>-1){
                            Hearts.get(hero.getPv()).setEtat(0);
                        }
                        calcifer.setCalcifer_toucher(1);
                        if (changement_fenetre ==0){
                            System.out.println("Moins une vie !");
                        }
                        hero.setPrevious_attitude(hero.getAttitude());
                        hero.setAttitude(6);
                        if (hero.getPv()==0) {
                            if (changement_fenetre ==0){
                                System.out.println("Game Over !");
                                changement_fenetre = 2;
                                stop();
                            }

                        }
                        if(hero.getPv()==-1){
                            indicateurHeart=0;
                        }
                    }

                   if(R_shoot1.contains(foe.getX(),foe.getY()) || R_shoot2.contains(foe.getX(),foe.getY())) { //Si foe a été touché
                       foe.setPv(0);
                       if (hero.getScore()<990){
                           hero.setScore(hero.getScore()+10);
                           if (changement_fenetre ==0){
                               System.out.println("+10 !");
                           }

                       }else{
                           hero.setScore(999);
                           if (changement_fenetre ==0){
                               System.out.println("Trop fort !");
                           }

                       }
                       score_centaine = (int) hero.getScore()/100 ; //avoir le chiffre des centaines
                       score_dizaine = (int) (hero.getScore() - score_centaine*100)/10 ; //avoir le chiffre des dizaines
                       score_unite = (int) (hero.getScore() -score_centaine*100 - score_dizaine*10); //avoir le chiffre des unités

                       if(R_shoot1.contains(foe.getX(),foe.getY())){
                           shoot1.setToucher(1);
                       }else{
                           shoot2.setToucher(1);
                       }
                   }

                    if(R_shoot1.contains(calcifer.getX(),calcifer.getY()) || R_shoot2.contains(calcifer.getX(),calcifer.getY())) { //Si calcifer a été touché
                        calcifer.setEtat(0);
                        if (hero.getScore()<990){
                            hero.setScore(hero.getScore()+10);
                            if (changement_fenetre ==0){
                                System.out.println("+10 !");
                            }

                        }else{
                            hero.setScore(999);
                            if (changement_fenetre ==0){
                                System.out.println("Trop fort !");
                            }

                        }
                        score_centaine = (int) hero.getScore()/100 ; //avoir le chiffre des centaines
                        score_dizaine = (int) (hero.getScore() - score_centaine*100)/10 ; //avoir le chiffre des dizaines
                        score_unite = (int) (hero.getScore() -score_centaine*100 - score_dizaine*10); //avoir le chiffre des unités

                        if(R_shoot1.contains(calcifer.getX(),calcifer.getY())){
                            shoot1.setToucher(1);
                        }else{
                            shoot2.setToucher(1);
                        }
                    }

                }
                }
        };
        timer.start(); // Lancement du Timer

    }


    public static void update(long time){ // actualise le BG
        double x1= leftBG.getX();
        double x2= rightBG.getX();

        int a = 8; // a>0, plus a est grand et plus le BG défile rapidement
        if(x1<2*a){ //prendre x<2a au lieu de 0 permet d'éviter un freeze de l'écran lors du changement de background
            //on affiche le back ground du début (pour créer une boucle avec le rightBG qui est alors à gauche du leftBG)
            leftBG.getImageView().setX(800);
            leftBG.setX(800);
            rightBG.getImageView().setX(0);
            rightBG.setX(0);
        }
        else{ // On défile background vers l'arrière
            leftBG.getImageView().setX(x1-a); //On modifie le x associé à l'image dans le background de gauche
            leftBG.setX( (x1 - a)); // On modifie la x associé au background de gauche qui est modifié. ligne 61 on aura x1=x1-6
            rightBG.getImageView().setX(x2-a); // " " gauche-->droite
            rightBG.setX((x2-a));


        }
        if (indicateurHeart==1){
            if (heart1.getEtat()==0){
                heart1.getImageView().setX(-300); //On fait disparaître le coeur de l'écran
            }
            if (heart2.getEtat()==0){
                heart2.getImageView().setX(-300);
            }
            if (heart3.getEtat()==0){
                heart3.getImageView().setX(-300);
            }
            if (heart4.getEtat()==0){
                heart4.getImageView().setX(-300);
            }
            if (heart5.getEtat()==0){
                heart5.getImageView().setX(-300);
            }
        }
        //pour les balles
        if(balles==2){
            balle1.getImageView().setX(balle1.getX()); //On fait apparaître la munition
            balle2.getImageView().setX(balle2.getX()); //On fait apparaître la munition
        }else if(balles ==1){
            balle1.getImageView().setX(balle1.getX()); //On fait apparaître la munition
            balle2.getImageView().setX(-300); //On fait dispparaître la munition
        }else if(balles==0){
            balle1.getImageView().setX(-300); //On fait dispparaître la munition
            balle2.getImageView().setX(-300); //On fait dispparaître la munition
        }

        //Le score
        int ku=0;
        int kd=0;
        int kc=0;
        for(ku = 0; ku<10 ; ku++){
            if (ku==score_unite){
                Unites.get(ku).getImageView().setX(330);
            }else{
                Unites.get(ku).getImageView().setX(-330);
            }
        }
        for(kd = 0; kd<10 ; kd++){
            if (kd==score_dizaine){
                Dizaines.get(kd).getImageView().setX(310);
            }else{
                Dizaines.get(kd).getImageView().setX(-330);
            }
        }
        for(kc = 0; kc<10 ; kc++){
            if (kc==score_centaine){
                Centaines.get(kc).getImageView().setX(290);
            }else{
                Centaines.get(kc).getImageView().setX(-330);
            }
        }



    }


    //Méthodes


    // Getters

    public Hero getHero(){return this.hero;}
    public Shoot getShoot1(){return this.shoot1;}
    public Shoot2 getShoot2(){return this.shoot2;}
    public Foe getFoe(){return this.foe;}
    public ArrayList<Foe> getFoes() {return Foes;}
    public staticThing getCalcifer(){return this.calcifer;}
    public staticThing getLeftBG(){return this.leftBG;}
    public staticThing getGameover(){ return this.gameover;}
    public staticThing getIndication(){return this.indication;}
    public staticThing getRightBG(){return this.rightBG;}
    public staticThing getHeart1(){return this.heart1;}
    public staticThing getHeart2(){return this.heart2;}
    public staticThing getHeart3(){return this.heart3;}
    public staticThing getHeart4(){return this.heart4;}
    public staticThing getHeart5(){return this.heart5;}
    public ArrayList<staticThing> getHearts(){return this.Hearts;}
    public staticThing getBalle1(){return this.balle1;}
    public staticThing getBalle2(){return this.balle2;}
    public static int getBalles(){return balles;}

    //Score
    public ArrayList<staticThing> getCentaines(){return Centaines;}
    public ArrayList<staticThing> getDizaines(){return Dizaines;}
    public ArrayList<staticThing> getUnites(){return Unites;}
    public staticThing getScore(){return this.score;}
    //Unites
    public staticThing getNumero0(){return this.numero0;}
    public staticThing getNumero1(){return this.numero1;}
    public staticThing getNumero2(){return this.numero2;}
    public staticThing getNumero3(){return this.numero3;}
    public staticThing getNumero4(){return this.numero4;}
    public staticThing getNumero5(){return this.numero5;}
    public staticThing getNumero6(){return this.numero6;}
    public staticThing getNumero7(){return this.numero7;}
    public staticThing getNumero8(){return this.numero8;}
    public staticThing getNumero9(){return this.numero9;}
    //Dizaines
    public staticThing getNumero00(){return this.numero00;}
    public staticThing getNumero11(){return this.numero11;}
    public staticThing getNumero22(){return this.numero22;}
    public staticThing getNumero33(){return this.numero33;}
    public staticThing getNumero44(){return this.numero44;}
    public staticThing getNumero55(){return this.numero55;}
    public staticThing getNumero66(){return this.numero66;}
    public staticThing getNumero77(){return this.numero77;}
    public staticThing getNumero88(){return this.numero88;}
    public staticThing getNumero99(){return this.numero99;}
    //Centaines
    public staticThing getNumero000(){return this.numero000;}
    public staticThing getNumero111(){return this.numero111;}
    public staticThing getNumero222(){return this.numero222;}
    public staticThing getNumero333(){return this.numero333;}
    public staticThing getNumero444(){return this.numero444;}
    public staticThing getNumero555(){return this.numero555;}
    public staticThing getNumero666(){return this.numero666;}
    public staticThing getNumero777(){return this.numero777;}
    public staticThing getNumero888(){return this.numero888;}
    public staticThing getNumero999(){return this.numero999;}
    //changement de fenetre
    public static int getChangement_fenetre(){return changement_fenetre;}



    //setters
    public static void setBalles(int b){balles = b;}
    public static void setChangement_fenetre(int a){changement_fenetre = a;}
    public void setScore_centaine(int score_centaine){this.score_centaine = score_centaine;}
    public void setScore_dizaine(int score_dizaine){this.score_dizaine = score_dizaine;}
    public void setScore_unite(int score_unite){this.score_unite = score_unite;}
    public static void setIndicateurHeart(int a){indicateurHeart = a;}

}
