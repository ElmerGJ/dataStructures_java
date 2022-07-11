import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestingDataStructure {


    // METODOS UTILIZADOS EN TODAS LAS CLASES --------------------------------------------------------------------------
    // ** Estaticos para ser utilizados desde el main y de cualquier clase **

    // Permite ingresar un valor por teclado y devolverlo como entero para acceder a los menus
    public static String input(boolean mainMenu){
        Scanner input = new Scanner(System.in);
        if (mainMenu)
            System.out.print(">> ");
        else
            System.out.print("\t\t>> ");

        return input.next();
    }


    // Muestra un mensaje de advertencia si la opcion ingresada, "entero devuelto del metodo enterOption()", no esta en lista
    public static void warningMessage() {
        JOptionPane.showConfirmDialog(null, "Ingrese una opcion enlistada!", "ADVERTENCIA", JOptionPane.DEFAULT_OPTION,  JOptionPane.WARNING_MESSAGE);
    }



    // Muestra un mensaje de error si la opcion ingresada no es un número,
    public static void errorInputMessage() {
        JOptionPane.showConfirmDialog(null, "Entrada Invalida!", "ERROR", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
    }




    // METODO PRINCIPAL, DESDE AQUI SE EJECUTA EL PROGRAMA COMPLETO ----------------------------------------------------
    public static void main(String[] args) {

        MyStack stack = new MyStack(50);
        MyQueue queue = new MyQueue(50);
        MyBinaryTree tree = new MyBinaryTree();
        MyLinkedList linkedList = new MyLinkedList();

        System.out.println("\n\n\t\t\tE S T R U C T U R A S   D E   D A T O S");

        System.out.println("\nProbemos estas Estructuras Dinamicas");

        String options = """
                
                
                1. PILAS
                2. COLAS
                3. ARBOLES BINARIOS
                4. LISTAS ENLAZADAS
                5. SALIR""";

        boolean exit = false;
        do{
            System.out.println(options);
            try{
                switch (Integer.parseInt(input(true))) {
                    case 1 -> {
                        MyStack.testMyStack(stack);
                    }
                    case 2 -> {
                        MyQueue.testMyQueue(queue);
                    }
                    case 3 -> {
                        MyBinaryTree.testMyBinaryTree(tree);
                    }
                    case 4 -> {
                        MyLinkedList.testMyLinkedList(linkedList);
                    }
                    case 5 -> {
                        exit = true;
                    }
                    default -> warningMessage();
                }
            }catch (InputMismatchException | NumberFormatException ignored){
                errorInputMessage();
            }
        }while (!exit);
    }
}
