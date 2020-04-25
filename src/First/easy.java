package First;

import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

import static javafx.stage.StageStyle.TRANSPARENT;

public class easy {
    double t = 0;
    String Type,TypeB;
    String hhh = "";
    String ttt = "";
    String TTT = "";
    String rrr = "";
    String the = "";

    int Velo;
    double theta;
    int check=0;

    double Hmax=-1;
    double Tmax=-1;
    double time=-1;
    double Range=-1;
    double Theta=-1;

    double Hcount=-1;
    double Tcount=-1;
    double tcount=-1;
    double rcount=-1;
    double thcount=-1;

    double H, T , R;
    int num;

    TextField hh = new TextField();
    TextField TT = new TextField();
    TextField tt = new TextField();
    TextField rr = new TextField();
    TextField thh = new TextField();

    public void EASY(Stage primaryStage) throws FileNotFoundException, IOException {
        Pane root = new Pane();

        Stage size = new Stage();
        GridPane ans = new GridPane();
        Scene s = new Scene(ans, 500, 300);

        Alert a = new Alert(Alert.AlertType.NONE);

        Scanner sc = new Scanner(new File("src/easy.txt"));
        int flag = 0,type=0, var=0;
        int position = 0;

        hh.setPromptText("0.00");
        hh.setFocusTraversable(false);
        rr.setPromptText("0.00");
        rr.setFocusTraversable(false);
        tt.setPromptText("0.00");
        tt.setFocusTraversable(false);
        TT.setPromptText("0.00");
        TT.setFocusTraversable(false);
        thh.setPromptText("0.00");
        thh.setFocusTraversable(false);

        Canvas cn = new Canvas(1500,500);
        cn.setTranslateX(100);
        cn.setTranslateY(20);
        GraphicsContext gc = cn.getGraphicsContext2D();
        Image board = new Image("blackboard.jpg");
        Image qB = new Image("Bd.jpg");
        gc.drawImage(board,1160,0);
        gc.drawImage(qB,20,30);

        Random random = new Random();

        Sphere ball = new Sphere(25);
        Ellipse shadow = new Ellipse();
        shadow.setCenterX(180.0f);
        shadow.setCenterY(670.0f);
        shadow.setRadiusX(40.0f);
        shadow.setRadiusY(15.0f);
        ball.setTranslateX(200);
        ball.setTranslateY(650);
        GaussianBlur gaussianBlur = new GaussianBlur();
        gaussianBlur.setRadius(30);
        shadow.setEffect(gaussianBlur);

        Label SVelo = new Label("Velocity: 0 m/s");
        SVelo.setTranslateX(1340);
        SVelo.setTranslateY(70);
        SVelo.setTextFill(Color.WHITE);
        SVelo.setScaleX(2);
        SVelo.setScaleY(2);

        Label STime = new Label("Time: 0 s");
        STime.setTranslateX(1330);
        STime.setTranslateY(120);
        STime.setTextFill(Color.WHITE);
        STime.setScaleX(2);
        STime.setScaleY(2);

        Label SHmax = new Label("Hmax: 0 m");
        SHmax.setTranslateX(1330);
        SHmax.setTranslateY(170);
        SHmax.setTextFill(Color.WHITE);
        SHmax.setScaleX(2);
        SHmax.setScaleY(2);

        Label SR = new Label("Range: 0 m");
        SR.setTranslateX(1330);
        SR.setTranslateY(220);
        SR.setTextFill(Color.WHITE);
        SR.setScaleX(2);
        SR.setScaleY(2);

        Label STmax = new Label("Tmax: 0 s");
        STmax.setTranslateX(1330);
        STmax.setTranslateY(270);
        STmax.setTextFill(Color.WHITE);
        STmax.setScaleX(2);
        STmax.setScaleY(2);

        Label SX = new Label("X: 0 m");
        SX.setTranslateX(1330);
        SX.setTranslateY(320);
        SX.setTextFill(Color.WHITE);
        SX.setScaleX(2);
        SX.setScaleY(2);

        Label SY = new Label("Y: 0 m");
        SY.setTranslateX(1330);
        SY.setTranslateY(370);
        SY.setTextFill(Color.WHITE);
        SY.setScaleX(2);
        SY.setScaleY(2);

        
        String st;
        int line = 0;
        num = randInt(1,6);
         //num=4;
        ArrayList<String> ques = new ArrayList<String>();
        while (sc.hasNextLine()) {
            if (flag == 0) {
                st = sc.nextLine();
                if (st.contains(num + ")")) {
                    flag = 1;
                }
            } else if (flag == 1) {
                st = sc.nextLine();
                if (type == 1) {
                    Type = st + ".jpg";
                    TypeB = "/" + st + "B.jpg";
                    type = -1;
                } else if (type == 0) {
                    if (st.contains("#")) {
                        type = 1;
                    } else {
                        ques.add(st);
                    }
                } else if (type == -1) {
                    if (st.contains("VAR")) {
                        flag = 2;
                    }
                }
            }
            else if(flag==2)
            {
                st = sc.nextLine();
                if(st.contains("ANS"))
                {
                    flag=3;
                }
                else
                {
                    if(var==0) {
                        if (st.contains("v")) {
                            var = 1;
                        }
                        else if(st.contains("theta"))
                        {
                            var=2;
                        }

                    }
                    else if(var==1)
                    {
                        Velo= Integer.parseInt(st);
                        var=0;
                    }
                    else if(var==2)
                    {
                        theta = Integer.parseInt(st);
                        var=0;
                    }
                }
            }

            else if(flag==3)
            {
                st = sc.nextLine();
                if(st.contains("END"))
                {
                    break;
                }
                else
                {
                    if(st.contains("H"))
                    {
                        Label H = new Label("Hmax: ");
                        H.setTextFill(Color.WHITE);
                        H.setScaleX(1.5);
                        H.setScaleY(1.5);
                        ans.add(H,1,position);
                        ans.add(hh, 2, position);
                        position++;
                        Hcount=0;
                    }
                    else if(st.contains("time"))
                    {
                        Label hT = new Label("Time: ");
                        hT.setTextFill(Color.WHITE);
                        hT.setScaleX(1.5);
                        hT.setScaleY(1.5);
                        ans.add(hT,1,position);
                        ans.add(tt, 2, position);
                        position++;
                        tcount=0;
                    }
                    else if(st.contains("T"))
                    {
                        Label T = new Label("Tmax: ");
                        T.setTextFill(Color.WHITE);
                        T.setScaleX(1.5);
                        T.setScaleY(1.5);
                        ans.add(T,1,position);
                        ans.add(TT, 2, position);
                        position++;
                        Tcount=0;
                    }
                    else if(st.contains("R"))
                    {
                        Label R = new Label("Range: ");
                        R.setTextFill(Color.WHITE);
                        R.setScaleX(1.5);
                        R.setScaleY(1.5);
                        ans.add(R,1,position);
                        ans.add(rr,2, position);
                        position++;
                        rcount=0;
                    }
                    else if(st.contains("theta"))
                    {
                        Label th = new Label("Angle: ");
                        th.setTextFill(Color.WHITE);
                        th.setScaleX(1.5);
                        th.setScaleY(1.5);
                        ans.add(th,1,position);
                        ans.add(thh,2, position);
                        position++;
                        thcount=0;
                    }
                }
            }
        }

        PhongMaterial material = new PhongMaterial();
        material.setDiffuseMap(new Image(getClass().getResourceAsStream(TypeB)));
        ball.setMaterial(material);

        Text L = new Text();
        L.setTranslateX(420);
        L.setTranslateY(150);
        L.setScaleX(2);
        L.setScaleY(2);

        for (int i = 0; i < ques.size(); i++) {
            L.setText(L.getText() + ques.get(i) + "\n");
        }

        L.setFill(Color.WHITE);
        L.setStroke(Color.WHITE);
        L.setStrokeWidth(0.5);
        Button St = new Button("Submit");
        St.setPadding(new Insets(15));
        setStyle(St);
        St.setTranslateX(1400);
        St.setTranslateY(730);

        Button en = new Button("Enter Answers");
        en.setPadding(new Insets(15));
        en.setStyle("-fx-padding: 8 15 15 15;\n" +
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
        en.setPrefSize(150,70);
        en.setTranslateX(700);
        en.setTranslateY(700);

        en.setOnAction(e -> {
                    try {
                        Label warning = new Label(null);
                        warning.setTextFill(Color.RED);
                        warning.setScaleX(1.2);
                        warning.setScaleY(1.2);
                        ans.add(warning,2,7);
                        Button Ok = new Button("Enter");
                        Ok.setStyle("-fx-background-color: \n" +
                                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                                "    -fx-background-radius: 8,7,6;\n" +
                                "    -fx-background-insets: 0,1,2;\n" +
                                "    -fx-text-fill: black;\n" +
                                "    -fx-font-weight: bold;\n" +
                                "    -fx-font-size: 1.1em;\n" +
                                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
                        Ok.setPrefSize(90, 40);
                        Button cancel = new Button("Cancel");
                        cancel.setStyle("-fx-background-color: \n" +
                                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                                "    -fx-background-radius: 8,7,6;\n" +
                                "    -fx-background-insets: 0,1,2;\n" +
                                "    -fx-text-fill: black;\n" +
                                "    -fx-font-weight: bold;\n" +
                                "    -fx-font-size: 1.1em;\n" +
                                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
                        cancel.setPrefSize(90, 40);
                        Button clear = new Button("Clear");
                        clear.setStyle("-fx-background-color: \n" +
                                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                                "    -fx-background-radius: 8,7,6;\n" +
                                "    -fx-background-insets: 0,1,2;\n" +
                                "    -fx-text-fill: black;\n" +
                                "    -fx-font-weight: bold;\n" +
                                "    -fx-font-size: 1.1em;\n" +
                                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
                        clear.setPrefSize(90, 40);
                        ans.add(Ok,4,10);
                        ans.add(cancel,2,10);
                        ans.add(clear,1,10);
                        ans.setAlignment(Pos.CENTER);
                        ans.setVgap(4);
                        ans.setHgap(10);
                        ans.setPadding(new Insets(5, 5, 5, 5));
                        size.setTitle("Answers");
                        Image BG = new Image("Answer.jpg");
                        BackgroundImage bi = new BackgroundImage(BG,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                BackgroundSize.DEFAULT);
                        Background Bg = new Background(bi);
                        ans.setBackground(Bg);
//                        size.initStyle(StageStyle.TRANSPARENT);
//                        s.setFill(Color.TRANSPARENT);
                        size.setScene(s);
                        size.show();

                        cancel.setOnAction(E->{
                            size.close();
                        });

                        clear.setOnAction(E->{
                            hh.clear();
                            //hh.setText(null);
                            rr.clear();
                            //rr.setText(null);
                            tt.clear();
                            //tt.setText(null);
                            TT.clear();
                            //TT.setText(null);
                            thh.clear();
                            //thh.setText(null);
                            warning.setText(null);
                                });

                       Ok.setOnAction(E->{
                                if(Hcount==0 && hh.getText().isEmpty() || Tcount==0 && TT.getText().isEmpty() || tcount==0 && tt.getText().isEmpty() || rcount==0 && rr.getText().isEmpty() || thcount==0 && thh.getText().isEmpty())
                                {
                                    System.out.println("dhukse");
                                    warning.setText("Please enter all the answers!");
                                }
                                else {
                                    try {
                                        warning.setText(null);
                                        size.close();
                                        if (Hcount == 0 && hh.getText() != null) {
                                            hhh = hh.getText();
                                            hh.clear();
                                            Hmax = Double.parseDouble(hhh);
                                        }
                                        if (Tcount == 0 && TT.getText() != null) {
                                            TTT = TT.getText();
                                            TT.clear();
                                            Tmax = Double.parseDouble(TTT);
                                        }
                                        if (tcount == 0 && tt.getText() != null) {
                                            ttt = tt.getText();
                                            tt.clear();
                                            time = Double.parseDouble(ttt);
                                        }
                                        if (rcount == 0 && rr.getText() != null) {
                                            rrr = rr.getText();
                                            rr.clear();
                                            Range = Double.parseDouble(rrr);
                                        }
                                        if (thcount == 0 && thh.getText() != null) {
                                            the = thh.getText();
                                            thh.clear();
                                            Theta = Double.parseDouble(the);
                                        }
                                    } catch (IllegalArgumentException il) {
                                        size.close();
                                    }
                                }
                       });
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                });

        double angle = (theta*Math.PI)/180;

        St.setOnAction(e -> {
            if(Hmax==-1 && Hcount==0||Theta==-1 && thcount==0 || Tmax==-1 && Tcount==0 || time==-1 && tcount==0 || Range==-1 && rcount==0)
            {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("You have to first answer the questions");
                a.show();
            }
            else {
                Type = "L" + Type;
                Image back = new Image(Type);
                BackgroundImage bi = new BackgroundImage(back,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                Background bg = new Background(bi);
                root.setBackground(bg);
                try {
                    shadow.setOpacity(0);
                    double posX = ball.getTranslateX();
                    double posY = ball.getTranslateY();
                    double S = Math.sin(angle);
                    double C = Math.cos(angle);
                    H = Math.pow((Velo * S), 2) / (2 * 9.8);
                    T = (2 * (Velo * S)) / 9.8;
                    R = ((Velo * Velo) * Math.sin(2 * angle)) / 9.8;
                    new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            double k = (Velo * C * t);
                            double j = (Velo * S * t) - (0.5 * 9.8 * t * t);
                            ball.setTranslateX(posX + k * 6);
                            ball.setTranslateY(posY - j * 4.5);
                            double vx = Velo * C;
                            double vy = Velo * S - (9.8 * t);
                            double TotalV = Math.sqrt((vx * vx) + (vy * vy));
                            SVelo.setText("Velocity: " + String.format("%.2f", TotalV) + "m/s");
                            if (t >= T) {
                                STime.setText("Time: " + String.format("%.2f", T) + "s");
                            } else {
                                STime.setText("Time: " + String.format("%.2f", t) + "s");
                            }
                            SHmax.setText("Hmax: " + String.format("%.2f", H) + "m");
                            SR.setText("Range: " + String.format("%.2f", R) + "m");
                            STmax.setText("Tmax: " + String.format("%.2f", T) + "s");
                            if (k <= R)
                                SX.setText("X: " + String.format("%.2f", k) + "m");
                            else
                                SX.setText("X: " + String.format("%.2f", R) + "m");
                            if (j <= 0)
                                SY.setText("Y: 0" + "m");
                            else
                                SY.setText("Y: " + String.format("%.2f", j) + "m");
                            if (t >= T) {
                                stop();
                                if (Hmax != -1) {
                                    if (RoundUpDecimal.round(H,Hmax)) {
                                        check = 0;
                                    }
                                    else
                                    {
                                        check=1;
                                    }
                                }
                                if(check==0) {
                                    if (time != -1) {
                                        if (RoundUpDecimal.round(time, Tmax / 2)) {
                                            check = 0;
                                        }
                                        else
                                        {
                                            check=1;
                                        }
                                    }
                                }
                                if(check==0) {
                                    if (Range != -1) {
                                        if (RoundUpDecimal.round(R, Range)) {
                                            check = 0;
                                        }
                                        else
                                        {
                                            check=1;
                                        }
                                    }
                                }
                                if(check==0) {
                                    if (Theta != -1) {
                                        if (RoundUpDecimal.round(theta, Theta)) {
                                            check = 0;
                                        }
                                        else
                                        {
                                            check=1;
                                        }
                                    }
                                }
                                Pane S = new Pane();
                                Scene Sans = new Scene(S, 600, 300);
                                Stage SA = new Stage();
                                Text ShowA = new Text();
                                ShowA.setScaleX(4);
                                ShowA.setScaleY(4);
                                if (check == 0) {
                                    ShowA.setText("Correct Answer");
                                    ShowA.setFill(Color.WHITE);
                                } else if (check == 1) {
                                    ShowA.setText("Wrong Answer");
                                    ShowA.setFill(Color.RED);
                                    Button see = new Button("See Solution");
                                    setStyleBoard(see);
                                    see.setPrefSize(120,40);
                                    see.setTranslateX(180);
                                    see.setTranslateY(200);
                                    see.setOnAction(eve->{
                                        SA.close();
                                        Pane sol = new Pane();
                                        Scene Solu = new Scene(sol,1450,800);
                                        Image Solution = new Image(num + "easy.png");
                                        BackgroundImage bi = new BackgroundImage(Solution,
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundRepeat.NO_REPEAT,
                                                BackgroundPosition.DEFAULT,
                                                BackgroundSize.DEFAULT);
                                        Background Bg = new Background(bi);
                                        Stage SS = new Stage();
                                        SS.setScene(Solu);
                                        sol.setBackground(Bg);
                                        SS.show();
                                        Solu.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                                            if (event.getCode() == KeyCode.ENTER) {
                                                SA.close();
                                            }
                                        });
                                    });
                                    S.getChildren().add(see);
                                    Button no = new Button("No Thanks");
                                    no.setPrefSize(120,40);
                                    no.setTranslateX(340);
                                    no.setTranslateY(200);
                                    setStyleBoard(no);
                                    no.setOnAction(eve->{
                                        SA.close();
                                    });
                                    S.getChildren().add(no);
                                }
                                ShowA.setTranslateX(270);
                                ShowA.setTranslateY(120);
                                S.getChildren().addAll(ShowA);
                                S.setPadding(new Insets(5, 5, 5, 5));
                                Image BG = new Image("check.jpg");
                                BackgroundImage bi = new BackgroundImage(BG,
                                        BackgroundRepeat.NO_REPEAT,
                                        BackgroundRepeat.NO_REPEAT,
                                        BackgroundPosition.DEFAULT,
                                        BackgroundSize.DEFAULT);
                                Background Bg = new Background(bi);
                                S.setBackground(Bg);
                                SA.initStyle(StageStyle.TRANSPARENT);
                                Sans.setFill(Color.TRANSPARENT);
                                SA.setScene(Sans);
                                SA.show();
                                Sans.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                                    if (event.getCode() == KeyCode.ENTER) {
                                        SA.close();
                                    }
                                });
                            } else {
                                t += 0.1;
                            }
                        }
                    }.start();
                } catch (IllegalArgumentException il) {
                    il.printStackTrace();
                }
            }
        });


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

        back.setOnAction(e->{
            try {
                solve goBack = new solve();
                goBack.start(primaryStage);
            }catch (Exception ex)
            {
                ex.printStackTrace();
            }
        });

        Image background = new Image(Type);
        root.getChildren().addAll(cn,back, shadow,ball,St,SVelo,STime,SHmax,SR,STmax,SX,SY,L,en);

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        root.setBackground(bg);


        Scene scene = new Scene(root, 1600, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public Button setStyle(Button b) {
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
                "    -fx-font-size: 1.1em;");
        return b;
    }

    public Button setStyleBoard(Button b)
    {
        b.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                "    -fx-background-radius: 8,7,6;\n" +
                "    -fx-background-insets: 0,1,2;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-font-size: 1.1em;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");
        return b;
    }

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
