/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestoralquiler.application;

import Models.Cliente;
import Presenters.ClientePresenter;
import Presenters.CochePresenter;
import Presenters.Interfaces.IClientePresenter;
import Presenters.Interfaces.ICochePresenter;
import Providers.ClienteProvider;
import Providers.CocheProvider;
import Providers.Interfaces.IClienteProvider;
import Providers.Interfaces.ICocheProvider;
import View.ClientsView;
import View.CocheView;
import View.Interfaces.IClientsView;
import View.Interfaces.ICocheView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GestorAlquilerApplication {

    public static void main(String[] args) throws IOException 
    {
        
       
        BufferedReader console;
        console = new BufferedReader(new InputStreamReader(System.in));
        console.readLine();
        int op;
        String menu=";";
        do{
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Clientes \n";
            menu+="2.- Añadir Coches \n";
            menu+="3.- Añadir Alquileres \n";
            menu+="4.- Salir \n";
            
            System.out.println(menu);
            op=Integer.parseInt(console.readLine());//hacer un try catch para capturar la excepcion de poner enter
            switch(op)
            {
                case 1:
                    IClienteProvider clienteprovider = new ClienteProvider();
                    IClientePresenter clientepresenter = new ClientePresenter(clienteprovider);
                    IClientsView clientsview =  new ClientsView(clientepresenter);
                    clientsview.Run();
                    break;
                case 2:
                    ICocheProvider cocheprovider = new CocheProvider();
                    ICochePresenter cochepresenter = new CochePresenter(cocheprovider);
                    ICocheView cocheview = new CocheView(cochepresenter);
                    cocheview.Run();
                    break;  
                case 3 :
                    
                    break;
                case 4 :
                    System.exit(0);
                    break;
                default :
                    System.out.println("introduzca una opcion");
                    break;
                        
            }
        }while(op!=4);
                
                    
    

        
        
    }

   
}


