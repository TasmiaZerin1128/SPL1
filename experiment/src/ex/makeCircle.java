package ex;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class makeCircle {

    int r;
    public int create(Sphere ball) {
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
                    radius.close();
                }
            });
        } catch (Exception E) {
            E.printStackTrace();
        }
        return r;
    }
}
