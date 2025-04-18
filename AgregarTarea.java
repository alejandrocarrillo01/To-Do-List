
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.*;

public class AgregarTarea extends JDialog implements ActionListener {
    // Usamos un JDialog para crear una ventana y pedirle al usuario la tarea

    Tarea tarea;
    JButton boton;
    JPanel panel;
    JTextField espacio;
    JTextField espacio2;
    JTextField texto;
    JTextField texto2;

    AgregarTarea(){

        //Logica UI 

        texto = new JTextField();
        texto.setText("Ingrese la tarea a agregar");
        texto.setBackground(Color.GRAY);
        texto.setFocusable(false);

        espacio = new JTextField();
        espacio.setPreferredSize(new Dimension(250,40));

        texto2 = new JTextField();
        texto2.setText("Ingrese la descripcion");
        texto2.setBackground(Color.GRAY);
        texto2.setFocusable(false);

        espacio2 = new JTextField();
        espacio.setPreferredSize(new Dimension(250,40));

        boton = new JButton("Guardar");
        boton.setAlignmentX(Component.CENTER_ALIGNMENT);
        boton.addActionListener(this);

        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.DARK_GRAY);
        panel.add(texto);
        panel.add(espacio);
        panel.add(texto2);
        panel.add(espacio2);
        panel.add(boton);

        this.setModal(true);  //Para que solo use la ventana emergente
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("Agregar Tareas");
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.add(panel);
        this.pack();

    }

    // Metodo para que guardemos la tarea en la clase Tarea 
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==boton){
            String titulo = espacio.getText();
            String descripcion = espacio2.getText();
            tarea = new Tarea(titulo,descripcion);
            this.dispose();  //cerramos la ventana
        }
    }

    public Tarea getTarea(){    //metodo de la clase anida tarea para retornar la tarea
        return tarea;
    }
}