package First;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class hard {
    double t = 0;
    String Type, TypeB;
    String hhh = "";
    String ttt = "";
    String TTT = "";
    String rrr = "";
    String the = "";
    String xxx = "";
    String yyy = "";
    String v00 = "";
    String vvv = "";
    String vhuman = "";

    double Velo;
    double theta;
    int check = 0;

    double Hmax = -1;
    double Tmax = -1;
    double time = -1;
    double Range = -1;
    double Theta = -1;
    double X = -1;
    double Y = -1;
    double V0 = -1;
    double V = -1;
    double Vhuman = -1;

    double Hcount = -1;
    double Tcount = -1;
    double tcount = -1;
    double rcount = -1;
    double thcount = -1;
    double xcount = -1;
    double ycount = -1;
    double v0count = -1;
    double Vcount = -1;
    double Vhucount = -1;

    double H = 0, T = 0, R = 0;
    double centerX, centerY, mulX, mulY, posX, posY;
    int projectileType = -1, yesX = 0, yesmulX = 0;

    TextField hh = new TextField();
    TextField TT = new TextField();
    TextField tt = new TextField();
    TextField rr = new TextField();
    TextField thh = new TextField();
    TextField xx = new TextField();
    TextField yy = new TextField();
    TextField v0 = new TextField();
    TextField vv = new TextField();
    TextField vHu = new TextField();

    public void Hard(Stage primaryStage) throws FileNotFoundException, IOException {
        Pane root = new Pane();

        Stage size = new Stage();
        GridPane ans = new GridPane();
        Scene s = new Scene(ans, 500, 300);

        Alert a = new Alert(Alert.AlertType.NONE);

        Scanner sc = new Scanner(new File("src/medium.txt"));
        int flag = 0, type = 0, var = 0;
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
        xx.setPromptText("0.00");
        xx.setFocusTraversable(false);
        yy.setPromptText("0.00");
        yy.setFocusTraversable(false);
        v0.setPromptText("0.00");
        v0.setFocusTraversable(false);
        vv.setPromptText("0.00");
        vv.setFocusTraversable(false);

        Canvas cn = new Canvas(1600, 800);
        cn.setTranslateX(0);
        cn.setTranslateY(0);
        GraphicsContext gc = cn.getGraphicsContext2D();
        Image board = new Image("blackboard.jpg");
        Image qB = new Image("Bd.jpg");

        Random random = new Random();

        Ellipse ball = new Ellipse();
        Sphere Ball = new Sphere(25);
        Ellipse shadow = new Ellipse();

        Box target = new Box(20,30,10);

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
        //int num = randInt(1,4);
        int num = 7;
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
                    Type = st;
                    type = -1;
                } else if (type == 0) {
                    if (st.contains("#")) {
                        type = 1;
                    } else {
                        ques.add(st);
                    }
                } else if (type == -1) {
                    if (st.contains("ellipse")) {
                        projectileType = 0;
                        ball.setRadiusX(20);
                        ball.setRadiusY(10);
                        ball.setFill(Color.BLACK);
                    } else if (st.contains("sphere")) {
                        projectileType = 1;
                        TypeB = "/" + Type + "B.jpg";
                        PhongMaterial material = new PhongMaterial();
                        material.setDiffuseMap(new Image(getClass().getResourceAsStream(TypeB)));
                        Ball.setMaterial(material);
                    } else if (st.contains("VAR")) {
                        flag = 2;
                    }
                }
            } else if (flag == 2) {
                st = sc.nextLine();
                if (st.contains("ANS")) {
                    flag = 3;
                } else {
                    if (var == 0) {
                        if (st.contains("v")) {
                            var = 1;
                        } else if (st.contains("theta")) {
                            var = 2;
                        } else if (st.contains("T")) {
                            var = 3;
                        }
                    } else if (var == 1) {
                        Velo = Double.parseDouble(st);
                        var = 0;
                    } else if (var == 2) {
                        theta = Integer.parseInt(st);
                        var = 0;
                    } else if (var == 3) {
                        T = Double.parseDouble(st);
                        var = 0;
                    }
                }
            } else if (flag == 3) {
                st = sc.nextLine();
                if (st.contains("CENTER")) {
                    flag = 4;
                } else {
                    if (st.contains("H")) {
                        Label H = new Label("Hmax: ");
                        H.setTextFill(Color.WHITE);
                        H.setScaleX(1.5);
                        H.setScaleY(1.5);
                        ans.add(H, 1, position);
                        ans.add(hh, 2, position);
                        position++;
                        Hcount = 0;
                    } else if (st.contains("time")) {
                        Label hT = new Label("Time: ");
                        hT.setTextFill(Color.WHITE);
                        hT.setScaleX(1.5);
                        hT.setScaleY(1.5);
                        ans.add(hT, 1, position);
                        ans.add(tt, 2, position);
                        position++;
                        tcount = 0;
                    } else if (st.contains("T")) {
                        Label T = new Label("Tmax: ");
                        T.setTextFill(Color.WHITE);
                        T.setScaleX(1.5);
                        T.setScaleY(1.5);
                        ans.add(T, 1, position);
                        ans.add(TT, 2, position);
                        position++;
                        Tcount = 0;
                    } else if (st.contains("R")) {
                        Label R = new Label("Range: ");
                        R.setTextFill(Color.WHITE);
                        R.setScaleX(1.5);
                        R.setScaleY(1.5);
                        ans.add(R, 1, position);
                        ans.add(rr, 2, position);
                        position++;
                        rcount = 0;
                    } else if (st.contains("theta")) {
                        Label th = new Label("Angle: ");
                        th.setTextFill(Color.WHITE);
                        th.setScaleX(1.5);
                        th.setScaleY(1.5);
                        ans.add(th, 1, position);
                        ans.add(thh, 2, position);
                        position++;
                        thcount = 0;
                    } else if (st.contains("x")) {
                        Label x = new Label("X: ");
                        x.setTextFill(Color.WHITE);
                        x.setScaleX(1.5);
                        x.setScaleY(1.5);
                        ans.add(x, 1, position);
                        ans.add(xx, 2, position);
                        position++;
                        xcount = 0;
                    } else if (st.contains("y")) {
                        Label y = new Label("Y: ");
                        y.setTextFill(Color.WHITE);
                        y.setScaleX(1.5);
                        y.setScaleY(1.5);
                        ans.add(y, 1, position);
                        ans.add(yy, 2, position);
                        position++;
                        ycount = 0;
                    } else if (st.contains("v0")) {
                        Label V0 = new Label("V0: ");
                        V0.setTextFill(Color.WHITE);
                        V0.setScaleX(1.5);
                        V0.setScaleY(1.5);
                        ans.add(V0, 1, position);
                        ans.add(v0, 2, position);
                        position++;
                        v0count = 0;
                    } else if (st.contains("V")) {
                        Label Vv = new Label("Velocity: ");
                        Vv.setTextFill(Color.WHITE);
                        Vv.setScaleX(1.5);
                        Vv.setScaleY(1.5);
                        ans.add(Vv, 1, position);
                        ans.add(vv, 2, position);
                        position++;
                        Vcount = 0;
                    }
                }
            } else if (flag == 4) {
                st = sc.nextLine();
                if (st.contains("MUL")) {
                    flag = 5;
                } else {
                    if (yesX == 0) {
                        if (projectileType == 0) {
                            ball.setCenterX(Double.parseDouble(st));
                            yesX = 1;
                        } else if (projectileType == 1) {
                            Ball.setTranslateX(Double.parseDouble(st));
                            yesX = 1;
                        }
                    } else {
                        if (projectileType == 0) {
                            ball.setCenterY(Double.parseDouble(st));
                        } else {
                            Ball.setTranslateY(Double.parseDouble(st));
                        }
                    }
                }
            } else if (flag == 5) {
                st = sc.nextLine();
                if (st.contains("WALL")) {
                    flag = 6;
                } else if (st.contains("END")) {
                    break;
                } else {
                    if (yesmulX == 0) {
                        mulX = Double.parseDouble(st);
                        yesmulX = 1;
                    } else {
                        mulY = Double.parseDouble(st);
                    }
                }
            } else if (flag == 6) {
                st = sc.nextLine();
                if (st.contains("END")) {
                    break;
                } else {
                    Image wall = new Image("wall.png");
                    if (projectileType == 0)
                        gc.drawImage(wall, ball.getCenterX() + Double.parseDouble(st) * mulX, 0);
                    else
                        gc.drawImage(wall, Ball.getTranslateX() + Double.parseDouble(st) * mulX, 0);
                }
            }
        }

        Type = Type + ".jpg";
        gc.drawImage(board, 1260, 20);
        gc.drawImage(qB, 120, 50);

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
        en.setPrefSize(150, 70);
        en.setTranslateX(700);
        en.setTranslateY(700);

        en.setOnAction(e -> {
            try {
                Label warning = new Label(null);
                warning.setTextFill(Color.RED);
                warning.setScaleX(1.2);
                warning.setScaleY(1.2);
                ans.add(warning, 2, 7);
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
                ans.add(Ok, 4, 10);
                ans.add(cancel, 2, 10);
                ans.add(clear, 1, 10);
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

                cancel.setOnAction(E -> {
                    size.close();
                });

                clear.setOnAction(E -> {
                    hh.clear();
                    rr.clear();
                    tt.clear();
                    TT.clear();
                    thh.clear();
                    xx.clear();
                    yy.clear();
                    v0.clear();
                    vv.clear();
                    warning.setText(null);
                });

                Ok.setOnAction(E -> {
                    if (Hcount == 0 && hh.getText().isEmpty() || Tcount == 0 && TT.getText().isEmpty() || tcount == 0 && tt.getText().isEmpty() || rcount == 0 && rr.getText().isEmpty() || thcount == 0 && thh.getText().isEmpty() || xcount == 0 && xx.getText().isEmpty() || ycount == 0 && yy.getText().isEmpty() || v0count == 0 && v0.getText().isEmpty() || Vcount == 0 && vv.getText().isEmpty()) {
                        System.out.println("dhukse");
                        warning.setText("Please enter all the answers!");
                    } else {
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
                            if (xcount == 0 && xx.getText() != null) {
                                xxx = xx.getText();
                                xx.clear();
                                X = Double.parseDouble(xxx);
                            }
                            if (ycount == 0 && yy.getText() != null) {
                                yyy = yy.getText();
                                yy.clear();
                                Y = Double.parseDouble(yyy);
                            }
                            if (v0count == 0 && v0.getText() != null) {
                                v00 = v0.getText();
                                v0.clear();
                                V0 = Double.parseDouble(v00);
                            }
                            if (Vcount == 0 && vv.getText() != null) {
                                vvv = vv.getText();
                                vv.clear();
                                V = Double.parseDouble(vvv);
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

        double angle = (theta * Math.PI) / 180;

        St.setOnAction(e -> {
            if (Hmax == -1 && Hcount == 0 || Theta == -1 && thcount == 0 || Tmax == -1 && Tcount == 0 || time == -1 && tcount == 0 || Range == -1 && rcount == 0 || X == -1 && xcount == 0 || Y == -1 && ycount == 0 || V0 == -1 && v0count == 0 || V == -1 && Vcount == 0) {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("You have to first answer the questions");
                a.show();
            } else {
                try {
                    shadow.setOpacity(0);
                    if (projectileType == 0) {
                        posX = ball.getTranslateX();
                        posY = ball.getTranslateY();
                    } else {
                        posX = Ball.getTranslateX();
                        posY = Ball.getTranslateY();
                    }
                    double S = Math.sin(angle);
                    double C = Math.cos(angle);
                    if (H == 0)
                        H = Math.pow((Velo * S), 2) / (2 * 9.8);
                    if (T == 0)
                        T = (2 * (Velo * S)) / 9.8;
                    if (R == 0)
                        R = ((Velo * Velo) * Math.sin(2 * angle)) / 9.8;
                    new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                            double k = (Velo * C * t);
                            double j = (Velo * S * t) - (0.5 * 9.8 * t * t);
                            if (projectileType == 0) {
                                ball.setTranslateX(posX + k * mulX);
                                ball.setTranslateY(posY - j * mulY);
                            } else {
                                Ball.setTranslateX(posX + k * mulX);
                                Ball.setTranslateY(posY - j * mulY);
                            }
                            double vx = Velo * C;
                            double vy = Velo * S - (9.8 * t);
                            double TotalV = Math.sqrt((vx * vx) + (vy * vy));
                            SVelo.setText("Velocity: " + String.format("%.2f", TotalV) + "m/s");
                            STime.setText("Time: " + String.format("%.2f", t) + "s");
                            SHmax.setText("Hmax: " + String.format("%.2f", H) + "m");
                            SR.setText("Range: " + String.format("%.2f", R) + "m");
                            STmax.setText("Tmax: " + String.format("%.2f", (2 * (Velo * S)) / 9.8) + "s");
                            SX.setText("X: " + String.format("%.2f", k) + "m");
                            SY.setText("Y: " + String.format("%.2f", j) + "m");
                            if (t >= T) {
                                stop();
                                if (Hmax != -1) {
                                    if (RoundUpDecimal.round(H, Hmax)) {
                                        check = 0;
                                    } else {
                                        check = 1;
                                    }
                                }
                                if (check == 0) {
                                    if (time != -1) {
                                        if (RoundUpDecimal.round(time, Tmax / 2)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                if (check == 0) {
                                    if (Range != -1) {
                                        if (RoundUpDecimal.round(R, Range)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                if (check == 0) {
                                    if (Theta != -1) {
                                        if (RoundUpDecimal.round(theta, Theta)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                if (check == 0) {
                                    if (X != -1) {
                                        if (RoundUpDecimal.round(k, X)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                if (check == 0) {
                                    if (Y != -1) {
                                        if (RoundUpDecimal.round(Math.abs(j), Y)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                if (check == 0) {
                                    if (V0 != -1) {
                                        if (RoundUpDecimal.round(V0, Velo)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                if (check == 0) {
                                    if (V != -1) {
                                        if (RoundUpDecimal.round(V, TotalV)) {
                                            check = 0;
                                        } else {
                                            check = 1;
                                        }
                                    }
                                }
                                GridPane S = new GridPane();
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
                                }
                                S.add(ShowA, 1, 1);
                                S.setAlignment(Pos.CENTER);
                                S.setVgap(4);
                                S.setHgap(5);
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
                                t += 0.01;
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

        back.setOnAction(e -> {
            try {
                solve goBack = new solve();
                goBack.start(primaryStage);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        Image background = new Image(Type);
        root.getChildren().addAll(cn, back, shadow, St, SVelo, STime, SHmax, SR, STmax, SX, SY, L, en);
        if (projectileType == 0) {
            root.getChildren().add(ball);
        } else {
            root.getChildren().add(Ball);
        }

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        root.setBackground(bg);


        Scene scene = new Scene(root, 1600, 800);

        scene.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            if (event.getCode() == KeyCode.ENTER) {

            }
        });
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

    public static int randInt(int min, int max) {

        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
