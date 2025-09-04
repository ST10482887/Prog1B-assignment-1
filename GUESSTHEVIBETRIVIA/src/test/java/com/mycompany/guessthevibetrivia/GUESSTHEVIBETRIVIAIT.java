/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.guessthevibetrivia;

import com.mycompany.guessthevibetrivia.GUESSTHEVIBETRIVIA.EasyQuestion;
import com.mycompany.guessthevibetrivia.GUESSTHEVIBETRIVIA.Player;
import com.mycompany.guessthevibetrivia.GUESSTHEVIBETRIVIA.Question;

public class  GUESSTHEVIBETRIVIAIT {
    public static void main(String[] args) {
        System.out.println(" Running Simple Tests ");

      
        Question q1 = new EasyQuestion(
            "What is 2+2?", new String[]{"3", "4", "5"}, 2, "Math"
        );
        assertTest("Question correctness", q1.isCorrect(2));

        
        Player p = new Player("Tester");
        p.addPoints(10);
        assertTest("Player score update", p.getScore() == 10);

 
        p.addQuestionAnswered();
        p.addCorrectAnswer();
        assertTest("Player percentage calc", Math.abs(p.getPercentage() - 100.0) < 0.01);

        System.out.println("=== Tests Completed ===");
    }

    private static void assertTest(String testName, boolean condition) {
        if (condition) {
            System.out.println("[PASS] " + testName);
        } else {
            System.out.println("[FAIL] " + testName);
        }
    }
}
