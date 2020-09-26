/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Hunter
 */
import core.*;
import java.util.*;

/**
 *
 * @author Hunter
 */
public class Connect4TextConsole {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Would you Like to play a computer (C) or another player (P)?");
        Scanner scanning = new Scanner(System.in);
        String input = scanning.nextLine();
        if (input.equalsIgnoreCase("p")) {
            Connect4TextConsole.realPlayer();
        } else if(input.equalsIgnoreCase("c")) {
            Connect4TextConsole.computerPlayer();
        }

    }
    
    /**
     *
     */
    public static void run() {
        System.out.println("Would you Like to play a computer (C) or another player (P)?");
        Scanner scanning = new Scanner(System.in);
        String input = scanning.nextLine();
        if (input.equalsIgnoreCase("p")) {
            Connect4TextConsole.realPlayer();
        } else if(input.equalsIgnoreCase("c")) {
            Connect4TextConsole.computerPlayer();
        }
    }

    /**
     *
     */
    public static void realPlayer() {
        Connect4 game = new Connect4();
        Scanner scan = new Scanner(System.in);
        game.drawBoard();

        while (true) {

            while (true) {

                System.out.println("Player 1, please choose a column...");
                int move = Integer.valueOf(scan.nextLine());
                if (move > 7 || move < 1) {
                    System.out.println("This is not a valid move, please go again");
                    continue;
                }
                if (game.playerOneMove(move) == true) {
                    break;
                }
            }

            game.drawBoard();
            if (game.checkWin() == true) {
                System.out.println("Player 1 wins!");
                break;
            }

            while (true) {

                System.out.println("Player 2, please choose a column...");
                int move = Integer.valueOf(scan.nextLine());
                if (move > 7 || move < 1) {
                    System.out.println("This is not a valid move, please go again");
                    continue;
                }
                if (game.playerTwoMove(move) == true) {
                    break;
                }

            }

            game.drawBoard();
            if (game.checkWin() == true) {
                System.out.println("Player 2 wins!");
                break;
            }

        }

    }

    /**
     *
     */
    public static void computerPlayer() {
        Connect4ComputerPlayer game = new Connect4ComputerPlayer();
        Scanner scan = new Scanner(System.in);
        game.drawBoard();

        while (true) {

            while (true) {

                System.out.println("Player 1, please choose a column...");
                int move = Integer.valueOf(scan.nextLine());
                if (move > 7 || move < 1) {
                    System.out.println("This is not a valid move, please go again");
                    continue;
                }
                if (game.playerOneMove(move) == true) {
                    break;
                }
            }

            game.drawBoard();
            if (game.checkWin() == true) {
                System.out.println("You win!");
                break;
            }

            while (true) {
                System.out.println("Computer's turn...");
                if(game.computerMove() == false) {
                    continue;
                } else {
                    break;
                }

            }

            game.drawBoard();
            if (game.checkWin() == true) {
                System.out.println("The computer wins!");
                break;
            }

        }
    }
}
