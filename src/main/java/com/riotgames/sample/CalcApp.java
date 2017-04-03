package com.riotgames.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Calculator application
 */
public class CalcApp {

    private Stack<String> stack;
    private ArrayList<String> postfix;

    public CalcApp() {
        this.postfix = new ArrayList<>();
        this.stack = new Stack<>();
    }

    public double calc(String[] tokens) {
        String[] pf = this.getPostFix(tokens);
        return this.calculatePostfix(pf);
    }

    private double calculatePostfix(String[] postfix) {
        return 0.0;
    }

    private String[] getPostFix(String[] infix) {
        this.postfix.clear();
        this.stack.clear();

        for (String in : infix) {
            if (isOperator(in)) {
                if (")".equals(in)) {
                    while (!this.stack.empty() && !"(".equals(this.stack.peek())) {
                        String popOp = this.stack.pop();
                        this.postfix.add(popOp);
                    }

                    if (!this.stack.empty() && "(".equals(this.stack.peek())) {
                        this.stack.pop();
                    }
                } else {
                    while (!this.stack.empty()
                            && !isHigherPrirorty(in, stack.peek())) {
                        String compareOp = this.stack.pop();
                        if (!"(".equals(in)) {
                            postfix.add(compareOp);
                        } else {
                            in = compareOp;
                        }
                    }
                    this.stack.push(in);
                }
            } else if (isNumber(in)) {
                this.postfix.add(in);
            }
        }

        while (!this.stack.empty()) {
            this.postfix.add(this.stack.pop());
        }
        String[] result = new String[this.postfix.size()];
        this.postfix.toArray(result);
        return result;
    }

    private boolean isNumber(String s) {
        String numRegex = "\\d+(\\.\\d*)?|\\.\\d+";
        Pattern p = Pattern.compile(numRegex);
        return p.matcher(s).matches();
    }

    private boolean isOperator(String s) {
        if ("+".equals(s) || "*".equals(s) || "/".equals(s) || "-".equals(s)
                || "(".equals(s) || ")".equals(s)) {
            return true;
        }

        return false;
    }

    private boolean isHigherPrirorty(String op1, String op2) {

        if ("+".equals(op1) || "-".equals(op1)) {
            if ("/".equals(op2) || "*".equals(op2)) {
                return false;
            }
            return true;
        }

        if ("*".equals(op1) || "/".equals(op1)) {
            if ("+".equals(op2) || "-".equals(op2)) {
                return true;
            }
            return false;
        }

        return false;
    }

    public static void main(String[] args) {
        final CalcApp app = new CalcApp();
        final StringBuilder outputs = new StringBuilder();
        Arrays.asList(args).forEach(value -> outputs.append(value).append(" "));
        System.out.print("Addition of values: " + outputs + " = ");
        System.out.println(app.calc(args));
    }
}
