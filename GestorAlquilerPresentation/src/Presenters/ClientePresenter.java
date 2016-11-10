package Presenters;
import Models.Cliente;
import Presenters.Interfaces.IClientePresenter;
import Providers.ClienteProvider;
import Providers.Interfaces.IClienteProvider;



public class ClientePresenter implements IClientePresenter
{
        private IClienteProvider clienteProvider;
       
        
        
        public ClientePresenter(IClienteProvider Clientep)
        {
            clienteProvider = Clientep;
        } 
        
        public boolean AddCliente(Cliente newCliente)
        {
            Cliente ClienteAAñadir = clienteProvider.GetCliente(newCliente.getDni());
            
            if (ClienteAAñadir == null )
                {
                    clienteProvider.AddCliente(newCliente);
                    System.out.println("El cliente ha sido creado");
                    return true;
                }
            else
                {   
                    return false;
                }
            
        }

    
        public boolean DeleteCliente(String dni) 
        {
            Cliente ClienteABorrar = clienteProvider.GetCliente(dni);
            
            if (ClienteABorrar != null )
                {
                    clienteProvider.DeleteCliente(ClienteABorrar);
                    System.out.println("El cliente ha sido borrado");
                    return true;
                }
            else
                {
                    return false;
                }
            
          
        }

    
        public boolean ModifyCliente(Cliente modifyCliente) 
        {
            Cliente ClienteAModificar = clienteProvider.GetCliente(modifyCliente.getDni());
            
            if (ClienteAModificar != null )
            {
                clienteProvider.ModifyCliente(modifyCliente);
                return true;
            }
            else
            {
                return false;  
            }
        }  
        /*public boolean BuscarCliente(Cliente buscarCliente)
        {
            Cliente ClienteABuscar = clienteProvider.BuscarCliente(buscarCliente.getDni());
            
            if(ClienteABuscar != null)
            {
                clienteProvider.BuscarCliente(buscarCliente);
                return true;
            }
            else
            {
                return false;
            }

        }*/
}
