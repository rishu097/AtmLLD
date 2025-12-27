package State.ConcreteStates;

import State.AtmContext;
import State.AtmState;

public class HasCardState implements AtmState {
    @Override
    public String getState() {
        return "Has Card State";
    }

    @Override
    public void setNextState(AtmContext atmContext) {
        atmContext.setState(new AuthenticatedState());
    }
}
