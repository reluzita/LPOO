import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CombinatorialCircuit {
    List<LogicVariable> variables;

    public CombinatorialCircuit() {
        variables = new ArrayList<>();
    }

    public boolean addVariable(LogicVariable lv) {
        if(variables.contains(lv))
            return false;

        variables.add(lv);
        return true;
    }

    public LogicVariable getVariableByName(String name) {
        for(LogicVariable lv: variables) {
            if(lv.getName().equals(name))
                return lv;
        }
        return null;
    }

}
