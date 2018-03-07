import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acceleration extends JInternalFrame {
    private static Acceleration instance = null;

    private JTextField speedWanted;
    private JTextField currentSpeed;
    private JTextField time;
    private JButton button;
    private JLabel label1, label2, label3, label4, label5;
    private JPanel upperPanel, lowerPanel, middlePanel;

    public static Acceleration getInstance() {
        if (instance == null) {
            instance = new Acceleration();
        }
        return instance;
    }

    private Acceleration() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Acceleration", false, true, false, false);
        speedWanted = new JTextField(5);
        currentSpeed = new JTextField(5);
        time = new JTextField(5);
        button = new JButton("Calculate Necessary Acceleration");

        label1 = new JLabel("Necessary Acceleration (mps^2): ");
        label2 = new JLabel();
        label3 = new JLabel("Current Speed (mph): ");
        label4 = new JLabel("Speed Wanted (mph): ");
        label5 = new JLabel("In How Much Time (seconds): ");

        upperPanel = new JPanel();
        middlePanel = new JPanel();
        lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        lowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); //prob. not needed
        middlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        upperPanel.add(label3);
        upperPanel.add(speedWanted);
        upperPanel.add(label4);
        upperPanel.add(currentSpeed);
        upperPanel.add(label5);
        upperPanel.add(time);
        middlePanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);
        add(middlePanel, BorderLayout.CENTER);

        addButtonListener();

        setBounds(25, 25, 750, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                getAcceleration();
            }
        });
    }

    private void getAcceleration() {
        label2.setText("");
        try {
            double numWantedSpeed = Double.parseDouble(currentSpeed.getText());
            double numCurrSpeed = Double.parseDouble(speedWanted.getText());
            double numTime = Double.parseDouble(time.getText());

            double convertNumTime = (numWantedSpeed - numCurrSpeed)/3600;

            double numAcceleration = convertNumTime*numTime;

            label2.setText(String.valueOf(numAcceleration));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter a number!");
        }
    }
}
