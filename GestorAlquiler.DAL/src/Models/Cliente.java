package Models;

public class Cliente 
{
    private String nombre;
    private String apellidos;
    private String dni;
    private int telefono;
    
    public Cliente()
        {
        nombre = "sin nombre";
        apellidos = "sin apellidos";
        dni = "sin dni"; 
        }

    public Cliente(Cliente aclonar)
        {
        nombre = aclonar.nombre;
        apellidos = aclonar.apellidos;
        dni = aclonar.dni;
        
        }

    public String getNombre() 
    {
        return nombre;
    }

  
    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public String getApellidos() 
    {
        return apellidos;
    }

    public void setApellidos(String apellidos) 
    {
        this.apellidos = apellidos;
    }

    public String getDni() 
    {
        return dni;
    }

    public void setDni(String dni)
    {
        this.dni = dni;
    }

    public int getTelefono()
    {
        return telefono;
    }

    public void setTelefono(int telefono) 
    {
        this.telefono = telefono;
    }

        @Override
    public String toString()
    {
        return dni + ";" + nombre + ";" + apellidos;
    }

    //public Cliente(String)
        {
        
        }
    public String serializar()
        {
        return null;
        }

}
