package com.example.calculadorafx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import pt.ubi.ihc.Registadora;

/**
 * FXML Controller class
 *
 * @author jpc
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextArea textoTxtArea;
    @FXML
    private Label resultadoLabel;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button0;
    @FXML
    private Button buttonPonto;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonDiv;
    @FXML
    private Button buttonMult;
    @FXML
    private Button buttonAdd;
    @FXML
    private Button buttonMinus;
    @FXML
    private Button buttonRes;

    Registadora registadora;

    private StringBuilder svalor;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        registadora = new Registadora();
        svalor = new StringBuilder();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button b = (Button) event.getSource();
            System.out.println(b.getText().charAt(0));
            process(b.getText().charAt(0));
        }
    }
    
    @FXML
    private void handleKeyTyped(KeyEvent event){
        char c0 = event.getCharacter().charAt(0);
        if((c0==13) || (c0 == 3)) c0 = '=';
        textoTxtArea.setFocusTraversable(true);
        process(c0);
    }

    public void process(char c) {
        if (c == '+' || c == '-' || c == 'x' || c == '/') {
            if (!svalor.isEmpty()) {
                processOperadores(c);
            }
        } else if (c == 'C') {
            processReset();
        } else if (Character.isDigit(c)) {
            processDigito(c);
        } else if (c == 'R') {
            if (!svalor.isEmpty()) {
                processResultado();
            }
        } else if (c == '.') {
            if (!contemPonto(svalor)) {
                svalor.append('.');
                textoTxtArea.appendText(".");
            }
        }
    }

    public void processOperadores(char c) {
        double num;

        num = Double.parseDouble(svalor.toString());
        registadora.regista(num);

        if (c == '+') {
            registadora.defineOperador('+');
        } else if (c == '-') {
            registadora.defineOperador('-');
        } else if (c == 'x') {
            registadora.defineOperador('x');
        } else if (c == '/') {
            registadora.defineOperador('/');
        }

        textoTxtArea.appendText(" " + c + "\n");

        resultadoLabel.setText(String.valueOf(registadora.getResultado()));
        svalor.setLength(0);
    }

    public void processReset() {
        registadora = new Registadora();
        svalor.setLength(0);
        //textoTxtArea.clear();
        resultadoLabel.setText("");
    }

    public void processDigito(char c) {
        svalor.append(c);
        textoTxtArea.appendText(String.valueOf(c));
    }

    public void processResultado() {
        double num = Double.parseDouble(svalor.toString());
        registadora.regista(num);

        resultadoLabel.setText(String.valueOf(registadora.getResultado()));
        textoTxtArea.appendText("\n-------------------\nResultado: " + String.valueOf(registadora.getResultado()) + "\n-------------------\n");
        processReset();
    }

    public boolean contemPonto(StringBuilder n) {
        for (int i = 0; i < n.length(); i++) {
            if (n.charAt(i) == '.') {
                return true;
            }
        }
        return false;
    }
}
