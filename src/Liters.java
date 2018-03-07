import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Liters extends JInternalFrame {
    private static Liters instance = null;

    private JTextField liters;
    private JButton button;
    private JLabel label1, label2, label3;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static Liters getInstance() {
        if (instance == null) {
            instance = new Liters();
        }
        return instance;
    }

    private Liters() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Convert Liters to Ounces", false, true, false, false);
        liters = new JTextField(5);
        button = new JButton("Calculate");

        label1 = new JLabel("Ounces: ");
        label2 = new JLabel();
        label3 = new JLabel("Liters: ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(liters);
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
                LitersToOunces();
            }
        });
    }

    private void LitersToOunces() {
        label2.setText("");
        try {
            double numLiters = Integer.parseInt(liters.getText());
            double numOunces = numLiters*33.814;

            label2.setText(String.valueOf(numOunces));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
