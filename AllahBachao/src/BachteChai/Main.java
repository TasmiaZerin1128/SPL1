package BachteChai;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.Effect;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.*;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.lang.annotation.Target;


public class Main extends Application {

    private int count=0;
    public int ang;
    public double t=0,ti= 0;

    @Override
    public void start(Stage theS) throws Exception {


        Rectangle tree = new Rectangle(30, 500);
        Rectangle dal = new Rectangle(200, 7);

        Rectangle ground = new Rectangle(1600, 100);

        Rectangle cannon = new Rectangle(100, 50);

        Circle ball = new Circle(12);
        Ellipse leaf = new Ellipse(120, 80);
        Ellipse leaf1 = new Ellipse(30, 20);

        Label X = new Label("The Canon is 350 meter away from the tree.\nBranch of the tree is 450 meter above the land.\nThe height of the monkey is 150 meter.\nHit the monkey using right angle.");
        Label angle = new Label("Angle: " + ang);

        Image monkey = new Image("Mbadge.png");
        Image mfalling = new Image("Mfalling.png");
        Image fall = new Image("Fallen.png");

        Group root = new Group();
        Canvas canvas = new Canvas(900, 800);
        root.getChildren().addAll(tree, dal, ground, canvas, ball, cannon, leaf, leaf1, X,angle);
        GraphicsContext gc = canvas.getGraphicsContext2D();


        tree.setFill(Color.SADDLEBROWN);
        dal.setFill(Color.SADDLEBROWN);
        ground.setFill(Color.DARKGREEN);
        cannon.setFill(Color.BLACK);
        ball.setFill(Color.BLACK);
        leaf.setFill(Color.GREEN);
        leaf1.setFill(Color.GREEN);
        X.setTextFill(Color.BLACK);
        angle.setTextFill(Color.BLACK);
        X.setScaleX(1.5);
        X.setScaleY(1.5);
        angle.setScaleX(2);
        angle.setScaleY(2);
        Scene scene = new Scene(root);
        scene.setFill(Color.LIGHTBLUE);
        tree.translateXProperty().set(700);
        tree.translateYProperty().set(200);
        dal.translateXProperty().set(720);
        dal.translateYProperty().set(250);
        ground.translateXProperty().set(0);
        ground.translateYProperty().set(700);
        cannon.translateXProperty().set(110);
        cannon.translateYProperty().set(680);
        ball.setCenterX(150);
        ball.setCenterY(700);
        leaf.setCenterX(710);
        leaf.setCenterY(150);
        leaf1.setCenterX(900);
        leaf1.setCenterY(250);
        X.setLayoutX(200);
        X.setLayoutY(120);
        angle.setLayoutX(300);
        angle.setLayoutY(750);
        theS.setScene(scene);
        theS.show();

        gc.drawImage(monkey, 760, 250);

        Rotate rotateLeft = new Rotate(-1);  //rotate the cannon
        Rotate rotateRight = new Rotate(1);


        theS.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.W) {
                cannon.getTransforms().add(rotateLeft);
                ang = ++count;
                angle.setText("Angle: " + ang);
                System.out.println(count);
            } else if (event.getCode() == KeyCode.S) {
                cannon.getTransforms().add(rotateRight);
                ang= --count;
                System.out.println(count);
            } else if (event.getCode() == KeyCode.SPACE) {
                int v0 = 120;
                double g = 9.8;
                double Thh = ang;
                double theta = (Thh * Math.PI) / 180.0;
                double S = Math.sin(theta);
                double C = Math.cos(theta);
                double T = (2 * (v0 * S)) / g;
                new AnimationTimer() {
                    public void handle(long currentNanoTime) {
                        double k = (v0 * C * t);
                        double j = (v0 * S * t) - (0.5 * g * t * t);
                        t= t + 0.3;
                        ball.setCenterX(150 + k);
                        ball.setCenterY(700 - j);

                        if (ball.getCenterX() >= 760 && ball.getCenterX() <= 860) {
                            if (ball.getCenterY() >= 250 && ball.getCenterY() <= 400) {
                                ball.opacityProperty().set(0);
                                stop();
                                gc.clearRect(560, 300, 900, 700);
                                final long startNanoTime = System.nanoTime();
                                final double H = 250;
                                new AnimationTimer() {
                                    public void handle(long currentNanoTime) {
                                        //double ti = 9 * ((currentNanoTime - startNanoTime) / 10000000.0);
                                        double i =H + ti;
                                        ti = ti+20;

                                        gc.clearRect(500, 0, 900, 700);
                                        gc.drawImage(mfalling, 760, i);

                                        if (i >= 600) {
                                            gc.clearRect(500, 0, 900, 800);
                                            gc.drawImage(fall, 760, 600);
                                            stop();
                                        }

                                    }
                                }.start();
                            }
                        }
                    }
                }.start();
            }
        });
    }



    public static void main(String[] args) {
        launch(args);
    }
}
