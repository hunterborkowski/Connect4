/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.Background;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import core.*;
import javafx.geometry.Insets;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Hunter
 */
public class Connect4GUI extends Application {

    /**
     * Takes user input to select GUI or Console; if GUI then asks for PvP or
     * PvC
     *
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to play with GUI(G) or Console(C)?");
        String input = scan.nextLine();
        if (input.equalsIgnoreCase("g")) {
            System.out.println("Press P for player game or C for Computer game:");
            input = scan.nextLine();
            if (input.equalsIgnoreCase("P")) {
                playPlayer(primaryStage);
            } else {
                playComputer(primaryStage);
            }
        } else if (input.equalsIgnoreCase("c")) {
            Connect4TextConsole.run();
        }
    }

    /**
     * Popup window for PVP game containing two buttons, reset and exit
     *
     * @param game
     * @param primaryStage
     */
    public void popup(Connect4 game, Stage primaryStage) {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Winner!");
        Label label1;

        if (game.getColor() == true) {
            label1 = new Label("Player 1 Wins!");
        } else {
            label1 = new Label("Player 2 Wins!");
        }
        Button button1 = new Button("Close Game");
        Button button2 = new Button("New Game");

        button1.setOnAction(e -> {
            primaryStage.close();
            popupwindow.close();
        });

        button2.setOnAction(e -> {
            primaryStage.close();
            popupwindow.close();
            primaryStage.close();
            playPlayer(primaryStage);
        });

        VBox layout = new VBox(10);

        layout.getChildren().addAll(label1, button1, button2);

        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();
    }

    /**
     * Popup window for PvC game containing two buttons, reset and exit
     *
     * @param game
     * @param primaryStage
     */
    public void popup(Connect4ComputerPlayer game, Stage primaryStage) {
        Stage popupwindow = new Stage();

        popupwindow.initModality(Modality.APPLICATION_MODAL);
        popupwindow.setTitle("Winner!");
        Label label1;

        if (game.getColor() == true) {
            label1 = new Label("Player 1 Wins!");
        } else {
            label1 = new Label("Computer Wins!");
        }
        Button button1 = new Button("Close Game");
        Button button2 = new Button("New Game");

        button1.setOnAction(e -> {
            primaryStage.close();
            popupwindow.close();
        });

        button2.setOnAction(e -> {
            primaryStage.close();
            popupwindow.close();
            primaryStage.close();
            playComputer(primaryStage);
        });

        VBox layout = new VBox(10);

        layout.getChildren().addAll(label1, button1, button2);

        layout.setAlignment(Pos.CENTER);

        Scene scene1 = new Scene(layout, 300, 250);

        popupwindow.setScene(scene1);

        popupwindow.showAndWait();
    }

    /**
     * Gets boolean from Connect4.java for PvP game
     *
     * @param game
     * @return
     */
    public boolean whosTurn(Connect4 game) {
        if (game.getColor() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Gets boolean from Connect4ComputerPlayer.java for PvC game
     *
     * @param game
     * @return
     */
    public boolean whosTurn(Connect4ComputerPlayer game) {
        if (game.getColor() == false) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Draws a colored circle in the correct position for PvP game
     *
     * @param xLocation
     * @param game
     * @return
     */
    public Circle drawCircle(int xLocation, Connect4 game) {
        int locationX = xLocation;
        if (whosTurn(game) == true) {
            game.playerOneMove(locationX);
        } else {
            game.playerTwoMove(locationX);
        }

        int locationY = game.returnY();
        int circleX = 0;
        int circleY = 0;
        Color color;

        if (game.getColor() == true) {
            color = Color.RED;
        } else {
            color = Color.YELLOW;
        }

        if (locationX == 1) {
            circleX = 75;
        }
        if (locationX == 2) {
            circleX = 200;
        }
        if (locationX == 3) {
            circleX = 325;
        }
        if (locationX == 4) {
            circleX = 450;
        }
        if (locationX == 5) {
            circleX = 575;
        }
        if (locationX == 6) {
            circleX = 700;
        }
        if (locationX == 7) {
            circleX = 825;
        }
        if (locationY == 1) {
            circleY = 75;
        }
        if (locationY == 2) {
            circleY = 200;
        }
        if (locationY == 3) {
            circleY = 325;
        }
        if (locationY == 4) {
            circleY = 450;
        }
        if (locationY == 5) {
            circleY = 575;
        }
        if (locationY == 6) {
            circleY = 700;
        }

        Circle move = new Circle(circleX, circleY, 50, color);

        return move;

    }

    /**
     * Draws a colored circle in the correct position for player 1 in PvC game
     *
     * @param xLocation
     * @param game
     * @return
     */
    public Circle drawCircle(int xLocation, Connect4ComputerPlayer game) {
        int locationX = xLocation;

        game.playerOneMove(locationX);

        int locationY = game.returnY();
        int circleX = 0;
        int circleY = 0;
        Color color;

        if (game.getColor() == true) {
            color = Color.RED;
        } else {
            color = Color.YELLOW;
        }

        if (locationX == 1) {
            circleX = 75;
        }
        if (locationX == 2) {
            circleX = 200;
        }
        if (locationX == 3) {
            circleX = 325;
        }
        if (locationX == 4) {
            circleX = 450;
        }
        if (locationX == 5) {
            circleX = 575;
        }
        if (locationX == 6) {
            circleX = 700;
        }
        if (locationX == 7) {
            circleX = 825;
        }
        if (locationY == 1) {
            circleY = 75;
        }
        if (locationY == 2) {
            circleY = 200;
        }
        if (locationY == 3) {
            circleY = 325;
        }
        if (locationY == 4) {
            circleY = 450;
        }
        if (locationY == 5) {
            circleY = 575;
        }
        if (locationY == 6) {
            circleY = 700;
        }

        Circle move = new Circle(circleX, circleY, 50, color);

        return move;

    }

    /**
     * Draws a colored circle in the correct position for computer in PvC game
     *
     * @param game
     * @return
     */
    public Circle drawCircle(Connect4ComputerPlayer game) {

        game.computerMove();
        int xLocation = game.returnX();

        int locationY = game.returnY();
        int circleX = 0;
        int circleY = 0;
        Color color;

        if (game.getColor() == true) {
            color = Color.RED;
        } else {
            color = Color.YELLOW;
        }

        if (xLocation == 1) {
            circleX = 75;
        }
        if (xLocation == 2) {
            circleX = 200;
        }
        if (xLocation == 3) {
            circleX = 325;
        }
        if (xLocation == 4) {
            circleX = 450;
        }
        if (xLocation == 5) {
            circleX = 575;
        }
        if (xLocation == 6) {
            circleX = 700;
        }
        if (xLocation == 7) {
            circleX = 825;
        }
        if (locationY == 1) {
            circleY = 75;
        }
        if (locationY == 2) {
            circleY = 200;
        }
        if (locationY == 3) {
            circleY = 325;
        }
        if (locationY == 4) {
            circleY = 450;
        }
        if (locationY == 5) {
            circleY = 575;
        }
        if (locationY == 6) {
            circleY = 700;
        }

        Circle move = new Circle(circleX, circleY, 50, color);

        return move;

    }

    /**
     * Draws board and contains GUI elements for PvP game
     *
     * @param primaryStage
     */
    public void playPlayer(Stage primaryStage) {
        Connect4 game = new Connect4();

        Pane root = new Pane();
        Circle r1c1 = new Circle(75.0f, 75.0f, 50.0f);
        Circle r1c2 = new Circle(200, 75, 50);
        Circle r1c3 = new Circle(325, 75, 50);
        Circle r1c4 = new Circle(450, 75, 50);
        Circle r1c5 = new Circle(575, 75, 50);
        Circle r1c6 = new Circle(700, 75, 50);
        Circle r1c7 = new Circle(825, 75, 50);
        Circle r2c1 = new Circle(75, 200, 50);
        Circle r2c2 = new Circle(200, 200, 50);
        Circle r2c3 = new Circle(325, 200, 50);
        Circle r2c4 = new Circle(450, 200, 50);
        Circle r2c5 = new Circle(575, 200, 50);
        Circle r2c6 = new Circle(700, 200, 50);
        Circle r2c7 = new Circle(825, 200, 50);
        Circle r3c1 = new Circle(75.0f, 325.0f, 50.0f);
        Circle r3c2 = new Circle(200, 325, 50);
        Circle r3c3 = new Circle(325, 325, 50);
        Circle r3c4 = new Circle(450, 325, 50);
        Circle r3c5 = new Circle(575, 325, 50);
        Circle r3c6 = new Circle(700, 325, 50);
        Circle r3c7 = new Circle(825, 325, 50);
        Circle r4c1 = new Circle(75, 450, 50);
        Circle r4c2 = new Circle(200, 450, 50);
        Circle r4c3 = new Circle(325, 450, 50);
        Circle r4c4 = new Circle(450, 450, 50);
        Circle r4c5 = new Circle(575, 450, 50);
        Circle r4c6 = new Circle(700, 450, 50);
        Circle r4c7 = new Circle(825, 450, 50);
        Circle r5c1 = new Circle(75.0f, 575, 50.0f);
        Circle r5c2 = new Circle(200, 575, 50);
        Circle r5c3 = new Circle(325, 575, 50);
        Circle r5c4 = new Circle(450, 575, 50);
        Circle r5c5 = new Circle(575, 575, 50);
        Circle r5c6 = new Circle(700, 575, 50);
        Circle r5c7 = new Circle(825, 575, 50);
        Circle r6c1 = new Circle(75, 700, 50);
        Circle r6c2 = new Circle(200, 700, 50);
        Circle r6c3 = new Circle(325, 700, 50);
        Circle r6c4 = new Circle(450, 700, 50);
        Circle r6c5 = new Circle(575, 700, 50);
        Circle r6c6 = new Circle(700, 700, 50);
        Circle r6c7 = new Circle(825, 700, 50);

        Rectangle rect1 = new Rectangle(25, 25, 100, 750);
        rect1.setFill(Color.TRANSPARENT);

        rect1.setOnMouseEntered(e -> rect1.setFill(Color.rgb(200, 200, 50, .3)));
        rect1.setOnMouseExited(e -> rect1.setFill(Color.TRANSPARENT));

        rect1.setOnMouseClicked(e -> {
            int xLocation = 1;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect2 = new Rectangle(150, 25, 100, 750);
        rect2.setFill(Color.TRANSPARENT);

        rect2.setOnMouseEntered(e -> rect2.setFill(Color.rgb(200, 200, 50, .3)));
        rect2.setOnMouseExited(e -> rect2.setFill(Color.TRANSPARENT));

        rect2.setOnMouseClicked(e -> {
            int xLocation = 2;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect3 = new Rectangle(275, 25, 100, 750);
        rect3.setFill(Color.TRANSPARENT);

        rect3.setOnMouseEntered(e -> rect3.setFill(Color.rgb(200, 200, 50, .3)));
        rect3.setOnMouseExited(e -> rect3.setFill(Color.TRANSPARENT));

        rect3.setOnMouseClicked(e -> {
            int xLocation = 3;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect4 = new Rectangle(400, 25, 100, 750);
        rect4.setFill(Color.TRANSPARENT);

        rect4.setOnMouseEntered(e -> rect4.setFill(Color.rgb(200, 200, 50, .3)));
        rect4.setOnMouseExited(e -> rect4.setFill(Color.TRANSPARENT));

        rect4.setOnMouseClicked(e -> {
            int xLocation = 4;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect5 = new Rectangle(525, 25, 100, 750);
        rect5.setFill(Color.TRANSPARENT);

        rect5.setOnMouseEntered(e -> rect5.setFill(Color.rgb(200, 200, 50, .3)));
        rect5.setOnMouseExited(e -> rect5.setFill(Color.TRANSPARENT));

        rect5.setOnMouseClicked(e -> {
            int xLocation = 5;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect6 = new Rectangle(650, 25, 100, 750);
        rect6.setFill(Color.TRANSPARENT);

        rect6.setOnMouseEntered(e -> rect6.setFill(Color.rgb(200, 200, 50, .3)));
        rect6.setOnMouseExited(e -> rect6.setFill(Color.TRANSPARENT));

        rect6.setOnMouseClicked(e -> {
            int xLocation = 6;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect7 = new Rectangle(775, 25, 100, 750);
        rect7.setFill(Color.TRANSPARENT);

        rect7.setOnMouseEntered(e -> rect7.setFill(Color.rgb(200, 200, 50, .3)));
        rect7.setOnMouseExited(e -> rect7.setFill(Color.TRANSPARENT));

        rect7.setOnMouseClicked(e -> {
            int xLocation = 7;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        //root.getChildren().add(btn);
        root.getChildren().add(r1c1);
        root.getChildren().add(r1c2);
        root.getChildren().add(r1c3);
        root.getChildren().add(r1c4);
        root.getChildren().add(r1c5);
        root.getChildren().add(r1c6);
        root.getChildren().add(r1c7);
        root.getChildren().add(r2c1);
        root.getChildren().add(r2c2);
        root.getChildren().add(r2c3);
        root.getChildren().add(r2c4);
        root.getChildren().add(r2c5);
        root.getChildren().add(r2c6);
        root.getChildren().add(r2c7);
        root.getChildren().add(r3c1);
        root.getChildren().add(r3c2);
        root.getChildren().add(r3c3);
        root.getChildren().add(r3c4);
        root.getChildren().add(r3c5);
        root.getChildren().add(r3c6);
        root.getChildren().add(r3c7);
        root.getChildren().add(r4c1);
        root.getChildren().add(r4c2);
        root.getChildren().add(r4c3);
        root.getChildren().add(r4c4);
        root.getChildren().add(r4c5);
        root.getChildren().add(r4c6);
        root.getChildren().add(r4c7);
        root.getChildren().add(r5c1);
        root.getChildren().add(r5c2);
        root.getChildren().add(r5c3);
        root.getChildren().add(r5c4);
        root.getChildren().add(r5c5);
        root.getChildren().add(r5c6);
        root.getChildren().add(r5c7);
        root.getChildren().add(r6c1);
        root.getChildren().add(r6c2);
        root.getChildren().add(r6c3);
        root.getChildren().add(r6c4);
        root.getChildren().add(r6c5);
        root.getChildren().add(r6c6);
        root.getChildren().add(r6c7);
        root.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        root.getChildren().add(rect1);
        root.getChildren().add(rect2);
        root.getChildren().add(rect3);
        root.getChildren().add(rect4);
        root.getChildren().add(rect5);
        root.getChildren().add(rect6);
        root.getChildren().add(rect7);

        Scene scene = new Scene(root, 900, 775);

        primaryStage.setTitle("Connect4 FX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Draws board and contains GUI elements for PvC game
     *
     * @param primaryStage
     */
    public void playComputer(Stage primaryStage) {
        Connect4ComputerPlayer game = new Connect4ComputerPlayer();

        Pane root = new Pane();
        Circle r1c1 = new Circle(75.0f, 75.0f, 50.0f);
        Circle r1c2 = new Circle(200, 75, 50);
        Circle r1c3 = new Circle(325, 75, 50);
        Circle r1c4 = new Circle(450, 75, 50);
        Circle r1c5 = new Circle(575, 75, 50);
        Circle r1c6 = new Circle(700, 75, 50);
        Circle r1c7 = new Circle(825, 75, 50);
        Circle r2c1 = new Circle(75, 200, 50);
        Circle r2c2 = new Circle(200, 200, 50);
        Circle r2c3 = new Circle(325, 200, 50);
        Circle r2c4 = new Circle(450, 200, 50);
        Circle r2c5 = new Circle(575, 200, 50);
        Circle r2c6 = new Circle(700, 200, 50);
        Circle r2c7 = new Circle(825, 200, 50);
        Circle r3c1 = new Circle(75.0f, 325.0f, 50.0f);
        Circle r3c2 = new Circle(200, 325, 50);
        Circle r3c3 = new Circle(325, 325, 50);
        Circle r3c4 = new Circle(450, 325, 50);
        Circle r3c5 = new Circle(575, 325, 50);
        Circle r3c6 = new Circle(700, 325, 50);
        Circle r3c7 = new Circle(825, 325, 50);
        Circle r4c1 = new Circle(75, 450, 50);
        Circle r4c2 = new Circle(200, 450, 50);
        Circle r4c3 = new Circle(325, 450, 50);
        Circle r4c4 = new Circle(450, 450, 50);
        Circle r4c5 = new Circle(575, 450, 50);
        Circle r4c6 = new Circle(700, 450, 50);
        Circle r4c7 = new Circle(825, 450, 50);
        Circle r5c1 = new Circle(75.0f, 575, 50.0f);
        Circle r5c2 = new Circle(200, 575, 50);
        Circle r5c3 = new Circle(325, 575, 50);
        Circle r5c4 = new Circle(450, 575, 50);
        Circle r5c5 = new Circle(575, 575, 50);
        Circle r5c6 = new Circle(700, 575, 50);
        Circle r5c7 = new Circle(825, 575, 50);
        Circle r6c1 = new Circle(75, 700, 50);
        Circle r6c2 = new Circle(200, 700, 50);
        Circle r6c3 = new Circle(325, 700, 50);
        Circle r6c4 = new Circle(450, 700, 50);
        Circle r6c5 = new Circle(575, 700, 50);
        Circle r6c6 = new Circle(700, 700, 50);
        Circle r6c7 = new Circle(825, 700, 50);

        Rectangle rect1 = new Rectangle(25, 25, 100, 750);
        rect1.setFill(Color.TRANSPARENT);

        rect1.setOnMouseEntered(e -> rect1.setFill(Color.rgb(200, 200, 50, .3)));
        rect1.setOnMouseExited(e -> rect1.setFill(Color.TRANSPARENT));

        rect1.setOnMouseClicked(e -> {
            int xLocation = 1;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
            
            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect2 = new Rectangle(150, 25, 100, 750);
        rect2.setFill(Color.TRANSPARENT);

        rect2.setOnMouseEntered(e -> rect2.setFill(Color.rgb(200, 200, 50, .3)));
        rect2.setOnMouseExited(e -> rect2.setFill(Color.TRANSPARENT));

        rect2.setOnMouseClicked(e -> {
            int xLocation = 2;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }

            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect3 = new Rectangle(275, 25, 100, 750);
        rect3.setFill(Color.TRANSPARENT);

        rect3.setOnMouseEntered(e -> rect3.setFill(Color.rgb(200, 200, 50, .3)));
        rect3.setOnMouseExited(e -> rect3.setFill(Color.TRANSPARENT));

        rect3.setOnMouseClicked(e -> {
            int xLocation = 3;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }

            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect4 = new Rectangle(400, 25, 100, 750);
        rect4.setFill(Color.TRANSPARENT);

        rect4.setOnMouseEntered(e -> rect4.setFill(Color.rgb(200, 200, 50, .3)));
        rect4.setOnMouseExited(e -> rect4.setFill(Color.TRANSPARENT));

        rect4.setOnMouseClicked(e -> {
            int xLocation = 4;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }

            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect5 = new Rectangle(525, 25, 100, 750);
        rect5.setFill(Color.TRANSPARENT);

        rect5.setOnMouseEntered(e -> rect5.setFill(Color.rgb(200, 200, 50, .3)));
        rect5.setOnMouseExited(e -> rect5.setFill(Color.TRANSPARENT));

        rect5.setOnMouseClicked(e -> {
            int xLocation = 5;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }

            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect6 = new Rectangle(650, 25, 100, 750);
        rect6.setFill(Color.TRANSPARENT);

        rect6.setOnMouseEntered(e -> rect6.setFill(Color.rgb(200, 200, 50, .3)));
        rect6.setOnMouseExited(e -> rect6.setFill(Color.TRANSPARENT));

        rect6.setOnMouseClicked(e -> {
            int xLocation = 6;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }

            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        Rectangle rect7 = new Rectangle(775, 25, 100, 750);
        rect7.setFill(Color.TRANSPARENT);

        rect7.setOnMouseEntered(e -> rect7.setFill(Color.rgb(200, 200, 50, .3)));
        rect7.setOnMouseExited(e -> rect7.setFill(Color.TRANSPARENT));

        rect7.setOnMouseClicked(e -> {
            int xLocation = 7;
            root.getChildren().add(drawCircle(xLocation, game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }

            root.getChildren().add(drawCircle(game));
            if (game.checkWin() == true) {
                popup(game, primaryStage);
            }
        });

        //root.getChildren().add(btn);
        root.getChildren().add(r1c1);
        root.getChildren().add(r1c2);
        root.getChildren().add(r1c3);
        root.getChildren().add(r1c4);
        root.getChildren().add(r1c5);
        root.getChildren().add(r1c6);
        root.getChildren().add(r1c7);
        root.getChildren().add(r2c1);
        root.getChildren().add(r2c2);
        root.getChildren().add(r2c3);
        root.getChildren().add(r2c4);
        root.getChildren().add(r2c5);
        root.getChildren().add(r2c6);
        root.getChildren().add(r2c7);
        root.getChildren().add(r3c1);
        root.getChildren().add(r3c2);
        root.getChildren().add(r3c3);
        root.getChildren().add(r3c4);
        root.getChildren().add(r3c5);
        root.getChildren().add(r3c6);
        root.getChildren().add(r3c7);
        root.getChildren().add(r4c1);
        root.getChildren().add(r4c2);
        root.getChildren().add(r4c3);
        root.getChildren().add(r4c4);
        root.getChildren().add(r4c5);
        root.getChildren().add(r4c6);
        root.getChildren().add(r4c7);
        root.getChildren().add(r5c1);
        root.getChildren().add(r5c2);
        root.getChildren().add(r5c3);
        root.getChildren().add(r5c4);
        root.getChildren().add(r5c5);
        root.getChildren().add(r5c6);
        root.getChildren().add(r5c7);
        root.getChildren().add(r6c1);
        root.getChildren().add(r6c2);
        root.getChildren().add(r6c3);
        root.getChildren().add(r6c4);
        root.getChildren().add(r6c5);
        root.getChildren().add(r6c6);
        root.getChildren().add(r6c7);
        root.setBackground(new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        root.getChildren().add(rect1);
        root.getChildren().add(rect2);
        root.getChildren().add(rect3);
        root.getChildren().add(rect4);
        root.getChildren().add(rect5);
        root.getChildren().add(rect6);
        root.getChildren().add(rect7);

        Scene scene = new Scene(root, 900, 775);

        primaryStage.setTitle("Connect4 FX");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
