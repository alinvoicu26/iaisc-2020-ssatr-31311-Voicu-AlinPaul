package mas.ssatr.Alin.Voicu;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class PetrinetLoader {
    public ArrayList<Place> places = new ArrayList<>();
    public ArrayList<Transition> transitions = new ArrayList<>();

    public PetrinetLoader() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/mas/ssatr/Alin/Voicu/petri.json"));

            JSONObject jsonObject = (JSONObject) obj;
            JSONArray jsonPlaces = (JSONArray) jsonObject.get("places");
            JSONArray jsonTransitions = (JSONArray) jsonObject.get("transitions");

            for (int i = 0; i < jsonPlaces.size(); i++) {
                JSONObject jsonObj = (JSONObject) jsonPlaces.get(i);
                Place aux = new Place((String) jsonObj.get("name"), Integer.parseInt(jsonObj.get("tokens").toString()));
                places.add(aux);
            }

            for (Object jsonTransition : jsonTransitions) {
                JSONObject jsonObj = (JSONObject) jsonTransition;

                String name = (String) jsonObj.get("name");
                ArrayList<String> inp = (ArrayList<String>) jsonObj.get("inputs");
                ArrayList<String> out = (ArrayList<String>) jsonObj.get("outputs");
                ArrayList<Place> tmp_in = new ArrayList<>();
                ArrayList<Place> tmp_out = new ArrayList<>();

                String min_time = jsonObj.get("min_time").toString();
                String max_time = jsonObj.get("max_time").toString();

                for (int j = 0; j < inp.size(); j++) {
                    for (Place p : places) {
                        if (p.name.equals((String) inp.get(j))) {
                            tmp_in.add(p);
                            break;
                        }
                    }
                }

                for (int j = 0; j < out.size(); j++) {
                    for (Place p : places) {
                        if (p.name.equals((String) out.get(j))) {
                            tmp_out.add(p);
                            break;
                        }
                    }
                }

                //Transition aux = new Transition(name, tmp_in, tmp_out);
                Transition aux = new Transition(name,Integer.parseInt(max_time),Integer.parseInt(min_time),tmp_in,tmp_out);
                transitions.add(aux);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}