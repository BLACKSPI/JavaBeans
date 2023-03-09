package application;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class JavaBeans extends Application {
    
    private Person person = new Person();
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Set up UI
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        
        Label nameLabel = new Label("Name:");
        Label ageLabel = new Label("Age:");
        Label emailLabel = new Label("Email:");
        
        TextField nameField = new TextField();
        nameField.textProperty().bindBidirectional(person.nameProperty());
        
        TextField ageField = new TextField();
        ageField.textProperty().bindBidirectional(person.ageProperty());
        
        TextField emailField = new TextField();
        emailField.textProperty().bindBidirectional(person.emailProperty());
        
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> save());
        
        root.add(nameLabel, 0, 0);
        root.add(nameField, 1, 0);
        root.add(ageLabel, 0, 1);
        root.add(ageField, 1, 1);
        root.add(emailLabel, 0, 2);
        root.add(emailField, 1, 2);
        root.add(saveButton, 1, 3);
        
        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    private void save() {
        // Save data to database or perform other action
        System.out.println("Saved: " + person.getName() + ", " + person.getAge() + ", " + person.getEmail());
    }
    
    public static class Person {
        private StringProperty name = new SimpleStringProperty();
        private StringProperty email = new SimpleStringProperty();
        private StringProperty age = new SimpleStringProperty();
        
        public String getName() {
            return name.get();
        }
        
        public void setName(String name) {
            this.name.set(name);
        }
        
        public StringProperty nameProperty() {
            return name;
        }
        
        public String getEmail() {
            return email.get();
        }
        
        public void setEmail(String email) {
            this.email.set(email);
        }
        
        public StringProperty emailProperty() {
            return email;
        }
        
        public String getAge() {
            return age.get();
        }
        
        public void setAge(String age) {
            this.age.set(age);
        }
        
        public StringProperty ageProperty() {
            return age;
        }
    }
}

