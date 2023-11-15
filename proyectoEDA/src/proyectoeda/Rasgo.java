package proyectoeda;

public abstract class Rasgo {
    protected String rasgo;

    public Rasgo(String rasgo) {
        this.rasgo = rasgo;
    }

    @Override
    public abstract String toString();
    public abstract String cadenaRasgo();
}
