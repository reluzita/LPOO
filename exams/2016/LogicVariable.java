import java.util.ArrayList;
import java.util.List;

public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate gate;

    private List<LogicGate> observers;

    public LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        this.gate = null;

        this.observers = new ArrayList<>();
    }

    public LogicVariable(String name) {
        this.name = name;
        this.value = false;
        this.gate = null;

        this.observers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
        notifyObservers();
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;

        LogicVariable lv = (LogicVariable) o;
        return name.equals(lv.getName()) && value == lv.getValue();
    }

    public void setGate(LogicGate gate) throws CollisionException {
        if(this.gate != null) throw new CollisionException();

        this.gate = gate;
    }

    public LogicGate getCalculatedBy() {
        return gate;
    }

    public String getFormula() {
        if (gate == null)
            return name;
        else
            return gate.getFormula();
    }

    public void addObserver(LogicGate lg) {
        observers.add(lg);
    }

    public void notifyObservers() {
        for(LogicGate lg: observers)
            lg.calculate();
    }
}
