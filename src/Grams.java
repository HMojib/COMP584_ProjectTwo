import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grams extends JInternalFrame {
    private static Grams instance = null;

    private JTextField grams;
    private JButton button;
    private JLabel label1, label2, label3;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static Grams getInstance() {
        if (instance == null) {
            instance = new Grams();
        }
        return instance;
    }

    private Grams() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Convert Grams to Pounds", false, true, false, false);
        grams = new JTextField(5);
        button = new JButton("Calculate");

        label1 = new JLabel("Pounds: ");
        label2 = new JLabel();
        label3 = new JLabel("Grams: ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(grams);
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
                gramsToPounds();
            }
        });
    }

    private void gramsToPounds() {
        label2.setText("");
        try {
            double numGrams = Integer.parseInt(grams.getText());
            double pounds = numGrams*0.0022;

            label2.setText(String.valueOf(pounds));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
