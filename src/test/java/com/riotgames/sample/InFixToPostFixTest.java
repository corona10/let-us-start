package com.riotgames.sample;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by corona10 on 2017. 4. 2..
 */
public class InFixToPostFixTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public InFixToPostFixTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(InFixToPostFixTest.class);
    }

    public void testInfixToPostFix1() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String[] postfix = {"13", "5", "+"};
        String[] infix = {"13", "+", "5"};
        String[] result = infixToPostFix.getPostFix(infix);
        assertEquals(postfix.length, result.length);
        for (int i = 0; i < postfix.length; i++) {
            assertEquals(postfix[i], result[i]);
        }
    }

    public void testInfixToPostFix2() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String[] infix = {"13", "+", "5", "*", "2"};
        String[] postfix = {"13", "5", "2", "*", "+"};
        String[] result = infixToPostFix.getPostFix(infix);
        assertEquals(postfix.length, result.length);
        for (int i = 0; i < postfix.length; i++) {
            assertEquals(postfix[i], result[i]);
        }
    }

    public void testInfixToPostFix3() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String[] infix = {"13.5", "+", "5", "*", "2", "+", "(", "4", "+", "2", ")"};
        String[] postfix = {"13.5", "5", "2", "*", "4", "2", "+", "+", "+"};
        String[] result = infixToPostFix.getPostFix(infix);
        assertEquals(postfix.length, result.length);
        for (int i = 0; i < postfix.length; i++) {
            assertEquals(postfix[i], result[i]);
        }
    }

    public void testInfixToPostFix4() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String[] infix = {"(", "13", "+", "5", ")", "*", "2", "+", "(", "4", "+", "2", ")"};
        String[] postfix = {"13", "5", "+", "2", "*", "4", "2", "+", "+"};
        String[] result = infixToPostFix.getPostFix(infix);
        assertEquals(postfix.length, result.length);
        for (int i = 0; i < postfix.length; i++) {
            assertEquals(postfix[i], result[i]);
        }
    }

    public void testInfixToPostFix5() {
        InfixToPostFix infixToPostFix = new InfixToPostFix();
        String[] infix = {"(", "1", "+", "2", "*", "3", ")", "/", "5"};
        String[] postfix = {"1", "2", "3", "*", "+", "5", "/"};
        String[] result = infixToPostFix.getPostFix(infix);
        assertEquals(postfix.length, result.length);
        for (int i = 0; i < postfix.length; i++) {
            assertEquals(postfix[i], result[i]);
        }
    }
}
