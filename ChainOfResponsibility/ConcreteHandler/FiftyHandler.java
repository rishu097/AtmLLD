package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnums.Note;

public class FiftyHandler extends Handler {
    public void handleRequest(int amount) {

        int required = amount/ Note.FIFTY.getValue();
        int left = amount-required*Note.FIFTY.getValue();

        if(required>0){
            System.out.println("Dispensing "+required +" notes of FIFTY");
        }
        if(left>0 && nextHandler!=null){
            nextHandler.handleRequest(left);
        }
    }
}
