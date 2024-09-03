package calculator;

public class CalculatorLogic {

    private double firstNumber = 0;
    private double secondNumber = 0;
    private double result = 0;
    private String operation = "";

    // Setters and getters for numbers and operation
    public void setFirstNumber(double number) {
        firstNumber = number;
    }

    public void setSecondNumber(double number) {
        secondNumber = number;
    }

    public void setOperation(String op) {
        operation = op;
    }

    public double getResult() {
        return result;
    }

    // Perform calculation based on the operation
    public void calculate() {
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    throw new ArithmeticException("Error: Division by zero");
                }
                break;
            case "pow":
                result = Math.pow(firstNumber, secondNumber);
                break;
            default:
                throw new IllegalArgumentException("Unknown operation");
        }
    }

    // Scientific operations
    public double sqrt(double number) {
        return Math.sqrt(number);
    }

    public double log(double number) {
        return Math.log(number);
    }

    public double sin(double angle) {
        return Math.sin(Math.toRadians(angle));
    }

    public double cos(double angle) {
        return Math.cos(Math.toRadians(angle));
    }

    public double tan(double angle) {
        return Math.tan(Math.toRadians(angle));
    }
}
