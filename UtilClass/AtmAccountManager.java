package UtilClass;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@Data
public class AtmAccountManager {

    private HashMap<String,Account> accountNumberToAccount;
    private HashMap<String,Card> cardNumberToCard;
    public AtmAccountManager() {

        accountNumberToAccount = new HashMap<>();
        cardNumberToCard = new HashMap<>();
    }

    public boolean authenticate(String cardNumber,String enteredPin) {
        Card card = cardNumberToCard.get(cardNumber);
        return card.getPin().equals(enteredPin);
    }

    public boolean hasFund(String cardNumber,int amount) {
        Card card = cardNumberToCard.get(cardNumber);
        String accountNumber = card.getAccountNumber();
        Account account = accountNumberToAccount.get(accountNumber);
        return account.getBalance() >= amount;
    }

    public void withdraw(String cardNumber,int amount) {
        Card card = cardNumberToCard.get(cardNumber);
        String accountNumber = card.getAccountNumber();
        Account account = accountNumberToAccount.get(accountNumber);
        account.setBalance(account.getBalance() - amount);
    }

    public void addAccount(String accountNumber,int balance) {
        Account account = new Account(accountNumber,balance);
        accountNumberToAccount.put(accountNumber,account);
    }

    public void addCard(String name, String cardNumber, String pin, String accountNumber) {
        Card card = new Card(name, cardNumber, pin,accountNumber);
        cardNumberToCard.put(cardNumber,card);

    }

    public String getAccountHolderName(String cardNumber) {
        Card card = cardNumberToCard.get(cardNumber);
        return card.getName();
    }


}
