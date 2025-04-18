import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;

public class Vista extends JFrame implements ActionListener {

    JButton botonCompletar;
    JButton botonAgregar;
    JPanel panelTitulo;
    JPanel panelMenu;
    JPanel panelTareas;
    private Controlador controlador;
    Tarea tarea;


    Vista(Controlador controlador){
        this.controlador = controlador;

        //Logica UI

        JTextField textoTitulo = new JTextField();
        textoTitulo.setText("Bienvenido al To-do List");
        textoTitulo.setHorizontalAlignment(JTextField.CENTER);
        textoTitulo.setBackground(Color.GRAY);
        textoTitulo.setMaximumSize(new Dimension(900,50));
        textoTitulo.setFocusable(false);

        botonCompletar = new JButton("Completar");
        botonCompletar.addActionListener(this);

        botonAgregar = new JButton("Agregar Tareas");
        botonAgregar.addActionListener(this);

        panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));
        panelTitulo.setBackground(Color.DARK_GRAY);
        panelTitulo.add(textoTitulo);

        panelMenu = new JPanel();
        panelMenu.setLayout(new BoxLayout(panelMenu, BoxLayout.X_AXIS));
        panelMenu.setBackground(Color.DARK_GRAY);
        panelMenu.add(botonCompletar);
        panelMenu.add(botonAgregar);
        // Un panel para solo las tareas que se ingresen 
        panelTareas = new JPanel();
        panelTareas.setLayout(new BoxLayout(panelTareas, BoxLayout.Y_AXIS));
        panelTareas.setBackground(Color.GRAY);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("To-do List");
        this.setSize(300,400);
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.add(panelTitulo);
        this.add(panelMenu);
        this.add(panelTareas);
        this.setVisible(true);
    }

    //menu principal, obedece a los dos botones disponibles 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==botonAgregar){
            this.agregarTareaUi();  //Se crea el JDialog
        }
        if (e.getSource()==botonCompletar){
            this.completarTareas();
        }
    }

    public void agregarTareaUi(){
            AgregarTarea agregarTarea = new AgregarTarea();    // para poder mostrar la ventana emergente
            agregarTarea.setVisible(true);                   // se muestra 
            tarea = agregarTarea.getTarea();                   // se retorna la tarea        
            controlador.añadirTareas(tarea);  
            pantallaPrincipal(tarea);            
    }

    public void pantallaPrincipal(Tarea tarea){
            JCheckBox checkBoxTitulo = new JCheckBox(tarea.getTitulo());                 //Logica UI
            checkBoxTitulo.setFont(new Font("Times new Roman",Font.BOLD,20));
            checkBoxTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
            JTextField textDescripcion = new JTextField(tarea.getDescripcion());           //textfield con descripcion
            textDescripcion.setFont(new Font("Times new Roman",Font.PLAIN,15));
            textDescripcion.setMaximumSize(new Dimension(300,40));
            
            // añadimos al Array y al panel visual

            controlador.añadirToListas(checkBoxTitulo, textDescripcion);                                        
            panelTareas.add(checkBoxTitulo);
            panelTareas.add(textDescripcion);
            panelTareas.revalidate();
            panelTareas.repaint();
    }

    public void completarTareas(){

        //ciclo for para recorrer array, de atras hacia adelante

        for (int i =  controlador.checkboxes.size()-1; i>=0; i--){

            // guardamos el check box y revisamos si fue seleccionado 
        
            JCheckBox check = controlador.checkboxes.get(i);
            if (check.isSelected()){

                // removemos de los array y del panel visual 

                panelTareas.remove(controlador.checkboxes.get(i));
                panelTareas.remove(controlador.descripcion.get(i));
                controlador.checkboxes.remove(i);
                controlador.descripcion.remove(i);
                controlador.tareas.remove(i);
                panelTareas.revalidate();
                panelTareas.repaint();
            }
        }
    }
}