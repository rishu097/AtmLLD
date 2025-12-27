package State;

public interface AtmState {
    void setNextState(AtmContext atmContext);
    String getState();
}
