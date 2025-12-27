package State.ConcreteStates;

import State.AtmContext;
import State.AtmState;

public class IdleState implements AtmState {

    @Override
    public String getState() {
        return "Idle";
    }

    @Override
    public void setNextState(AtmContext atmContext) {
        atmContext.setState(new HasCardState());
    }
}
