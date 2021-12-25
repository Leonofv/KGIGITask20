package sample;

import sample.CircleColors;
import javafx.animation.Animation;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Group group = new Group();
        stage.setScene(new Scene(group, 600, 600, Color.color(0,0,0)));
        stage.setTitle("Window");
        stage.show();

        Group circles = new Group();
        Transition[] transitions = new Transition[3];

        for (int i = 0; i < 3; i++) {
            Circle circle = new Circle(110, CircleColors.colors[i]);
            circles.getChildren().add(circle);
            circle.setBlendMode(BlendMode.ADD);

            PathTransition pathTransition = new PathTransition();
            pathTransition.setNode(circle);
            pathTransition.setDuration(Duration.seconds(2));

            pathTransition.setPath(new Path(

                    new MoveTo(250, 300),

                    new LineTo(360, 300),

                    new LineTo(250, 300)
            ));

            transitions[i] = pathTransition;
            pathTransition.setCycleCount(Animation.INDEFINITE);

        }

        group.getChildren().add(circles);

        for (int i = 0; i < 3; i++) {
            transitions[i].jumpTo(transitions[i].getCycleDuration().divide(i / 3.));
        }

        for (int i = 0; i < 3; i++) {
            transitions[i].play();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
