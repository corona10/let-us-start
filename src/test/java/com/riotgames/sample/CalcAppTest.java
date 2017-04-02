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
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod("getPostFix", new Class[]{String[].class});
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
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod("getPostFix", new Class[]{String[].class});
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
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod("getPostFix", new Class[]{String[].class});
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
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod("getPostFix", new Class[]{String[].class});
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
            Method m = infixToPostFixCalc.getClass().getDeclaredMethod("getPostFix", new Class[]{String[].class});
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
}
