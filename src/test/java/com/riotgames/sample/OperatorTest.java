package com.riotgames.sample;

/**
 * Created by corona10 on 2017. 4. 5..
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by corona10 on 2017. 4. 5..
 */
public class OperatorTest extends TestCase {
    public OperatorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(OperatorTest.class);
    }

    public void testOperatorException() {
        boolean failed = false;
        try {
            Operator.findOperator("abcd");
        } catch(RuntimeException ex) {
            failed = true;
        } finally {
            assertEquals(true, failed);
        }
    }

    public void testOperatorEvaluate1() {
        boolean failed = false;
        try {
            Operator op = Operator.findOperator("+");
            double result = op.evaluate(1, 1);
            assertEquals(2.0, result);
        } catch(RuntimeException ex) {
            failed = true;
        } finally {
            assertEquals(false, failed);
        }
    }

    public void testOperatorEvaluate2() {
        boolean failed = false;
        try {
            Operator op = Operator.findOperator("*");
            double result = op.evaluate(3, 4);
            assertEquals(12.0, result);
        } catch(RuntimeException ex) {
            failed = true;
        } finally {
            assertEquals(false, failed);
        }
    }

    public void testOperatorEvaluate3() {
        boolean failed = false;
        try {
            Operator op = Operator.findOperator("/");
            double result = op.evaluate(8, 4);
            assertEquals(2.0, result);
        } catch(RuntimeException ex) {
            failed = true;
        } finally {
            assertEquals(false, failed);
        }
    }

    public void testOperatorEvaluate5() {
        boolean failed = false;
        try {
            Operator op = Operator.findOperator("-");
            double result = op.evaluate(8, 4);
            assertEquals(4.0, result);
        } catch(RuntimeException ex) {
            failed = true;
        } finally {
            assertEquals(false, failed);
        }
    }
}
