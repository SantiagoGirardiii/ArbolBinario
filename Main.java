import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        ArbolBinario arbol;
        Nodo a1 = null, a2 = null, a = null;
        int opcion;
        int dato = 0;
        Scanner sc = new Scanner(System.in);
        PilaVector pila = new PilaVector();
        do {
            System.out.println("ingrese 1 para agregar nodos");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("ingrese dni a guardar o 0 para terminar");
                        dato = sc.nextInt();
                        a = ArbolBinario.nuevoArbol(a1, dato, a2);
                        dato = sc.nextInt();
                        if (dato == 0) {
                            a2 = ArbolBinario.nuevoArbol(null, null, null);
                            a1 = ArbolBinario.nuevoArbol(null, null, null);
                            try {
                                pila.insertar(a);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        } else {
                            a2 = ArbolBinario.nuevoArbol(null, dato, null);
                            dato = sc.nextInt();
                            a1 = ArbolBinario.nuevoArbol(null, dato, null);
                            try {
                                pila.insertar(a);
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                            arbol = new ArbolBinario(a);
                        }
                    } while (dato != 0);
                case 2:
                    try {
                        pila.quitar();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    pila.preorden(a);
            }
        } while (opcion != 0);
    }
}
