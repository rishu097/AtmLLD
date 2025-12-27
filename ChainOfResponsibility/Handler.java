package ChainOfResponsibility;

public abstract class Handler {

    protected Handler nextHandler;

    public abstract void handleRequest(int amount);
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
