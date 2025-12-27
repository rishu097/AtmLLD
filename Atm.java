import CommonEnums.Note;
import State.AtmContext;
import State.ConcreteStates.AuthenticatedState;
import State.ConcreteStates.DispenseState;
import State.ConcreteStates.HasCardState;
import State.ConcreteStates.IdleState;
import UtilClass.AtmAccountManager;
import UtilClass.Card;
import UtilClass.CashInventory;

public class Atm {

    private static Atm atmInstance;
    private CashInventory cashInventory;
    private AtmAccountManager atmAccountManager;
    private AtmContext atmContext;
    private String currentCardNumber;

    private Atm() {
        cashInventory = new CashInventory();
        atmAccountManager = new AtmAccountManager();
        atmContext = new AtmContext();
    }
    public static Atm getInstance() {
        if (atmInstance == null) {
            atmInstance = new Atm();
        }
        return atmInstance;
    }

    //Admin Operations
    public void fillInventory(Note note,int count){
        cashInventory.addNote(note,count);
    }
    public void addAccount(String name,int balance){
        atmAccountManager.addAccount(name,balance);
    }
    public void addCard(String name, String cardNumber, String pin, String accountNumber) {
        atmAccountManager.addCard(name, cardNumber, pin,accountNumber);
    }

    //Customer Operation
    public void insertCard(String cardNumber){
        if(atmContext.getAtmState() instanceof IdleState){
            String cardHolderName = atmAccountManager.getAccountHolderName(cardNumber);
            this.currentCardNumber = cardNumber;
            System.out.println("Hi "+cardHolderName+",Please Enter your Pin");
            atmContext.setNextState();
        }
        else{
            throw new IllegalStateException("Please Insert Your card First");
        }
    }

    public void enterPin(String pin) throws IllegalAccessException {
        if(atmContext.getAtmState() instanceof HasCardState){
            if(atmAccountManager.authenticate(currentCardNumber,pin)){
                System.out.println("Your Account is Authenticated!!");
                System.out.println("Enter the amount You want to withdraw");
                atmContext.setNextState();
            }
            else{
                throw new IllegalAccessException("Your Pin is Wrong");
            }
        }
        else{
            throw new IllegalStateException("Please Insert Your Card First");
        }
    }

    public void enterAmount(int amount) throws IllegalAccessException {
        if(atmContext.getAtmState() instanceof AuthenticatedState){
            if(atmAccountManager.hasFund(currentCardNumber,amount)){
                System.out.println("Please press dispense Button to collect cash");
                atmContext.setNextState();
            }
            else{
                throw new IllegalAccessException("Insufficient Funds");
            }
        }
        else{
            throw new IllegalStateException("Please Authenticate Your Card First by entering PIN");
        }
    }

    public void dispenseCash(int amount){
        if(atmContext.getAtmState() instanceof DispenseState){
            atmAccountManager.withdraw(currentCardNumber,amount);
            cashInventory.withdraw(amount);
            atmContext.setNextState();
            this.currentCardNumber = null;
        }
        else{
            throw new IllegalStateException("Operation not allowed in this state");
        }
    }

}
