package programa;
import com.google.gson.Gson;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
public class Consulta {
    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed;
    private int dia;
    private String mes;
    private int anio;

    public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    

    public Consulta() {
        this.ci=-1;
        this.nombrePaciente="";
        this.apellidoPaciente="";
        this.idMed= -1;
        this.dia=-1;
        this.mes="";
        this.anio=-1;
    }
    public void alta(){
        String ruta = "archivosConsultas/consulta"+ +".json";
        Gson gson = new Gson();
        
        try {
            FileWriter w = new FileWriter(ruta);
            gson.toJson(this, w);
            w.close();
            System.out.println("\t\t---ALTA DE MEDICOS");
        } catch (Exception e) {
            System.out.println("ERROR EN ALTA FACTURA:\n\n"+e);
        }
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getApellidoPaciente() {
        return apellidoPaciente;
    }

    public void setApellidoPaciente(String apellidoPaciente) {
        this.apellidoPaciente = apellidoPaciente;
    }

    public int getIdMed() {
        return idMed;
    }

    public void setIdMed(int idMed) {
        this.idMed = idMed;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    

    @Override
    public String toString() {
        return "Consulta{" + "ci=" + ci + ", nombrePaciente=" + nombrePaciente + ", apellidoPaciente=" + apellidoPaciente + ", idMed=" + idMed + ", dia=" + dia + ", mes=" + mes + ", anios=" + anios + '}';
    }
    
    
}
