/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package programa;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Medico {
    private int IdMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    public Medico(int IdMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.IdMed = IdMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    public Medico() {
            this.IdMed = -1;
            this.nombreMed = "";
            this.apellidoMed = "";
            this.aniosExperiencia=-1;
    }
    public void Alta(){
        String ruta = "archivosMedicos/medicos"+IdMed+".json";
        Gson gson = new Gson();
        
        try {
            FileWriter w = new FileWriter(ruta);
            gson.toJson(this, w);
            w.close();
            System.out.println("\t\t---ALTA DE MEDICOS CORRECTO---");
        } catch (Exception e) {
            System.out.println("ERROR EN ALTA MEDICOS: \n\n"+e);
        }
    }
    public void cargar(String ruta){
        Gson gson = new Gson();
        try {
            FileReader r = new FileReader(ruta);
            Medico f = gson.fromJson(r, Medico.class);
            this.IdMed = f.getIdMed();
            this.nombreMed = f.getNombreMed();
            this.apellidoMed = f.getApellidoMed();
            this.aniosExperiencia= f.getAniosExperiencia();
            r.close();
            
            System.out.println("\t\t---CARGA DE MEDICOS CORRECTO---");
        } catch (Exception e) {
            System.out.println("ERROR EN CARGA MEDICOS:\n\n"+e);
        }
    }
    public void baja(){
        String ruta = "archivosMedicos/medico"+IdMed+".json";
        
        File archivo = new File(ruta);
        if(archivo.delete()){
            System.out.println("SE ELIMINO CORRECTAMENTE EL ARCHIVO "+archivo.getPath());
        }else{
            System.out.println("ERROR EN ELIMINACION DEL ARCHIVO "+archivo.getPath());
        }
    }

    public int getIdMed() {
        return IdMed;
    }

    public void setIdMed(int IdMed) {
        this.IdMed = IdMed;
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
        return "Medico{" + "IdMed=" + IdMed + ", nombreMed=" + nombreMed + ", apellidoMed=" + apellidoMed + ", aniosExperiencia=" + aniosExperiencia + '}';
    }
    
    
    
}
