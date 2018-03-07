import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonthlyPayment extends JInternalFrame {

    private static MonthlyPayment instance = null;

    private JTextField numMonths;
    private JTextField rate;
    private JTextField downPayment;
    private JTextField loanTotal;
    private JButton button;
    private JLabel label1, label2, label3, label4, label5, label6;
    private JPanel upperPanel, lowerPanel, middlePanel, secondMiddlePanel;

    public static MonthlyPayment getInstance() {
        if (instance == null) {
            instance = new MonthlyPayment();
        }
        return instance;
    }

    private MonthlyPayment() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Monthly Payment Calculator", false, true, false, false);
        numMonths = new JTextField(5);
        rate = new JTextField(5);
        downPayment = new JTextField(5);
        loanTotal = new JTextField(5);
        button = new JButton("Calculate Monthly Payment");

        label1 = new JLabel("Monthly Payment: ");
        label2 = new JLabel();
        label3 = new JLabel("Number of Months: ");
        label4 = new JLabel("Interest Rate: ");
        label5 = new JLabel("Down Payment: ");
        label6 = new JLabel("Loan Total: ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        secondMiddlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        secondMiddlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(numMonths);
        upperPanel.add(label4);
        upperPanel.add(rate);
        upperPanel.add(label5);
        upperPanel.add(downPayment);
        upperPanel.add(label6);
        upperPanel.add(loanTotal);
        middlePanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        add(middlePanel, BorderLayout.CENTER);

        addButtonListener();

        setBounds(25, 25, 700, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                paymentCalc();
            }
        });
    }

    private void paymentCalc() {
        label2.setText("");
        try {
            int monthly = Integer.parseInt(numMonths.getText());
            double ratePer = Double.parseDouble(rate.getText());
            double down = Double.parseDouble(downPayment.getText());
            double loan = Double.parseDouble(loanTotal.getText());

            double loanMinusDown = loan - down;

            double monthlyPaymentTotal = (loanMinusDown + ((ratePer / 100) * loanMinusDown)) / monthly;

            label2.setText(String.valueOf(monthlyPaymentTotal));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
