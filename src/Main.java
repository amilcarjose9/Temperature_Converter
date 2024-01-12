import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    // Main method that executes the program
    public Main(){
        JOptionPane.showMessageDialog(null, "Welcome to Temperature Converter!");
        String temp_scale = get_initial_scale();
        String convert_scale = get_convert_scale(temp_scale);
        convert_temperature(temp_scale, convert_scale);

        String exit;
        do {
            exit = JOptionPane.showInputDialog("Do you want to keep using Temperature Converter? \n" +
                    "Y: Yes \nN: No").toUpperCase();
        } while (!exit.equals("Y") && !exit.equals("N"));

        if (exit.equals("Y")){
            new Main();
        }
        else{
            JOptionPane.showMessageDialog(null, "Goodbye!");
            System.exit(0);
        }
    }

    // Method to get the initial temperature scale from the user
    public String get_initial_scale(){
        String temp_scale;
        ArrayList<String> temperature_scales = new ArrayList<>(Arrays.asList("F", "C", "K"));

        do {
            temp_scale = JOptionPane.showInputDialog("Enter temperature scale: \n - F: Fahrenheit\n " +
                    "- C: Celsius\n - K: Kelvin").toUpperCase();
        } while (!temperature_scales.contains(temp_scale));

        return temp_scale;
    }
    // Method to get the temperature scale for conversion from the user
    public String get_convert_scale(String temp_scale){
        String convert_scale;
        if (temp_scale.equals("F")) {
            do {
                convert_scale = JOptionPane.showInputDialog("Enter temperature scale for conversion: \n " +
                        "- C: Celsius\n - K: Kelvin").toUpperCase();
            } while (!convert_scale.equals("C") && !convert_scale.equals("K"));
        }
        else if (temp_scale.equals("C")) {
            do {
                convert_scale = JOptionPane.showInputDialog("Enter temperature scale for conversion: \n " +
                        "- F: Fahrenheit\n - K: Kelvin").toUpperCase();
            } while (!convert_scale.equals("F") && !convert_scale.equals("K"));
        }
        else {
            do {
                convert_scale = JOptionPane.showInputDialog("Enter temperature scale for conversion: \n " +
                        "- F: Fahrenheit\n - C: Celsius").toUpperCase();
            } while (!convert_scale.equals("F") && !convert_scale.equals("C"));
        }
        return convert_scale;
    }

    // Method to perform temperature conversion based on user input
    public void convert_temperature(String temp_scale, String convert_scale){
        DecimalFormat df = new DecimalFormat("0.00");
        TemperatureConverter tc = new TemperatureConverter();

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
            double convert_measurement = tc.performConversion(temp_measurement, temp_scale, convert_scale);
            if (convert_scale.equals("C")){
                JOptionPane.showMessageDialog(null, temp_measurement + " F° is equal to " +
                        "" + df.format(convert_measurement) + " C°");
            }
            else {
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
            double convert_measurement = tc.performConversion(temp_measurement, temp_scale, convert_scale);
            if (convert_scale.equals("F")){
                JOptionPane.showMessageDialog(null, temp_measurement + " C° is equal to " +
                        "" + df.format(convert_measurement) + " F°");
            }
            else {
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
            double convert_measurement = tc.performConversion(temp_measurement, temp_scale, convert_scale);
            if (convert_scale.equals("F")){
                JOptionPane.showMessageDialog(null, temp_measurement + " K is equal to " +
                        "" + df.format(convert_measurement) + " F°");
            }
            else {
                JOptionPane.showMessageDialog(null, temp_measurement + " K is equal to " +
                        "" + df.format(convert_measurement) + " C°");
            }
        }
    }
}
