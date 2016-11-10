/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Providers.Interfaces;

import Models.Coche;

public interface ICocheProvider 
{
    void AddCoche(Coche newCoche);
    void DeleteCoche(Coche deleteCoche);
    void ModifyCoche(Coche modifyCoche);
    Coche GetCoche(String matricula);
    void mostrarCoches();
}
