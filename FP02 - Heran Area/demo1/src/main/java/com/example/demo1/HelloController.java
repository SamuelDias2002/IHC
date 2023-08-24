package com.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class HelloController {
    private static final DecimalFormat df = new DecimalFormat("0.0000");

    @FXML
    TextField textA;

    @FXML
    TextField textB;

    @FXML
    TextField textC;

    @FXML
    TextField AreaValue;


    public static double isNumeric(String str) {
        try {
            double num = Double.parseDouble(str);
            return num;
        } catch (NumberFormatException e) {
            return -1;
        }
    }


    @FXML
    public void AcaoCalculo() {
        double a = HelloController.isNumeric(textA.getText());
        double b = HelloController.isNumeric(textB.getText());
        double c = HelloController.isNumeric(textC.getText());

        // O user inseriu pelo menos uma string
        if (a == -1 || b == -1 || c == -1 ) {
            if(a == -1){
                textA.setText("Insira um int!");
                textA.requestFocus();
            }
            if(b == -1){
                textB.setText("Insira um int!");
                textB.requestFocus();
            }
            if(c == -1){
                textC.setText("Insira um int!");
                textC.requestFocus();
            }

            AreaValue.setText("Erro!");
            AreaValue.setEditable(false);

        } else {
            boolean calcular = true;
            if (a > b + c) {
                AreaValue.setText("ERRO: a>b+c");
                AreaValue.requestFocus();
                calcular = false;
            }
            if (b > c + a) {
                AreaValue.setText("ERRO: b>c+a");
                AreaValue.requestFocus();
                calcular = false;
            }
            if (c > a + b) {
                AreaValue.setText("ERRO: c>a+b");
                AreaValue.requestFocus();
                calcular = false;
            }

            // Só procede para o cálculo caso a condição de um lado ser sempre menor ou igual à soma dos outros dois, ser aplicada neste triângulo
            if (calcular == true) {
                double somaABC = a + b + c;
                double ABCdiv2 = somaABC / 2;
                double area = Math.sqrt((ABCdiv2) * (ABCdiv2 - a) * (ABCdiv2 - b) * (ABCdiv2 - c));
                System.out.println("\n\nA=" + a + "\nB=" + b + "\nC=" + c + "\n\nÁrea=" + area);
                AreaValue.setText(String.valueOf(df.format(area)));
                AreaValue.setEditable(false);
            } else {
                AreaValue.setText("Erro!");
                AreaValue.setEditable(false);
            }
        }

    }


    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}