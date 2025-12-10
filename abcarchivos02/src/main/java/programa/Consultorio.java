package programa;
import java.io.*;
import java.util.ArrayList;
public class Consultorio {
    private String consultas;
    private String medicos;

    public Consultorio(String consultas, String medicos) {
        this.consultas = consultas;
        this.medicos = medicos;
    }
    public void agregarConsulta(Consulta c){
        c.alta();
    }
    
    public void agregarMedico(Medico m){
        m.alta();
    }
    public void MostrarConsultas(){
        ArrayList<Consulta> lista= new ArrayList<Consulta>();
        File carpeta = new File(this.consultas);
        File[] archivos = carpeta.listFiles();
        
        for(File c: archivos){
            Consulta nuevo = new Consulta();
            nuevo.cargar(c.getPath());
            lista.add(nuevo);
        }
        for(Consulta c: lista){
            System.out.println(c);
        }
        
    }
    public void MostrarMedicos(){
        ArrayList<Medico> lista= new ArrayList<Medico>();
        File carpeta = new File(this.medicos);
        File[] archivos = carpeta.listFiles();
        
        for(File m: archivos){
            Medico nuevo = new Medico();
            nuevo.cargar(m.getPath());
            lista.add(nuevo);
        }
        for(Medico m: lista){
            System.out.println(m);
        }
        
    }
    public ArrayList<Medico> cargarMedicos(){
        ArrayList<Medico> lista= new ArrayList<Medico>();
        File carpeta = new File(this.medicos);
        File[] archivos = carpeta.listFiles();
        
        for(File m: archivos){
            Medico nuevo = new Medico();
            nuevo.cargar(m.getPath());
            lista.add(nuevo);
        }
        return lista;
    }
    public ArrayList<Consulta> cargarConsultas(){
        ArrayList<Consulta> lista= new ArrayList<Consulta>();
        File carpeta = new File(this.consultas);
        File[] archivos = carpeta.listFiles();
        for(File c: archivos){
            Consulta nuevo = new Consulta();
            nuevo.cargar(c.getPath());
            lista.add(nuevo);
        }
        return lista;
    }
    //BORRAR EL MEDICO DE NOMBRE X, APELLIDO Y y SUS CONSULTAS
    public void ejercicio1(String nombreX, String apellidoY){
        ArrayList<Medico> meds = this.cargarMedicos();
        int idBuscado =-1;
        
        for(Medico m: meds){
            if(m.getNombreMed().equals(nombreX) && m.getApellidoMed().equals(apellidoY)){
                    idBuscado = m.getIdMed();
                    m.baja();
                    System.out.println("Medico eliminado: " + m.getNombreMed() + " " + m.getApellidoMed());
                
            }
        }if(idBuscado != -1){
            ArrayList<Consulta> consul = this.cargarConsultas();
            for(Consulta c:consul){
                if(c.getIdMed() == idBuscado){
                    c.baja();
                }
            }
        }
        else{
            System.out.println("---Producto no encontrado de("+nombreX+")");
        }
        
        
    }
    // CAMBIA EL DIA DE LA CONSULTA DE LOS PACIENTES Q AGENDARON EN NAVIDAD O AÑO NUEVO
    public void ejercicio2(int nuevoDia){
        ArrayList<Consulta> consultas = this.cargarConsultas();
        int consultasCambiadas = 0;
        
        for(Consulta c: consultas){
            boolean esNavidad = (c.getDia() == 25 && c.getMes().equalsIgnoreCase("diciembre"));
            boolean esFinDeAnio = (c.getDia() == 31 && c.getMes().equalsIgnoreCase("diciembre"));
            boolean esAnioNuevo = (c.getDia() == 1 && c.getMes().equalsIgnoreCase("enero"));
            
            // Si la consulta es en Navidad, Fin de Año o Año Nuevo
            if(esNavidad || esFinDeAnio || esAnioNuevo){
                System.out.println("Cambiando consulta: " + c.getNombrePaciente() + 
                                   " del dia " + c.getDia() + " de " + c.getMes());
                
                // Eliminar el archivo viejo
                c.baja();
                
                // Cambiar el día
                c.setDia(nuevoDia);
                
                // Crear el archivo nuevo con el día actualizado
                c.alta();
                
                consultasCambiadas++;
            }
        }
        
        System.out.println("\nSe cambiaron " + consultasCambiadas + " consultas al dia " + nuevoDia);
    }
    
        
    
}
