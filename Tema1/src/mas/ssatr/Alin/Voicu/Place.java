package mas.ssatr.Alin.Voicu;

public class Place {
    public String name = "";
    public int tokens = 0;

    int getTokens() {
        return tokens;
    }

    void addTokens() {
        this.tokens++;
    }

    void extractTokens(){
        this.tokens--;
    }

    public Place(String name, int tokens) {
        this.name = name;
        this.tokens = tokens;
    }
}
