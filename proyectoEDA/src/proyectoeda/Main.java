/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoeda;

/**
 *
 * @author ALEJANDRO
 */
class Main {
    public static void main(String[] args) {
        Rasgo ojos[] = {
                new Ojos("Negro"),
                new Ojos("Azul"),
                new Ojos("Verde"),
                new Ojos("Marron"),
        };
        Rasgo gruposSangre[] = {
                new TipoSangre("RH+"),
                new TipoSangre("RH-"),
                new TipoSangre("O+"),
        };
        Rasgo predisposicion[] = {
                new PredisposicionCancer("NO"),
                new PredisposicionCancer("SI")
        };
        // -------------------- Individuos
        Lista_individuo individuo1 = new Lista_individuo("A","dominante");
        individuo1.agregarFrente(ojos[0]);
        individuo1.agregarFrente(gruposSangre[0]);
        individuo1.agregarFrente(predisposicion[0]);

        Lista_individuo individuo2 = new Lista_individuo("B","recesivo");
        individuo2.agregarFrente(ojos[1]);
        individuo2.agregarFrente(gruposSangre[1]);
        individuo2.agregarFrente(predisposicion[1]);

        Lista_individuo individuo3 = new Lista_individuo("C","recesivo");
        individuo3.agregarFrente(ojos[2]);
        individuo3.agregarFrente(gruposSangre[2]);
        individuo3.agregarFrente(predisposicion[0]);

        Lista_individuo individuo4 = new Lista_individuo("D","dominante");
        individuo4.agregarFrente(ojos[3]);
        individuo4.agregarFrente(gruposSangre[2]);
        individuo4.agregarFrente(predisposicion[0]);

        Lista_individuo individuo5 = new Lista_individuo("E","");
        individuo5.agregarFrente(ojos[1]);
        individuo5.agregarFrente(gruposSangre[2]);
        individuo5.agregarFrente(predisposicion[1]);

        Lista_individuo individuos[] = {
                individuo1,
                individuo2,
                individuo3,
                individuo4,
                individuo5
        };

        // ---------------------------------

        Cola_poblacion poblacion1 = new Cola_poblacion("P1");
        for (int i = 0; i < individuos.length; i++) {
            poblacion1.encolar(individuos[i]);
        }

        System.out.println("--------");

        Pila_generacion generaciones = new Pila_generacion("G0");
        generaciones.apilar(poblacion1);
        generaciones.imprimirPila();

    }
}
