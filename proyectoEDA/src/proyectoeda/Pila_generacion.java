//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package proyectoeda;

public class Pila_generacion {
    private Nodo_poblacion cima;
    public String nombre;

    public Pila_generacion() {
        this.cima = null;
    }

    public Pila_generacion(String nombre) {
        this.nombre = nombre;
        this.cima = null;
    }

    public boolean estaVacia() {
        return this.cima == null;
    }

    public void apilar(Cola_poblacion elemento) {
        Nodo_poblacion nuevoNodo = new Nodo_poblacion(elemento);
        nuevoNodo.sig = this.cima;
        this.cima = nuevoNodo;
    }

    public Cola_poblacion desapilar() {
        if (this.estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        } else {
            Cola_poblacion elementoDesapilado = this.cima.poblacion;
            this.cima = this.cima.sig;
            return elementoDesapilado;
        }
    }

    public Cola_poblacion cima() {
        if (this.estaVacia()) {
            throw new IllegalStateException("La pila está vacía");
        } else {
            return this.cima.poblacion;
        }
    }

    public void imprimirPila() {
        for(Nodo_poblacion actual = this.cima; actual != null; actual = actual.sig) {
            System.out.println(this.nombre + "[ ");
            actual.poblacion.imprimir();
            System.out.println(" ]");
        }

        System.out.println();
    }
}
