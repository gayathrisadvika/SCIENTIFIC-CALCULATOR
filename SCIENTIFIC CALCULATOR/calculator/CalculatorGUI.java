package calculator;  // Ensure this matches the directory structure

import javax.swing.*;
import java.awt.*;

// Ensure CalculatorButtonListener is in the same package
public class CalculatorGUI extends JFrame {

    private JTextField display;

    public CalculatorGUI() {
        // Set up the JFrame
        setTitle("Scientific Calculator");
        setSize(400, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create display field
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // Set up buttons
        setupButtons();

        // Display the frame
        setVisible(true);
    }

    private void setupButtons() {
        String[] buttonLabels = {
                "7", "8", "9", "/", "sqrt",
                "4", "5", "6", "*", "pow",
                "1", "2", "3", "-", "log",
                "0", ".", "=", "+", "sin",
                "cos", "tan", "C"
        };

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 5, 5, 5));

        // Create and add buttons to the panel
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.BOLD, 18));
            button.addActionListener(new CalculatorButtonListener(this)); // Ensure the listener class exists and is compiled
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
    }

    // Getter for display field
    public JTextField getDisplay() {
        return display;
    }
}
