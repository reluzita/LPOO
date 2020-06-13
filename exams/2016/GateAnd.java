public class GateAnd extends LogicGate{
    public GateAnd(LogicVariable output, LogicVariable input1, LogicVariable input2) throws CollisionException, CycleException {
        super(output, input1, input2);
        calculate();
    }

    @Override
    public String getSymbol() {
        return "AND";
    }

    @Override
    public void calculate() {
        output.setValue(input1.getValue() && input2.getValue());
    }
}
