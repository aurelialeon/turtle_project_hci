package turtle_project_hci;

import turtle_project_hci.Pupil;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Clemence
 */
public class RequestSQLite {

    private Connection conn = null;

    /**
     * Connect to the database
     */
    public void connect() {
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\sqlite\\gui\\gp4_Turtleproject.db";
            //String url = "jdbc:sqlite:/Users/manonsacre/sqlite/gui/gp4_Turtleproject.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Deconnect from the database
     */
    public void deconnect() {
        try {
            if (conn != null) {
                conn.close();
                System.out.println("Deconnection to SQLite done.");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Fetch one pupil, using the id of this pupil in the database
     *
     * @param id
     * @return newPupil, the newly created pupil
     */
    public Pupil fetchOnePupil(int idPup) {
        // Declaration of the variables
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String name;
        String firstName;
        Pupil newPupil = null;

        // creation of the request
        String request = "SELECT namePupil, firstNamePupil FROM Pupil WHERE idPupil = ?";

        // connection to the database
        connect();

        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setInt(1, idPup); // add the varaible into the sql request

            rs = pstmt.executeQuery(); // Execution of the query

            rs.next();
            name = rs.getString("namePupil"); // get the name of the pupil in the database
            firstName = rs.getString("firstNamePupil");
            newPupil = new Pupil(name, firstName); // creation of a new pupil

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (newPupil);
    }

    /**
     * fetch all the pupils in the database
     *
     * @return listPupils
     */
    public ArrayList<Pupil> FetchAllPupil() {
        // Declaration of the variables
        Statement stmt = null;
        ResultSet rs = null;
        String name = null;
        String firstName = null;
        Pupil newPupil = null;
        ArrayList<Pupil> listPupils = null;

        // creation of the request
        String request = "SELECT namePupil, firstNamePupil FROM Pupil";

        // connection to the database
        connect();

        try {
            stmt = conn.createStatement(); // Creation of a statement

            rs = stmt.executeQuery(request); // Execution of the query
            
            listPupils = new ArrayList<Pupil>();
            
            while (rs.next()) {
                newPupil = new Pupil(rs.getString("namePupil"),rs.getString("firstNamePupil"));
                listPupils.add(newPupil);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (listPupils);
    }
    
    /**
     * Fetch in the database all the names of the exercises
     * @return a list of exercise names
     */
    public ArrayList<Exercise> fetchAllExerciseName () {
        // Declaration of the variables
        Statement stmt = null;
        ResultSet rs = null;
        Exercise newExercise = null;
        ArrayList<Exercise> listExercise = null;

        // creation of the request
        String request = "SELECT nameEx FROM Exercise";

        // connection to the database
        connect();

        try {
            stmt = conn.createStatement(); // Creation of a statement

            rs = stmt.executeQuery(request); // Execution of the query
            
            listExercise = new ArrayList<Exercise>();
            
            while (rs.next()) {
                newExercise = new Exercise();
                newExercise.setNameExercise(rs.getString("nameEx"));
                listExercise.add(newExercise);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (listExercise);
    }
    
    /**
     * Fetch one pupil, using the id of this pupil in the database
     *
     * @param id
     * @return newPupil, the newly created pupil
     */
    public ArrayList<Exercise> fetchExercisebyClass(String nameClass) {
        // Declaration of the variables
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Exercise newExercise = null;
        ArrayList<Exercise> listExercise = null;
        listExercise = new ArrayList<Exercise>();
        
        // creation of the request
        String request = "SELECT nameEx FROM Exercise WHERE level = ?";

        // connection to the database
        connect();

        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setString(1, nameClass); // add the varaible into the sql request

            rs = pstmt.executeQuery(); // Execution of the query

            while(rs.next()){
                newExercise = new Exercise();
                newExercise.setNameExercise(rs.getString("nameEx"));
                listExercise.add(newExercise);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (listExercise);
    }
    
    /**
     * Fetch in the database the list of attempt for one Pupil
     * @return 
     */
    public ArrayList<Attempt> fetchAttemptList (int idPupil) {
        // Declaration of the variables
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String request;
        Attempt newAttempt;
        ArrayList<Attempt> listAttempt;
        listAttempt = new ArrayList<Attempt>();
        Exercise newEx; 
        
        request = "SELECT answerPupil, nameEx, idExercise FROM Attempt INNER JOIN Exercise ON Attempt.idExercise = Exercise.idExercise WHERE Attempt.idPupil = ?";
        
        // connection to the database
        connect();

        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setInt(1, idPupil); // add the varaible into the sql request

            rs = pstmt.executeQuery(); // Execution of the query

            while(rs.next()){
                newAttempt = new Attempt(null);
                newAttempt.setAnswer(rs.getString("answerPupil"));
                newEx = new Exercise();
                newAttempt.setExo(newEx);
                newEx.setIdEx(rs.getInt("idExercise"));
                newEx.setNameExercise(rs.getString("nameEx"));
                listAttempt.add(newAttempt);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (listAttempt);
    }
   
         /**
         * Takes the id of the exercise to get the name of the exercise
         * @param idExercise
         * @return exoName
         */
        public String fetchExerciseName (int idExercise) {
        // Declaration of the variables
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String request;
        String exoName = null;
        
        request = "SELECT nameEx FROM Exercise WHERE idExercise = ?";
        
        // connection to the database
        connect();

        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setInt(1, idExercise); // add the varaible into the sql request
            
            rs = pstmt.executeQuery(); // Execution of the query

            rs.next();
            exoName = rs.getString("nameEx");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (exoName);
    }
        
    /**
     * Count the total number of attempts for one pupil
     * @param idPupil
     * @return numAttempt
     */
    public int fetchNumberofAttempt (int idPupil){
        // Declaration of the variables
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String request;
        int numAttempt = 0;
        
        request = "SELECT COUNT(*) FROM Attempt WHERE idPupil = ?";
        
        // connection to the database
        connect();

        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setInt(1, idPupil); // add the varaible into the sql request

            rs = pstmt.executeQuery(); // Execution of the query

            rs.next();
            numAttempt = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (numAttempt);
    }
    
     /**
     * Fetch a pupil with a given login
     * @param login
     * @return a boolean which allow to access the pupil part
     */
        public boolean fetchLogin (String login){
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String request;
        boolean resultat = false;
        request = "SELECT loginPupil FROM Pupil WHERE loginPupil = ?";
        connect();
        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setString(1, login); // add the varaible into the sql request
            rs = pstmt.executeQuery(); // Execution of the query  
            String mdp = rs.getString(1);
            while(rs.next()){
                if(mdp.equals(login)){
                    JOptionPane.showMessageDialog(null, "Authentification réussie !");
                    resultat = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Login Incorrect !");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (resultat);
    }
        
     /**
     * Fetch a teacher with a given identification and password
     * @param id
     * @param pwd
     * @return a boolean which allow to access the teacher part
     */
        public boolean authentificationTeacher (String login, String pwd){
        PreparedStatement pstmt, pstmt2 = null;
        ResultSet rs, rs2 = null;
        String request, request2;
        boolean resultat = false;
        request = "SELECT loginTeacher FROM Teacher WHERE loginTeacher = ? AND passwordTeacher = ?";
        connect();
        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setString(1, login); // add the varaible into the sql request
            pstmt.setString(2, pwd); // add the varaible into the sql request
            rs = pstmt.executeQuery(); // Execution of the query  
            
            String mdp = rs.getString(1);
            
            if (mdp.equals(login)){
                JOptionPane.showMessageDialog(null, "Authentification réussie !");
                resultat = true;
            } else {
                JOptionPane.showMessageDialog(null, "Login or password Incorrect !");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (resultat);
    }
        
     /**
     * Fetch a teacher with a given identification and password
     * @param id
     * @param pwd
     * @return a boolean which allow to access the teacher part
     */
        public Teacher fetchTeacher (String login, String pwd){
        PreparedStatement pstmt, pstmt2 = null;
        ResultSet rs, rs2 = null;
        String request, request2;
        Teacher teach = null;
        request = "SELECT * FROM Teacher WHERE loginTeacher = ? AND passwordTeacher = ?";
        connect();
        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setString(1, login); // add the varaible into the sql request
            pstmt.setString(2, pwd); // add the varaible into the sql request
            rs = pstmt.executeQuery(); // Execution of the query  
            
            String mdp = rs.getString(1);
            
            if (mdp.equals(login)){
                rs.next();
                teach = new Teacher(rs.getString("nameTeacher"),rs.getString("firstNameTeacher"));
                teach.setLogin(login);
                teach.setPassword(pwd);
                teach.setIdT(rs.getInt("idTeacher"));
                //JOptionPane.showMessageDialog(null, "Authentification réussie !");
                //resultat = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return teach;
    }
        
        /**
     * Fetch a teacher with a given identification and password
     * @param id
     * @param instruction
     * @return a boolean which allow to access the teacher part
     */
        public Teacher saveExercice (String nameEx, String instruction){
        PreparedStatement pstmt, pstmt2 = null;
        ResultSet rs, rs2 = null;
        String request, request2;
        Teacher teach = null;
        request = "INSERT INTO Teacher WHERE loginTeacher = ? AND passwordTeacher = ?";
        connect();
        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setString(1, nameEx); // add the varaible into the sql request
            pstmt.setString(2, instruction); // add the varaible into the sql request
            rs = pstmt.executeQuery(); // Execution of the query  
            
            String mdp = rs.getString(1);
            
            if (mdp.equals(nameEx)){
                rs.next();
                teach = new Teacher(rs.getString("nameTeacher"),rs.getString("firstNameTeacher"));
                teach.setLogin(nameEx);
                teach.setPassword(instruction);
                teach.setIdT(rs.getInt("idTeacher"));
                //JOptionPane.showMessageDialog(null, "Authentification réussie !");
                //resultat = true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return teach;
    }
        
        
            /**
     * fetch all the pupils in the database
     *
     * @return listPupils
     */
    public ArrayList<Class> FetchTeacherClass(int idTeacher) {
        // Declaration of the variables
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String nameClass = null;
        String firstName = null;
        Teacher newTeacher = null;
        Class newClass = null;
        ArrayList<Class> listClass = null;

        // creation of the request
        String request = "SELECT * FROM Class where idTeacher = ? ";

        // connection to the database
        connect();

        try {
            pstmt = conn.prepareStatement(request); // Creation of a statement
            pstmt.setInt(1, idTeacher); // add the varaible into the sql request

            rs = pstmt.executeQuery(request); // Execution of the query
            
            listClass = new ArrayList<Class>();
            
            while (rs.next()) {
                newClass = new Class(newTeacher,rs.getString("nameClass"));
                listClass.add(newClass);
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return (listClass);
    }
}
