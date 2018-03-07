import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TripEstimate extends JInternalFrame {
    private static TripEstimate instance = null;

    private JTextField distance;
    private JTextField rate;
    private JButton button;
    private JLabel label1, label2, label3, label4;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static TripEstimate getInstance() {
        if (instance == null) {
            instance = new TripEstimate();
        }
        return instance;
    }

    private TripEstimate() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Trip Estimator", false, true, false, false);
        distance = new JTextField(5);
        rate = new JTextField(5);
        button = new JButton("Calculate Time to Target");

        label1 = new JLabel("Time to Target (hours): ");
        label2 = new JLabel();
        label3 = new JLabel("Distance (miles): ");
        label4 = new JLabel("Rate (mph): ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(distance);
        upperPanel.add(label4);
        upperPanel.add(rate);
        middlePanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        add(middlePanel, BorderLayout.CENTER);

        addButtonListener();

        setBounds(25, 25, 450, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getTripEstimate();
            }
        });
    }

    private void getTripEstimate() {
        label2.setText("");
        try {
            double numDistance = Double.parseDouble(distance.getText());
            double numRate = Double.parseDouble(rate.getText());

            double numTime = numDistance/numRate;

            label2.setText(String.valueOf(numTime));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
