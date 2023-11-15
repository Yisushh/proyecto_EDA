//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package proyectoeda;

public class Pila_generacion {
    private Nodo_poblacion cima;
    public String nombre;

    public int n=0;

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
        for (Nodo_poblacion actual = this.cima; actual != null; actual = actual.sig) {
            System.out.println(this.cima.poblacion.nombre + "[ ");
            actual.poblacion.imprimir();
            System.out.println(" ]");
        }

        System.out.println();
    }
    public int contarNodos() {
        int contador = 0;
        Nodo_poblacion actual = cima;

        while (actual != null) {
            contador++;
            actual = actual.sig;
        }

        return contador;
    }
    public Pila_generacion copiarPila(Pila_generacion origen) {
        Pila_generacion nuevaPila = new Pila_generacion();
        Pila_generacion pilaTemporal = new Pila_generacion();

        // Copiar elementos de la pila de origen a la pila temporal y la nueva pila
        while (!origen.estaVacia()) {
            Cola_poblacion elemento = origen.desapilar();
            pilaTemporal.apilar(elemento);
            nuevaPila.apilar(elemento);
        }

        // Restaurar la pila de origen desde la pila temporal
        while (!pilaTemporal.estaVacia()) {
            origen.apilar(pilaTemporal.desapilar());
        }

        return nuevaPila;
    }

    // -----Generar Hijo
    public Lista_individuo generarHijo(Lista_individuo padre1, Lista_individuo padre2) {
        // Array de Rasgos de los padres
        Rasgo[] ojosPadre = new Rasgo[2];
        Rasgo[] sangrePadre = new Rasgo[2];
        Rasgo[] predPadre = new Rasgo[2];
        ojosPadre[0] = padre1.primero.rasgo;
        ojosPadre[1] = padre2.primero.rasgo;
        sangrePadre[0] = padre1.primero.sig.rasgo;
        sangrePadre[1] = padre2.primero.sig.rasgo;
        predPadre[0] = padre1.ultimo.rasgo;
        predPadre[1] = padre2.ultimo.rasgo;
        // Lista hijo para asignar los rasgos de los padres
        Lista_individuo hijo = new Lista_individuo(padre1.nombre + padre2.nombre, "test");
        // Logica para Rasgos de los hijos
        // Si hay rasgo dominante
        if (padre1.caracter == "dominante" && padre2.caracter != "dominante") {
            Nodo_rasgo actual = padre1.primero;
            while (actual != null) {
                hijo.agregarFrente(actual.rasgo);
                actual = actual.sig;
            }
        } else if (padre2.caracter == "dominante" && padre1.caracter != "dominante") {
            Nodo_rasgo actual = padre2.primero;
            while (actual != null) {
                hijo.agregarFrente(actual.rasgo);
                actual = actual.sig;
            }
        }
        // Si codominante
        else if (padre1.caracter == "dominante" && padre2.caracter == "dominante") {
            int ranHeredar = (int) (Math.random() * 2 );
            String ojosP1 = ojosPadre[0].cadenaRasgo();
            String ojosP2 = ojosPadre[1].cadenaRasgo();
            String sangreP1 = sangrePadre[0].cadenaRasgo();
            String sangreP2 = sangrePadre[1].cadenaRasgo();
            Rasgo ojosHijo = new Ojos(ojosP1+"+"+ojosP2);
            Rasgo sangreHijo = new TipoSangre(sangreP1+sangreP2);
            hijo.agregarFrente(ojosHijo);
            hijo.agregarFrente(sangreHijo);
            hijo.agregarFrente(predPadre[ranHeredar]);
        }

        // Si ninguno dominante
        else if (padre1.caracter != "dominante" && padre2.caracter != "dominante") {
            int cont = 0;
            Nodo_rasgo actual1 = padre1.primero;
            Nodo_rasgo actual2 = padre2.primero;
            while (actual1 != null && actual2 != null) {
                int ranHeredar = (int) (Math.random() * 2);
                if (actual1 == actual2) {
                    hijo.agregarFrente(actual1.rasgo);
                    cont++;
                } else if (cont == 0) {
                    hijo.agregarFrente(ojosPadre[ranHeredar]);
                    cont++;
                } else if (cont == 1) {
                    hijo.agregarFrente(sangrePadre[ranHeredar]);
                    cont++;
                } else if (cont == 2) {
                    hijo.agregarFrente(predPadre[ranHeredar]);
                    cont++;
                }
                actual1 = actual1.sig;
                actual2 = actual2.sig;
            }
        }

        // ESTO VA EN OTRO LUGAR (CREO)
        //cola.encolar(hijo);
        //Logica supervivencia
        int muerte = (int)(Math.random()*10+1);
        //Sobreviven los padres
        if (padre1.supervivencia >= muerte){
            padre1.supervivencia = padre1.supervivencia - 2;
            // Se genera un hijo nuevo desde aca?
            //generarHijo(padre1, padre2);
        } else {
            //Mueren los padres
            //cola.decolar();
            //cola.decolar();
        }
        return hijo;

    }

    public Cola_poblacion reproducirPoblacion(Lista_individuo padre1, Lista_individuo padre2) {
        Pila_generacion pilaTemp = this.copiarPila(this);
        Cola_poblacion nuevaPoblacion = pilaTemp.cima.poblacion.copiarCola(this.cima.poblacion);
        Lista_individuo hijo = generarHijo(padre1, padre2);
        // Encolar el hijo
        nuevaPoblacion.encolar(hijo);
        // Logica de supervivencia
        // Random para la supervivencia
        // int probSupervivencia = (int)(Math.random()*10+1);
        // if (probSupervivencia < 8) {
        // Se registra la generacion en la pila

        // Nueva reproduccion
        // generarHijo() + nuevoindice de supervivencia
        // } else {
        // Se borra de la cola los dos elementos del frente
        // cola.decolar();
        // cola.decolar();
        // }
        return nuevaPoblacion;
    }

    public void crearGeneracion() {
        Pila_generacion pilaTemp = this.copiarPila(this);
        Cola_poblacion temp = pilaTemp.cima.poblacion.copiarCola(this.cima.poblacion);
        //Cola_poblacion temp = pilaTemp.cima.poblacion;
        Lista_individuo padre1 = temp.decolar();
        Lista_individuo padre2 = temp.decolar();
        Cola_poblacion generacion = reproducirPoblacion(padre1, padre2);
        this.apilar(generacion);
        //generacion.nombre = "G"+String.valueOf(this.contarNodos());
        n++;
        generacion.nombre = "G"+String.valueOf(this.n);
        generacion.frente.individuo.supervivencia -= 20;
    }
    public void crearGeneraciones(int n){
        for(int i=0;i<n;i++){
            this.crearGeneracion();
        }
    }
}