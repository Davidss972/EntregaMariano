package Providers;

import Models.Cliente;
import Models.Coche;
import Providers.Interfaces.ICocheProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CocheProvider implements ICocheProvider
{
String nombreFichero = "libreto.txt";
    ArrayList<Coche> listacoches = new ArrayList<>();
    
    public CocheProvider()//que busque si un archivo esta creado o no (comparar).
    {
    listacoches = CargarCochesDesdeArchivo();
    
        
  
    }
    
    public ArrayList<Coche> CargarCochesDesdeArchivo()
    {
        ArrayList<Coche> listacoches1 = new ArrayList<>();
        try  
        {
           
            Scanner sc = new Scanner(new File(this.nombreFichero)).useDelimiter(";");
            while (sc.hasNext()) 
            {
                Coche coche = new Coche();
                coche.setMatricula(sc.next());
                coche.setMarca(sc.next());
                coche.setModelo(sc.next());
                listacoches1.add(coche);
                }
        }     
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(CocheProvider.class.getName()).log(Level.SEVERE, null, ex);
            }

            return listacoches1;
    }
    private void volcarCoches() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreFichero));
                for (Coche coche : listacoches) 
                {
                    fw.write(coche.toString() + ";");
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(CocheProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarCoches()
    {
        for (Coche coche : listacoches)
        {
            System.out.println(coche);
        }
    }

    public Coche GetCoche(String matricula)
    {
        String cochematricula = "";
            
        for (Coche coche : listacoches) 
        {
            cochematricula = coche.getMatricula();
            if(cochematricula != null)
            {
                if(cochematricula == null ? matricula == null : cochematricula.equals(matricula))
                {
                    return coche;
                }  
            }
        }
        return null;    
    }
    
    public void AddCoche (Coche newCoche)
        {
           listacoches.add(newCoche);
           volcarCoches();
        }
    public void DeleteCoche(Coche deleteCoche)
        {
           listacoches.remove(deleteCoche);
           volcarCoches();
        }
    public void ModifyCoche(Coche modifyCoche)//llamar a getclient y modificar diretamente
        {
           Coche coche = GetCoche(modifyCoche.getMatricula());
           DeleteCoche(coche);
           AddCoche(modifyCoche);
        }
    
}
