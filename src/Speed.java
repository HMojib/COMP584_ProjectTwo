import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Speed extends JInternalFrame{
    private static Speed instance = null;

    private JTextField distance;
    private JTextField time;
    private JButton button;
    private JLabel label1, label2, label3, label4;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static Speed getInstance() {
        if (instance == null) {
            instance = new Speed();
        }
        return instance;
    }

    private Speed() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Speed", false, true, false, false);
        distance = new JTextField(5);
        time = new JTextField(5);
        button = new JButton("Calculate Necessary Speed");

        label1 = new JLabel("Necessary Speed (mph): ");
        label2 = new JLabel();
        label3 = new JLabel("Distance (miles): ");
        label4 = new JLabel("Trip Time Wanted (hours): ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(distance);
        upperPanel.add(label4);
        upperPanel.add(time);
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
                getSpeed();
            }
        });
    }

    private void getSpeed() {
        label2.setText("");
        try {
            double numDistance = Double.parseDouble(distance.getText());
            double numTime = Double.parseDouble(time.getText());

            double numRate = numDistance/numTime*1;

            label2.setText(String.valueOf(numRate));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
