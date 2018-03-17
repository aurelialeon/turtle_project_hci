/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.awt.event.ActionEvent;
import Application.CreateExercises;
import Interface.TortueCouleur;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Utilisateur
 */
public class ActionsCreationExercise extends JFrame implements ActionListener{
    
    private CreateExercises cre;
    
    public ActionsCreationExercise(CreateExercises c){
        cre = c;
        
    }
    
    /**
         * Method that allow to make action depending on the button. 
         * @param e 
         */
        
    public void actionPerformed(ActionEvent e)
    {
        cre.press(e);
    }
        /**if (cre.getCheck1().isSelected()){
            cre.getMyExercise().setMode(cre.getTortueN());
            if (e.getSource()== cre.getExo()){
                //TortueG tg = new TortueG();
                cre.getMyExercise().setInstruction(cre.getConsigne().getText());
                cre.getMyExercise().setNameExercise(cre.getNameExo().getText());
                cre.createOneExercise(cre.getMyExercise().getMode());
                //cre.getFirstFrame().dispose();
            }
        } else if (cre.getCheck2().isSelected()){
            cre.getMyExercise().setMode(cre.getTortueC());
            if (e.getSource()== cre.getExo()){
                //TortueCouleur tc = new TortueCouleur();
                cre.getMyExercise().setInstruction(cre.getConsigne().getText());
                cre.getMyExercise().setNameExercise(cre.getNameExo().getText());
                cre.createOneExercise(cre.getMyExercise().getMode());
                //cre.getFirstFrame().dispose();
            }
        }
        else if (cre.getCheck3().isSelected()){
            cre.getMyExercise().setMode(cre.getTortueR());
            if (e.getSource()== cre.getExo()){
                //TortueRapide tr = new TortueRapide();
                cre.getMyExercise().setInstruction(cre.getConsigne().getText());
                cre.getMyExercise().setNameExercise(cre.getNameExo().getText());
                
                cre.createOneExercise(cre.getMyExercise().getMode());
                //cre.getFirstFrame().dispose();
            }
        } else if (e.getSource() == cre.getForward()){
            while (cre.getNewTurtle().getDirection()!=3){
                cre.getNewTurtle().tourner();
            }
            cre.setResult(cre.getResult()+"T"); //top
        }else if (e.getSource() == cre.getLeft()) {
            while (cre.getNewTurtle().getDirection()!=2){
                cre.getNewTurtle().tourner();

            }
            cre.setResult(cre.getResult()+"L"); //left
        }else if (e.getSource() == cre.getRight()){
            while (cre.getNewTurtle().getDirection()!=0){
                cre.getNewTurtle().tourner(); 

            }
            cre.setResult(cre.getResult()+"R"); //right
        }else if (e.getSource()==cre.getBackward()){
            while (cre.getNewTurtle().getDirection()!=1){
                cre.getNewTurtle().tourner();
            }
            cre.setResult(cre.getResult()+"B"); //bottom
        }else if (e.getSource()==cre.getUnwrite()){
            cre.getNewTurtle().tracer(false);
            cre.setResult(cre.getResult()+"U"); //unwrite

        }else if (e.getSource()==cre.getWrite()){
            cre.getNewTurtle().tracer(true);
            cre.setResult(cre.getResult()+"W"); //write
        }else if (e.getSource()== cre.getNormal()){
            cre.setNewTurtle(cre.getTortueN());
            cre.getSpeedUp().setEnabled(false);
            cre.getSlowDown().setEnabled(false);
            cre.getNewTurtle().reset();
            cre.setResult("");

        }else if (e.getSource()== cre.getColor()){
            cre.setNewTurtle(cre.getTortueC());
            cre.getSpeedUp().setEnabled(false);
            cre.getSlowDown().setEnabled(false);
            cre.getNewTurtle().reset();
            cre.setResult("");

            cre.chooseMode(cre.getTortueC());
        }else if (e.getSource()== cre.getFast()){
            cre.setNewTurtle(cre.getTortueR());
            cre.getSpeedUp().setEnabled(true);
            cre.getSlowDown().setEnabled(true);
            cre.getNewTurtle().reset();
            cre.setResult("");
            cre.chooseMode(cre.getTortueR());

        }else if (e.getSource()== cre.getMove()){
            cre.getNewTurtle().avancer();
            cre.setResult(cre.getResult()+"M"); //move

        }else if (e.getSource()== cre.getRestart()){
            cre.getNewTurtle().reset();
            cre.setResult("");
        } else if (e.getSource()==cre.getBlack()){
            cre.setNewTurtle(new TortueCouleur("black"));
            cre.getSecondFrame().dispose();
        } else if (e.getSource()==cre.getRed()){
            cre.setNewTurtle(new TortueCouleur("red"));
            cre.getSecondFrame().dispose();
        } else if (e.getSource()==cre.getBlue()){
            cre.setNewTurtle(new TortueCouleur("blue"));
            cre.getSecondFrame().dispose();
        } else if (e.getSource()==cre.getGreen()){
            cre.setNewTurtle(new TortueCouleur("green"));
            cre.getSecondFrame().dispose();
        } else if (e.getSource()==cre.getYellow()){
            cre.setNewTurtle(new TortueCouleur("yellow"));
            cre.getSecondFrame().dispose();
        } else if (e.getSource()==cre.getMagenta()){
            cre.setNewTurtle(new TortueCouleur("magenta"));
            cre.getSecondFrame().dispose();
        } else if (e.getSource()==cre.getSetSpeed()){
            if (cre.getCheck1Bis().isSelected()){
                cre.getTortueR().setVitesse(1);
            }else if (cre.getCheck2Bis().isSelected()){
                cre.getTortueR().setVitesse(2);
            }else if (cre.getCheck3Bis().isSelected()){
                cre.getTortueR().setVitesse(3);
            }else if (cre.getCheck4Bis().isSelected()){
                cre.getTortueR().setVitesse(4);
            }else if (cre.getCheck5Bis().isSelected()){
                cre.getTortueR().setVitesse(5);
            }
            cre.getThirdFrame().dispose();

        }else if (e.getSource()==cre.getSpeedUp()){
            cre.getTortueR().accelerer();
            cre.setResult(cre.getResult()+"A"); //acceler
            
        }else if (e.getSource()==cre.getSlowDown()){
            cre.getTortueR().ralentir();
            cre.setResult(cre.getResult()+"F"); //freiner
        }else if (e.getSource()==cre.getSave()){
            cre.getMyExercise().setCodeExercise(cre.getResult());
            this.dispose();
            //labelInstruction.setText(exo.getCodeExercise());
            try {
                saveGraph();
            } catch (IOException ex) {
                Logger.getLogger(CreateExercise.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }*/
    
    
    
}
