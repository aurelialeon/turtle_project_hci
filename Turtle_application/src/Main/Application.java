/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Application.AccueilEvaluation;
import Application.CreateExercises;
import Application.HomePage;
import Interface.Canvas;
import Interface.CanvasTortue;
import Application.CreateOneExercise;
import Interface.TortueG;
import Interface.TortueRapide;
import Application.PupilInterface;
import Interface.TortueCouleur;
import java.util.ArrayList;
import turtle_project_hci.Attempt;
import turtle_project_hci.Exercise;
import turtle_project_hci.RequestSQLite;



/**
 *
 * @author Utilisateur
 */
public class Application{
    public static void main(String[] args) {
        //HomePage hm = new HomePage("Application");
        //TortueRapide t = new TortueRapide();
        //CreateExercise c = new CreateOneExercise(t);
        //PupilInterface pi = new PupilInterface();
        //CreateExercises ce = new CreateExercises();
        
        /**ArrayList<Exercise> p = new ArrayList<>();
        RequestSQLite req = new RequestSQLite();
        p = req.fetchExercisebyClass("CM1");
        for (Exercise ex : p) {
           System.out.println(ex.getNameExercise());
        }*/
        Exercise ex = new Exercise();
        ex.setCodeExercise("MMM");
        Attempt att = new Attempt("MMRM");
        AccueilEvaluation acEval= new AccueilEvaluation(ex, att);
    }
}
