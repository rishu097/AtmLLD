package ChainOfResponsibility.ConcreteHandler;

import ChainOfResponsibility.Handler;
import CommonEnums.Note;

public class TenHandler extends Handler {
    @Override
    public void handleRequest(int amount) {

        int required = amount/ Note.TEN.getValue();
        int left = amount-required*Note.TEN.getValue();

        if(required>0){
            System.out.println("Dispensing "+required +" notes of TEN");
        }
        if(left>0 && nextHandler!=null){
            nextHandler.handleRequest(left);
        }
    }
}
