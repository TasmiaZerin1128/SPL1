package First;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class solve extends Application {
    @Override
    public void start(Stage primaryStage) throws NullPointerException, FileNotFoundException {

        Text headning = new Text("Practice By");
        headning.setScaleX(3);
        headning.setScaleY(3);
        headning.setTranslateX(730);
        headning.setTranslateY(50);
        headning.setFill(Color.WHITE);

        final ToggleGroup group = new ToggleGroup();

        RadioButton Category = new RadioButton("Category");
        Category.setToggleGroup(group);
        Category.setTranslateX(850);
        Category.setTranslateY(100);
        Category.setScaleX(2.5);
        Category.setScaleY(2.5);
        Category.setTextFill(Color.WHITE);

        RadioButton Difficulty = new RadioButton("Difficulty");
        Difficulty.setToggleGroup(group);
        Difficulty.setTranslateX(620);
        Difficulty.setTranslateY(100);
        Difficulty.setScaleX(2.5);
        Difficulty.setScaleY(2.5);
        Difficulty.setTextFill(Color.WHITE);
        Difficulty.setSelected(true);

        Button easy = new Button("Easy");
        easy.setTranslateX(710);
        easy.setTranslateY(200);
        setStyle(easy);
        easy.setPrefSize(150, 100);

        Button medium = new Button("Medium");
        medium.setTranslateX(710);
        medium.setTranslateY(350);
        setStyle(medium);
        medium.setPrefSize(150, 100);

        Button hard = new Button("Hard");
        hard.setTranslateX(710);
        hard.setTranslateY(500);
        setStyle(hard);
        hard.setPrefSize(150, 100);

        Button MH = new Button("Height");
        MH.setTranslateX(580);
        MH.setTranslateY(250);
        setStyleSmall(MH);
        MH.setPrefSize(150, 60);

        Button time = new Button("Time");
        time.setTranslateX(580);
        time.setTranslateY(400);
        setStyleSmall(time);
        time.setPrefSize(150, 60);

        Button range = new Button("Range");
        range.setTranslateX(580);
        range.setTranslateY(550);
        setStyleSmall(range);
        range.setPrefSize(150, 60);

        Button dis = new Button("Distance");
        dis.setTranslateX(800);
        dis.setTranslateY(250);
        setStyleSmall(dis);
        dis.setPrefSize(150, 60);

        Button velo = new Button("Velocity");
        velo.setTranslateX(800);
        velo.setTranslateY(400);
        setStyleSmall(velo);
        velo.setPrefSize(150, 60);

        Button ang = new Button("Angle");
        ang.setTranslateX(800);
        ang.setTranslateY(550);
        setStyleSmall(ang);
        ang.setPrefSize(150, 60);

        Button back = new Button("Back");
        back.setTranslateX(50);
        back.setTranslateY(20);
        back.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;");
        back.setPrefSize(60, 30);

        Image background = new Image("Back.png");
        Pane root = new Pane();
        root.getChildren().addAll(medium,back,easy,hard,headning,Category,Difficulty);

        easy.setOnAction(e->{
            try {
                easy goEasy = new easy();
                goEasy.EASY(primaryStage);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });

        medium.setOnAction(e->{
            try {
                medium goMedium = new medium();
                goMedium.Medium(primaryStage);
            }
            catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });


        back.setOnAction(e->{
            try {
                ThirdPage goBack = new ThirdPage();
                goBack.TheThird(primaryStage);
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });

        Difficulty.setOnAction(event -> {
            root.getChildren().removeAll(MH,dis,range,time,velo,ang);
            root.getChildren().addAll(easy,medium,hard);
        });

        Category.setOnAction(event -> {
            root.getChildren().removeAll(easy,medium,hard);
            root.getChildren().addAll(MH,dis,range,time,velo,ang);
        });

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        root.setBackground(bg);


        Scene scene = new Scene(root, 1600, 800);
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true);
        primaryStage.show();
    }

    public Button setStyle ( Button b)
    {
        b.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 2.1em;");
        return b;
    }
    public Button setStyleSmall ( Button b)
    {
        b.setStyle("-fx-padding: 8 15 15 15;\n" +
                "    -fx-background-insets: 0,0 0 5 0, 0 0 6 0, 0 0 7 0;\n" +
                "    -fx-background-radius: 8;\n" +
                "    -fx-background-color: \n" +
                "        linear-gradient(from 0% 93% to 0% 100%, #8d9092 0%, #717375 100%),\n" +
                "        #8d9092,\n" +
                "        #717375,\n" +
                "        radial-gradient(center 50% 50%, radius 100%, #ffffff, #a1a3a6);\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(0,0,0,0.75) , 4,0,0,1 );\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.3em;");
        return b;
    }
}

