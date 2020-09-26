package core;

import java.io.*;
import java.net.*;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Hunter
 */
public class Connect4Client extends Application
        implements Connect4Constants {
    // Indicate whether the player has the turn

    private boolean myTurn = false;

    // Indicate the token for the player
    private char myToken = ' ';

    // Indicate the token for the other player
    private char otherToken = ' ';

    // Create and initialize cells
    private Connect4 game = new Connect4();

    // Create and initialize a title label
    private Label lblTitle = new Label();

    // Create and initialize a status label
    private Label lblStatus = new Label();

    // Indicate selected row and column by the current move
    private int rowSelected;
    private int columnSelected;

    // Input and output streams from/to server
    private DataInputStream fromServer;
    private DataOutputStream toServer;

    // Continue to play?
    private boolean continueToPlay = true;

    // Wait for the player to mark a cell
    private boolean waiting = true;

    // Host name or ip
    private String host = "localhost";

    /**
     *
     * @param primaryStage
     * @throws IOException
     */
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws IOException {
        // Pane to hold cell

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

        rect1.setOnMouseClicked(e -> handleMouseClick(1, root));

        Rectangle rect2 = new Rectangle(150, 25, 100, 750);
        rect2.setFill(Color.TRANSPARENT);

        rect2.setOnMouseEntered(e -> rect2.setFill(Color.rgb(200, 200, 50, .3)));
        rect2.setOnMouseExited(e -> rect2.setFill(Color.TRANSPARENT));

        rect2.setOnMouseClicked(e -> handleMouseClick(2, root));

        Rectangle rect3 = new Rectangle(275, 25, 100, 750);
        rect3.setFill(Color.TRANSPARENT);

        rect3.setOnMouseEntered(e -> rect3.setFill(Color.rgb(200, 200, 50, .3)));
        rect3.setOnMouseExited(e -> rect3.setFill(Color.TRANSPARENT));

        rect3.setOnMouseClicked(e -> handleMouseClick(3, root));

        Rectangle rect4 = new Rectangle(400, 25, 100, 750);
        rect4.setFill(Color.TRANSPARENT);

        rect4.setOnMouseEntered(e -> rect4.setFill(Color.rgb(200, 200, 50, .3)));
        rect4.setOnMouseExited(e -> rect4.setFill(Color.TRANSPARENT));

        rect4.setOnMouseClicked(e -> handleMouseClick(4, root));

        Rectangle rect5 = new Rectangle(525, 25, 100, 750);
        rect5.setFill(Color.TRANSPARENT);

        rect5.setOnMouseEntered(e -> rect5.setFill(Color.rgb(200, 200, 50, .3)));
        rect5.setOnMouseExited(e -> rect5.setFill(Color.TRANSPARENT));

        rect5.setOnMouseClicked(e -> handleMouseClick(5, root));

        Rectangle rect6 = new Rectangle(650, 25, 100, 750);
        rect6.setFill(Color.TRANSPARENT);

        rect6.setOnMouseEntered(e -> rect6.setFill(Color.rgb(200, 200, 50, .3)));
        rect6.setOnMouseExited(e -> rect6.setFill(Color.TRANSPARENT));

        rect6.setOnMouseClicked(e -> handleMouseClick(6, root));

        Rectangle rect7 = new Rectangle(775, 25, 100, 750);
        rect7.setFill(Color.TRANSPARENT);

        rect7.setOnMouseEntered(e -> rect7.setFill(Color.rgb(200, 200, 50, .3)));
        rect7.setOnMouseExited(e -> rect7.setFill(Color.TRANSPARENT));

        rect7.setOnMouseClicked(e -> handleMouseClick(7, root));

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

        BorderPane border = new BorderPane();
        border.setTop(lblTitle);
        border.setCenter(root);
        border.setBottom(lblStatus);

        Scene scene = new Scene(border, 900, 800);

        primaryStage.setTitle("Connect4 FX");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

        // Connect to the server
        connectToServer(root);
    }

    private void connectToServer(Pane root) {
        try {
            // Create a socket to connect to the server
            Socket socket = new Socket(host, 8000);

            // Create an input stream to receive data from the server
            fromServer = new DataInputStream(socket.getInputStream());

            // Create an output stream to send data to the server
            toServer = new DataOutputStream(socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Control the game on a separate thread
        new Thread(() -> {
            try {
                // Get notification from the server
                int player = fromServer.readInt();

                // Am I player 1 or 2?
                if (player == PLAYER1) {
                    myToken = 'X';
                    otherToken = 'O';
                    Platform.runLater(() -> {
                        lblTitle.setText("Player 1 RED token");
                        lblStatus.setText("Waiting for player 2 to join");
                    });

                    // Receive startup notification from the server
                    fromServer.readInt(); // Whatever read is ignored

                    // The other player has joined
                    Platform.runLater(()
                            -> lblStatus.setText("Player 2 has joined. I start first"));

                    // It is my turn
                    myTurn = true;
                } else if (player == PLAYER2) {
                    myToken = 'O';
                    otherToken = 'X';
                    Platform.runLater(() -> {
                        lblTitle.setText("Player 2 with YELLOW token");
                        lblStatus.setText("Waiting for player 1 to move");
                    });
                }

                // Continue to play
                while (continueToPlay) {
                    if (player == PLAYER1) {
                        waitForPlayerAction(); // Wait for player 1 to move
                        receiveInfoFromServer(root); // Receive info from the server
                    } else if (player == PLAYER2) {
                        receiveInfoFromServer(root); // Receive info from the server
                        waitForPlayerAction(); // Wait for player 2 to move
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }

    /**
     * Wait for the player to mark a cell
     */
    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
        }

        waiting = true;

    }

    /**
     * Send this player's move to the server
     */
    private void sendMove() throws IOException {
        toServer.writeInt(columnSelected); // Send the selected column
    }

    /**
     * Receive info from the server
     */
    private void receiveInfoFromServer(Pane root) throws IOException {
        // Receive game status
        int status = fromServer.readInt();

        if (status == PLAYER1_WON) {
            // Player 1 won, stop playing
            continueToPlay = false;
            if (myToken == 'X') {
                Platform.runLater(() -> lblStatus.setText("I won! (RED)"));
            } else if (myToken == 'O') {
                Platform.runLater(()
                        -> lblStatus.setText("Player 1 (RED) has won!"));
                receiveMove(root);
            }
        } else if (status == PLAYER2_WON) {
            // Player 2 won, stop playing
            continueToPlay = false;
            if (myToken == 'O') {
                Platform.runLater(() -> lblStatus.setText("I won! (YELLOW)"));
            } else if (myToken == 'X') {
                Platform.runLater(()
                        -> lblStatus.setText("Player 2 (YELLOW) has won!"));
                receiveMove(root);
            }
        } else {
            receiveMove(root);
            Platform.runLater(() -> lblStatus.setText("My turn"));
            myTurn = true; // It is my turn
        }
    }

    private void receiveMove(Pane root) throws IOException {
        // Get the other player's move
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        int color = fromServer.readInt();
        Platform.runLater(() -> root.getChildren().add(drawCircle(column, row, color)));
    }

    /**
     *
     * @param xLocation
     * @param yLocation
     * @param color1
     * @return
     */
    public Circle drawCircle(int xLocation, int yLocation, int color1) {
        int locationX = xLocation;
        int locationY = yLocation;

        Color color;

        int circleX = 0;
        int circleY = 0;

        if (color1 == 1) {
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

    private void handleMouseClick(int col, Pane root) {
        // If cell is not occupied and the player has the turn

        if (myTurn) {

            try {
                int column = col;

                toServer.writeInt(column);
                int row = fromServer.readInt();
                int color = fromServer.readInt();

                root.getChildren().add(drawCircle(column, row, color));

                myTurn = false;

                lblStatus.setText("Waiting for the other player to move");
                waiting = false; // Just completed a successful move
            } catch (IOException ex) {
            }

        }

    }

    /**
     * The main method is only needed for the IDE with limited JavaFX
     * support.Not needed for running from the command line.
     *
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
