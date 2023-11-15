package proyectoeda;

public class Ojos extends Rasgo {

    public Ojos(String rasgo) {
        super(rasgo);
    }
    public String cadenaRasgo(){
        return this.rasgo;
    }
    @Override
    public String toString() {
        return "Color de ojos: " + this.rasgo;
    }
}
