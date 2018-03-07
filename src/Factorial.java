import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Factorial extends JInternalFrame {

    private static Factorial instance = null;

    private JTextField textField;
    private JButton button;
    private JLabel label1, label2;
    private JPanel upperPanel, lowerPanel;

    public static Factorial getInstance() {
        if (instance == null) {
            instance = new Factorial();
        }
        return instance;
    }

    private Factorial() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Factorial", false, true, false, false);
        textField = new JTextField(10);
        button = new JButton("Get Factorial");
        label1 = new JLabel("Answer: ");
        label2 = new JLabel();
        upperPanel = new JPanel();
        lowerPanel = new JPanel();
        upperPanel.setLayout(new FlowLayout()); //prob. not needed
        lowerPanel.setLayout(new FlowLayout()); //prob. not needed
        upperPanel.add(textField);
        upperPanel.add(button);
        lowerPanel.add(label1);
        lowerPanel.add(label2);
        add(upperPanel, BorderLayout.NORTH);
        add(lowerPanel, BorderLayout.SOUTH);

        addButtonListener();

        setBounds(25, 25, 250, 120);
        setLocation(100, 100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                factorial();
            }
        });
    }

    private void factorial() {
        label2.setText("");
        try {
            int toFactorial = Integer.parseInt(textField.getText());
            long answer = 1;
            if(toFactorial > 0){
                for (int i = toFactorial; i > 0;i--){
                    answer *= i;
                }
            }
            label2.setText(String.valueOf(answer));
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this, "Hey buddy, enter an integer!");
        }
    }
}
