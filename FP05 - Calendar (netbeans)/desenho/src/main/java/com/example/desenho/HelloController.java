package com.example.desenho;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class HelloController {
    @FXML
    private Pane panel;

    @FXML
   private ToggleButton circle;
    @FXML
    private ToggleButton rectangle;
    @FXML
    private ToggleButton triangle;

    @FXML
    private ColorPicker colour;

    @FXML
    private Spinner spin;

    @FXML
    private void handleButtonAction (ActionEvent event){
        panel.getChildren().clear();
    }

    private void panOnMouseReleased(MouseEvent event){
        double dx = panel.getWidth();
        double dy = panel.getHeight();
        double x = event.getX();
        double y = event.getY();

        Color cor = colour.getValue();
        int brush = (int) spin.getValue();

        if (circle.isSelected()){
            Circle circle = new Circle(brush, cor);
            circle.setTranslateX(x);
            circle.setTranslateY(y);
            panel.getChildren().addAll(circle);
        } else if (rectangle.isSelected())  {

            Rectangle square = new Rectangle(x,y,2*brush, 2*brush);
            square.setStroke(cor);
            /* ... */
        }


    }
}