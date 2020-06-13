import java.util.List;

public abstract class LogicGate {
    protected LogicVariable output;
    protected LogicVariable input1;
    protected LogicVariable input2;


    public LogicGate(LogicVariable output, LogicVariable input1, LogicVariable input2) throws CollisionException, CycleException {
        if(checkForCycle(output, input1, input2)) throw new CycleException();

        output.setGate(this);

        this.output = output;
        this.input1 = input1;
        input1.addObserver(this);
        this.input2 = input2;
        if(input2 != null)
            input2.addObserver(this);
    }

    private boolean checkForCycle(LogicVariable output, LogicVariable input1, LogicVariable input2) {
        LogicGate temp = input1.getCalculatedBy();
        if(temp != null) {
            for (LogicVariable lv : temp.getInputs()) {
                if (lv.equals(output)) return true;
            }
        }

        if(input2 == null) return false;

        temp = input2.getCalculatedBy();
        if(temp != null) {
            for (LogicVariable lv : temp.getInputs()) {
                if (lv.equals(output)) return true;
            }
        }

        return false;
    }

    public LogicVariable getOutput() {
        return output;
    }

    public LogicVariable[] getInputs() {
        if(input2 == null)
            return new LogicVariable[]{input1};
        return new LogicVariable[]{input1, input2};
    }

    public abstract String getSymbol();

    public String getFormula() {
        String res =  getSymbol() + "(" + input1.getFormula();
        if(input2 == null)
            return res + ")";
        else
            return res + "," + input2.getFormula() + ")";
    }

    public abstract void calculate();
}
