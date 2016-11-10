
package View;

import Models.Cliente;
import Presenters.Interfaces.IClientePresenter;
import Providers.ClienteProvider;
import Providers.Interfaces.IClienteProvider;
import View.Interfaces.IClientsView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ClientsView implements IClientsView
{   
    BufferedReader console;
    IClientePresenter clientePresenter;
    IClienteProvider clienteProvider;
    ClienteProvider mostrar = new ClienteProvider();
    public ClientsView(IClientePresenter diseño)
    {
    clientePresenter = diseño;
    console = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public Cliente GetClienteDetails() throws IOException//detalles para cuando te hayas metido en cliente.
    {
        Cliente newCLiente = new Cliente();
        String continuamos;
        do{
            newCLiente.setDni(GetClienteDni());
            System.out.println("introduce el nombre");
            newCLiente.setNombre(console.readLine());
            System.out.println("introduce los appelidos");
            newCLiente.setApellidos(console.readLine()); 
            System.out.println("¿Deseea introducir un nuevo cliente(S/N)?");
            continuamos = console.readLine();
            return newCLiente;
           } while (continuamos.startsWith("s") || continuamos.startsWith("S"));    
    }
    public String GetClienteDni() throws IOException//pedir dni
    {
        System.out.println("Introduzca el DNI: ");
    
        return console.readLine();
    }
    public int GetClienteAction() throws IOException//switch 
    {
        
        console.readLine();
        
        int op;
        String menu="";
        Cliente cliente;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Cliente \n";
            menu+="2.- Borrar Cliente \n";
            menu+="3.- Modificar Cliente \n";
            menu+="4.- Buscar Cliente \n";
            menu+="5.- Mostrar Clientes \n";
            menu+="6.- Salir \n";
            
            System.out.println(menu);
            op=Integer.parseInt(console.readLine());
            
            switch(op)
            {
                case 1:
                cliente = GetClienteDetails();
                clientePresenter.AddCliente(cliente);
                if(clientePresenter.AddCliente(cliente) == false)
                {
                    
                } 
                    break;
                case 2:
                
                if(clientePresenter.DeleteCliente(GetClienteDni()) == false)
                {
                    System.out.println("El cliente no existe");
                }
                    
                    break;  
                case 3:
                    cliente = GetClienteDetails();
                    clientePresenter.ModifyCliente(cliente);
                    if(clientePresenter.ModifyCliente(cliente) == false)
                    {
                        System.out.println("El cliente ha sido modificado");
                    }
                    break;
                case 4:
                    /*cliente = GetClienteDetails();
                    clientePresenter.BuscarCliente(cliente);
                    if(clientePresenter.BuscarCliente(cliente) == false)
                    break;*/
                case 5:
                    mostrar.mostrarClientes();
                    break;
                case 6:
                    break;
                 
            }
            return op;
        
    }
    public void Run() throws IOException//while bucle
    { 
        while(GetClienteAction() != 6)
        {
        
        }
        
    }
}
