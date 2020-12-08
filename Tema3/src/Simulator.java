import java.util.List;
public class Simulator {
    Ports ports=new Ports();
    Capsule capsule=new Capsule();
    String capsule_name;
    List<Ports> portsin;
    List<Ports> portsout;

    public void getCapsule(){
        capsule_name=capsule.getName();
    }
    public List<String> getPortIn(){
        return capsule.getIn();
    }
    public List<String> getPortOut(){
        return capsule.getOut();
    }

    public static void checkTypePortsIn(){
        System.out.println("test RT-UML");
    }
    public static void main(String[] args){
        checkTypePortsIn();
    }
}
