package programa;
import com.google.gson.Gson;
import java.io.*;
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
        this.ci = -1;
        this.nombrePaciente = "";
        this.apellidoPaciente = "";
        this.idMed = -1;
        this.dia = -1;
        this.mes = "";
        this.anio = -1;
    }
    public void alta(){
        String ruta = "archivoConsultas/consultas"+dia+".json";
        Gson gson=new Gson();    
        try {
            FileWriter w = new FileWriter(ruta);
            gson.toJson(this, w);
            w.close();
            System.out.println("\t\t ALTA DE CONSULTA CORRECTA");
        }catch (Exception e){
            System.out.println("ERROR DE ALTA EN COLSULTAS:\n\n" + e);
            
        }
    }
    public void cargar(String ruta){
        Gson gson = new Gson();
        try {
            FileReader r = new FileReader(ruta);
            Consulta c = gson.fromJson(r, Consulta.class);
            this.ci= c.getCi();
            this.nombrePaciente= c .getNombrePaciente();
            this.apellidoPaciente= c.getApellidoPaciente();
            this.idMed= c.getIdMed();
            this.dia= c.getDia();
            this.mes= c.getMes();
            this.anio=c.getAnio();
            r.close();
            System.out.println("\t\t CARGA DE CONSULTA CORRECTA");
        }catch (Exception e){
           System.out.println("ERROR DE CARGA EN COLSULTAS:\n\n" + e);
        }
        
    }
    public void baja(){
        String ruta = "archivoConsultas/consultas"+dia+".json";
        File archivo = new File(ruta);
        if(archivo.delete()){
            System.out.println("SE ELIMINO CORRECTAMENTE el consultorio"+archivo.getPath());
        }else{
            System.out.println("ERROR AL ELIMINAR el consultorio "+archivo.getPath());
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

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Consulta{" + "ci=" + ci + ", nombrePaciente=" + nombrePaciente + ", apellidoPaciente=" + apellidoPaciente + ", idMed=" + idMed + ", dia=" + dia + ", mes=" + mes + ", anio=" + anio + '}';
    }
    

    
    
}

    
    
}

