import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

public class Controlador{

    // arrays para los datos

    ArrayList<JCheckBox> checkboxes = new ArrayList<>();
    ArrayList<JTextField> descripcion = new ArrayList<>();
    ArrayList<Tarea> tareas = new ArrayList<>();

    //metodo para añadir objetos Tarea a la lista 
    public void añadirTareas(Tarea tarea){
        tareas.add(tarea);
    }

    // metodo para añadir titulo y descripcion a listas 
    public void añadirToListas(JCheckBox checkBoxTitulo, JTextField textDescripcion){
        checkboxes.add(checkBoxTitulo);
        descripcion.add(textDescripcion);

    }
}  
