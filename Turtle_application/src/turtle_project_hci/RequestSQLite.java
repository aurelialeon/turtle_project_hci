package turtle_project_hci;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

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
            String url = "jdbc:sqlite:C:/sqlite/gui/gp4_Turtleproject.db";
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
     * Return the list of the pupils for a class selected by its id
     * @param idClass
     * @return listPupils
     */
    public ArrayList<Pupil> FetchPupilByClass (String nameClass) {
        ArrayList<Pupil> listPupils; 
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Pupil newPupil = null;
        
        listPupils = new ArrayList<Pupil>();
        String request = "SELECT namePupil, firstNamePupil FROM Pupil WHERE nameClass = ?";
        
        connect();
        
        try {
            pstmt = conn.prepareStatement(request);
            pstmt.setString(1, nameClass);
            rs = pstmt.executeQuery();
            
            while (rs.next()) {
                newPupil = new Pupil (rs.getString("namePupil"),rs.getString("firstNamePupil"));
                listPupils.add(newPupil);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return(listPupils);
    }
    
    /**
     * fetch the teacher's password in the database using his id
     * @param idTeacher
     * @return password
     */
    public String fetchPassword (int idTeacher) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String pwd = null;
        
        String request = "SELECT passwordTeacher FROM Teacher WHERE idTeacher = ?";
        
        connect(); 
        
        try {
            pstmt = conn.prepareStatement(request);
            pstmt.setInt(1, idTeacher);
            rs = pstmt.executeQuery();
            
            rs.next();
            pwd = rs.getString("passwordTeacher");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        
        return(pwd);
    }
    
    /**
     * fetch the teacher's password using his login
     * @param loginTeacher
     * @return password
     */
    public String fetchPassword (String loginTeacher) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String pwd = null;
        
        String request = "SELECT passwordTeacher FROM Teacher WHERE loginTeacher = ?";
        
        connect();
        
        try {
            pstmt = conn.prepareStatement(request);
            pstmt.setString(1, loginTeacher);
            rs = pstmt.executeQuery();
            
            rs.next();
            pwd = rs.getString("passwordTeacher");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            deconnect();
        }
        return(pwd);
    }
    
    
}
