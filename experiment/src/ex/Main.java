package ex;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main extends Application {
    int x=0,y=0,r;
    int[] h = new int[2];
    int[] w = new int[2];
    double v=0,vofObj1=0,vofObj2=0;
    int countGiveV=0;
    double g=9.8, t=0,theta=0;

    Sphere ball = new Sphere();
    Box[] rectangle = new Box[2];

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {

        Pane root = new Pane();

        Image background = new Image("backg.jpg");

        NumberAxis xAxis = new NumberAxis(0, 100, 5);

        NumberAxis yAxis = new NumberAxis(0, 50, 5);

        LineChart lc = new LineChart(xAxis,yAxis);

        lc.setPrefHeight(550);
        lc.setPrefWidth(650);
        lc.setMinHeight(625);
        lc.setMinWidth(1250);

        lc.setTranslateX(50);
        lc.setTranslateY(115);
        lc.setBlendMode(BlendMode.SCREEN);

        Label SVelo = new Label("Velocity: " + v );
        SVelo.setTranslateX(1350);
        SVelo.setTranslateY(70);
        SVelo.setTextFill(Color.WHITE);
        SVelo.setScaleX(2);
        SVelo.setScaleY(2);

        Label STime = new Label("Time: 0" );
        STime.setTranslateX(1350);
        STime.setTranslateY(120);
        STime.setTextFill(Color.WHITE);
        STime.setScaleX(2);
        STime.setScaleY(2);

        Label SHmax = new Label( "Hmax: 0" );
        SHmax.setTranslateX(1350);
        SHmax.setTranslateY(170);
        SHmax.setTextFill(Color.WHITE);
        SHmax.setScaleX(2);
        SHmax.setScaleY(2);

        Label SR = new Label("Range: 0");
        SR.setTranslateX(1350);
        SR.setTranslateY(220);
        SR.setTextFill(Color.WHITE);
        SR.setScaleX(2);
        SR.setScaleY(2);

        Label STmax = new Label("Tmax: 0");
        STmax.setTranslateX(1350);
        STmax.setTranslateY(270);
        STmax.setTextFill(Color.WHITE);
        STmax.setScaleX(2);
        STmax.setScaleY(2);

        Label SX = new Label("X: 0");
        SX.setTranslateX(1350);
        SX.setTranslateY(320);
        SX.setTextFill(Color.WHITE);
        SX.setScaleX(2);
        SX.setScaleY(2);

        Label SY = new Label("Y: 0");
        SY.setTranslateX(1350);
        SY.setTranslateY(370);
        SY.setTextFill(Color.WHITE);
        SY.setScaleX(2);
        SY.setScaleY(2);

        rectangle[0]= new Box();
        rectangle[1]= new Box();

        Alert a = new Alert(Alert.AlertType.NONE);

        Rectangle Ground = new Rectangle();
        Ground.setHeight(5);
        Ground.setWidth(2000);
        Ground.translateXProperty().set(0);
        Ground.translateYProperty().set(700);
        Ground.setFill(Color.WHITE);

        Menu m1 = new Menu("Add");

        MenuItem item1 = new MenuItem("Circle");
        FileInputStream it1 = new FileInputStream("src/circle.png");
        Image inp1 = new Image(it1);
        item1.setGraphic(new ImageView(inp1));

        MenuItem item2 = new MenuItem("Rectangle");
        FileInputStream it2 = new FileInputStream("src/rectangle.png");
        Image inp2 = new Image(it2);
        item2.setGraphic(new ImageView(inp2));

        m1.getItems().addAll(item1, item2);
        FileInputStream input = new FileInputStream("src/A.png");
        Image im = new Image(input);
        m1.setGraphic(new ImageView(im));


        item1.setOnAction(e -> {
            x++;
            if(x>1)
            {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("Not permitted to use more than one circle");
                a.show();
            }
            else {

                try {
                    Stage radius = new Stage();
                    GridPane R = new GridPane();
                    R.setAlignment(Pos.CENTER);
                    Label setRL = new Label("Radius");
                    TextField Rad = new TextField();
                    Label CL = new Label("m");
                    R.setVgap(4);
                    R.setHgap(10);
                    R.setPadding(new Insets(5, 5, 5, 5));
                    R.add(setRL, 0, 0);
                    R.add(Rad, 1, 0);
                    R.add(CL, 2, 0);
                    Scene S = new Scene(R, 500, 200);
                    radius.setTitle("Radius");
                    radius.setScene(S);
                    radius.show();

                    S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                        if (event.getCode() == KeyCode.ENTER) {
                            String Radius = Rad.getText();
                            r = Integer.parseInt(Radius);
                            ball.setRadius(r);
                            ball.setTranslateX(700);
                            ball.setTranslateY(300);
                            PhongMaterial M = new PhongMaterial();
                            M.setDiffuseMap(new Image(getClass().getResourceAsStream("/ball.png")));
                            ball.setMaterial(M);
                            root.getChildren().add(ball);
                            radius.close();
                        }
                    });

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        ball.setOnMouseDragged(e ->{
            if((ball.getTranslateY()+e.getY())<(700-r)){
                    ball.setTranslateX(ball.getTranslateX() + e.getX());
                    ball.setTranslateY(ball.getTranslateY() + e.getY());
                }
                });

        item2.setOnAction(e -> {
            y++;
            if(y>2)
            {
                a.setAlertType(Alert.AlertType.WARNING);
                a.setContentText("Not permitted to use more than two rectangles");
                a.show();
            }
            else {
                try {
                    Stage size = new Stage();
                    GridPane Hw = new GridPane();
                    Hw.setAlignment(Pos.CENTER);
                    Label setH = new Label("Height");
                    Label setW = new Label("Width");
                    TextField He = new TextField();
                    TextField We = new TextField();
                    Label CL = new Label("m");
                    Label CL1 = new Label("m");
                    Hw.setVgap(4);
                    Hw.setHgap(10);
                    Hw.setPadding(new Insets(5, 5, 5, 5));
                    Hw.add(setH, 0, 0);
                    Hw.add(setW, 0, 1);
                    Hw.add(He, 1, 0);
                    Hw.add(We, 1, 1);
                    Hw.add(CL, 2, 0);
                    Hw.add(CL1, 2, 1);
                    Scene S = new Scene(Hw, 500, 200);
                    size.setTitle("Size");
                    size.setScene(S);
                    size.show();

                    S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                        if (event.getCode() == KeyCode.ENTER) {
                            if(He.getText()==null || We.getText()==null)
                            {
                                size.close();
                                a.setAlertType(Alert.AlertType.ERROR);
                                a.setContentText("Please enter all the parameters");
                                a.show();
                            }
                            else {
                                String Height = He.getText();
                                h[y - 1] = Integer.parseInt(Height)*11;
                                String width = We.getText();
                                w[y - 1] = Integer.parseInt(width)*11;
                                rectangle[y - 1].setHeight(h[y - 1]);
                                rectangle[y - 1].setWidth(w[y - 1]);
                                rectangle[y - 1].setTranslateX(600);
                                rectangle[y - 1].setTranslateY(300);

                                PhongMaterial M = new PhongMaterial();
                                M.setDiffuseMap(new Image(getClass().getResourceAsStream("/wall.png")));
                                rectangle[y - 1].setMaterial(M);
                                root.getChildren().add(rectangle[y - 1]);
                                size.close();
                            }
                        }
                    });

                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });

        rectangle[0].setOnMouseDragged(e ->{
            if((rectangle[0].getTranslateY()+ e.getY())<(700-h[0]/2)){
                rectangle[0].setTranslateX(rectangle[0].getTranslateX()+ e.getX());
                rectangle[0].setTranslateY(rectangle[0].getTranslateY()+ e.getY());}
        });

        rectangle[1].setOnMouseDragged(e ->{
            if((rectangle[1].getTranslateY()+ e.getY())<(700-h[1]/2)){
                rectangle[1].setTranslateX(rectangle[1].getTranslateX()+ e.getX());
                rectangle[1].setTranslateY(rectangle[1].getTranslateY()+ e.getY());}
        });

        ContextMenu cm = new ContextMenu();
        MenuItem Ivelo = new MenuItem("Add/Change Initial Velocity");
        MenuItem Itheta = new MenuItem("Add/Change Initial Angle");
        MenuItem Igrav = new MenuItem("Add/Change Gravity");
        cm.getItems().addAll(Ivelo,Itheta,Igrav);

        ball.setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                cm.show(ball, event.getScreenX(), event.getScreenY());
            }
        });

        ContextMenu CM1 = new ContextMenu();
        MenuItem V = new MenuItem("Add Velocity");
        MenuItem Id = new MenuItem("Add Direction");
        CM1.getItems().addAll(V,Id);

        rectangle[0].setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                CM1.show(rectangle[0], event.getScreenX(), event.getScreenY());
            }
        });

        ContextMenu CM2 = new ContextMenu();
        MenuItem V2 = new MenuItem("Add Velocity");
        MenuItem Id2 = new MenuItem("Add Direction");
        CM2.getItems().addAll(V2,Id2);

        rectangle[1].setOnContextMenuRequested(new EventHandler<ContextMenuEvent>() {

            @Override
            public void handle(ContextMenuEvent event) {

                CM2.show(rectangle[1], event.getScreenX(), event.getScreenY());
            }
        });

        V.setOnAction(e->{
            try {
                if (countGiveV == 0) {
                    Stage velo = new Stage();
                    GridPane VELO = new GridPane();
                    VELO.setAlignment(Pos.CENTER);
                    Label setV = new Label("Velocity:");
                    Label CL = new Label("m/s");
                    TextField Ve = new TextField();
                    VELO.add(setV, 3, 0, 2, 1);
                    VELO.add(Ve, 3, 10, 1, 1);
                    VELO.add(CL, 25, 10, 1, 1);
                    Scene S = new Scene(VELO, 300, 200);
                    velo.setTitle("Velocity");
                    velo.setScene(S);
                    velo.show();

                    S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                        if (event.getCode() == KeyCode.ENTER) {
                            countGiveV = 1;
                            String Velocity = Ve.getText();
                            vofObj1 = Double.parseDouble(Velocity);
                            velo.close();
                        }
                    });
                }
                else
                {
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Not permitted to give velocity to two rectangles!");
                    a.show();
                }
            }catch (Exception E) {
                E.printStackTrace();
            }
        });

        V2.setOnAction(e->{
            try {
                if (countGiveV == 0) {
                    Stage velo = new Stage();
                    GridPane VELO = new GridPane();
                    VELO.setAlignment(Pos.CENTER);
                    Label setV = new Label("Velocity:");
                    TextField Ve = new TextField();
                    VELO.add(setV, 3, 0, 2, 1);
                    VELO.add(Ve, 3, 10, 1, 1);
                    Scene S = new Scene(VELO, 300, 200);
                    velo.setTitle("Velocity");
                    velo.setScene(S);
                    velo.show();

                    S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                        if (event.getCode() == KeyCode.ENTER) {
                            countGiveV=1;
                            String Velocity = Ve.getText();
                            vofObj2 = Double.parseDouble(Velocity);
                            velo.close();
                        }
                    });
                }
                else
                {
                    a.setAlertType(Alert.AlertType.WARNING);
                    a.setContentText("Not permitted to give velocity to two rectangles!");
                    a.show();
                }
            }catch (Exception E) {
                E.printStackTrace();
            }
        });

        Ivelo.setOnAction(e -> {
            try {
                Stage velo = new Stage();
                GridPane VELO = new GridPane();
                VELO.setAlignment(Pos.CENTER);
                Label setV = new Label("Velocity:");
                TextField Ve = new TextField();
                VELO.add(setV,3,0,2,1);
                VELO.add(Ve,3,10,1,1);
                Scene S = new Scene(VELO, 300, 200);
                velo.setTitle("Velocity");
                velo.setScene(S);
                velo.show();

                S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        String Velocity = Ve.getText();
                        v = Double.parseDouble(Velocity);
                        velo.close();
                    }
                });
            } catch (Exception E) {
                E.printStackTrace();
            }
        });

        Igrav.setOnAction(e -> {
            try {
                Stage grav = new Stage();
                GridPane G = new GridPane();
                G.setAlignment(Pos.CENTER);
                Label setG = new Label("Gravity:");
                TextField Gr = new TextField();
                G.add(setG,3,0,2,1);
                G.add(Gr,3,10,1,1);
                Scene S = new Scene(G, 300, 200);
                grav.setTitle("Gravity");
                grav.setScene(S);
                grav.show();

                S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        String Gravity = Gr.getText();
                        g = Double.parseDouble(Gravity);
                        grav.close();
                    }
                });
            } catch (Exception E) {
                E.printStackTrace();
            }
        });

        Itheta.setOnAction(e -> {
            try {
                Stage thet = new Stage();
                GridPane T = new GridPane();
                T.setAlignment(Pos.CENTER);
                Label setT = new Label("Angle:");
                TextField Th = new TextField();
                T.add(setT,3,0,2,1);
                T.add(Th,3,10,1,1);
                Scene S = new Scene(T, 300, 200);
                thet.setTitle("Angle");
                thet.setScene(S);
                thet.show();

                S.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
                    if (event.getCode() == KeyCode.ENTER) {
                        String Theta = Th.getText();
                        theta = (Double.parseDouble(Theta)*Math.PI)/180;
                        thet.close();
                    }
                });
            } catch (Exception E) {
                E.printStackTrace();
            }
        });


        Button St = new Button("Start");
        St.setPadding(new Insets(15));
        setStyle(St);
        St.setTranslateX(1200);
        St.setTranslateY(730);

        Button Pa = new Button("Pause");
        Pa.setPadding(new Insets(15));
        setStyle(Pa);
        Pa.setTranslateX(1280);
        Pa.setTranslateY(730);


        St.setOnAction(e ->{
            double posX = ball.getTranslateX();
            double posY = ball.getTranslateY();
            double S = Math.sin(theta) ;
            double C = Math.cos(theta);
            double T = (2 * (v * S)) / g;
            double H = Math.pow((v*S),2)/(2*g);
            double R = ((v*v)*Math.sin(2*theta))/g;
            System.out.println(v);
            new AnimationTimer() {
                @Override
                public void handle(long now) {
                    double k = (v * C * t);
                    double j = (v * S * t) - (0.5 * g * t * t);
                    ball.setTranslateX(posX+k*12);
                    ball.setTranslateY(posY-j*10);
                    if(checkCollisions()==true)
                    {
                        stop();
                    }
                    double vx = v * C ;
                    double vy = v * S - ( g * t );
                    double TotalV = Math.sqrt((vx*vx)+(vy*vy));
                    SVelo.setText("Velocity: "+ String.format("%.2f", TotalV)+"m/s");
                    STime.setText("Time: "+ String.format("%.2f", t)+"s");
                    SHmax.setText("Hmax: "+ String.format("%.2f", H)+"m");
                    SR.setText("Range: "+ String.format("%.2f", R)+"m");
                    STmax.setText("Tmax: " + String.format("%.2f", T)+"s");
                    SX.setText("X: " + String.format("%.2f", k)+"m");
                    SY.setText("Y: " + String.format("%.2f", j)+"m");

                    rectangle[0].setTranslateX(rectangle[0].getTranslateX()-(0.01*vofObj1));

                    if(t>=T && T!=0)
                    {
                        if(ball.getTranslateY()>=(700-ball.getRadius()))
                        stop();
                    }
                    else if(ball.getTranslateY()>=(700-ball.getRadius()))
                    {
                        stop();
                    }
                    else {
                        t += 0.01;
                    }

                    Pa.setOnAction(event->{
                        stop();
                        root.setOnKeyPressed(E->{
                            if(E.getCode()==KeyCode.D)
                            {
                                double Sx = (v * C * t);
                                double Sy = (v * S * t) - (0.5 * g * t * t);
                                ball.setTranslateX(posX+Sx*12);
                                ball.setTranslateY(posY-Sy*10);
                                if(checkCollisions()==true)
                                {
                                    stop();
                                }
                                double Vx = v * C ;
                                double Vy = v * S - ( g * t );
                                double TotalVelo = Math.sqrt((Vx*Vx)+(Vy*Vy));
                                SVelo.setText("Velocity: "+ String.format("%.2f", TotalVelo)+"m/s");
                                STime.setText("Time: "+ String.format("%.2f", t)+"s");
                                SHmax.setText("Hmax: "+ String.format("%.2f", H)+"m");
                                SR.setText("Range: "+ String.format("%.2f", R)+"m");
                                STmax.setText("Tmax: " + String.format("%.2f", T)+"s");
                                SX.setText("X: " + String.format("%.2f", Sx)+"m");
                                SY.setText("Y: " + String.format("%.2f", Sy)+"m");
                                if(t>=T || ball.getTranslateY()>=700)
                                {
                                    stop();
                                }
                                else {
                                    t += 0.01;
                                }
                            }
                            else if(E.getCode()==KeyCode.A)
                            {
                                t-=0.01;
                                double Sx = (v * C * t);
                                double Sy = (v * S * t) - (0.5 * g * t * t);
                                ball.setTranslateX(posX+Sx*12);
                                ball.setTranslateY(posY-Sy*10);
                                if(checkCollisions()==true)
                                {
                                    stop();
                                }
                                double Vx = v * C ;
                                double Vy = v * S - ( g * t );
                                double TotalVelo = Math.sqrt((Vx*Vx)+(Vy*Vy));
                                SVelo.setText("Velocity: "+ String.format("%.2f", TotalVelo)+"m/s");
                                STime.setText("Time: "+ String.format("%.2f", t)+"s");
                                SHmax.setText("Hmax: "+ String.format("%.2f", H)+"m");
                                SR.setText("Range: "+ String.format("%.2f", R)+"m");
                                STmax.setText("Tmax: " + String.format("%.2f", T)+"s");
                                SX.setText("X: " + String.format("%.2f", Sx)+"m");
                                SY.setText("Y: " + String.format("%.2f", Sy)+"m");
                                if(t>=T || ball.getTranslateY()>=Ground.getTranslateY())
                                {
                                    stop();
                                }
                            }
                        });
                    });
                }
                }.start();
        });

        Button Re = new Button("Reset");
        Re.setPadding(new Insets(15));
        setStyle(Re);
        Re.setTranslateX(1370);
        Re.setTranslateY(730);

        Re.setOnAction(e->{
            root.getChildren().remove(ball);
            root.getChildren().remove(rectangle[0]);
            root.getChildren().remove(rectangle[1]);
            x=0;
            y=0;
        });

        Menu m2 = new Menu("Settings");
        MenuItem item3 = new MenuItem("Change Background");
        MenuItem item4 = new MenuItem("Reset to default");
        m2.getItems().addAll(item3, item4);

        FileInputStream input1 = new FileInputStream("src/settings.png");
        Image im1 = new Image(input1);
        m2.setGraphic(new ImageView(im1));

        MenuBar menubar = new MenuBar();
        
        menubar.getMenus().addAll(m1, m2);
        root.getChildren().addAll(menubar);
        root.getChildren().addAll(Ground,lc,St,Pa,Re);
        root.getChildren().addAll(SVelo,STime,SHmax,SR,STmax,SX,SY);

        BackgroundImage bi = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        Background bg = new Background(bi);
        root.setBackground(bg);

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        //primaryStage.setFullScreen(true);
        primaryStage.show();

    }


    public Button setStyle( Button b)
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
                "    -fx-font-size: 1.1em;");
        return  b;
    }

    public boolean checkCollisions()
    {
        Bounds r3 = rectangle[0].getBoundsInParent();

        Bounds r2 = ball.getBoundsInParent();

            if (r2.intersects(r3)) {
                return true;
            }
            else
                return false;
    }


    public static void main(String[] args) {
        launch(args);
    }
}
