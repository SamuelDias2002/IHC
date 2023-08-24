package colors;

import pt.ubi.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author jpc
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Slider sliderRed;
    @FXML
    private Slider sliderGreen;
    @FXML
    private Slider sliderBlue;
    @FXML
    private Label LabelResRed;
    @FXML
    private Label LabelResGreen;
    @FXML
    private Label LabelResBlue; 
    @FXML
    private Pane painel;
    
    private Double blue = 0.0;
    private Double red = 0.0;
    private Double green = 0.0;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        sliderBlue.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> agr0, Number arg1, Number agr2) {
                blue = sliderBlue.getValue();
                LabelResBlue.setText(Integer.toString((int) ((double)blue))+" "+Integer.toHexString((int) ((double)blue)).toUpperCase());
                painel.setStyle("-fx-background-color: rgb(" + (int)((double)red) + "," + (int)((double)green) + ", " + (int)((double)blue) + ");");
                LabelResBlue.setStyle("-fx-background-color: rgb(" + 0 + "," + 0 + ", " + (int)((double)blue) + ");");
            }
        });
        sliderGreen.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> agr0, Number arg1, Number agr2) {
                green = sliderGreen.getValue();   
                LabelResGreen.setText(Integer.toString((int) ((double)green))+" "+Integer.toHexString((int) ((double)green)).toUpperCase());
                painel.setStyle("-fx-background-color: rgb(" + (int)((double)red) + "," + (int)((double)green) + ", " + (int)((double)blue) + ");");
                LabelResGreen.setStyle("-fx-background-color: rgb(" + 0 + "," + (int)((double)green) + ", " + 0 + ");");
            }
        });
        sliderRed.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> agr0, Number arg1, Number agr2) {
                red = sliderRed.getValue();
                LabelResRed.setText(Integer.toString((int) ((double)red))+" "+Integer.toHexString((int) ((double)red)).toUpperCase());
                painel.setStyle("-fx-background-color: rgb(" + (int)((double)red) + "," + (int)((double)green) + ", " + (int)((double)blue) + ");");
                LabelResRed.setStyle("-fx-background-color: rgb(" + (int)((double)red) + "," + 0 + ", " + 0 + ");");
            }
        });
    }       
}
