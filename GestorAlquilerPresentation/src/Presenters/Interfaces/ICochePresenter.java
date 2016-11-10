/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presenters.Interfaces;

import Models.Coche;

/**
 *
 * @author gokud
 */
public interface ICochePresenter 
{
    boolean AddCoche(Coche newCoche);
    boolean DeleteCoche(String matricula);
    boolean ModifyCoche(Coche modifyCoche);
}
