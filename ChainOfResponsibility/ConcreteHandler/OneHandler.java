package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnums.Note;

public class OneHandler extends Handler {

    @Override
    public void handleRequest(int amount) {

        int required = amount/ Note.ONE.getValue();
        int left = amount-required*Note.ONE.getValue();

        if(required>0){
            System.out.println("Dispensing "+required +" notes of One");
        }
        if(left>0 && nextHandler!=null){
            nextHandler.handleRequest(left);
        }
    }
}
