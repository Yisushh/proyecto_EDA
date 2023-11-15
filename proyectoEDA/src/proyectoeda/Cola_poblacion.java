package proyectoeda;

public class Cola_poblacion {

    String nombre;
    Nodo_individuo frente;
    Nodo_individuo cima;

    public Cola_poblacion() {
    }

    public Cola_poblacion(String nombre) {
        this.nombre = nombre;
    }

    public void imprimir() {
        Nodo_individuo actual = cima;
        while (actual != null) {
            System.out.print("\t↳" + actual.individuo.nombre + "( ");
            actual.individuo.imprimir();
            System.out.println(")");
            actual = actual.sig;
        }
        System.out.print("\t↳null");
        System.out.println();
    }
    public Cola_poblacion copiarCola(Cola_poblacion origen) {
        Cola_poblacion nuevaCola = new Cola_poblacion();
        Cola_poblacion colaTemporal = new Cola_poblacion();

        // Copiar elementos de la cola de origen a la cola temporal y la nueva cola
        while (!origen.estaVacia()) {
            Lista_individuo individuo = origen.decolar();
            colaTemporal.encolar(individuo);
            nuevaCola.encolar(individuo);
        }

        // Restaurar la cola de origen desde la cola temporal
        while (!colaTemporal.estaVacia()) {
            origen.encolar(colaTemporal.decolar());
        }

        return nuevaCola;
    }

    public void encolar(Lista_individuo n) {
        Nodo_individuo temp = new Nodo_individuo(n);
        if (frente == null) {
            frente = cima = temp;
        } else {
            temp.sig = cima;
            cima = temp;
        }
    }

    public boolean estaVacia() {
        if (frente == null) {
            return true;
        } else {
            return false;
        }
    }

    public Lista_individuo decolar() {
        Lista_individuo elem = null;
        if (estaVacia()) {
            System.out.println("cola vacia");
        } else {
            Nodo_individuo actual;
            actual = cima;
            // si tengo un solo elemento
            if (actual.sig == null) {
                elem = cima.individuo;
                cima = frente = null;
            } else {
                while (actual.sig != frente) {
                    actual = actual.sig;
                }
                elem = frente.individuo;
                frente = actual;
                actual.sig = null;
            }
        }
        return elem;
    }

    public void invertirCola() {
        Cola_poblacion temp = new Cola_poblacion();
        Nodo_individuo actual = cima;
        while (actual != null) {
            temp.encolar(actual.individuo);
            actual = actual.sig;
        }
        int n = this.cuentaElemPropios();
        for (int i = 0; i < n; i++) {
            this.decolar();
        }
        while (temp.estaVacia() != true) {
            this.encolar(temp.decolar());
        }
    }

    public int cuentaElem(Cola_poblacion temp) {
        int cuenta = 0;
        while (this.estaVacia() != true) {
            temp.encolar(this.decolar());
            cuenta++;
        }
        return cuenta;
    }

    public int cuentaElemPropios() {
        Cola_poblacion temp = new Cola_poblacion();
        int cuenta = 0;
        while (this.estaVacia() != true) {
            temp.encolar(this.decolar());
            cuenta++;
        }
        while (temp.estaVacia() != true) {
            this.encolar(temp.decolar());
        }
        return cuenta;
    }

    public Lista_individuo peek() {
        return frente.individuo;
    }

}
