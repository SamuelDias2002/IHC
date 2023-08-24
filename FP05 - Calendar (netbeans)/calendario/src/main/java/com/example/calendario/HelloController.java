package com.example.calendario;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

public class HelloController implements Initializable {
    public boolean []matrizMes;
    @FXML
    public Spinner<Integer> spnYear;
    @FXML
    public ComboBox cmbMes;
    @FXML
    public Label label1;
    @FXML
    public Label label2;
    @FXML
    public Label label3;
    @FXML
    public Label label4;
    @FXML
    public Label label5;
    @FXML
    public Label label6;
    @FXML
    public Label label7;
    @FXML
    public Label label8;
    @FXML
    public Label label9;
    @FXML
    public Label label10;
    @FXML

    public Label label11;
    public Label label12;
    public Label label13;
    public Label label14;
    public Label label15;
    public Label label16;
    public Label label17;
    public Label label18;
    public Label label19;
    public Label label20;
    public Label label21;
    public Label label22;
    public Label label23;
    public Label label24;
    public Label label25;
    public Label label26;
    public Label label27;
    public Label label28;
    public Label label29;
    public Label label30;
    public Label label31;
    public Label label32;
    public Label label33;
    public Label label34;
    public Label label35;
    public Label label36;
    public Label label37;

    @FXML
    private void handleButtonTime(ActionEvent event) throws Exception{
        int ano = (Integer)spnYear.getValue();
        int mes = cmbMes.getSelectionModel().getSelectedIndex();
        escreverMes(ano, mes);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb)  {
        boolean[] matrizMes;

        Calendar date = Calendar.getInstance(Locale.ENGLISH);
        cmbMes.setStyle("-fx-font: 14px \"Arial Black\";");
        cmbMes.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio",
                "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");

        matrizMes = new boolean[37];
        for (boolean b : matrizMes) b = false;

        int month = date.get(Calendar.MONTH);
        System.out.println("Month:" + month);
        cmbMes.getSelectionModel().select(month);

        int year = date.get(Calendar.YEAR);
        SpinnerValueFactory<Integer> spinModel =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1900, 2099, year);
        spnYear.setValueFactory(spinModel);
        spnYear.setStyle("-fx-font: 14px \"Arial Black\";");
        escreverMes(year, month);
    }



    private void escreverMes(int ano, int mes) {
        Calendar primeiro = new GregorianCalendar(ano, mes, 1);
        int diaSemana = primeiro.get(Calendar.DAY_OF_WEEK);
        diaSemana = (12 + diaSemana) % 7 + 1;
        int maxMes = primeiro.getActualMaximum(Calendar.DATE);

        for (Field f : getClass().getDeclaredFields()) {
            if (f.getName().startsWith("label")) {
                try {
                    Label label = (Label) f.get(this);
                    int id = Integer.parseInt(f.getName().substring(3));
                    int dt = id - diaSemana + 1;

                    if (dt <= 0 || dt > maxMes) {
                        label.setText("");
                        label.setStyle("-fx-background-color: #F4F4F4;" + "-fx-border-color: #F4F4F4;");
                    } else {
                        label.setStyle("-fx-background-color: white;" + "-fx-border-color: gray;");
                        label.setText("" + dt);
                    }
                } catch (Exception ex){}

            }
        }
    }

}
