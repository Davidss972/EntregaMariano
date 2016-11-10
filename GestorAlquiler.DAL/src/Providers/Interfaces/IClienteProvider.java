package Providers.Interfaces;

import Models.Cliente;

public interface IClienteProvider 
{
    void AddCliente(Cliente newCliente);
    void DeleteCliente(Cliente deleteCliente);
    void ModifyCliente(Cliente modifyCliente);
    Cliente GetCliente(String dni);
    void mostrarClientes();
    /*void BuscarCliente(Cliente buscarCliente);*/
}
