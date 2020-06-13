public class GateNot extends LogicGate {
    public GateNot(LogicVariable output, LogicVariable input1) throws CollisionException, CycleException {
        super(output, input1, null);
        calculate();
    }

    @Override
    public String getSymbol() {
        return "NOT";
    }

    @Override
    public void calculate() {
        output.setValue(!input1.getValue());
    }
}
