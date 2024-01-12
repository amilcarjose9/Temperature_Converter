Temperature Converter

Welcome to Temperature Converter! This project provides a simple and user-friendly interface to convert temperatures between Fahrenheit (F), Celsius (C), and Kelvin (K). 
The program is implemented in Java and consists of two classes: Main and TemperatureConverter.

Main Class

The Main class is responsible for executing the program and interacting with the user through JOptionPane dialogs. It utilizes the TemperatureConverter class to 
perform temperature conversions.

Methods

main(String[] args): Entry point of the program. Instantiates an object of the Main class to start the application.

Main(): Constructor that initiates the Temperature Converter application. It displays a welcome message, prompts the user for input, performs conversions, and 
allows the user to continue or exit.

get_initial_scale(): Method to get the initial temperature scale from the user. Ensures valid input (F, C, or K).

get_convert_scale(String temp_scale): Method to get the temperature scale for conversion from the user based on the initial scale.

convert_temperature(String temp_scale, String convert_scale): Method to perform temperature conversion based on user input. Utilizes the TemperatureConverter class for conversions.

TemperatureConverter Class

The TemperatureConverter class contains methods for performing temperature conversions between Fahrenheit, Celsius, and Kelvin.

Methods

performConversion(double tempMeasurement, String tempScale, String convertScale): Main method for temperature conversion. Calls appropriate conversion methods based on the target scale.

convertToFahrenheit(double tempMeasurement, String tempScale): Converts temperatures to Fahrenheit.

convertToCelsius(double tempMeasurement, String tempScale): Converts temperatures to Celsius.

convertToKelvin(double tempMeasurement, String tempScale): Converts temperatures to Kelvin.

How to Use

Run the program by executing the Main class.
Enter the initial temperature scale (F, C, or K).
Specify the target temperature scale for conversion.
Enter the temperature measurement in the specified scale.
View the converted temperature.

Repeating the Process

After each conversion, the program prompts the user if they want to continue using the Temperature Converter. Enter 'Y' for Yes or 'N' for No.

If 'Y' is selected, a new instance of the Main class is created, allowing the user to perform additional conversions. If 'N' is selected, the program exits with a farewell message.
