package programa;
import com.google.gson.Gson;
import java.io.*;
import java.io.FileReader;
import java.io.FileWriter;
public class Medico {
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;
    

    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
        
    }

    public Medico() {
        this.idMed = -1;
        this.nombreMed = "";
        this.apellidoMed = "";
        this.aniosExperiencia = -1;
    }
    public void alta(){
        String ruta = "archivoMedicos/medicos"+idMed+".json";
        Gson gson=new Gson();
        try {
            FileWriter w = new FileWriter(ruta);
            gson.toJson(this, w);
            w.close();
            System.out.println("\t\t ALTA DE MEDICOS CORRECTA");
        }catch (Exception e){
            System.out.println("ERROR DE ALTA EN MEDICOS:\n\n" +e);
            
        }
    }
    public void cargar(String ruta){
        Gson gson = new Gson();
        try {
            FileReader r = new FileReader(ruta);
            Medico m = gson.fromJson(r, Medico.class);
            this.idMed=m.getIdMed();
            this.nombreMed=m.getNombreMed();
            this.apellidoMed=m.getApellidoMed();
            this.aniosExperiencia=m.getAniosExperiencia();
            r.close();
            System.out.println("\t\t CARGA DE MEDICOS CORRECTA");
        }catch (Exception e){
           System.out.println("ERROR DE CARGA DE MEDICOS:\n\n" + e);
        }
        
    }
    public void baja(){
        String ruta  = "archivoMedicos/medicos"+idMed+".json";
        File archivo = new File(ruta);
        if(archivo.delete()){
            System.out.println("SE ELIMINO CORRECTAMENTE"+archivo.getPath());
        }else{
            System.out.println("ERROR AL ELIMINAR "+archivo.getPath());
        }
    }

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public void setNombreMed(String nombreMed) {
        this.nombreMed = nombreMed;
    }

    public String getApellidoMed() {
        return apellidoMed;
    }

    public void setApellidoMed(String apellidoMed) {
        this.apellidoMed = apellidoMed;
    }

    public int getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setAniosExperiencia(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "Medico{" + "idMed=" + idMed + ", nombreMed=" + nombreMed + ", apellidoMed=" + apellidoMed + ", aniosExperiencia=" + aniosExperiencia + '}';
    }
    
    
    
}
