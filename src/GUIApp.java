import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIApp extends JFrame {

    private JDesktopPane desktop;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JSplitPane splitPane;
    private JPanel labelPanel;
    private JLabel statusLabel;
    private JTree tree;

    // menu stuff
    private JMenuBar menuBar;
    private JMenu app;
    private JMenu help;
    private JMenuItem exit;
    private JMenuItem about;

    public GUIApp() {
        initComponents();
    }

    private void initComponents() {
        buildDesktop();
        buildTree();
        addTreeListeners();
        buildMenu();
        addMenuListeners();
        buildPanel();
        buildFrame();
    }

    private void buildTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tools");

        DefaultMutableTreeNode math = new DefaultMutableTreeNode("Math");
        DefaultMutableTreeNode finance = new DefaultMutableTreeNode("Finance");
        DefaultMutableTreeNode basicConversions = new DefaultMutableTreeNode("The Wrong Way to the Right Way");
        DefaultMutableTreeNode driving = new DefaultMutableTreeNode("Driving");
        DefaultMutableTreeNode misc = new DefaultMutableTreeNode("Miscellaneous");

        DefaultMutableTreeNode areaOfCircle = new DefaultMutableTreeNode("Area of Circle");
        DefaultMutableTreeNode degreeToRadian = new DefaultMutableTreeNode("Convert Degrees to Radians");
        DefaultMutableTreeNode factorial = new DefaultMutableTreeNode("Factorial");

        DefaultMutableTreeNode tipCalc = new DefaultMutableTreeNode("Tip Calculator");
        DefaultMutableTreeNode monthlyPayment = new DefaultMutableTreeNode("Calculate Monthly Payments");
        DefaultMutableTreeNode yearlySalary = new DefaultMutableTreeNode("Yearly Salary Calculator");

        DefaultMutableTreeNode grams = new DefaultMutableTreeNode("Grams to Pounds");
        DefaultMutableTreeNode liters = new DefaultMutableTreeNode("Liters to Ounces");
        DefaultMutableTreeNode kilometers = new DefaultMutableTreeNode("Kilometers to Miles");

        DefaultMutableTreeNode tripEstimate = new DefaultMutableTreeNode("Trip Estimate");
        DefaultMutableTreeNode speed = new DefaultMutableTreeNode("Speed");
        DefaultMutableTreeNode acceleration = new DefaultMutableTreeNode("Acceleration");

        DefaultMutableTreeNode volSquare = new DefaultMutableTreeNode("Volume of a Cube");
        DefaultMutableTreeNode volCircle = new DefaultMutableTreeNode("Volume of a Sphere");
        DefaultMutableTreeNode longTask = new DefaultMutableTreeNode("Long Task");

        math.add(areaOfCircle);
        math.add(degreeToRadian);
        math.add(factorial);

        finance.add(tipCalc);
        finance.add(monthlyPayment);
        finance.add(yearlySalary);

        basicConversions.add(grams);
        basicConversions.add(liters);
        basicConversions.add(kilometers);

        driving.add(tripEstimate);
        driving.add(speed);
        driving.add(acceleration);

        misc.add(volSquare);
        misc.add(volCircle);
        misc.add(longTask);

        root.add(math);
        root.add(finance);
        root.add(basicConversions);
        root.add(driving);
        root.add(misc);
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);
    }

    private void addTreeListeners() {
        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                int selRow = tree.getRowForLocation(mouseEvent.getX(), mouseEvent.getY());
                if (selRow != -1) {
                    treeClicked();
                }
            }
        });
    }

    private void treeClicked() {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        if (node != null && node.isLeaf()) {
            switch (node.toString()) {
                case "Area of Circle":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    AreaOfCircle areaOfCircle = AreaOfCircle.getInstance();
                    if (!areaOfCircle.isVisible()) {
                        areaOfCircle.setVisible(true);
                        desktop.add(areaOfCircle);
                    }
                    break;
                case "Convert Degrees to Radians":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    DegreeToRadian degreeToRadian = DegreeToRadian.getInstance();
                    if (!degreeToRadian.isVisible()) {
                        degreeToRadian.setVisible(true);
                        desktop.add(degreeToRadian);
                    }
                    break;
                case "Factorial":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    Factorial factorial = Factorial.getInstance();
                    if (!factorial.isVisible()) {
                        factorial.setVisible(true);
                        desktop.add(factorial);
                    }
                    break;
                case "Tip Calculator":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    TipCalculator tipCalc = TipCalculator.getInstance();
                    if (!tipCalc.isVisible()) {
                        tipCalc.setVisible(true);
                        desktop.add(tipCalc);
                    }
                    break;
                case "Calculate Monthly Payments":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    MonthlyPayment monthlyPayment = MonthlyPayment.getInstance();
                    if (!monthlyPayment.isVisible()) {
                        monthlyPayment.setVisible(true);
                        desktop.add(monthlyPayment);
                    }
                    break;
                case "Yearly Salary Calculator":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    YearlySalary yearlySalary = YearlySalary.getInstance();
                    if (!yearlySalary.isVisible()) {
                        yearlySalary.setVisible(true);
                        desktop.add(yearlySalary);
                    }
                    break;
                case "Grams to Pounds":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    Grams grams = Grams.getInstance();
                    if (!grams.isVisible()) {
                        grams.setVisible(true);
                        desktop.add(grams);
                    }
                    break;
                case "Liters to Ounces":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    Liters liters = Liters.getInstance();
                    if (!liters.isVisible()) {
                        liters.setVisible(true);
                        desktop.add(liters);
                    }
                    break;
                case "Kilometers to Miles":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    Kilometers kilometers = Kilometers.getInstance();
                    if (!kilometers.isVisible()) {
                        kilometers.setVisible(true);
                        desktop.add(kilometers);
                    }
                    break;
                case "Trip Estimate":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    TripEstimate tripEstimate = TripEstimate.getInstance();
                    if (!tripEstimate.isVisible()) {
                        tripEstimate.setVisible(true);
                        desktop.add(tripEstimate);
                    }
                    break;
                case "Speed":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    Speed speed = Speed.getInstance();
                    if (!speed.isVisible()) {
                        speed.setVisible(true);
                        desktop.add(speed);
                    }
                    break;
                case "Acceleration":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    Acceleration acceleration = Acceleration.getInstance();
                    if (!acceleration.isVisible()) {
                        acceleration.setVisible(true);
                        desktop.add(acceleration);
                    }
                    break;
                case "Volume of a Cube":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    VolumeCube volumeCube = VolumeCube.getInstance();
                    if (!volumeCube.isVisible()) {
                        volumeCube.setVisible(true);
                        desktop.add(volumeCube);
                    }
                    break;
                case "Volume of a Sphere":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    VolumeSphere volumeSphere = VolumeSphere.getInstance();
                    if (!volumeSphere.isVisible()) {
                        volumeSphere.setVisible(true);
                        desktop.add(volumeSphere);
                    }
                    break;
                case "Long Task":
                    // bring up the dialog box
                    statusLabel.setText(node.toString() + " clicked!");
                    LongTask longTask = LongTask.getInstance(this);
                    if (!longTask.isVisible()) {
                        longTask.setVisible(true);
                        desktop.add(longTask);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void buildDesktop() {
        desktop = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics g) {
                ImageIcon imageIcon = new ImageIcon("images/csun_logo.png");
                Image image = imageIcon.getImage();

                int x = 0;
                int y = 0;
                double imageWidth = image.getWidth(null);
                double imageHeight = image.getHeight(null);
                double screenWidth = getWidth();
                double screenHeight = getHeight();

                if (screenWidth != 0) {
                    x = (int) screenWidth / 2 - (int) imageWidth / 2;
                }
                if (screenHeight != 0) {
                    y = (int) screenHeight / 2 - (int) imageHeight / 2;
                }

                g.drawImage(image, x, y, this);
            }
        };
    }

    private void addMenuListeners() {

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                exitActionPerformed();
            }
        });

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                aboutActionPerformed();
            }
        });

    }

    private void exitActionPerformed() {
        dispose();
    }

    private void aboutActionPerformed() {
        JOptionPane.showMessageDialog(this, "Thx for using my app!");
    }

    private void buildPanel() {

        panel = new JPanel();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        scrollPane = new JScrollPane();
        scrollPane.getViewport().add(tree);

        // label panel and label
        labelPanel = new JPanel();
        statusLabel = new JLabel();
        statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        statusLabel.setMinimumSize(new Dimension(0, 18));
        statusLabel.setPreferredSize(new Dimension(0, 18));

        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);
        splitPane.setContinuousLayout(true);
        splitPane.add(scrollPane, JSplitPane.LEFT);
        splitPane.add(desktop, JSplitPane.RIGHT);

        panel.setLayout(new BorderLayout());
        panel.add(splitPane, BorderLayout.CENTER);

        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(statusLabel, BorderLayout.CENTER);
    }

    private void buildMenu() {
        menuBar = new JMenuBar();
        app = new JMenu("App");
        help = new JMenu("Help");
        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");
        app.add(exit);
        help.add(about);
        menuBar.add(app);
        menuBar.add(help);
    }

    private void buildFrame() {
        setLayout(new BorderLayout());
        getContentPane().add(labelPanel, BorderLayout.SOUTH);
        getContentPane().add(panel, BorderLayout.CENTER);
        setIconImage(Toolkit.getDefaultToolkit().getImage("images/csun.gif"));
        setTitle("My App");
        setJMenuBar(menuBar);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

}
