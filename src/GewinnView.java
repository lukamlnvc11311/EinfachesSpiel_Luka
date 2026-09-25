import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GewinnView extends JFrame {
    private JLabel lblPunkte;
    private JLabel lblRunde;
    private JTextField txtEingabe;
    private JTextField txtComputer;
    private JButton btnNochEinmal;

    public GewinnView() {
        super("Gewinnspiel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 250);
        setLocationRelativeTo(null);
        initLayout();
    }

    private void initLayout() {
        setLayout(new BorderLayout());

        JPanel pnlNord = new JPanel(new GridLayout(2, 1));
        lblPunkte = new JLabel("Punkte: 30", SwingConstants.CENTER);
        lblRunde = new JLabel("Runde: 0", SwingConstants.CENTER);
        lblPunkte.setOpaque(true);
        lblRunde.setOpaque(true);
        lblPunkte.setBackground(Color.WHITE);
        lblRunde.setBackground(Color.WHITE);
        pnlNord.add(lblPunkte);
        pnlNord.add(lblRunde);
        add(pnlNord, BorderLayout.NORTH);

        JPanel pnlMitte = new JPanel(new GridLayout(2, 2));
        pnlMitte.add(new JLabel("Deine Zahl (1-9):"));
        txtEingabe = new JTextField();
        pnlMitte.add(txtEingabe);

        pnlMitte.add(new JLabel("Computer-Zahl:"));
        txtComputer = new JTextField();
        txtComputer.setEditable(false);
        pnlMitte.add(txtComputer);
        add(pnlMitte, BorderLayout.CENTER);

        btnNochEinmal = new JButton("Noch einmal!");
        add(btnNochEinmal, BorderLayout.SOUTH);
    }

    public void addEingabeListener(ActionListener al) {
        txtEingabe.addActionListener(al);
    }

    public void addNochEinmalListener(ActionListener al) {
        btnNochEinmal.addActionListener(al);
    }

    public String getEingabe() {
        return txtEingabe.getText().trim();
    }

    public void setComputerZahl(int zahl) {
        txtComputer.setText(String.valueOf(zahl));
    }

    public void setErgebnisse(int punkte, int runde) {
        lblPunkte.setText("Punkte: " + punkte);
        lblRunde.setText("Runde: " + runde);
    }

    public void reset() {
        txtEingabe.setText("");
        txtComputer.setText("");
        lblRunde.setText("Runde: 0");
    }

    public JTextField getTxtEingabe() {
        return txtEingabe;
    }

    public JButton getBtnNochEinmal() {
        return btnNochEinmal;
    }

    public JLabel getLblPunkte() {
        return lblPunkte;
    }

    public JLabel getLblRunde() {
        return lblRunde;
    }
}