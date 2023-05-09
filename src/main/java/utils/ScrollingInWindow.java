package utils;

import com.example.harrypottergui.vue.FightBoard;
import com.example.harrypottergui.vue.StartController;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.Transition;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ScrollingInWindow {
    public static Stage stagetext = new Stage();
    public static void printInWindow(String text) {
        printInWindow(text, stagetext, 0);
    }

    public static void printInWindow(String text, int delay) {
        printInWindow(text, stagetext, delay);
    }

    public static Button nextButton;
    public static void printInWindow(String text, Stage stage, int delay) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 400);
        stage.setScene(scene);
        TextArea textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        root.getChildren().add(textArea);

        nextButton = new Button("Suivant");
        nextButton.setOnAction(event -> {
            stage.close();
        });
        root.getChildren().add(nextButton);
        VBox.setMargin(nextButton, new Insets(20, 0, 0, 0));
        nextButton.setAlignment(Pos.CENTER);

        stage.show();

        String[] lines = text.split("\n");
        for (String line : lines) {
            if (delay > 0) {
                PauseTransition pause = new PauseTransition(Duration.millis(delay));
                pause.setOnFinished(event -> textArea.appendText(line + "\n"));
                pause.play();
            } else {
                textArea.appendText(line + "\n");
            }
        }
    }

    public static void setMessage(String string) {
        final Animation animation = new Transition() {
            {
                setCycleDuration(Duration.millis(1000));
            }

            protected void interpolate(double frac) {
                final int length = string.length();
                final int n = Math.round(length * (float) frac);
                FightBoard.textDialogue.setText(string.substring(0, n));
            }
        };
        animation.play();
    }



//    public static void printInWindow(String text) {
//        printInWindow(text, new Stage(), 0);
//    }
//
//    public static void printInWindow(String text, int delay) {
//        printInWindow(text, new Stage(), delay);
//    }

//    public static void printInWindow(String text, Stage stage, int delay) {
//        VBox root = new VBox();
//        Scene scene = new Scene(root, 600, 400);
//        stage.setScene(scene);
//        TextArea textArea = new TextArea();
//        textArea.setWrapText(true);
//        textArea.setEditable(false);
//        root.getChildren().add(textArea);
//        stage.show();
//        String[] lines = text.split("\n");
//        for (String line : lines) {
//            PauseTransition pause = new PauseTransition(Duration.millis(delay));
//            pause.setOnFinished(event -> textArea.appendText(line + "\n"));
//            pause.play();
//        }
//    }

}
