import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class YearlySalary extends JInternalFrame {
    private static YearlySalary instance = null;

    private JTextField hourlyPay;
    private JTextField hoursWorked;
    private JButton button;
    private JLabel label1, label2, label3, label4;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static YearlySalary getInstance() {
        if (instance == null) {
            instance = new YearlySalary();
        }
        return instance;
    }

    private YearlySalary() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Yearly Salary Calculator", false, true, false, false);
        hourlyPay = new JTextField(5);
        hoursWorked = new JTextField(5);
        button = new JButton("Calculate Yearly Salary");

        label1 = new JLabel("Yearly Salary: ");
        label2 = new JLabel();
        label3 = new JLabel("Hourly Pay: ");
        label4 = new JLabel("Hours per Week: ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(hourlyPay);
        upperPanel.add(label4);
        upperPanel.add(hoursWorked);
        middlePanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
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
                yearlySalaryCalc();
            }
        });
    }

    private void yearlySalaryCalc() {
        label2.setText("");
        try {
            int hours = Integer.parseInt(hoursWorked.getText());
            double pay = Double.parseDouble(hourlyPay.getText());

            double yearlyPay = (hours*pay)*52;

            label2.setText(String.valueOf(yearlyPay));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
