import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VolumeCube extends JInternalFrame {
    private static VolumeCube instance = null;

    private JTextField textField;
    private JButton button;
    private JLabel label1, label2;
    private JPanel upperPanel, lowerPanel;

    public static VolumeCube getInstance() {
        if(instance == null) {
            instance = new VolumeCube();
        }
        return instance;
    }

    private VolumeCube() {
        //args: title, resisability, closability, maximizablity and iconifiability
        super("Volume of a Cube", false, true, false, false);
        textField = new JTextField(10);
        button = new JButton("Volume");
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
        setLocation(100,100);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void addButtonListener() {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                volumeOfCube();
            }
        });
    }

    private void volumeOfCube() {
        label2.setText("");
        try {
            double side = Double.parseDouble(textField.getText());
            double answer = (side*side*side);
            label2.setText(String.valueOf(answer));
        }
        catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(this,"Hey buddy, enter a number!");
        }
    }
}
