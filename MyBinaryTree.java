import java.util.InputMismatchException;
import java.util.Random;

public class MyBinaryTree extends TestingDataStructure {

    // ATRIBUTOS DE ESTRUCTURA -----------------------------------------------------------------------------------------
    private Node root;




    // CLASE NODO ------------------------------------------------------------------------------------------------------

    static class Node{

        int value;
        Node left;
        Node right;

        Node(int value){
           this.value = value;
           right = null;
           left = null;
        }
    }


    // METODOS DE ARBOLES BINARIOS -------------------------------------------------------------------------------------

    // Genera un arbol aleatorio
    private void getRandomTree(){

        root = null;

        int i = 0;
        while (i < getNodesAmount()) {
            addNode(getNodeValue());
            System.out.print("\n\t\tNode " + i + ": ");
            i++;
        }
    }


    // Devuelve un valor aleatorio entre 3 y 10, utilizado para la cantidad de nodos que tendra nuestro arbol
    private int getNodesAmount(){
        Random x = new Random();
        return x.nextInt(11 - 3) + 3;
    }


    // Devuelve un valor aleatorio entre 1 y 100, utilizado el valor de los nodos que tendra nuestro arbol
    private int getNodeValue(){
        Random x = new Random();
        return x.nextInt(101 - 1) + 1;
    }


    // Insertar un nodo en el arbol, metodo recursivo
    private Node addRecursive(Node current, int value) {

        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }

        return current;
    }


    // Inicializa la recursividad desde el nodo raiz, inserta en nodo
    private void addNode(int value){
        root = addRecursive(root, value);
    }


    // Muestra los valores de los nodos en un Recorrido preOrden
    private void preOrden(Node node){
        System.out.print("\t\t");
        if (node != null) {
            System.out.print("[" + node.value + "] ");
            preOrden(node.left);
            preOrden(node.right);
        }
    }


    // Muestra los valores de los nodos en un Recorrido postOrden
    private void postOrden(Node node){
        if (node != null) {
            postOrden(node.left);
            postOrden(node.right);
            System.out.print("[" + node.value + "] ");
        }
    }


    // Muestra los valores de los nodos en un Recorrido enOrden
    private void inOrden(Node node){
        if (node != null) {
            inOrden(node.left);
            System.out.print("[" + node.value + "] ");
            inOrden(node.right);
        }
    }


    // METODO QUE PRUEBA LA ESTRUCTURA ---------------------------------------------------------------------------------
    public static void testMyBinaryTree(MyBinaryTree tree){

        System.out.println("\n\n\t\t >>> Utilizando Arboles Binarios<<<");
        String options = """
                
                
                \t\t1. Generar arbol
                
                \t\t2. Recorrido preOrden
                \t\t3. Recorrido postOrden
                \t\t4. Recorrido enOrden
                
                \t\t5. Salir""";

        boolean exit = false;
        do{
            System.out.println(options);
            try{
                switch (Integer.parseInt(input(false))) {
                    case 1 -> tree.getRandomTree();
                    case 2 -> tree.preOrden(tree.root);
                    case 3 -> tree.postOrden(tree.root);
                    case 4 -> tree.inOrden(tree.root);
                    case 5 -> exit = true;
                    default -> warningMessage();
                }
            }catch (InputMismatchException | NumberFormatException ignored) {
                errorInputMessage();
            }
        }while (!exit);
    }
}
