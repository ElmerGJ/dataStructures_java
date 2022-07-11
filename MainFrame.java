import javax.swing.*;
import java.util.Objects;

public class MainFrame extends JFrame {

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    JButton btn3 = new JButton();
    JButton btn4 = new JButton();
    JButton btn5 = new JButton();
    JPanel jPanel = new JPanel();

    MainFrame(){
        initComponents();
    }


    void initComponents(){
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setUndecorated(true);
        setTitle("ESTRUCTURAS DE DATOS");





        // Configuraciones del Boton 1 (PILA)
        btn1.setText("PILAS");
        btn1.setBounds(100, 175, 200, 75);


        // Configuraciones del Boton 1 (COLA)
        btn2.setText("COLAS");
        btn2.setBounds(400, 175, 200, 75);


        // Configuraciones del Boton 1 (ARBOL BINARIO)
        btn3.setText("ARBOLES BINARIOS");
        btn3.setBounds(100, 325, 200, 75);


        // Configuraciones del Boton 1 (LISTA ENLAZADA)
        btn4.setText("LISTAS ENLAZADAS");
        btn4.setBounds(400, 325, 200, 75);


        // Configuraciones del Boton 1 (SALIR)
        btn5.setText("SALIR");
        btn5.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("img/off2.png"))));
        btn5.setBounds(600, 430, 45, 50);
        btn5.addActionListener(e -> salir());


        getContentPane().add(jPanel);

        // Configuraciones del Panel
        jPanel.setLayout(null);

        jPanel.add(btn1);
        jPanel.add(btn2);
        jPanel.add(btn3);
        jPanel.add(btn4);
        jPanel.add(btn5);
        jPanel.setBounds(0, 0, 700, 500);


        setSize(jPanel.getSize());
        setLocationRelativeTo(null);
    }


    // Terminar le ejecucion del programa
    void salir(){
        System.exit(-1);
    }


    // Llama a la ventana de Pilas
    void newPila(){

    }



    // LLama a la ventana de Cola
    void newCola(){

    }


    // Llama a la ventana de Arbol Binario
    void newBinaryTree(){

    }


    // Llama a la ventana de Lista Enlazada
    void newLinkedList(){

    }


    public static void main(String[] args) {
        new MainFrame().setVisible(true);

    }
}
