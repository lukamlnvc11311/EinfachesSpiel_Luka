import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
        this.view.getBtnNochEinmal().setEnabled(false);
        this.view.addEingabeListener(this);
        this.view.addNochEinmalListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == view.getTxtEingabe()) {
            verarbeiteEingabe();
        } else if (e.getSource() == view.getBtnNochEinmal()) {
            resetRunde();
        }
    }

    private void verarbeiteEingabe() {
        if (model.hatGewonnen() == true || model.hatVerloren() == true) {
            return;
        }

        try {
            int zahl = Integer.parseInt(view.getEingabe());
            if (zahl < 1 || zahl > 9) {
                return;
            }

            model.berechneRunde(zahl);
            view.setComputerZahl(model.getComputerZahl());
            view.setErgebnisse(model.getGesamtPunkte(), model.getRundenErgebnis());

            view.getTxtEingabe().setEnabled(false);
            view.getBtnNochEinmal().setEnabled(true);

            if (model.getRundenErgebnis() > 0 || model.hatGewonnen() == true) {
                view.getLblPunkte().setBackground(Color.GREEN);
                view.getLblRunde().setBackground(Color.GREEN);
            } else {
                view.getLblPunkte().setBackground(Color.RED);
                view.getLblRunde().setBackground(Color.RED);
            }

        } catch (NumberFormatException ex) {
        }
    }

    private void resetRunde() {
        view.reset();

        view.getTxtEingabe().setEnabled(true);
        view.getBtnNochEinmal().setEnabled(false);

        view.getLblPunkte().setBackground(Color.WHITE);
        view.getLblRunde().setBackground(Color.WHITE);
    }
}