package calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorButtonListener implements ActionListener {

    private final CalculatorGUI calculatorGUI;
    private final CalculatorLogic calculatorLogic;

    public CalculatorButtonListener(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
        this.calculatorLogic = new CalculatorLogic();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JTextField display = calculatorGUI.getDisplay();

        try {
            switch (command) {
                case "C":
                    // Clear the display and reset logic
                    display.setText("");
                    calculatorLogic.setFirstNumber(0);
                    calculatorLogic.setSecondNumber(0);
                    calculatorLogic.setOperation("");
                    break;

                case "=":
                    // Perform the calculation
                    calculatorLogic.setSecondNumber(Double.parseDouble(display.getText()));
                    calculatorLogic.calculate();
                    display.setText(String.valueOf(calculatorLogic.getResult()));
                    break;

                case "sqrt":
                    double sqrtResult = calculatorLogic.sqrt(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(sqrtResult));
                    break;

                case "pow":
                case "+":
                case "-":
                case "*":
                case "/":
                    calculatorLogic.setFirstNumber(Double.parseDouble(display.getText()));
                    calculatorLogic.setOperation(command);
                    display.setText("");
                    break;

                case "log":
                    double logResult = calculatorLogic.log(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(logResult));
                    break;

                case "sin":
                    double sinResult = calculatorLogic.sin(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(sinResult));
                    break;

                case "cos":
                    double cosResult = calculatorLogic.cos(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(cosResult));
                    break;

                case "tan":
                    double tanResult = calculatorLogic.tan(Double.parseDouble(display.getText()));
                    display.setText(String.valueOf(tanResult));
                    break;

                default:
                    // Append numbers and decimal points to the display
                    display.setText(display.getText() + command);
                    break;
            }
        } catch (NumberFormatException ex) {
            display.setText("Error");
        } catch (ArithmeticException | IllegalArgumentException ex) {
            display.setText(ex.getMessage());
        }
    }
}
