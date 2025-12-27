package State;

import State.ConcreteStates.IdleState;
import lombok.Data;

@Data
public class AtmContext {
    private AtmState atmState;

    public AtmContext() {
        this.atmState = new IdleState();
    }

    public void setNextState() {
        this.atmState.setNextState(this);
    }

    public void setState(AtmState atmState) {
        this.atmState = atmState;
    }
}
