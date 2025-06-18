package javafx1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApp extends Application {

    private TextField display = new TextField();
    private double num1 = 0;
    private String operator = "";

    //ui part
    @Override
    public void start(Stage stage) {
        display.setEditable(false);
        display.setStyle("-fx-font-size: 18px;");
        display.setPrefHeight(50);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", "C", "=", "+"
        };

        int row = 1;
        int col = 0;

        for (String text : buttons) {
            Button btn = new Button(text);
            btn.setPrefSize(80, 80);
            btn.setStyle("-fx-font-size: 16px;");
            btn.setOnAction(e -> handleInput(text));
            grid.add(btn, col, row);

            col++;
            if (col > 3) {
                col = 0;
                row++;
            }
        }

        grid.add(display, 0, 0, 4, 1);

        Scene scene = new Scene(grid, 270, 300);
        stage.setTitle("JavaFX Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void handleInput(String text) {
        switch (text) {
            case "C":
                display.clear();
                num1 = 0;
                operator = "";
                break;
            case "=":
                calculateResult();
                break;
            case "+": case "-": case "*": case "/":
                num1 = Double.parseDouble(display.getText());
                operator = text;
                display.clear();
                break;
            default:
                display.appendText(text);
        }
    }

    private void calculateResult() {
        try {
            double num2 = Double.parseDouble(display.getText());
            double result = 0;

            switch (operator) {
                case "+": result = num1 + num2; break;
                case "-": result = num1 - num2; break;
                case "*": result = num1 * num2; break;
                case "/":
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }

            display.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            display.setText("Error");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
