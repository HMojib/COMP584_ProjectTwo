import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.List;

public class LongTask extends JInternalFrame{

    private static LongTask instance = null;

    private JLabel lbl, lbl2;
    private JTextField tf;
    private JButton fileBtn, readBtn;
    private JFileChooser fc;
    private String fileName;
    private Task task;
    private JProgressBar progressBar;
    private JFrame frame; // to properly center JDialogFrame
    private int numOfTimeProcessGotCalled;

    public static LongTask getInstance(JFrame frame) {
        if (instance == null) {
            instance = new LongTask(frame);
        }
        return instance;
    }


    class Task extends SwingWorker<Void, String> {
        /*
         * Main task. Executed in background thread.
         */
        @Override
        public Void doInBackground() {
            if (fileName.equals("")) {
                JOptionPane.showMessageDialog(frame, "Choose a file!");
                return null;
            }
            progressBar.setIndeterminate(true);
            lbl2.setText("");
            try {
                int lines = 0;
                String fileLine = "";
                FileReader data = new FileReader(fileName);
                BufferedReader br = new BufferedReader(data);
                while ((fileLine = br.readLine()) != null) {
                    System.out.println("Number of lines: " + String.valueOf(lines));
                    lbl2.setText(String.valueOf(lines));
                    publish(String.valueOf(lines));
                    lines++;
                }
                lbl2.setText(String.valueOf(lines));
                // close the file
                br.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "File not found!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "An error occured");
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            // Messages received from the doInBackground() (when invoking the publish() method)
            //System.out.println("in process (called by doInBackground), setting label to: " + String.valueOf(chunks.get(chunks.size()-1)));
            //lbl2.setText(String.valueOf(chunks.get(chunks.size()-1)));
            //System.out.println("in process (called by doInBackground): numOfTimeProcessGotCalled = " + numOfTimeProcessGotCalled);
        }

        /*
         * Executed in event dispatch thread
         */
        @Override
        public void done() {
            progressBar.setIndeterminate(false);
            readBtn.setEnabled(true);
            System.out.println("numOfTimeProcessGotCalled: " + numOfTimeProcessGotCalled);

        }
    }

    private void chooseFile() {
        lbl2.setText("");
        fileName = "";
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            tf.setText(file.getAbsolutePath());
            fileName = file.getAbsolutePath();
        } else {
            JOptionPane.showMessageDialog(this, "Open command cancelled by user.");
        }
    }

    private LongTask(JFrame frame) {

        super("File Info", false, true, false, false);
        this.frame = frame;
        // init
        tf = new JTextField(50);
        tf.setEditable(false);
        fileBtn = new JButton("...");
        readBtn = new JButton("Read");
        lbl = new JLabel("Number of lines: ");
        lbl2 = new JLabel();
        fc = new JFileChooser();
        progressBar = new JProgressBar(0, 100);
        //Call setStringPainted now so that the progress bar height
        //stays the same whether or not the string is shown.
        progressBar.setStringPainted(false);
        fileName = "";

        fileBtn.setPreferredSize(new Dimension(20, 20));
        readBtn.setPreferredSize(new Dimension(80, 20));

        JPanel upperPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel lowerPanel = new JPanel();

        upperPanel.setLayout(new FlowLayout());
        midPanel.setLayout(new FlowLayout());
        lowerPanel.setLayout(new FlowLayout());

        upperPanel.add(tf);
        upperPanel.add(fileBtn);
        upperPanel.add(readBtn);

        midPanel.add(progressBar);

        lowerPanel.add(lbl);
        lowerPanel.add(lbl2);

        add(upperPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);

        // add button listener
        fileBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                chooseFile();
            }
        });

        // add button listener
        readBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                readBtn.setEnabled(false);
                task = new Task();
                //task.addPropertyChangeListener(this);
                task.execute();
            }
        });

        pack();
        setBounds(25, 25, 700, 120);
        setLocation(50, 50);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
}
