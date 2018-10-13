package rssfeed;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.scene.paint.Color;
import java.util.*;


public class ScoreService {
    private List<Client> observers = new ArrayList<>();

    public void addObserver(Client obs) {
        observers.add(obs);
    }

    public void removeObserver(Client obs) {
        observers.remove(obs);
    }

    public Pane getRoot() {
        return createNodeHierarchy();
    }

    private Pane createNodeHierarchy() {
        HBox p1 = new HBox();
        p1.setPadding(new Insets(20));
        p1.setBackground(
                new Background(
                        new BackgroundFill(Color.HOTPINK,
                                new CornerRadii(0), new Insets(0))));

        VBox home = new VBox();
        Label homeTitle = new Label("Home");
        home.setAlignment(Pos.CENTER);

        HBox homeTop = new HBox();
        homeTop.setPadding(new Insets(10));
        homeTop.setSpacing(8);
        Label name = new Label("Name");
        TextField nameField = new TextField();
        homeTop.getChildren().addAll(name, nameField);

        HBox homeBottom = new HBox();
        homeBottom.setPadding(new Insets(10));
        homeBottom.setSpacing(8);
        Label score = new Label("Score");
        TextField scoreField = new TextField();
        homeBottom.getChildren().addAll(score, scoreField);

        home.getChildren().addAll(homeTitle, homeTop, homeBottom);

        VBox away = new VBox();
        Label awayTitle = new Label("Away");
        away.setAlignment(Pos.CENTER);

        HBox awayTop = new HBox();
        awayTop.setPadding(new Insets(10));
        awayTop.setSpacing(8);
        Label name2 = new Label("Name");
        TextField nameField2 = new TextField();
        awayTop.getChildren().addAll(name2, nameField2);

        HBox awayBottom = new HBox();
        awayBottom.setPadding(new Insets(10));
        awayBottom.setSpacing(8);
        Label score2 = new Label("Score");
        TextField scoreField2 = new TextField();
        awayBottom.getChildren().addAll(score2, scoreField2);

        away.getChildren().addAll(awayTitle, awayTop, awayBottom);

        VBox sport = new VBox();
        Label sportTitle = new Label("Sport");
        sport.setAlignment(Pos.CENTER);

        HBox sportTop = new HBox();
        sportTop.setPadding(new Insets(10));
        TextField sportField = new TextField();
        sportTop.getChildren().add(sportField);

        HBox sportBottom = new HBox();
        sportTop.setPadding(new Insets(10));
        Button submitButton = new Button("Submit");
        sportBottom.setAlignment(Pos.CENTER);
        sportBottom.getChildren().addAll(submitButton);

        sport.getChildren().addAll(sportTitle, sportTop, sportBottom);

        p1.getChildren().addAll(home, away, sport);

        submitButton.setOnAction(event -> {
            //notify observers
            for (Client c : observers) {
                c.newScore(sportField.getText(),
                        nameField.getText(),
                        nameField2.getText(),
                        scoreField.getText(),
                        scoreField2.getText());
            }

            //clear all text fields upon pressing submit
            nameField.setText("");
            nameField2.setText("");
            scoreField.setText("");
            scoreField2.setText("");
            sportField.setText("");
        });

        return p1;
    }

}
