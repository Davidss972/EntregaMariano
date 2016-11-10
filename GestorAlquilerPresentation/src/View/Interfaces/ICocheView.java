/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Interfaces;

import Models.Coche;
import java.io.IOException;

/**
 *
 * @author gokud
 */
public interface ICocheView 
{
    Coche GetCocheDetails() throws IOException; 
    String GetCocheMatricula()throws IOException;
    int GetCocheAction()throws IOException;
    void Run()throws IOException;  
}
