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
            System.out.println("ingrese 1 para agregar nodos, 2 para eliminar, 3 para recorrer , 0 para salir");
            opcion = sc.nextInt();
            sc.nextLine();
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
                        if(contador < 2){ 
                        System.out.println("ingese 0 para salir  o 1 para continuar");
                        dato = sc.nextInt();
                        }
                        }
                        while (dato != 0 && contador < 2);
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
                    try {
                        pila.quitar();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                break;
                case 3: 
                    System.out.println("Ingrese 1 para recorrer en preorden, 2 para inorden, 3 para postorden");
                    
                    int opcion2 = 0;
                    opcion2 = sc.nextInt();
                    switch(opcion2){
                        case 1:
                            pila.preorden(a);
                        break;
                        case 2:
                            pila.inorden(a);
                        break;
                        case 3:
                            pila.postorden(a);
                        break;
                    }
            }
        } while (opcion != 0);
    }
}
