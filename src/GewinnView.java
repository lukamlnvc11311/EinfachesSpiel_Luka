import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
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
        setSize(400, 220);
        setLocationRelativeTo(null);
        initLayout();
    }

    private void initLayout() {
        setLayout(new BorderLayout());

        JPanel pnlNord = new JPanel(new GridLayout(2, 2));
        pnlNord.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        pnlNord.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        lblRundenErgebnis = new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);
        lblGesamtPunkte = new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);

        lblRundenErgebnis.setOpaque(true);
        lblGesamtPunkte.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);
        lblGesamtPunkte.setBackground(Color.WHITE);

        pnlNord.add(lblRundenErgebnis);
        pnlNord.add(lblGesamtPunkte);
        add(pnlNord, BorderLayout.NORTH);

        JPanel pnlMitte = new JPanel(new GridLayout(2, 2));
        pnlMitte.add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        pnlMitte.add(new JLabel("Computer:", SwingConstants.CENTER));

        txtEingabe = new JTextField();
        txtEingabe.setHorizontalAlignment(JTextField.CENTER);

        txtComputer = new JTextField();
        txtComputer.setHorizontalAlignment(JTextField.CENTER);
        txtComputer.setEditable(false);
        txtComputer.setBackground(Color.WHITE);

        pnlMitte.add(txtEingabe);
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
