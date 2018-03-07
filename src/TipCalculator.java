import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TipCalculator extends JInternalFrame {

    private static TipCalculator instance = null;

    private JTextField billTotal;
    private JTextField tipPercentage;
    private JButton button;
    private JLabel label1, label2, label3, label4, label5, label6;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static TipCalculator getInstance() {
        if (instance == null) {
            instance = new TipCalculator();
        }
        return instance;
    }

    private TipCalculator() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Tip Calculator", false, true, false, false);
        billTotal = new JTextField(5);
        tipPercentage = new JTextField(5);
        button = new JButton("Calculate Tip");

        label1 = new JLabel("Tip: ");
        label2 = new JLabel();
        label3 = new JLabel("Total: ");
        label4 = new JLabel();
        label5 = new JLabel("Tip (%): ");
        label6 = new JLabel("Bill SubTotal: ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 0 )); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label5);
        upperPanel.add(billTotal);
        upperPanel.add(label6);
        upperPanel.add(tipPercentage);
        middlePanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
        lowerPanel.add(label3);
        lowerPanel.add(label4);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        add(middlePanel, BorderLayout.CENTER);

        addButtonListener();

        setBounds(25, 25, 350, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                tipCalc();
            }
        });
    }

    private void tipCalc() {
        label2.setText("");
        label4.setText("");
        try {
            double bill = Double.parseDouble(tipPercentage.getText());
            double tip = Double.parseDouble(billTotal.getText());
            double tipTotal;
            double totalBill;

           tipTotal = bill * (tip/100);
           totalBill = bill + tipTotal;

            label2.setText(String.valueOf(tipTotal));
            label4.setText(String.valueOf(totalBill));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}

