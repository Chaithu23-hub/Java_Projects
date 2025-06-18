import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class TodoListApp extends Application {
    private ObservableList<String> tasks;
    @Override
    public void start(Stage stage) {
        TextField taskInput = new TextField();
        taskInput.setPromptText("Enter a task");

        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete Selected");

        tasks = FXCollections.observableArrayList();
        ListView<String> taskListView = new ListView<>(tasks);

        //Action for buttons
        //Action for add button
        addButton.setOnAction(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskInput.clear();
            }
        });
        //Action for delete
        deleteButton.setOnAction(e -> {
            String selected = taskListView.getSelectionModel().getSelectedItem();
            if (selected != null) {
                tasks.remove(selected);
            }
        });

        HBox inputBox = new HBox(10, taskInput, addButton);
        VBox layout = new VBox(10, inputBox, taskListView, deleteButton);
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 350, 400);
        stage.setTitle("JavaFX To-Do List");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
