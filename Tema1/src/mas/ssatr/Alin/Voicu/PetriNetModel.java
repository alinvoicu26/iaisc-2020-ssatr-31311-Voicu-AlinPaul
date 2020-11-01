package mas.ssatr.Alin.Voicu;

import java.util.ArrayList;

public class PetriNetModel {
    public int step = 0;
    private ArrayList<Place> places;
    private ArrayList<Transition> transitions;

    public PetriNetModel() {
        PetrinetLoader pnl = new PetrinetLoader();
        this.places = pnl.places;
        this.transitions = pnl.transitions;
    }

    public ArrayList<String> get_state() {
        ArrayList<String> state = new ArrayList<String>();
        for (Place p : this.places) {
            state.add(String.valueOf(p.getTokens()));
        }
        return state;
    }

    public ArrayList<Place> getPlaces() {
        return places;
    }

    public ArrayList<Transition> getTransitions() {
        return transitions;
    }

    public void Step() {
        ArrayList<Transition> executable = new ArrayList<>();
        for (Transition t : this.transitions) {
            if (t.allHaveToken(t.input_P) || t.hasToken() == 1) {
                executable.add(t);
            }
        }

        for (Transition transition : executable) {
            transition.Execute();
        }
        this.step++;
    }

}
