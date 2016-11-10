/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenters.Interfaces;

import Models.Cliente;

/**
 *
 * @author gokud
 */
public interface IClientePresenter 
{
    boolean AddCliente(Cliente newCliente);
    boolean DeleteCliente(String dni);
    boolean ModifyCliente(Cliente modifyCliente);
    //boolean BuscarCliente(Cliente buscarCliente);
//void mostrarClientes();
}
