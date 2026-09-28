import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GewinnView extends JFrame {
    private JLabel lblRundenErgebnis;
    private JLabel lblGesamtPunkte;
    private JTextField txtEingabe;
    private JTextField txtComputer;
    private JButton btnNochEinmal;

    public GewinnView() {
        super("Zahlen-Gewinnspiel (v1.0)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 260);
        setLocationRelativeTo(null);
        initLayout();
    }

    private void initLayout() {
        setLayout(new BorderLayout(10, 10));
        ((JPanel) getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel pnlNord = new JPanel(new GridLayout(2, 2, 10, 2));
        JLabel lblHeaderRunde = new JLabel("Rundenergebnis:", SwingConstants.CENTER);
        JLabel lblHeaderGesamt = new JLabel("Gesamtpunkte:", SwingConstants.CENTER);

        lblRundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblGesamtPunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);

        lblRundenErgebnis.setOpaque(true);
        lblGesamtPunkte.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);
        lblGesamtPunkte.setBackground(Color.WHITE);

        Font boldFont = new Font("Arial", Font.BOLD, 14);
        lblRundenErgebnis.setFont(boldFont);
        lblGesamtPunkte.setFont(boldFont);

        pnlNord.add(lblHeaderRunde);
        pnlNord.add(lblHeaderGesamt);
        pnlNord.add(lblRundenErgebnis);
        pnlNord.add(lblGesamtPunkte);
        add(pnlNord, BorderLayout.NORTH);

        JPanel pnlMitte = new JPanel(new GridLayout(1, 2, 15, 0));

        JPanel pnlLinks = new JPanel(new BorderLayout(5, 5));
        JLabel lblDeineZahl = new JLabel("Deine Zahl:", SwingConstants.CENTER);
        txtEingabe = new JTextField();
        txtEingabe.setHorizontalAlignment(JTextField.CENTER);
        txtEingabe.setFont(new Font("Arial", Font.BOLD, 32));
        pnlLinks.add(lblDeineZahl, BorderLayout.NORTH);
        pnlLinks.add(txtEingabe, BorderLayout.CENTER);

        JPanel pnlRechts = new JPanel(new BorderLayout(5, 5));
        JLabel lblComputer = new JLabel("Computer:", SwingConstants.CENTER);
        txtComputer = new JTextField();
        txtComputer.setHorizontalAlignment(JTextField.CENTER);
        txtComputer.setFont(new Font("Arial", Font.BOLD, 32));
        txtComputer.setEditable(false);
        txtComputer.setBackground(Color.WHITE);
        pnlRechts.add(lblComputer, BorderLayout.NORTH);
        pnlRechts.add(txtComputer, BorderLayout.CENTER);

        pnlMitte.add(pnlLinks);
        pnlMitte.add(pnlRechts);
        add(pnlMitte, BorderLayout.CENTER);

        JPanel pnlSued = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnNochEinmal = new JButton("Noch einmal!");
        pnlSued.add(btnNochEinmal);
        add(pnlSued, BorderLayout.SOUTH);
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

    public void setRundenErgebnisText(String text) {
        lblRundenErgebnis.setText(text);
    }

    public void setGesamtPunkteText(String text) {
        lblGesamtPunkte.setText(text);
    }

    public void reset() {
        txtEingabe.setText("");
        txtComputer.setText("");
        lblRundenErgebnis.setText("Tippe eine Zahl von 1 bis 9");
        lblGesamtPunkte.setText("Gesamtpunkte: 30");
    }

    public JTextField getTxtEingabe() {
        return txtEingabe;
    }

    public JButton getBtnNochEinmal() {
        return btnNochEinmal;
    }

    public JLabel getLblPunkte() {
        return lblGesamtPunkte;
    }

    public JLabel getLblRunde() {
        return lblRundenErgebnis;
    }
}