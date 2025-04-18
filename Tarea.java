public class Tarea {

    private String titulo;
    private String descripcion;

    Tarea(String titulo,String descripcion){
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    //Metodos get para Tarea
    
    public String getTitulo(){
        return titulo;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
