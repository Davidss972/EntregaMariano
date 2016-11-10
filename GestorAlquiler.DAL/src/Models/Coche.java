package Models;

public class Coche 
{
    private String matricula;
    private String marca;
    private String modelo;
    public Coche()
        {
        modelo = "sin modelo";
        marca = "sin marca";
        matricula = "sin matricula"; 
        }

    public Coche(Coche aclonar)
        {
        modelo = aclonar.modelo;
        marca = aclonar.marca;
        matricula = aclonar.matricula;
        
        }
    public String getMatricula() 
    {
        return matricula;
    }


    public void setMatricula(String matricula) 
    {
        this.matricula = matricula;
    }

    public String getMarca() 
    {
        return marca;
    }

    public void setMarca(String marca)
    {
        this.marca = marca;
    }


    public String getModelo()
    {
        return modelo;
    }

    public void setModelo(String modelo) 
    {
        this.modelo = modelo;
    }

            @Override
    public String toString()
    {
        return matricula + ";" + marca + ";" + modelo;
    }
}

