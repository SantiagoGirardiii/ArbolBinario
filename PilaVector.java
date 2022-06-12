import java.util.Vector;

public class PilaVector {
    private static final int INICIAL = 19;
    private int cima;
    private Vector listaPila;

    public PilaVector() {
        cima = -1;
        listaPila = new Vector(INICIAL);
    }

    public void insertar(Object elemento) throws Exception {
        cima++;
        listaPila.addElement(elemento);
    }

    public Object quitar() throws Exception {
        Object aux;
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        aux = listaPila.elementAt(cima);
        listaPila.removeElementAt(cima);
        cima--;
        return aux;
    }

    public Object cimaPila() throws Exception {
        if (pilaVacia()) {
            throw new Exception("Pila vacía, no se puede extraer.");
        }
        return listaPila.elementAt(cima);
    }

    public boolean pilaVacia() {
        return cima == -1;
    }

    public void limpiarPila() throws Exception {
        while (!pilaVacia())
            quitar();
    }

    public static void preorden(Nodo r) {
        if (r != null) {
            r.visitar();
            preorden(r.subarbolIzdo());
            preorden(r.subarbolDcho());
        }
    }

    public static void inorden(Nodo r){
        if (r != null){
            inorden (r.subarbolIzdo());
            r.visitar();
            inorden (r.subarbolDcho());
	    }
    }
    
    public static void postorden(Nodo r){
        if (r != null){
            postorden (r.subarbolIzdo());
            postorden (r.subarbolDcho());
            r.visitar();
	    }
    }
}
