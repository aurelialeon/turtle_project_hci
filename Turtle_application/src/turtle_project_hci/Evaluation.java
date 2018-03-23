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
public class Evaluation {

    private Attempt att;
    private Grade grade;
    private String comment;
    private Teacher teacher;

    public Evaluation(String commentA) {
        this.grade = Grade.NOT;
        this.comment = commentA;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Attempt getAtt() {
        return att;
    }

    public Teacher getTeacher() {
        return teacher;
    }

}
