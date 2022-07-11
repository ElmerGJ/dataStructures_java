import java.util.InputMismatchException;

public class MyStack extends TestingDataStructure{


    // ATRIBUTOS DE ESTRUCTURA ----------------------------------------------------------------------------------------------
    private final String[] values;
    private final int max;
    private int top;


    // CONSTRUCTOR -----------------------------------------------------------------------------------------------------
    public MyStack(int max){
        values = new String[max];
        this.max = max;
        top = -1;
    }


    // METODOS DE LA ESTRUCTURA "PILA" ---------------------------------------------------------------------------------

    //Inserta un valor en la cabeza de la pila
    private void push(){
        System.out.println("\n\t\t--> Insertando...");
        String value = input(false);

        if (isFull()){
            fullStack();
        }
        else {
            System.out.println("\n\t\t--> Elemento " + value + " insertado");
            values[++top] = value;
        }
    }


    // Remueve un elemento desde la cabeza de la pila
    private void pop(){

        if (isEmpty()){
            emptyStack();
        }
        else {
            System.out.println("\n\t\t--> Elemento " + values[top] + " removido");
            values[top] = null;
            top--;
        }
    }


    // Devuelve el valor de la cabeza de la pila
    private void peek(){

        if (!isEmpty())
            System.out.println("\n\t\t--> Elemento en la cima: " + values[top]);
        else
            emptyStack();
    }


    // Muestra los elementos de la pila
    private void showElements(){
        if (isEmpty()) {
            emptyStack();
        }
        else{
            System.out.println("\n\t\t--> Mostrando elementos de la Pila");
            for (int i = (size(false) - 1); i > -1; i--) {
                System.out.print("\n\t\t[" + values[i] + "] ");
            }
            System.out.println("\n\n");
        }
    }


    // Devuelve la cantidad actual de valores en la pila
    private int size(boolean printSize){
        if (printSize)
            System.out.println("\n\t\t--> Tama\u00F1o de la pila: " + (top + 1));
        return top +1;
    }


    // Comprueba si la pila esta llena
    private boolean isFull(){
        return top == max - 1;
    }


    // Comprueba si la pila esta vacía
    private boolean isEmpty(){
        return  top == -1;
    }


    // Imprime "Pila Vacia"
    public void emptyStack(){
        System.out.println("\n\t\t--> Pila Vacia\n");
    }


    // Imprime "Pila Llena"
    private void fullStack() {
        System.out.println("\n\t\t--> Pila Llena\n");
    }




    // METODO QUE PRUEBA LA ESTRUCTURA ---------------------------------------------------------------------------------
    public static void testMyStack(MyStack stack){

        System.out.println("\n\n\n\t\t\t >>> Utilizando Pilas <<<");
        String options = """
                
                
                \t\t1. Insertar
                \t\t2. Extraer
                
                \t\t3. Visualizar
                
                \t\t4. Cima
                \t\t5. Tama\u00F1o
                
                \t\t6. Salir""";

        boolean exit = false;
        do{
            System.out.println(options);
            try{
                switch (Integer.parseInt(input(false))) {
                    case 1 -> stack.push();
                    case 2 -> stack.pop();
                    case 3 -> stack.showElements();
                    case 4 -> stack.peek();
                    case 5 -> stack.size(true);
                    case 6 -> exit = true;
                    default -> warningMessage();
                }
            } catch (InputMismatchException | NumberFormatException ignored) {
                errorInputMessage();
            }
        }while (!exit);
    }

}
