package proyectoeda;

public class TipoSangre extends Rasgo {

    public TipoSangre(String rasgo) {
        super(rasgo);
    }

    @Override
    public String toString() {
        return "Tipo de sangre: " + rasgo;
    }
}
