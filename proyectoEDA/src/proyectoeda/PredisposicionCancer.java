package proyectoeda;

public class PredisposicionCancer extends Rasgo {

    public PredisposicionCancer(String rasgo) {
        super(rasgo);
    }

    @Override
    public String toString() {
        return "Predisposición a tener cancer: " + rasgo;
    }
}