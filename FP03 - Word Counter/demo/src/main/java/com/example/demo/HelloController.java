package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextArea txAreatexto;
    @FXML
    private TextField txfpalavra;
    @FXML
    private Label txfnumVezesAparece;
    @FXML
    private CheckBox maiusculas;

    @FXML
    public void actionContar(ActionEvent e) {
        String texto = txAreatexto.getText();
        String palavraProcurada = txfpalavra.getText();
        int num = 0;

        if (maiusculas.isSelected()) {
            String textoUC = texto.toUpperCase();
            String palavraProcuradaUC = palavraProcurada.toUpperCase();
            num = HelloController.contaPalavraNumTexto(textoUC, palavraProcuradaUC);
            txfnumVezesAparece.setText(String.valueOf(num));
        } else {
            num = HelloController.contaPalavraNumTexto(texto, palavraProcurada);
            txfnumVezesAparece.setText(String.valueOf(num));
        }
    }
    public static int contaPalavraNumTexto(String texto, String palavraProcurada) {
        int cont = 0;
        String[] palavrasTexto = texto.split("\\W+"); //Da split ao texto palavra por palavra

        for (int i = 0; i < palavrasTexto.length; i++) {
            if (palavrasTexto[i].equals(palavraProcurada))
                cont++;
        }

        return cont;
    }
}