package Providers;

import Models.Cliente;
import Providers.Interfaces.IClienteProvider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ClienteProvider implements IClienteProvider
{   
    String nombreFichero = "libreta.txt";
    ArrayList<Cliente> listaclientes = new ArrayList<>();
    
    public ClienteProvider()//que busque si un archivo esta creado o no (comparar).
    {
    listaclientes = CargarClientesDesdeArchivo();
    
        
        /*leer todas las lineas del fichero
             y por cada linea crear un objeto de tipo cliente
            Pasandole por el constructor la linea y añadiendo el cliente a una lista de clientes*/
    }
    
    public ArrayList<Cliente> CargarClientesDesdeArchivo()
    {//añadir a la lista clientes mediante un bucle for
        ArrayList<Cliente> listaclientes1 = new ArrayList<>();
        try  
        {
           
            Scanner sc = new Scanner(new File(this.nombreFichero)).useDelimiter(";");
            while (sc.hasNext()) 
            {
                Cliente cliente = new Cliente();
                cliente.setDni(sc.next());
                cliente.setNombre(sc.next());
                cliente.setApellidos(sc.next());
                listaclientes1.add(cliente);
                }
        }     
            catch (FileNotFoundException ex)
            {
                Logger.getLogger(ClienteProvider.class.getName()).log(Level.SEVERE, null, ex);
            }

            return listaclientes1;
    }
    private void volcarContactos() //antes de volcar manera de borrar todo lo que haya dentro/*porque lo que cargamos es la lista.*/
    {
        try {
                FileWriter fw = new FileWriter(new File(this.nombreFichero));
                for (Cliente cliente : listaclientes) 
                {
                    fw.write(cliente.toString() + ";");
                }
                fw.close();
            } 
        catch (IOException ex) 
            {
                Logger.getLogger(ClienteProvider.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mostrarClientes()
    {
        for (Cliente cliente : listaclientes)
        {
            System.out.println(cliente);
        }
    }

    public Cliente GetCliente(String dni)
    {
        String clientdni = "";
            
        for (Cliente cliente : listaclientes) 
        {
            clientdni = cliente.getDni();
            if(clientdni != null)
            {
                if(clientdni == null ? dni == null : clientdni.equals(dni))
                {
                    return cliente;
                }  
            }
        }
        return null;    
    }
    
    public void AddCliente (Cliente newCliente)
        {
           listaclientes.add(newCliente);
           volcarContactos();
        }
    public void DeleteCliente(Cliente deleteCliente)
        {
           listaclientes.remove(deleteCliente);
           volcarContactos();
        }
    public void ModifyCliente(Cliente modifyCliente)//llamar a getclient y modificar diretamente
        {
            
           Cliente cliente = GetCliente(modifyCliente.getDni());
           DeleteCliente(cliente);
           AddCliente(modifyCliente);
           
        }
    /*public void BuscarCliente(Cliente buscarCliente)
        {
           Cliente cliente = GetCliente(buscarCliente.getDni());
        
        }*/
    
    
    


}

