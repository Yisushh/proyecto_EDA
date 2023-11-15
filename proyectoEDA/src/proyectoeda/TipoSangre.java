package proyectoeda;

public class TipoSangre extends Rasgo {

    public TipoSangre(String rasgo) {
        super(rasgo);
    }
    public String cadenaRasgo(){
        return rasgo;
    }
    @Override
    public String toString() {
        return "Tipo de sangre: " + rasgo;
    }
}
