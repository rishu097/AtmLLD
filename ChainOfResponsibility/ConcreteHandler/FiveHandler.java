package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnums.Note;

public class FiveHandler extends Handler {
    @Override
    public void handleRequest(int amount) {

        int required = amount/ Note.FIVE.getValue();
        int left = amount-required*Note.FIVE.getValue();

        if(required>0){
            System.out.println("Dispensing "+required +" notes of FIVE");
        }
        if(left>0 && nextHandler!=null){
            nextHandler.handleRequest(left);
        }
    }
}
