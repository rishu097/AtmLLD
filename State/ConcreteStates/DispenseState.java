package State.ConcreteStates;

import State.AtmContext;
import State.AtmState;

public class DispenseState implements AtmState {
    @Override
    public String getState() {
        return "DispenseState";
    }

    @Override
    public void setNextState(AtmContext atmContext) {
        atmContext.setState(new IdleState());
    }
}
