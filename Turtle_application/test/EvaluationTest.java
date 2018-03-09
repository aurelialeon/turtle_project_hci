/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import turtle_project_hci.Teacher;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author manonsacre
 */
public class EvaluationTest {
    
    public EvaluationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getGrade method, of class Evaluation.
     */
    @Test
    public void testGetGrade() {
        System.out.println("getGrade");
        Evaluation instance = null;
        Grade expResult = null;
        Grade result = instance.getGrade();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGrade method, of class Evaluation.
     */
    @Test
    public void testSetGrade() {
        System.out.println("setGrade");
        Grade grade = null;
        Evaluation instance = null;
        instance.setGrade(grade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getComment method, of class Evaluation.
     */
    @Test
    public void testGetComment() {
        System.out.println("getComment");
        Evaluation instance = null;
        String expResult = "";
        String result = instance.getComment();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setComment method, of class Evaluation.
     */
    @Test
    public void testSetComment() {
        System.out.println("setComment");
        String comment = "";
        Evaluation instance = null;
        instance.setComment(comment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAtt method, of class Evaluation.
     */
    @Test
    public void testGetAtt() {
        System.out.println("getAtt");
        Evaluation instance = null;
        Attempt expResult = null;
        Attempt result = instance.getAtt();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTeacher method, of class Evaluation.
     */
    @Test
    public void testGetTeacher() {
        System.out.println("getTeacher");
        Evaluation instance = null;
        Teacher expResult = null;
        Teacher result = instance.getTeacher();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
