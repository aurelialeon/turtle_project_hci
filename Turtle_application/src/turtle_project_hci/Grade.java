/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package turtle_project_hci;

/**
 *
 * @author manonsacre
 */
public enum Grade {
  //Objets directement construits
  ACQ("Acquired"),
  PROG("In progress"),
  NOT("Not acquired");

  private String name = "";
   
  //Constructeur
  Grade(String name){
    this.name = name;
  }
  
  public String toString(){
    return name;
  }
   
  /*
  public static void main(String args[]){
    Grade g1 = Grade.ACQ;
    Grade g2 = Grade.COURSE;
    Grade g3 = Grade.NOT;
    
    g1.toString();
  }
*/
}
