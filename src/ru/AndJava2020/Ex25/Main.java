package ru.AndJava2020.Ex25;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        regular("255.234.156.123");
        regular("013.144.124.124");
        regular("-255.213.200.123");
        regular("256.100.100.100");
        regular("putur");
        regular("0262.204.124.124");

        regularBrackets("(3*+*5)*–*9*×*4.");
        regularBrackets("((3*+*5)*–*9*×*4.");
        regularBrackets("(3*+*5)*–*9)*×*4.");
        regularBrackets("(3*+*5)*–*9()*×*4.");
        regularBrackets("(3*+*5)*–*(9()*×*4.");
    }
    public static void regular(String c){
        String regex="^(((25[0-5]|2[0-4][0-9]|[1]?[0-9][0-9]|0)\\.){3}(25[0-5]|2[0-4][0-9]|[1]?[1-9][1-9]|0))";
        Pattern rg=Pattern.compile(regex);


        Matcher mg=rg.matcher(c);
        if(mg.find()) {
            System.out.println(c.substring(mg.start(), mg.end()));
        }
        else{
            System.out.println("error");
        }

    }
    public static void regularBrackets(String c){
        String temp=c;
        Pattern rg=Pattern.compile("\\([^\\(\\)]*\\)");
        Pattern rgMini=Pattern.compile("[^\\(\\)]");
        temp=rgMini.matcher(temp).replaceAll("");

        Matcher mg=rg.matcher(temp);//для скобок
        while (true) {
            if (mg.find()) {
                temp=mg.replaceAll("");
            }
            else{

                if(temp.length()==0) System.out.println(c);
                else{
                    System.out.println("error: "+c);
                }
                return;
            }
        }
    }
}
