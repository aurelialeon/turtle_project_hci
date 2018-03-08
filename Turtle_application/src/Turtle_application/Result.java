/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Turtle_application;

import java.util.ArrayList;

/**
 *
 * @author manonsacre
 */
public class Result {
    private ArrayList<Evaluation> results;

    public Result() {
    }
    
    public void addEval (Evaluation e) {
        results.add(e);
    }
}
