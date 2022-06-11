import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        ArbolBinario arbol;
        Nodo a1 = null, a2 = null, a = null; 
        int contador = 0 ;
        int opcion;
        int dni = 0;
        int dato = 0;
        Scanner sc = new Scanner(System.in);
        PilaVector pila = new PilaVector();
        do {
            System.out.println("ingrese 1 para agregar nodos, 2 para eliminar");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        System.out.println("ingrese dni nodo isquierdo");
                        dni = sc.nextInt();
                        a1 = ArbolBinario.nuevoArbol(null,dni,null);
                        System.out.println("ingrese dni nodo derecho");
                        dni = sc.nextInt();
                        a2 = ArbolBinario.nuevoArbol(null,dni,null);
                        System.out.println("ingrese dni raiz del sub arbol ");
                        dni = sc.nextInt();
                        contador = contador + 1;
                        a = ArbolBinario.nuevoArbol(a1,dni,a2);
                        try {
                            pila.insertar(a);
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                        System.out.println("ingese 0 para salir  o 1 para continuar");
                        dato = sc.nextInt();
                        }
                        while (dato != 0);
                        if ( contador != 1  ){
                            try {
                                a2 = (Nodo) pila.quitar();
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            try {
                                a1 = (Nodo) pila.quitar();
                            } catch (Exception e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                            System.out.println("ingrese dni raiz del arbol ");
                            dni = sc.nextInt();
                            a = ArbolBinario.nuevoArbol(a1,dni,a2);
                            arbol = new ArbolBinario(a);
                         }
                     break;
                case 2:
                    pila.preorden(a);
            }
        } while (opcion != 0);
    }
}
