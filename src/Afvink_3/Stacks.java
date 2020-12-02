package Afvink_3;

import java.util.Scanner;
import java.util.Stack;

public class Stacks {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.
        System.out.print("Enter a string: ");
        String str = sc.nextLine(); //reads string.
        System.out.println(checker(str));

    }

    public static String checker(String str) {
        Stack<Character> sta = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char next_char = str.charAt(i);

            if (next_char == '}' || next_char == ')' || next_char == ']') {
                char last_char = sta.pop();
                if (last_char == '{' && next_char != '}') {
                    return "{} is niet goed geopend en gesloten";
                } else if (last_char == '(' && next_char != ')') {
                    return "() is niet goed geopend en gesloten";
                } else if (last_char == '[' && next_char != ']') {
                    return "[] is niet goed geopend en gesloten";
                }
            }
            if (next_char == '{' || next_char == '(' || next_char == '[') {
                sta.push(next_char);
            }
        }
        if(sta.empty()) {
            return "Syntax klopt";
        }
        else{
            return "De '" + sta.pop() + "' is niet gesloten";
        }
    }
}
