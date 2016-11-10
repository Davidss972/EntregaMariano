/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Providers.Interfaces;

import Models.Alquiler;
/**
 *
 * @author David
 */
public interface IAlquilerProvider 
{
void AddAlquiler(Alquiler newAlquiler);
void DeleteAlquiler(Alquiler deleteAlquiler);
void ModifyAlquiler(Alquiler modifyAlquiler);

}
