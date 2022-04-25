package com.m3.c216.assessment;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private static int tie, win, lose=0;
    private static Random r = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public void play(){
        System.out.println("Rock ('1'), Paper ('2'), or Scissors ('3')?");
        int user_hand = scanner.nextInt();
        int comp_hand = r.nextInt(3)+1;
        if (comp_hand == user_hand){
            System.out.println("Tie!");
            tie++;
        }
        else if ((comp_hand == 1 && user_hand==2) || (comp_hand == 2 && user_hand==3) || (comp_hand == 3 && user_hand==1)){
            System.out.println("You Win!");
            win++;
        }
        else {
            System.out.println("You lose!");
            lose++;
        }
    }

    public static void main(String[] args) {
        String reset_score;
        String play_again;
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the number of rounds you want to play between 1 and 10, inclusive.");
            int input = scanner.nextInt();
            if (input < 1 || input > 10) {
                System.out.println("Error - please enter a number between 1 and 10, inclusive.");
                break;
            } else {
                RockPaperScissors game = new RockPaperScissors();
                for (int x = 0; x < input; x++) {
                    game.play();
                }
                String winner = (win>lose) ? "User. Congratulations!" : (win==lose ? "No winner! It's a Tie!" : "Computer. Better luck next time.");
                System.out.printf("User Wins: %d, Computer Wins: %d, Ties %d %nOverall Winner: %s", win, lose, tie, winner);
                System.out.println("Do you want to play again? 'y' - yes, 'n' - no");
                play_again = scanner.next();
                if (play_again.equals("y")){
                    System.out.println("Do you want to reset the score? 'y' - yes, 'n' - no");
                    reset_score = scanner.next();
                    if (reset_score.equals("y")) {win = 0; lose = 0; tie = 0;}
                }
                else break;
            }
        }
    }
}

