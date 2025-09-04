/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.guessthevibetrivia;

import java.util.Scanner;


/**
 *
 * @author lab_services_student
 */
public class GUESSTHEVIBETRIVIA {

    
    // Question 
    
    static class Question {
        private String questionText;
        private String[] options;
        private int correctAnswer;
        private String category;

        public Question(String questionText, String[] options, int correctAnswer, String category) {
            this.questionText = questionText;
            this.options = options;
            this.correctAnswer = correctAnswer;
            this.category = category;
        }

        public String getQuestionText() { return questionText; }
        public String[] getOptions() { return options; }
        public int getCorrectAnswer() { return correctAnswer; }
        public String getCategory() { return category; }

        public boolean isCorrect(int answer) {
            return answer == correctAnswer;
        }

        public void showQuestion() {
            System.out.println("Category: " + category);
            System.out.println("Question: " + questionText);
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }
        }
    }

    
    // EasyQuestion 
    
    static class EasyQuestion extends Question {
        public EasyQuestion(String questionText, String[] options, int correctAnswer, String category) {
            super(questionText, options, correctAnswer, category);
        }
        public int getPoints() { return 10; }
    }

    
    // HardQuestion (
    
    static class HardQuestion extends Question {
        public HardQuestion(String questionText, String[] options, int correctAnswer, String category) {
            super(questionText, options, correctAnswer, category);
        }
        public int getPoints() { return 20; }
    }

    
    // Player 
    
    static class Player {
        private String name;
        private int score;
        private int questionsAnswered;
        private int correctAnswers;

        public Player(String name) {
            this.name = name;
            this.score = 0;
            this.questionsAnswered = 0;
            this.correctAnswers = 0;
        }

        public String getName() { return name; }
        public int getScore() { return score; }
        public int getQuestionsAnswered() { return questionsAnswered; }
        public int getCorrectAnswers() { return correctAnswers; }

        public void addPoints(int points) { score += points; }
        public void addQuestionAnswered() { questionsAnswered++; }
        public void addCorrectAnswer() { correctAnswers++; }

        public double getPercentage() {
            if (questionsAnswered == 0) return 0;
            return (double) correctAnswers / questionsAnswered * 100;
        }
    }

    
    // QuizGame 
   
    static class QuizGame {
        private Question[] questions;
        private Player player;
        private Scanner input;

        public QuizGame() {
            input = new Scanner(System.in);
            createQuestions();
        }

        private void createQuestions() {
            questions = new Question[15];

            // Singers
            questions[0] = new EasyQuestion("Who sang 'Shape of You'?",
                new String[]{"Bruno Mars", "Ed Sheeran", "Justin Bieber", "Shawn Mendes"}, 2, "Singers");

            questions[1] = new EasyQuestion("Which singer released 'Anti-Hero'?",
                new String[]{"Ariana Grande", "Billie Eilish", "Taylor Swift", "Dua Lipa"}, 3, "Singers");

            questions[2] = new HardQuestion("Which artist won the most Grammy Awards in 2023?",
                new String[]{"Harry Styles", "Beyoncé", "Bad Bunny", "Lizzo"}, 2, "Singers");

            questions[3] = new EasyQuestion("Who is known as 'Queen B'?",
                new String[]{"Rihanna", "Beyoncé", "Ariana Grande", "Lady Gaga"}, 2, "Singers");

            questions[4] = new HardQuestion("What is Billie Eilish's full real name?",
                new String[]{"Billie Eilish Pirate", "Billie Eilish O'Connell", "Billie Eilish Baird O'Connell", "Billie Eilish Smith"}, 3, "Singers");

            // Movies
            questions[5] = new EasyQuestion("Which movie has the song 'Let It Go'?",
                new String[]{"Moana", "Frozen", "Tangled", "Encanto"}, 2, "Movies");

            questions[6] = new EasyQuestion("Who plays Spider-Man in recent movies?",
                new String[]{"Tobey Maguire", "Andrew Garfield", "Tom Holland", "Miles Morales"}, 3, "Movies");

            questions[7] = new HardQuestion("Which movie won Best Picture in 2022?",
                new String[]{"Dune", "CODA", "The Power of the Dog", "West Side Story"}, 2, "Movies");

            questions[8] = new EasyQuestion("Which movie has 'We Don't Talk About Bruno'?",
                new String[]{"Moana", "Coco", "Encanto", "Frozen 2"}, 3, "Movies");

            questions[9] = new HardQuestion("Who directed 'Everything Everywhere All at Once'?",
                new String[]{"Christopher Nolan", "Denis Villeneuve", "Daniels", "Jordan Peele"}, 3, "Movies");

            // TikTok Trends
            questions[10] = new EasyQuestion("What does POV mean on TikTok?",
                new String[]{"Point of View", "Power of Voice", "Part of Video", "Piece of Victory"}, 1, "TikTok Trends");

            questions[11] = new EasyQuestion("Which dance went viral on TikTok in 2019?",
                new String[]{"Floss", "Renegade", "Orange Justice", "Default Dance"}, 2, "TikTok Trends");

            questions[12] = new HardQuestion("Who was first to reach 100 million TikTok followers?",
                new String[]{"Addison Rae", "Charli D'Amelio", "Bella Poarch", "Zach King"}, 2, "TikTok Trends");

            questions[13] = new EasyQuestion("What is the maximum TikTok video length?",
                new String[]{"30 seconds", "1 minute", "3 minutes", "10 minutes"}, 4, "TikTok Trends");

            questions[14] = new HardQuestion("What does FYP mean on TikTok?",
                new String[]{"For Your Page", "Find Your People", "Follow Your Passion", "For You Page"}, 4, "TikTok Trends");
        }

        public void start() {
            System.out.println("=== QUIZ GAME ===");
            System.out.print("Enter your name: ");
            String name = input.nextLine();
            player = new Player(name);

            System.out.println("Hello " + name + "!");

            while (true) {
                showMenu();
                int choice = getChoice();

                if (choice == 1) playQuiz();
                else if (choice == 2) showRules();
                else if (choice == 3) {
                    System.out.println("Thanks for playing! Goodbye " + name + "!");
                    break;
                } else {
                    System.out.println("Please choose 1, 2, or 3");
                }
            }
        }

        private void showMenu() {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Play Quiz");
            System.out.println("2. Show Rules");
            System.out.println("3. Exit Game");
        }

        private int getChoice() {
            System.out.print("Choose option (1-3): ");
            try {
                int choice = input.nextInt();
                input.nextLine();
                return choice;
            } catch (Exception e) {
                System.out.println("Please enter a valid number!");
                input.nextLine();
                return 0;
            }
        }

        private void showRules() {
            System.out.println("\n--- GAME RULES ---");
            System.out.println("* Categories: Singers, Movies, TikTok Trends");
            System.out.println("* Easy questions = 10 points");
            System.out.println("* Hard questions = 20 points");
            System.out.println("* Answer 1, 2, 3, or 4");
            System.out.println("* Get a report at the end");
            System.out.print("Press Enter to continue...");
            input.nextLine();
        }

        private void playQuiz() {
            System.out.println("\n--- STARTING QUIZ ---");
            System.out.print("How many questions? (1-15): ");
            int numQuestions = input.nextInt();
            input.nextLine();

            if (numQuestions > 15) numQuestions = 15;
            if (numQuestions < 1) numQuestions = 1;

            for (int i = 0; i < numQuestions; i++) {
                System.out.println("\n--- Question " + (i + 1) + " ---");
                askQuestion(questions[i]);
            }

            showReport();
        }

        private void askQuestion(Question q) {
            q.showQuestion();
            System.out.print("Your answer (1-4): ");

            try {
                int answer = input.nextInt();
                input.nextLine();
                player.addQuestionAnswered();

                if (q.isCorrect(answer)) {
                    System.out.println("Correct!");
                    player.addCorrectAnswer();

                    if (q instanceof EasyQuestion) {
                        player.addPoints(((EasyQuestion) q).getPoints());
                        System.out.println("You got 10 points!");
                    } else if (q instanceof HardQuestion) {
                        player.addPoints(((HardQuestion) q).getPoints());
                        System.out.println("You got 20 points!");
                    }
                } else {
                    System.out.println("Wrong! The answer was: " + q.getOptions()[q.getCorrectAnswer() - 1]);
                }
            } catch (Exception e) {
                System.out.println("Invalid input! Moving to next question...");
                input.nextLine();
                player.addQuestionAnswered();
            }
        }

        private void showReport() {
            System.out.println("\n=== QUIZ RESULTS ===");
            System.out.println("Player: " + player.getName());
            System.out.println("Total Score: " + player.getScore() + " points");
            System.out.println("Questions Answered: " + player.getQuestionsAnswered());
            System.out.println("Correct Answers: " + player.getCorrectAnswers());
            System.out.printf("Percentage: %.1f%%\n", player.getPercentage());

            double percentage = player.getPercentage();
            if (percentage >= 80) System.out.println("Rating: Excellent!");
            else if (percentage >= 60) System.out.println("Rating: Good!");
            else System.out.println("Rating: Keep practicing!");

            System.out.println("\nPress Enter to return to main menu...");
            input.nextLine();
        }
    }

   
    // Main Method
    
    public static void main(String[] args) {
        QuizGame game = new QuizGame();
        game.start();
    }
}



// This program is a console-based quiz game called Guess the Vibe Trivia.  
// It tests the player with questions from singers, movies, and TikTok trends.  
  // The EasyQuestion and HardQuestion classes give different points for answers.  
// The Player class keeps track of the player’s name, score, and results.  
// The QuizGame class runs the game by showing a menu, asking questions, and giving feedback.  
// At the end, it displays the player’s total score, percentage, and rating.  
