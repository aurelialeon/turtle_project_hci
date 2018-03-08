/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Interface.Canvas;
import Interface.CanvasTortue;
import Interface.CreateExercise;
import Interface.TortueG;
import Interface.TortueRapide;
import turtle_project_hci.TestCanvasTortue;

/**
 *
 * @author Utilisateur
 */
public class Application{
    public static void main(String[] args) {
        TortueRapide t = new TortueRapide();
        CreateExercise c = new CreateExercise(t);
        
    }
}

