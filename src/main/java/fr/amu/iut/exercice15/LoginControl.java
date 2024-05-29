package fr.amu.iut.exercice15;

import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.binding.IntegerBinding;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.function.Predicate;

public class LoginControl extends GridPane {
    @FXML
    private TextField userId;

    @FXML
    private PasswordField pwd;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button okBtn;

    public void createBindings() {
        // MÉTHODE À COMPLÉTER
        pwd.disableProperty()
                .bind(
                        Bindings.not(Bindings.greaterThanOrEqual(Bindings.length(userId.textProperty()), 6))
                );

        cancelBtn.disableProperty()
                .bind(
                        Bindings.not(Bindings.or(
                            Bindings.greaterThanOrEqual(Bindings.length(userId.textProperty()), 1),
                            Bindings.greaterThanOrEqual(Bindings.length(pwd.textProperty()), 1)
                        ))
                );

        okBtn.disableProperty()
                .bind(
                        Bindings.not(Bindings.and(
                            Bindings.and(
                                    Bindings.createBooleanBinding(() -> {
                                        boolean test = pwd.textProperty().get().chars().anyMatch(Character::isUpperCase);
                                        return test;
                                    }, pwd.textProperty()),
                                    Bindings.createBooleanBinding(() -> {
                                        boolean test = pwd.textProperty().get().chars().anyMatch(Character::isDigit);
                                        return test;
                                    }, pwd.textProperty())
                            ),
                            Bindings.greaterThanOrEqual(Bindings.length(pwd.textProperty()), 8)
                        ))
                );
    }

    @FXML
    private void okClicked() {
        System.out.print(userId.getText() + " ");
        for (char c : pwd.getText().toCharArray()) {
            System.out.print("*");
        }
        System.out.println();
    }

    @FXML
    private void cancelClicked() {
        userId.setText("");
        pwd.setText("");
    }
}