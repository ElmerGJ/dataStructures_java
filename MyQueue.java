import java.util.InputMismatchException;

public class MyQueue extends TestingDataStructure{


    // ATRIBUTOS DE ESTRUCTURA ----------------------------------------------------------------------------------------------
    private final String[] values;
    private final int max;
    private int front;
    private int rear;
    private int size;


    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------
    public MyQueue(int max) {
        values = new String[max];
        this.max = max;
        front = 0;
        rear = -1;
        size = 0;
    }


    // METODOS DE LA ESTRUCTURA "PILA" ---------------------------------------------------------------------------------


    // Inserta un valor en la parte trasera de la cola
    private void enQueue(){
        System.out.println("\n\t\t--> Insertando... ");
        String value = input(false);

        if (isFull()){
            fullQueue();
        }
        else {
            System.out.println("\n\t\t--> Elemento " + value + " insertado");
            rear = (rear + 1) % max;
            values[rear] = value;
            size++;
        }
    }


    // Remueve y devuelve el valor del frente de la cola
    private void deQueue(){

        if (isEmpty()){
            emptyQueue();
        }
        else{
            System.out.println("\n\t\t--> Elemento " + values[front] + " removido");
            values[front] = null;
            front = (front + 1) % max;
            size--;
        }
    }


    // Devuelve el valor del frente de la cola
    private void peek(){

        if (!isEmpty())
            System.out.println("\n\t\t--> Elemento en la cabeza: " + values[front]);
        else
            emptyQueue();
    }


    // Devuelve el elemento del final de la cola
    private void last() {
        if (!isEmpty())
            System.out.println("\n\t\t--> Ultimo elemento: " + values[rear]);
        else
            emptyQueue();
    }


    // Muestra los elementos de la cola
    private void showElements(){
        if (isEmpty()){
            emptyQueue();
        }
        else {
            System.out.println("\n\t\t--> Mostrando elementos de la Cola");
            for (int i = front; i < rear + 1; i++) {
                if (i == front){
                    System.out.print("\n\t\t");
                }
                System.out.print("[" + values[i] + "] ");
            }
            System.out.println("\n\n");
        }
    }


    // Devuelve la cantidad actual de valores en la cola
    private int size(boolean printSize){
        if (printSize){
            System.out.println("\n\t\t--> Tama\u00F1o de la cola: " + size);
        }
        return size;
    }


    // Verifica si la cola esta vacía
    private boolean isEmpty(){
        return (size(false) == 0);
    }


    // Verifica si la cola esta llena
    private boolean isFull(){
        return (size(false) == max);
    }


    // Imprime "Cola Vacia"
    public void emptyQueue(){
        System.out.println("\n\t\t--> Cola Vacia\n");
    }


    // Imprime "Cola Llena"
    private void fullQueue() {
        System.out.println("\n\t\t--> Cola Llena\n");
    }




    // METODO QUE PRUEBA LA ESTRUCTURA ---------------------------------------------------------------------------------
    public static void testMyQueue(MyQueue queue){

        System.out.println("\n\n\n\t\t\t >>> Utilizando Colas <<<");
        String options = """


                \t\t1. Insertar
                \t\t2. Extraer
                
                \t\t3. Visualizar
                
                \t\t4. Frente
                \t\t5. Ultimo
                \t\t6. Tama\u00F1o
                
                \t\t7. Salir""";
        boolean exit = false;
        do{
            System.out.println(options);
            try{
                switch (Integer.parseInt(input(false))) {
                    case 1 -> queue.enQueue();
                    case 2 -> queue.deQueue();
                    case 3 -> queue.showElements();
                    case 4 -> queue.peek();
                    case 5 -> queue.last();
                    case 6 -> queue.size(true);
                    case 7 -> exit = true;
                    default -> warningMessage();
                }
            } catch (InputMismatchException | NumberFormatException ignored) {
                errorInputMessage();
            }
        }while (!exit);
    }
}
