package Runner;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;




public class Main extends Application {
    //Méthodes
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Enjoy the game !"); //Titre de la fenêtre
        Group root = new Group();
        Pane pane = new Pane(root); //fenêtre
        GameScene theScene = new GameScene(pane, 600, 400, true); //Permet de définir la fenêtre affichée : c'est la partie qui nous intéresse du BG. Sinon (1600 , 400) permet d'avoir les deux BG.
        //En fait, un BG a une largeur de 800. Pour faire défiler le fond correctement, il faut prendre une largeur <800. On choisit arbitrairement 600.

        pane.getChildren().add(theScene.getIndication().getImageView()); // ajout de l'indication
        primaryStage.setScene(theScene); //charger la scène theScene
        primaryStage.show(); //Afficher la scène




        //Lier les commande aux touches du clavier
        theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.SPACE) {
                    System.out.println("Jump!");
                    theScene.getHero().setFly(0); //pour éviter de continuer à voler lorsque l'on shoot
                    theScene.getHero().setIndex(0); //pour que le saut se fasse bien du début à la fin (mouvement complet)
                    theScene.getHero().setAttitude(2);

                }

                if (ke.getCode() == KeyCode.ENTER) {
                    if(theScene.getHero().getAttitude()!=6){ //pour éviter un bug (le héros disparaît quand je n'ai plus de balles et que je tire au moment de tomber sur l'ennemi)
                        if (theScene.getShoot1().getMunitions()==1){
                            theScene.setBalles(theScene.getBalles() - 1); //on enlève une munition de l'image
                            theScene.getShoot1().setMunitions(0);
                            System.out.println("Shoot!"); //On ne met pas l'index à 0 car on veut qu'il shoot à l'endroit où il est
                            theScene.getShoot1().setAttitude(1); //On signal un shoot à la classe shoot
                            theScene.getShoot1().setX(theScene.getHero().getX()+theScene.getHero().getL()); //la balle est tiré au niveau de la position du héros (un peu translaté pour les x)
                            theScene.getShoot1().setY(theScene.getHero().getY());
                        }else if(theScene.getShoot2().getMunitions()==1){
                            theScene.setBalles(theScene.getBalles() - 1); //on enlève une munition de l'image
                            theScene.getShoot2().setMunitions(0);
                            System.out.println("Shoot!"); //On ne met pas l'index à 0 car on veut qu'il shoot à l'endroit où il est
                            theScene.getShoot2().setAttitude(1); //On signal un shoot à la classe shoot
                            theScene.getShoot2().setX(theScene.getHero().getX()+theScene.getHero().getL()); //la balle est tiré au niveau de la position du héros (un peu translaté pour les x)
                            theScene.getShoot2().setY(theScene.getHero().getY());
                        }else{
                            System.out.println("Plus de munitions !");
                        }
                        if (theScene.getHero().getFly()==1){
                            theScene.getHero().setAttitude(5); //Fly and Shoot !
                        }else{
                            if (theScene.getHero().getAttitude()==2 ||theScene.getHero().getAttitude()==3){
                                theScene.getHero().setAttitude(3); //Jump and Shoot !
                            }else {
                                theScene.getHero().setAttitude(1); //Run and Shoot
                            }
                        }
                    }

                }
                if (ke.getCode() == KeyCode.UP) { //permet de rester en lévitation à la hauteur où l'on est au moment de l'appuie sur UP
                    System.out.println("Fly!");
                    theScene.getHero().setFly(1);
                    theScene.getHero().setAttitude(4);
                }
                if (ke.getCode() == KeyCode.DOWN) { //on arrête de voler et on termine le saut que l'on était en train d'effectuer
                    theScene.getHero().setFly(0);
                }
                if (ke.getCode() == KeyCode.A) { //On redémarre le jeu depuis le début
                    if(theScene.getChangement_fenetre()==2){
                        pane.getChildren().removeAll();
                        pane.getChildren().add(theScene.getIndication().getImageView()); // ajout de la fenetre d'indication
                        theScene.setChangement_fenetre(1);
                        primaryStage.setScene(theScene); //charger la scène theScene
                        primaryStage.show(); //Afficher la scène
                    }else if (theScene.getChangement_fenetre()==1){
                        //Reinitialisation de tous les paramètres et de la fenêtre
                        //reinitiallisation des coeurs
                        theScene.getHero().setPv(5);
                        theScene.getHeart1().setEtat(1);
                        theScene.getHeart1().setX(550);
                        theScene.getHeart1().getImageView().setX(550);
                        theScene.getHeart1().getImageView().setY(40);
                        theScene.getHeart1().setY(40);
                        theScene.getHeart2().setEtat(1);
                        theScene.getHeart2().setX(510);
                        theScene.getHeart2().getImageView().setX(510);
                        theScene.getHeart2().getImageView().setY(40);
                        theScene.getHeart2().setY(40);
                        theScene.getHeart3().setEtat(1);
                        theScene.getHeart3().setX(470);
                        theScene.getHeart3().setY(40);
                        theScene.getHeart3().getImageView().setX(470);
                        theScene.getHeart3().getImageView().setY(40);
                        theScene.getHeart4().setEtat(1);
                        theScene.getHeart4().setX(430);
                        theScene.getHeart4().setY(40);
                        theScene.getHeart4().getImageView().setX(430);
                        theScene.getHeart4().getImageView().setY(40);
                        theScene.getHeart5().setEtat(1);
                        theScene.getHeart5().setX(390);
                        theScene.getHeart5().setY(40);
                        theScene.getHeart5().getImageView().setX(390);
                        theScene.getHeart5().getImageView().setY(40);
                        theScene.setIndicateurHeart(1);
                        //réinitialisation du score
                        theScene.getHero().setScore(0);
                        theScene.setScore_centaine(0);
                        theScene.setScore_dizaine(0);
                        theScene.setScore_unite(0);

                        pane.getChildren().removeAll();
                        //Creation de la nouvelle fenêtre
                        pane.getChildren().add(theScene.getRightBG().getImageView()); // ajout du leftBG à la scène
                        pane.getChildren().add(theScene.getLeftBG().getImageView()); // ajout du rightBG à la scène
                        pane.getChildren().add(theScene.getHeart1().getImageView()); // ajout d'un coeur à la scène
                        pane.getChildren().add(theScene.getHeart2().getImageView()); // ajout d'un coeur à la scène
                        pane.getChildren().add(theScene.getHeart3().getImageView()); // ajout d'un coeur à la scène
                        pane.getChildren().add(theScene.getHeart4().getImageView()); // ajout d'un coeur à la scène
                        pane.getChildren().add(theScene.getHeart5().getImageView()); // ajout d'un coeur à la scène
                        pane.getChildren().add(theScene.getBalle1().getImageView()); // ajout d'une balle à la scène
                        pane.getChildren().add(theScene.getBalle2().getImageView()); // ajout d'une balle à la scène
                        //Score
                        pane.getChildren().add(theScene.getScore().getImageView()); // ajout d'un score à la scène
                        //Unités
                        pane.getChildren().add(theScene.getNumero0().getImageView());
                        pane.getChildren().add(theScene.getNumero1().getImageView());
                        pane.getChildren().add(theScene.getNumero2().getImageView());
                        pane.getChildren().add(theScene.getNumero3().getImageView());
                        pane.getChildren().add(theScene.getNumero4().getImageView());
                        pane.getChildren().add(theScene.getNumero5().getImageView());
                        pane.getChildren().add(theScene.getNumero6().getImageView());
                        pane.getChildren().add(theScene.getNumero7().getImageView());
                        pane.getChildren().add(theScene.getNumero8().getImageView());
                        pane.getChildren().add(theScene.getNumero9().getImageView());
                        //Dizaines
                        pane.getChildren().add(theScene.getNumero00().getImageView());
                        pane.getChildren().add(theScene.getNumero11().getImageView());
                        pane.getChildren().add(theScene.getNumero22().getImageView());
                        pane.getChildren().add(theScene.getNumero33().getImageView());
                        pane.getChildren().add(theScene.getNumero44().getImageView());
                        pane.getChildren().add(theScene.getNumero55().getImageView());
                        pane.getChildren().add(theScene.getNumero66().getImageView());
                        pane.getChildren().add(theScene.getNumero77().getImageView());
                        pane.getChildren().add(theScene.getNumero88().getImageView());
                        pane.getChildren().add(theScene.getNumero99().getImageView());
                        //Centaines
                        pane.getChildren().add(theScene.getNumero000().getImageView());
                        pane.getChildren().add(theScene.getNumero111().getImageView());
                        pane.getChildren().add(theScene.getNumero222().getImageView());
                        pane.getChildren().add(theScene.getNumero333().getImageView());
                        pane.getChildren().add(theScene.getNumero444().getImageView());
                        pane.getChildren().add(theScene.getNumero555().getImageView());
                        pane.getChildren().add(theScene.getNumero666().getImageView());
                        pane.getChildren().add(theScene.getNumero777().getImageView());
                        pane.getChildren().add(theScene.getNumero888().getImageView());
                        pane.getChildren().add(theScene.getNumero999().getImageView());
                        pane.getChildren().add(theScene.getCalcifer().getImageView());

                        pane.getChildren().add(theScene.getHero().getSpriteSheet());// ajout du héros à la scène
                        pane.getChildren().add(theScene.getFoe().getSpriteSheet());// ajout de l'ennemi à la scène
                        pane.getChildren().add(theScene.getShoot1().getSpriteSheet()); // ajout d'une balle à la scène
                        pane.getChildren().add(theScene.getShoot2().getSpriteSheet()); // ajout d'une balle à la scène

                        theScene.setChangement_fenetre(0);
                        primaryStage.setScene(theScene); //charger la scène theScene
                        primaryStage.show(); //Afficher la scène

                    }

                }


                }



        });



    }

    //Main
    public static void main(String[] args) {
        launch(args);
    }


}