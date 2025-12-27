import CommonEnums.Note;

public class AtmDemo {

    public static void main(String[] args) {
        Atm atm = Atm.getInstance();

        atm.addCard("Rishu","4444","4444","1234");
        atm.addCard("Prince","5555","5555","5678");
        atm.addAccount("1234",1000);
        atm.addAccount("5678",50);

        //Fill inventory
        atm.fillInventory(Note.ONE,100);
        atm.fillInventory(Note.FIVE,50);
        atm.fillInventory(Note.TEN,25);
        atm.fillInventory(Note.FIFTY,10);

        //Happy Flow check
        atm.insertCard("4444");
        //Authentication
        try {
            atm.enterPin("4444");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        //Enter Amount
        try {
            atm.enterAmount(167);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }

        atm.dispenseCash(167);

    }
}
