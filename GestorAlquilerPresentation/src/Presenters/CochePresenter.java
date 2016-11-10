package Presenters;

import Models.Coche;
import Presenters.Interfaces.ICochePresenter;
import Providers.Interfaces.IClienteProvider;
import Providers.Interfaces.ICocheProvider;

public class CochePresenter implements ICochePresenter
{
    private ICocheProvider cocheProvider;
    
    
    public CochePresenter(ICocheProvider Cochep)
        {
            cocheProvider = Cochep;
        } 
    
    
    public boolean AddCoche(Coche newCoche)
        {
            Coche CocheAAñadir = cocheProvider.GetCoche(newCoche.getMatricula());
            
            if (CocheAAñadir == null )
                {
                    cocheProvider.AddCoche(newCoche);
                    System.out.println("El coche ha sido creado");
                    return true;
                }
            else
                {
                    return false;
                }
            
        }
    public boolean DeleteCoche(String matricula)
    {
            Coche CocheABorrar = cocheProvider.GetCoche(matricula);
            
        if (CocheABorrar != null )
            {
                cocheProvider.DeleteCoche(CocheABorrar);
                System.out.println("El coche ha sido borrado");
                return true;
            }
        else
            {
                return false;
            }
            
    }
    public boolean ModifyCoche(Coche modifyCoche)
        {
            Coche CocheAModificar = cocheProvider.GetCoche(modifyCoche.getMatricula());
            
            if (CocheAModificar == null )
                {
                    cocheProvider.ModifyCoche(modifyCoche);
                    return true;
                }
            else
                {
                    return false;
                }
            
        }

}
