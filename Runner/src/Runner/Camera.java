package Runner;

public class Camera {
    //Attributs
    private double x;
    private double y;

    //Constructeurs
    public Camera(){
        this.x=0;
        this.y=0;
    }
    public Camera(double x, double y){
        this.x=x;
        this.y=y;
    }

    //Méthodes
    public void update(long time){


    }

    @Override
    public String toString() {
        return "( "+this.x+" , "+this.y+" )" ;
    }
}