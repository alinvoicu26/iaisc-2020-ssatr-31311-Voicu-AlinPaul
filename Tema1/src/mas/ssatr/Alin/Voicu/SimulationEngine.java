package mas.ssatr.Alin.Voicu;

import java.io.FileOutputStream;
import java.util.Arrays;

public class SimulationEngine {
    public boolean active = true;
    PetriNetModel pnm = new PetriNetModel();

    public void simulate() {
        String file_name = "output.txt";
        try {
            FileOutputStream outputStream = new FileOutputStream(file_name);
            while (this.active) {
                System.out.format("Running step %d \n", pnm.step); //display the information
                for (Place p : pnm.getPlaces()) {
                    System.out.format("%s: %d, ", p.name, p.getTokens());
                }
                System.out.println();
                for (Transition t : pnm.getTransitions()) {
                    System.out.format("%s: %d, ", t.name, t.hasToken());
                }
                System.out.println();
                String str = String.format("Step: %" + 2 + "s" + ": %s\n", pnm.step, String.join(", ", pnm.get_state()));

                byte[] strToBytes = str.getBytes();
                outputStream.write(strToBytes);


                pnm.Step(); //execute a step
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (pnm.step == 20) {
                    active = false;
                }
            }
            outputStream.close();
        }catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}
