package First;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class H {
    int startP=0;
    Circle ball = new Circle();
    Canvas canvas = new Canvas();
    Text def = new Text();
    public void start(Pane root, int n, Button back)
    {
        if(n==0) {
            def.setText("H is the maximum height attained by the projectile or the maximum displacement on the\nvertical axis(y-axis) covered by the projectile");
            def.setTranslateX(400);
            def.setTranslateY(250);
            def.setScaleX(2);
            def.setScaleY(2);
            def.setStroke(Color.LIGHTGOLDENRODYELLOW);
            def.setFont(Font.font("Times New Roman", FontPosture.ITALIC, 14));

        ball = new Circle(30);
        ball.setFill(Color.WHITE);
        ball.setTranslateX(200);
        ball.setTranslateY(700);
        canvas = new Canvas(1000, 1000);
        canvas.setTranslateX(115);

            Path path = new Path();
            path.getElements().add(new MoveTo(200f, 700f));
            CubicCurveTo cct = new CubicCurveTo();
            cct.setControlX1(550.0f);
            cct.setControlY1(250.0f);
            cct.setControlX2(670.0f);
            cct.setControlY2(250.0f);
            cct.setX(1017.0f);
            cct.setY(700.0f);
            path.getElements().add(cct);
            path.setOpacity(100.0);
            path.setStroke(Color.WHITE);


            PathTransition pt = new PathTransition();
            pt.setDuration(Duration.seconds(6));
            pt.setNode(ball);
            pt.setPath(path);
            pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
            pt.setCycleCount(Timeline.INDEFINITE);
            pt.setAutoReverse(false);
            pt.play();

            GraphicsContext gc = canvas.getGraphicsContext2D();
            Image R = new Image("height.png");
            gc.drawImage(R, 410, 340);
            root.getChildren().addAll(canvas, ball, path,def);
        }
        else
        {
                root.getChildren().remove(ball);
                root.getChildren().remove(canvas);
                root.getChildren().remove(def);
        }


    }
}
