/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Models.Coche;
import Presenters.Interfaces.ICochePresenter;
import Providers.CocheProvider;
import Providers.Interfaces.ICocheProvider;
import View.Interfaces.ICocheView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author gokud
 */
public class CocheView implements ICocheView
{   
    BufferedReader console;
    ICochePresenter cochePresenter;
    ICocheProvider cocheProvider;
    CocheProvider mostrar = new CocheProvider();
    public CocheView(ICochePresenter diseño)
    {
        cochePresenter = diseño;
        console = new BufferedReader(new InputStreamReader(System.in));
    }
    public Coche GetCocheDetails() throws IOException//detalles para cuando te hayas metido en coche.
    {
        Coche newcoche = new Coche();
        String continuamos;
        do{
            newcoche.setMatricula(GetCocheMatricula());
            System.out.println("introduce Marca");
            newcoche.setMarca(console.readLine());
            System.out.println("introduce Modelo");
            newcoche.setModelo(console.readLine()); 
            System.out.println("¿Deseea introducir un nuevo coche(S/N)?");
            continuamos = console.readLine();        
            return newcoche;
        }while (continuamos.startsWith("s") || continuamos.startsWith("S"));
    }
    public String GetCocheMatricula() throws IOException//pedir matricula
    {
        System.out.println("Introduzca la matricula: ");
        
        return console.readLine();
    }
    public int GetCocheAction() throws IOException//switch 
    {
        console.readLine();
        int op;
        String menu="";
        Coche coche;
            menu="";
            menu+="****** Menú ******\n";
            menu+="1.- Añadir Coche \n";
            menu+="2.- Borrar Coche \n";
            menu+="3.- Modificar Coche \n";
            menu+="4.- Buscar Coche \n";
            menu+="5.- Mostrar Coches \n";
            menu+="6.- Salir \n";
            System.out.println(menu);
            op=Integer.parseInt(console.readLine());
            
            switch(op)
            {
                case 1:
                coche = GetCocheDetails();
                cochePresenter.AddCoche(coche);
                if(cochePresenter.AddCoche(coche) == false)
                {

                }
                    break;
                case 2:
                
                if(cochePresenter.DeleteCoche(GetCocheMatricula()) == false)
                {
                    System.out.println("El coche no existe");
                }
                    break;
                case 3:
                coche = GetCocheDetails();
                cochePresenter.ModifyCoche(coche);
                if(cochePresenter.ModifyCoche(coche) == false)
                {
                    System.out.println("El coche ha sido modificado");
                }
                    break;
                case 4:
                    break;
                case 5:
                    mostrar.mostrarCoches();
                    break;
                case 6:
                    break;
            }
        
        return op;
        
    }
    public void Run() throws IOException//while bucle
    {
        while(GetCocheAction() != 5)
        {
        
        }    
           
    }
}
