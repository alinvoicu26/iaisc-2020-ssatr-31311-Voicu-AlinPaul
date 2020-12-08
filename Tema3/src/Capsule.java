import java.util.List;

public class Capsule {
    String name_capsule;
    List<String> inputs;
    List<String> outputs;

    public Capsule() {

    }

    public String getName() {
        return name_capsule;
    }

    public void setName(String name) {
        this.name_capsule = name;
    }

    public List<String> getIn() {
        return inputs;
    }

    public void setIn(List<String> in) {
        this.inputs = inputs;
    }

    public List<String> getOut() {
        return outputs;
    }

    public void setOut(List<String> out) {
        this.outputs = out;
    }
}
