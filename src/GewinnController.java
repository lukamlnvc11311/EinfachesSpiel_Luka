import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GewinnController implements ActionListener {
    private GewinnModel model;
    private GewinnView view;

    public GewinnController(GewinnModel model, GewinnView view) {
        this.model = model;
        this.view = view;
        initEvents();
    }

    private void initEvents() {
        view.addEingabeListener(this);
        view.addNochEinmalListener(this);
    }

    @Override
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

        try {
            int zahl = Integer.parseInt(view.getEingabe());
            if (zahl < 1 || zahl > 9) {
                return;
            }

            model.berechneRunde(zahl);
            view.setComputerZahl(model.getComputerZahl());
            view.setErgebnisse(model.getGesamtPunkte(), model.getRundenErgebnis());

        } catch (NumberFormatException ex) {
        }
    }

    private void resetRunde() {
        view.reset();
    }
}