import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kilometers extends JInternalFrame {
    private static Kilometers instance = null;

    private JTextField kilometers;
    private JButton button;
    private JLabel label1, label2, label3;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static Kilometers getInstance() {
        if (instance == null) {
            instance = new Kilometers();
        }
        return instance;
    }

    private Kilometers() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Convert Kilometers to Miles", false, true, false, false);
        kilometers = new JTextField(5);
        button = new JButton("Calculate");

        label1 = new JLabel("Miles: ");
        label2 = new JLabel();
        label3 = new JLabel("Kilometers: ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(kilometers);
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
                kilometersToMiles();
            }
        });
    }

    private void kilometersToMiles() {
        label2.setText("");
        try {
            double numKilometer = Double.parseDouble(kilometers.getText());

            double numMiles = numKilometer*0.621371;

            label2.setText(String.valueOf(numMiles));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
