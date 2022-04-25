package com.m3.c216.assessment;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    private int rounds;
    private static int tie=0;
    private static int win=0;
    private static int lose=0;
    private static Random r = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

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
        String play_again = "y";
        Scanner scanner = new Scanner(System.in);
        while (play_again.equals("y")) {
            System.out.println("Enter the number of rounds you want to play between 1 and 10, inclusive.");
            int input = scanner.nextInt();
            if (input < 1 || input > 10) {
                System.out.println("Error - please enter a number between 1 and 10, inclusive.");
                break;
            } else {
                RockPaperScissors game = new RockPaperScissors();
                game.setRounds(input); // setter method
                for (int x = 0; x < input; x++) {
                    game.play();
                }
                String winner = (win>lose) ? "User! Congratulations!" : "Computer! Better luck next time.";
                System.out.printf("User Wins: %d, Computer Wins: %d, Ties %d %nOverall Winner: %s", win, lose, tie, winner);
                System.out.println("\ndo you want to play again? 'y' - yes, 'n' - no");
                play_again = scanner.next();
            }
        }
    }
}
