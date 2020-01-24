package sample;

import java.math.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.PointLight;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Sphere;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import java.io.*;

import java.util.ArrayList;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));




            TextField V = new TextField();
            TextField G = new TextField();
            TextField Th = new TextField();

            Label v = new Label("Velocity:");
            Label gr = new Label("Gravity:");
            Label th = new Label("Angle:");

            v.setLabelFor(V);
            v.setLayoutX(200);
            v.setLayoutY(550);
            V.setLayoutX(250);
            V.setLayoutY(550);
            gr.setLabelFor(G);
            gr.setLayoutX(200);
            gr.setLayoutY(590);
            G.setLayoutX(250);
            G.setLayoutY(590);
            th.setLabelFor(Th);
            th.setLayoutX(200);
            th.setLayoutY(630);
            Th.setLayoutX(250);
            Th.setLayoutY(630);





            Sphere ball = new Sphere();

            Line L = new Line();

            L.setStartX(100);
            L.setStartY(510);
            L.setEndX(1200);
            L.setEndY(510);

            ball.setRadius(20);

            ball.setMaterial(new PhongMaterial(Color.RED));

        Button button1 = new Button("Start");
        Button button2 = new Button("Pause");
        Button button3 = new Button("Reset");
        button1.setLayoutX(1300);
        button1.setLayoutY(300);
        button1.setMinSize(100,60);
        button2.setLayoutX(1300);
        button2.setLayoutY(400);
        button2.setMinSize(100,60);
        button3.setLayoutX(1300);
        button3.setLayoutY(500);
        button3.setMinSize(100,60);




            Group Root = new Group();


            Root.getChildren().addAll(ball,L,button1,button2,button3,v,gr,th,V,G,Th);

            Scene scene = new Scene(Root, 600, 700, Color.ORANGE);

            ball.setTranslateX(300.0);

            ball.setTranslateY(500.0);

        button3.setOnAction(e->{
            V.clear();
            G.clear();
            Th.clear();
            ball.setTranslateX(300.0);
            ball.setTranslateY(500.0);
        });


            primaryStage.setTitle("Ball");
            primaryStage.setScene(scene);
            primaryStage.show();

        button1.setOnAction(e->{
            String Velo = V.getText();
            String Gr = G.getText();
            String tht = Th.getText();
            int v0;
            v0 = Integer.parseInt(Velo);
            double g = Double.parseDouble(Gr);
            double Thh = Double.parseDouble(tht);
            double theta = (Thh*Math.PI)/180.0;
            double S = Math.sin(theta);
            double C = Math.cos(theta);
            double T = (2* (v0* S))/g;

            new Thread() {
                @Override
                public void run() {
                    super.run();

                    try {
                        Double k = 0.0, j = 0.0;

                        for (double m = 0.00; m <= T; m=m+0.1) {
                            sleep(80);
                            k = v0 * C * m;
                            j = (v0 * S * m) - (0.5 * g * m*m);
                            ball.setTranslateX(300 + (k* 5));
                            ball.setTranslateY(500 - (j*5));
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        });



    }


    public static void main(String[] args) {
        launch(args);
    }
}
