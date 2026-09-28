import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
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
        if (model.hatGewonnen() || model.hatVerloren()) {
            return;
        }

        String text = view.getEingabe();
        if (text.length() != 1 || text.charAt(0) < '1' || text.charAt(0) > '9') {
            return;
        }

        int zahl = Integer.parseInt(text);
        model.berechneRunde(zahl);

        view.setComputerZahl(model.getComputerZahl());
        view.setGesamtPunkteText(String.valueOf(model.getGesamtPunkte()));

        if (model.hatGewonnen()) {
            view.setRundenErgebnisText("Gewonnen!");
        } else if (model.hatVerloren()) {
            view.setRundenErgebnisText("Verloren");
        } else if (model.getRundenErgebnis() > 0) {
            view.setRundenErgebnisText("+" + model.getRundenErgebnis());
        } else {
            view.setRundenErgebnisText(String.valueOf(model.getRundenErgebnis()));
        }
    }

    private void resetRunde() {
        view.reset();
    }
}
