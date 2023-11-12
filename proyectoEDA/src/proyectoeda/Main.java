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
        Rasgo ojos = new Ojos("Negro");
        Rasgo grupo = new TipoSangre("A");
        Rasgo predisposicion = new PredisposicionCancer("SI");
        Lista_individuo individuo1 = new Lista_individuo();
        individuo1.agregarFrente(ojos);
        individuo1.agregarFrente(grupo);
        individuo1.agregarFrente(predisposicion);
        individuo1.imprimir();
        
    }
}
