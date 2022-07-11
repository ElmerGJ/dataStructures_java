import java.util.InputMismatchException;

public class MyLinkedList extends TestingDataStructure{

    // ATRIBUTOS DE LISTA ENLAZADA -------------------------------------------------------------------------------------
    private int size = 0;
    private Node head;
    private Node last;

    // CLASE NODO ------------------------------------------------------------------------------------------------------
    static class Node{

        // ATRIBUTOS DE NODO
        String data;
        Node next;

        // CONSTRUCTOR DEL NODO
        public Node(String data){
            this.data = data;
            this.next = null;
        }
    }


    // METODOS DE LISTA ENLAZADA ---------------------------------------------------------------------------------------

    // Agrega un Nodo a la lista (Predeterminado al final)
    public void addNode(){
        addLast();
    }


    // Agrega un nuevo Nodo al inicio de la Lista
    public void addFirst(){
        System.out.println("\n\t\t--> Introduciendo...");
        String data = input(false);
        System.out.println("\n\t\tElemento " + data + " introducido");

        Node newNode = new Node(data);

        if (isEmpty())
            last = newNode;
        else{
            newNode.next = head;
        }
        head = newNode;
        size++;
    }


    // Agrega un nuevo Nodo al final de la Lista
    public void addLast(){
        System.out.println("\n\t\t--> Introduciendo...");
        String data = input(false);
        System.out.println("\n\t\tElemento " + data + " introducido");

        Node newNode = new Node(data);

        newNode.next = null;

        if (isEmpty())
            head = newNode;
        else
            last.next = newNode;

        last = newNode;
        size++;
    }


    // Elimina el primer nodo
    public void delFirst(){
        System.out.println("\n\t\tElemento "  + head.data + " eliminado");

        if (isEmpty()){
            listEmpty();
        }
        else {
            if (head != last)
                head = head.next;
            else
                head = last = null;
        }

        size--;
    }


    // Elimina el último nodo
    public void delLast(){
        System.out.println("\n\t\tElemento " + last.data + " eliminado");

        if (isEmpty()){
            listEmpty();
        }
        else {
            if (head != last){
                Node temp = head;
                while (temp.next != last){
                    temp = temp.next;
                }
                last = temp;
                last.next = null;
            }
            else
                head = last = null;
        }

        size--;
    }


    // Elimina el primer nodo que contenga el valor ingresado (key value)
    public void delKey(String key){
        //EN DESARROLLO
    }


    // Elimina el nodo según el índice ingresado
    public void delAt(int index){
        //EN DESARROLLO
    }


    // Devuelve el último Nodo
    public void getLast(){
        if (last == null)
            listEmpty();
        else
            System.out.println("\n\t\t Ultimo Elemento " + last.data);
    }


    // Devuelve el primer Nodo
    public void getHead(){
        if (head == null)
            listEmpty();
        else
            System.out.println("\n\t\tElemento Cabeza " + head.data);
    }


    // Muestra el tamaño de la lista
    private void getSize() {
        System.out.println("\n\t\t--> Tama\u00F1o de la lista: " + size);
    }


    // Muestra los valores contenidos en los Nodos de la lista
    public void showElements(){
        Node current = head;

        if (head == null){
            listEmpty();
        }
        else {
            System.out.println("\n\t\t--> Mostrando los elementos de la Lista");
            while (current != null){
                if (current == head){
                    System.out.print("\n\t\t");
                }
                System.out.print("[" + current.data + "]" + " --> ");
                current = current.next;
            }
            System.out.print("null\n\n");
        }
    }


    // Verifica si la Lista esta vacía
    public boolean isEmpty(){
        return head == null;
    }


    // Mensaje si la lista esta vacia
    public void listEmpty(){
        System.out.println("\n\t\t--> Lista Vacia\n");;
    }


    // METODO QUE PRUEBA LA ESTRUCTURA ---------------------------------------------------------------------------------
    public static void testMyLinkedList(MyLinkedList linkedList){

        System.out.println("\n\n\n\t\t >>> Utilizando Listas Enlazadas <<<");
        String options = """
                
                
                \t\t1. Introducir elemento
                \t\t2. Introducir al principio
                
                \t\t3. Eliminar elemento
                \t\t4. Eliminar al principio
                
                \t\t5. Recorrer lista
                
                \t\t6. Elemento cabeza
                \t\t7. Ultimo elemento
                \t\t8. Tama\u00F1o
                                
                \t\t9. Salir""";

        boolean exit = false;
        do {
            System.out.println(options);
            try{
                switch (Integer.parseInt(input(false))){
                    case 1 -> linkedList.addNode();
                    case 2 -> linkedList.addFirst();
                    case 3 -> linkedList.delLast();
                    case 4 -> linkedList.delFirst();
                    case 5 -> linkedList.showElements();
                    case 6 -> linkedList.getHead();
                    case 7 -> linkedList.getLast();
                    case 8 -> linkedList.getSize();
                    case 9 -> exit = true;
                    default -> warningMessage();
                }
            } catch (InputMismatchException | NumberFormatException ignore) {
                errorInputMessage();
            }
        }while (!exit);
    }
}
