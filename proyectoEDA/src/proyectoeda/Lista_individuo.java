package proyectoeda;

public class Lista_individuo {
    String nombre;
    Nodo_rasgo lista;
    Nodo_rasgo primero;
    Nodo_rasgo ultimo;
    String caracter;

    public Lista_individuo(){
    }
    public Lista_individuo(String nombre, String caracter){
        this.nombre=nombre;
        this.caracter = caracter;
    }

    public void agregarFrente(Rasgo n) {
        Nodo_rasgo temp = new Nodo_rasgo(n);
        if (lista == null) {
            primero = temp;
        } else {
            lista.sig = temp;
        }
        lista = temp;
        ultimo = temp;
    }

    public void agregarCima(Rasgo n) {
        Nodo_rasgo temp = new Nodo_rasgo(n);
        temp.sig = primero;
        primero = temp;
        if (lista == null) {
            lista = primero;
        }
    }

    public void imprimir() {
        Nodo_rasgo actual = primero;
        while (actual != null) {
            System.out.print(actual.rasgo.toString() + " ");
            actual = actual.sig;
        }
    }

    public int contar() {
        Nodo_rasgo actual = primero;
        int c = 0;
        while (actual != null) {
            c++;
            actual = actual.sig;
        }
        return c;
    }

    public void borrar(Rasgo n) {
        Nodo_rasgo prev = primero;
        Nodo_rasgo actual = primero.sig;
        if (primero.rasgo.toString().equals(n.toString())){
            primero = primero.sig;
        } else {
            while (actual != null) {
                if (actual.rasgo.toString().equals(n.toString())) {
                    //encontrado
                    break;
                } else {
                    prev = prev.sig;
                    actual = actual.sig;
                }
            }
            if (actual == null) {
                System.out.println("elemento no encontrado");
            } else {
                prev.sig = actual.sig;
                actual.sig = null;
            }
        }
    }
}

