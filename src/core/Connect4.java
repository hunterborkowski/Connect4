/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Hunter
 */

import javafx.scene.paint.Color;
/**
 *
 * @author Hunter
 */
public class Connect4 {

    private String[][] board;
    private int x;
    private int y;
    private int counter;

    //Constructor: Creates matrix 

    /**
     *
     */
    public Connect4() {
        board = new String[6][7];
        for (int m = 0; m <= 5; m++) {
            for (int n = 0; n <= 6; n++) {
                board[m][n] = " ";
            }
        }

        x = 0;
        y = 0;
    }

    //Displays Connect 4 game

    /**
     * Draws current board surrounded with borders
     * 
     */
    public void drawBoard() {
        System.out.println("---------------");
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("---------------");
        
        //Loops through matrix and places walls around each location
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= 6; j++) {
                System.out.print("|" + board[i][j]);
            }
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("---------------");
    }
    //Takes location input and finds bottom-most empty cell in that row

    /**
     * Takes location input and finds bottom-most empty cell in that row
     * @param space int
     * @return Boolean
     */
    public Boolean playerOneMove(int space) {
        int location = space - 1;

        if (!board[5][location].equals(" ")) {
            if (!board[4][location].equals(" ")) {
                if (!board[3][location].equals(" ")) {
                    if (!board[2][location].equals(" ")) {
                        if (!board[1][location].equals(" ")) {
                            if (!board[0][location].equals(" ")) {
                                //If no cells are empty in the column, message is returned
                                System.out.println("This column is full! Pick again...");
                                return false;
                            } else {
                                board[0][location] = "X";
                                x = location;
                                y = 0;
                                counter++;
                                return true;
                            }
                        } else {
                            board[1][location] = "X";
                            x = location;
                            y = 1;
                            counter++;
                            return true;
                        }
                    } else {
                        board[2][location] = "X";
                        x = location;
                        y = 2;
                        counter++;
                        return true;
                    }
                } else {
                    board[3][location] = "X";
                    x = location;
                    y = 3;
                    counter++;
                    return true;
                }
            } else {
                board[4][location] = "X";
                x = location;
                y = 4;
                counter++;
                return true;
            }
        } else {
            board[5][location] = "X";
            x = location;
            y = 5;
            counter++;
            return true;
        }

    }

    /**
     *Takes location input and finds bottom-most empty cell in that row
     * @param space int
     * @return Boolean
     */
    public Boolean playerTwoMove(int space) {
        int location = space - 1;

        if (!board[5][location].equals(" ")) {
            if (!board[4][location].equals(" ")) {
                if (!board[3][location].equals(" ")) {
                    if (!board[2][location].equals(" ")) {
                        if (!board[1][location].equals(" ")) {
                            if (!board[0][location].equals(" ")) {
                                System.out.println("This column is full! Pick again...");
                                return false;
                            } else {
                                board[0][location] = "O";
                                x = location;
                                y = 0;
                                counter++;
                                return true;
                            }
                        } else {
                            board[1][location] = "O";
                            x = location;
                            y = 1;
                            counter++;
                            return true;
                        }
                    } else {
                        board[2][location] = "O";
                        x = location;
                        y = 2;
                        counter++;
                        return true;
                    }
                } else {
                    board[3][location] = "O";
                    x = location;
                    y = 3;
                    counter++;
                    return true;
                }
            } else {
                board[4][location] = "O";
                x = location;
                y = 4;
                counter++;
                return true;
            }
        } else {
            board[5][location] = "O";
            x = location;
            y = 5;
            counter++;
            return true;
        }
    }

    /**
     * Checks for horizontal, vertical, and diagonal wins
     * @return Boolean
     */
    public Boolean checkWin() {
        int count = 0;

        //Horizontal Check
         for (int i = 0; i < 7; i++) {
            if (board[y][i].equals(board[y][x])) {
                count++;
                if (count >= 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        count = 0;

        //Vertical Check
        for (int j = 0; j < 6; j++) {
            if (board[j][x].equals(board[y][x])) {
                count++;
                if (count >= 4) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        
        count = 0;

        //Diagonal Down & Right Check (Left Portion)
        for (int roww = 0; roww < 6; roww++) {
            for (int col = 0, row = roww; row < 6 && col < 7; row++, col++) {
                if (board[row][col].equals(board[y][x])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }

        //Diagonal Down & Right Check (Right Portion)
        for (int coll = 0; coll < 7; coll++) {
            for (int col = coll, row = 0; col < 7 && row < 6; col++, row++) {
                if (board[row][col].equals(board[y][x])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }

        //Diagonal Up & Right Check (Left Portion)
        for (int roww = 5; roww > -1; roww--) {
            for (int col = 0, row = roww; col < 7 && row > -1; col++, row--) {
                if (board[row][col].equals(board[y][x])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }

        //Diagonal Up & Right Check (Right Portion) 
        for (int coll = 0; coll > -1; coll++) {
            for (int col = coll, row = 5; col < 7 && row > -1; col++, row--) {
                if (board[row][col].equals(board[y][x])) {
                    count++;
                    if (count == 4) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
            count = 0;
        }
        return false;

    }
    
    /**
     *
     * @return
     */
    public int returnY() {
        return (this.y+1);
    }
    
    /**
     *
     * @return
     */
    public boolean getColor() {
        if (counter % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
    
    
    
    

}
