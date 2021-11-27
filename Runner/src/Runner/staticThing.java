package Runner;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class staticThing {
    private double x;
    private double y;
    private ImageView imageview;
    private int etat = 1; //indique si le coeur est encore utilisable : 1 = utilisable, 0 = déjà utilisé / indique si calcifer  a été tué : 0 = mort, 1 = vivant


    public staticThing(double x, double y, String fileName){
        Image image = new Image("/Images/"+fileName+".png"); // Image récupère l'image d'adresse : "/Images/"+fileName+".png"
        this.imageview = new ImageView(image); // On crée une image à voir
        this.imageview.setX(x); // On définit le x à imageview (pour pouvoir le modifier)
        this.imageview.setY(y); //On définit le y à imageview (pour pouvoir le modifier)
        this.x=x;
        this.y=y;
    }

    // Getters
    public ImageView getImageView(){return this.imageview;}
    public double getX() {return this.x;}
    public double getY(){return this.y;}
    public int getEtat(){return this.etat;}



    // Setters
    public void setX(double x) {this.x=x;}
    public void setY(double y) {this.y=y;}
    public void setEtat(int etat){this.etat = etat;}



}