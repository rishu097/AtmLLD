package State.ConcreteStates;

import State.AtmContext;
import State.AtmState;

public class AuthenticatedState implements AtmState {
    @Override
    public String getState() {
        return "Authenticated";
    }

    @Override
    public void setNextState(AtmContext atmContext) {
        atmContext.setState(new DispenseState());
    }
}
