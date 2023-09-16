import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main(){
        get_temperature_measurements();
    }

    public void get_temperature_measurements(){
        JOptionPane.showMessageDialog(null, "Welcome to Temperature Converter!");
        String temp_scale;
        ArrayList<String> temperature_scales = new ArrayList<>(Arrays.asList("F", "C", "K"));
        do {
            temp_scale = JOptionPane.showInputDialog("Enter temperature scale: \n - F: Fahrenheit\n " +
                    "- C: Celsius\n - K: Kelvin").toUpperCase();
        } while (!temperature_scales.contains(temp_scale));

        String convert_scale;
        if (temp_scale.equals("F")) {
            do {
                convert_scale = JOptionPane.showInputDialog("Enter temperature scale for conversion: \n " +
                        "- C: Celsius\n - K: Kelvin").toUpperCase();
            } while (!convert_scale.equals("C") && !convert_scale.equals("K"));
            convert_temperature(temp_scale,convert_scale);
        }
        else if (temp_scale.equals("C")) {
            do {
                convert_scale = JOptionPane.showInputDialog("Enter temperature scale for conversion: \n " +
                        "- F: Fahrenheit\n - K: Kelvin").toUpperCase();
            } while (!convert_scale.equals("F") && !convert_scale.equals("K"));
            convert_temperature(temp_scale,convert_scale);
        }
        else {
            do {
                convert_scale = JOptionPane.showInputDialog("Enter temperature scale for conversion: \n " +
                        "- F: Fahrenheit\n - C: Celsius").toUpperCase();
            } while (!convert_scale.equals("F") && !convert_scale.equals("C"));
            convert_temperature(temp_scale,convert_scale);
        }

        String exit;
        do {
            exit = JOptionPane.showInputDialog("Do you want to keep using Temperature Converter? \n" +
                    "Y: Yes \nN: No").toUpperCase();
        } while (!exit.equals("Y") && !exit.equals("N"));

        if (exit.equals("Y")){
            get_temperature_measurements();
        }
        else{
            JOptionPane.showMessageDialog(null, "Goodbye!");
            System.exit(0);
        }
    }

    public void convert_temperature(String temp_scale, String convert_scale){
        DecimalFormat df = new DecimalFormat("0.00");

        if (temp_scale.equals("F")){
            boolean check = true;
            double temp_measurement = 0;
            while (check){
                try{
                    temp_measurement = Double.parseDouble(JOptionPane.showInputDialog("Enter F°: "));
                    check = false;
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid numerical measurement!");
                }
            }
            double convert_measurement;
            if (convert_scale.equals("C")){
                convert_measurement = (temp_measurement - 32) / 1.8;
                JOptionPane.showMessageDialog(null, temp_measurement + " F° is equal to " +
                        "" + df.format(convert_measurement) + " C°");
            }
            else {
                convert_measurement = (temp_measurement - 32) * 5 / 9 + 273.15;
                JOptionPane.showMessageDialog(null, temp_measurement + " F° is equal to " +
                        "" + df.format(convert_measurement) + " K");
            }
        }
        else if (temp_scale.equals("C")){
            boolean check = true;
            double temp_measurement = 0;
            while (check){
                try{
                    temp_measurement = Double.parseDouble(JOptionPane.showInputDialog("Enter C°: "));
                    check = false;
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter a valid numerical measurement!");
                }
            }
            double convert_measurement;
            if (convert_scale.equals("F")){
                convert_measurement = (temp_measurement * 1.8) + 32;
                JOptionPane.showMessageDialog(null, temp_measurement + " C° is equal to " +
                        "" + df.format(convert_measurement) + " F°");
            }
            else {
                convert_measurement = temp_measurement + 273.15;
                JOptionPane.showMessageDialog(null, temp_measurement + " C° is equal to " +
                        "" + df.format(convert_measurement) + " K");
            }
        }
        else {
            boolean check = true;
            double temp_measurement = 0;
            while (check){
                try{
                    temp_measurement = Double.parseDouble(JOptionPane.showInputDialog("Enter K°: "));
                    check = false;
                }
                catch (Exception e){
                    JOptionPane.showMessageDialog(null, "Please enter a valid numerical measurement!");
                }
            }
            double convert_measurement;
            if (convert_scale.equals("F")){
                convert_measurement = (temp_measurement - 273.15) * 1.8 + 32;
                JOptionPane.showMessageDialog(null, temp_measurement + " K is equal to " +
                        "" + df.format(convert_measurement) + " F°");
            }
            else {
                convert_measurement = temp_measurement - 273.15;
                JOptionPane.showMessageDialog(null, temp_measurement + " K is equal to " +
                        "" + df.format(convert_measurement) + " C°");
            }
        }
    }
}
