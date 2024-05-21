import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter {
    private JFrame frame;
    private JTextField amountField;
    private JComboBox<String> fromCombo;
    private JComboBox<String> toCombo;
    private JButton convertButton;
    private JLabel resultLabel;

    public CurrencyConverter() {
        frame = new JFrame("Currency Converter");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JLabel amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(20, 20, 60, 25);
        frame.add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(80, 20, 150, 25);
        frame.add(amountField);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(20, 50, 40, 25);
        frame.add(fromLabel);

        fromCombo = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"}); // Added INR
        fromCombo.setBounds(80, 50, 100, 25);
        frame.add(fromCombo);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(20, 80, 40, 25);
        frame.add(toLabel);

        toCombo = new JComboBox<>(new String[]{"USD", "EUR", "GBP", "INR"}); // Added INR
        toCombo.setBounds(80, 80, 100, 25);
        frame.add(toCombo);

        convertButton = new JButton("Convert");
        convertButton.setBounds(100, 120, 80, 25);
        frame.add(convertButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(20, 150, 200, 25);
        frame.add(resultLabel);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        frame.setVisible(true);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            String fromCurrency = (String) fromCombo.getSelectedItem();
            String toCurrency = (String) toCombo.getSelectedItem();
            double convertedAmount = convert(amount, fromCurrency, toCurrency);
            resultLabel.setText("Converted amount: " + String.format("%.2f", convertedAmount) + " " + toCurrency);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Invalid amount");
        }
    }

    private double convert(double amount, String fromCurrency, String toCurrency) {
        // Dummy conversion for demonstration
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            return amount * 0.85;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("GBP")) {
            return amount * 0.72;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("INR")) {
            return amount * 73.58; // 1 USD = 73.58 INR (as of current exchange rate)
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            return amount * 1.18;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("GBP")) {
            return amount * 0.85;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("INR")) {
            return amount * 87.21; // 1 EUR = 87.21 INR (as of current exchange rate)
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("USD")) {
            return amount * 1.39;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("EUR")) {
            return amount * 1.18;
        } else if (fromCurrency.equals("GBP") && toCurrency.equals("INR")) {
            return amount * 101.98; // 1 GBP = 101.98 INR (as of current exchange rate)
        } else if (fromCurrency.equals("INR") && toCurrency.equals("USD")) {
            return amount * 0.014; // 1 INR = 0.014 USD (as of current exchange rate)
        } else if (fromCurrency.equals("INR") && toCurrency.equals("EUR")) {
            return amount * 0.011; // 1 INR = 0.011 EUR (as of current exchange rate)
        } else if (fromCurrency.equals("INR") && toCurrency.equals("GBP")) {
            return amount * 0.0098; // 1 INR = 0.0098 GBP (as of current exchange rate)
        } else {
            return amount; // Same currency conversion
        }
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}