package programa;
import com.google.gson.Gson;
import java.io.*;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        
        /////alta
        Medico M1= new Medico(12345,"pablo","arascaeta",2);
        Medico M2= new Medico(23456,"marcelo","choque",1);
        Medico M3= new Medico(34567,"jose","quispe",3);
        M1.alta();
        M2.alta();
        M3.alta();
        ////alta
        Consulta C1=new Consulta(12121,"shakira","katari",12345,25,"diciembre",2001);
        Consulta C2=new Consulta(24242,"maluma","yupanqui",12345,2,"febrero",2002);
        Consulta C3=new Consulta(12312,"romeo","huanca",12345,5,"diciembre",2003);
        Consulta C4=new Consulta(13232,"faraon","chambi",23456,4,"abril",2004);
        Consulta C5=new Consulta(12435,"sacha","colque",23456,31,"mayo",2005);
        Consulta C6=new Consulta(17565,"michael","quenta",23456,26,"diciembre",2006);
        Consulta C7=new Consulta(17655,"erick","suntura",12345,7,"julio",2007);
        Consulta C8=new Consulta(16565,"ander","arroba",34567,31,"diciembre",2008);
        Consulta C9=new Consulta(19382,"alexis","calle",34567,1,"enero",2009);
        C1.alta();
        C2.alta();
        C3.alta();
        C4.alta();
        C5.alta();
        C6.alta();
        C7.alta();
        C8.alta();
        C9.alta();
        
        Consultorio consultorio = new Consultorio("archivoConsultas","archivoMedicos"); 
        System.out.println("--------------ANTES DE LA BAJA-------");
        consultorio.MostrarConsultas();
        consultorio.MostrarMedicos();
        
        
        //ejercicio2
        //BORRAR EL MEDICO DE NOMBRE X, APELLIDO Y y SUS CONSULTAS
        
        
        consultorio.ejercicio1("marcelo", "choque");
        System.out.println("\n\n--------------DESPUES DE LA BAJA--------");
        consultorio.MostrarConsultas();
        consultorio.MostrarMedicos();
        
        consultorio.agregarConsulta(new Consulta(121142,"juan","acarapi",12345,1,"enero",2010));
        
        
        // EJERCICIO 3: CAMBIA EL DIA DE LA CONSULTA DE NAVIDAD O AÑO NUEVO
        
        System.out.println("\n\n--------------CAMBIANDO FECHAS DE NAVIDAD/ANIO NUEVO--------");
        consultorio.ejercicio2(26); // Cambiar al día 26
        
        System.out.println("\n\n--------------DESPUES DEL CAMBIO--------");
        consultorio.MostrarConsultas();
    }
}
