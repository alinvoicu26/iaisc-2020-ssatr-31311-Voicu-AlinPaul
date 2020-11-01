package mas.ssatr.Alin.Voicu;

import java.util.ArrayList;
import java.util.Random;
public class Transition {
    public String name= "";
    private boolean has_token = false;
    public int max_time = 0;
    public int min_time = 0;
    private int current_time = 0;
    public ArrayList <Place> input_P;
    public ArrayList <Place> output_P;
    private int random;

    public Transition(String name, int max_time, int min_time, ArrayList<Place> input_P, ArrayList<Place> output_P) {
        this.name = name;
        this.max_time = max_time;
        this.min_time = min_time;
        this.input_P = input_P;
        this.output_P = output_P;
    }

    public boolean allHaveToken(ArrayList<Place> list) {
        for (Place p : list) if (!(p.getTokens() > 0)) return false;
        return true;
    }


    public int hasToken() {
        if (this.has_token) {
            return 1;
        } else {
            return 0;
        }
    }

    public void Execute() {
        this.current_time++;
        if (allHaveToken(input_P)) {
            Random random = new Random();
            if (this.max_time != this.min_time){
                this.random = random.nextInt(this.max_time-this.min_time)+this.min_time;
            }
            else {
                this.random = this.max_time;
            }
            for (Place p: input_P) {
                p.extractTokens();
            }
            this.has_token = true;
        }

        if (this.has_token && (this.current_time >= this.random)) {
            for (Place o: output_P) {
                o.addTokens();
            }
            this.has_token = false;
        }
    }


}
