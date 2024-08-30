package am;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AtmInteface extends JFrame {

    // Fields
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JTextArea outputArea;
    private AtmHandler atm;
    private double initialAmount = 0;
    private JPanel inputDisplay, outputDisplay;

    public AtmInteface() {
        // Set up the frame
        this.setTitle("ATM");
        this.setResizable(false);
        this.setSize(500, 500);
        this.setLayout(new GridBagLayout());

        // Initialize ATM handler
        atm = new AtmHandler(new BankAccount(initialAmount));

        // GridBagConstraints for layout management
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Create and add buttons
        JButton withdrawButton = new JButton("Withdraw");
        gbc.gridx = 1;
        gbc.gridy = 0;
        withdrawButton.setBackground(Color.BLUE);
        withdrawButton.setForeground(Color.WHITE);
        this.add(withdrawButton, gbc);

        JButton depositButton = new JButton("Deposit");
        gbc.gridy = 1;
        depositButton.setBackground(Color.BLUE);
        depositButton.setForeground(Color.WHITE);
        this.add(depositButton, gbc);

        JButton balanceButton = new JButton("Balance");
        gbc.gridy = 2;
        balanceButton.setBackground(Color.BLUE);
        balanceButton.setForeground(Color.WHITE);
        this.add(balanceButton, gbc);

        JButton cancelButton = new JButton("Cancel");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        cancelButton.setBackground(Color.RED);
        cancelButton.setForeground(Color.WHITE);
        this.add(cancelButton, gbc);

        // Initialize input field and label
        inputField = new JTextField();
        inputField.setPreferredSize(new Dimension(100, 40)); // Use preferred size

        String labelText = "<html>Enter amount</html>";
        JLabel heading = new JLabel(labelText);
        heading.setVerticalAlignment(JLabel.TOP);
        heading.setBorder(new EmptyBorder(10, 10, 10, 10)); // Adding margin to the label

        // Create and set up input display panel
        inputDisplay = new JPanel();
        inputDisplay.setLayout(new GridBagLayout()); // Use GridBagLayout
        inputDisplay.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints inputGbc = new GridBagConstraints();
        inputGbc.insets = new Insets(10, 10, 10, 10);
        inputGbc.gridx = 0;
        inputGbc.gridy = 0;
        inputGbc.fill = GridBagConstraints.HORIZONTAL;
        inputDisplay.add(heading, inputGbc);

        inputGbc.gridy = 1;
        inputDisplay.add(inputField, inputGbc);

        // Initialize output area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(300, 100)); // Use preferred size

        // Create and set up output display panel
        outputDisplay = new JPanel();
        outputDisplay.setLayout(new GridBagLayout()); // Use GridBagLayout
        outputDisplay.setBackground(Color.LIGHT_GRAY);
        GridBagConstraints outputGbc = new GridBagConstraints();
        outputGbc.insets = new Insets(10, 10, 10, 10);
        outputGbc.gridx = 0;
        outputGbc.gridy = 0;
        outputGbc.fill = GridBagConstraints.HORIZONTAL;
        outputDisplay.add(scrollPane, outputGbc);

        // Add panels to the frame
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridheight = 3;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        this.add(inputDisplay, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridheight = 1;
        gbc.weighty = 0.0;
        this.add(outputDisplay, gbc);

        // Add action listeners for buttons
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDisplay.setVisible(false);
                outputDisplay.setVisible(true);
                handleWithdraw();
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDisplay.setVisible(false);
                outputDisplay.setVisible(true);
                handleDeposit();
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputDisplay.setVisible(false);
                showBalance();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Set the frame visible
        this.setVisible(true);
    }

    // Methods to handle the tasks
    private void handleWithdraw() {
        try {
            String inputText = inputField.getText().trim();  // Trim whitespace
            if (inputText.isEmpty()) {
                outputArea.setText("Input field is empty. Please enter an amount.");
                return;
            }

            double amount = Double.parseDouble(inputText);
            atm.withdraw(amount);
            outputArea.setText("Withdrawal successful. New balance: " + atm.getBalance());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            outputArea.setText(e.getMessage());
        }
    }

    private void handleDeposit() {
        try {
            String inputText = inputField.getText().trim();  // Trim whitespace
            if (inputText.isEmpty()) {
                outputArea.setText("Input field is empty. Please enter an amount.");
                return;
            }

            double amount = Double.parseDouble(inputText);
            atm.deposit(amount);
            outputArea.setText("Deposit successful. New balance: " + atm.getBalance());
        } catch (NumberFormatException e) {
            outputArea.setText("Invalid input. Please enter a numeric value.");
        } catch (IllegalArgumentException e) {
            outputArea.setText(e.getMessage());
        }
    }

    private void showBalance() {
        outputArea.setText("Current balance: " + atm.getBalance());
        scrollPane.setVisible(true);
    }
}
