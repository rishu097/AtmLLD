package ChainOfResponsibility;

import ChainOfResponsibility.ConcreteHandler.FiftyHandler;
import ChainOfResponsibility.ConcreteHandler.FiveHandler;
import ChainOfResponsibility.ConcreteHandler.OneHandler;
import ChainOfResponsibility.ConcreteHandler.TenHandler;

public class HandlerChain {
    private Handler OneHandler;
    private Handler FiveHandler;
    private Handler TenHandler;
    private Handler FiftyHandler;

    public HandlerChain(){
        OneHandler = new OneHandler();
        FiveHandler = new FiveHandler();
        TenHandler = new TenHandler();
        FiftyHandler = new FiftyHandler();

        FiftyHandler.setNextHandler(TenHandler);
        TenHandler.setNextHandler(FiveHandler);
        FiveHandler.setNextHandler(OneHandler);
    }

    public void dispense(int amount){
        FiftyHandler.handleRequest(amount);
    }
}
