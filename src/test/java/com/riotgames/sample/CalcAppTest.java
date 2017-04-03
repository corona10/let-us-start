package com.riotgames.sample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.lang.reflect.Method;

/**
 * Unit test for simple CalcApp.
 */
public class CalcAppTest
        extends TestCase {

    private String getPostFixName = "getPostFix";
    private String calculatePostfixName = "calculatePostfix";
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalcAppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CalcAppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() {
        assertTrue(true);
    }

    public void testInfixToPostFix1() {
        CalcApp infixToPostFixCalc = new CalcApp();
        try {
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod(getPostFixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] postfix = {"13", "5", "+"};
            String[] infix = {"13", "+", "5"};
            String[] result = (String[]) m.invoke(infixToPostFixCalc, new Object[]{infix});
            assertEquals(postfix.length, result.length);
            for (int i = 0; i < postfix.length; i++) {
                assertEquals(postfix[i], result[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testInfixToPostFix2() {
        CalcApp infixToPostFixCalc = new CalcApp();
        try {
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod(getPostFixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] infix = {"13", "+", "5", "*", "2"};
            String[] postfix = {"13", "5", "2", "*", "+"};
            String[] result = (String[]) m.invoke(infixToPostFixCalc, new Object[]{infix});
            assertEquals(postfix.length, result.length);
            for (int i = 0; i < postfix.length; i++) {
                assertEquals(postfix[i], result[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testInfixToPostFix3() {
        CalcApp infixToPostFixCalc = new CalcApp();
        try {
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod(getPostFixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] infix = {"13.5", "+", "5", "*", "2", "+", "(", "4", "+", "2", ")"};
            String[] postfix = {"13.5", "5", "2", "*", "4", "2", "+", "+", "+"};
            String[] result = (String[]) m.invoke(infixToPostFixCalc, new Object[]{infix});
            assertEquals(postfix.length, result.length);
            for (int i = 0; i < postfix.length; i++) {
                assertEquals(postfix[i], result[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testInfixToPostFix4() {
        CalcApp infixToPostFixCalc = new CalcApp();
        try {
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod(getPostFixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] infix = {"(", "13", "+", "5", ")", "*", "2", "+", "(", "4", "+", "2", ")"};
            String[] postfix = {"13", "5", "+", "2", "*", "4", "2", "+", "+"};
            String[] result = (String[]) m.invoke(infixToPostFixCalc, new Object[]{infix});
            assertEquals(postfix.length, result.length);
            for (int i = 0; i < postfix.length; i++) {
                assertEquals(postfix[i], result[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testInfixToPostFix5() {
        CalcApp infixToPostFixCalc = new CalcApp();
        try {
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod(getPostFixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] infix = {"(", "1", "+", "2", "*", "3", ")", "/", "5"};
            String[] postfix = {"1", "2", "3", "*", "+", "5", "/"};
            String[] result = (String[]) m.invoke(infixToPostFixCalc, new Object[]{infix});
            assertEquals(postfix.length, result.length);
            for (int i = 0; i < postfix.length; i++) {
                assertEquals(postfix[i], result[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void testcalculatePostfix1(){
        CalcApp calcPostFix = new CalcApp();
        try {
            Method m = calcPostFix.getClass().getDeclaredMethod(calculatePostfixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] postfix = {"15.7","12.2","-"};
            Double correct = 3.5;
            Double result = (Double) m.invoke(calcPostFix, new Object[]{postfix});
            assertEquals(result, correct);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void testcalculatePostfix2(){
        CalcApp calcPostFix = new CalcApp();
        try {
            Method m = calcPostFix.getClass().getDeclaredMethod(calculatePostfixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] postfix =  {"20", "5", "+"};
            Double correct = 25.0;
            Double result = (Double) m.invoke(calcPostFix, new Object[]{postfix});
            assertEquals(result, correct);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void testcalculatePostfix3(){
        CalcApp calcPostFix = new CalcApp();
        try {
            Method m = calcPostFix.getClass().getDeclaredMethod(calculatePostfixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] postfix = {"300", "23", "+", "43", "21", "-", "*", "3", "7", "+", "/"};
            Double correct = 710.6;
            Double result = (Double) m.invoke(calcPostFix, new Object[]{postfix});
            assertEquals(result, correct);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void testcalculatePostfix4(){
        CalcApp calcPostFix = new CalcApp();
        try {
            Method m = calcPostFix.getClass().getDeclaredMethod(calculatePostfixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] postfix = {"3.2", "4", "5", "*", "2", "/","+"};
            Double correct = 13.2;
            Double result = (Double) m.invoke(calcPostFix, new Object[]{postfix});
            assertEquals(result, correct);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void testcalculatePostfix5(){
        CalcApp calcPostFix = new CalcApp();
        try {
            Method m = calcPostFix.getClass().getDeclaredMethod(calculatePostfixName, new Class[]{String[].class});
            m.setAccessible(true);
            String[] postfix = {"20", "5.2", "5", "*", "+"};
            Double correct = 46.0;
            Double result = (Double) m.invoke(calcPostFix, new Object[]{postfix});
            assertEquals(result, correct);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
