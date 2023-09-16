public class TemperatureConverter {

    // Method to perform temperature conversion based on the given scales and measurement
    public double performConversion(double tempMeasurement, String tempScale, String convertScale){
        if (convertScale.equals("F")){
            return convertToFahrenheit(tempMeasurement, tempScale);
        }
        else if (convertScale.equals("C")){
            return convertToCelsius(tempMeasurement, tempScale);
        }
        else {
            return convertToKelvin(tempMeasurement, tempScale);
        }
    }

    // Method to convert from other scales to Fahrenheit
    private double convertToFahrenheit(double tempMeasurement, String tempScale) {
        if (tempScale.equals("C")){        // Celsius to Fahrenheit
            return (tempMeasurement * 1.8) + 32;
        }
        else {                             // Kelvin to Fahrenheit
            return (tempMeasurement - 273.15) * 1.8 + 32;
        }
    }

    // Method to convert from other scales to Celsius
    private double convertToCelsius(double tempMeasurement, String tempScale) {
        if (tempScale.equals("F")){     // Fahrenheit to Celsius
            return (tempMeasurement - 32) / 1.8;
        }
        else {                          // Kelvin to Celsius
            return tempMeasurement - 273.15;
        }
    }

    // Method to convert from other scales to Kelvin
    private double convertToKelvin(double tempMeasurement, String tempScale) {
        if (tempScale.equals("F")){     // Fahrenheit to Kelvin
            return (tempMeasurement - 32) * 5 / 9 + 273.15;
        }
        else {                          // Celsius to Kelvin
            return tempMeasurement + 273.15;
        }
    }

}
