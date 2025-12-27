package UtilClass;

import ChainOfResponsibility.HandlerChain;
import CommonEnums.Note;

import java.util.HashMap;

public class CashInventory {
    private HashMap<Note, Integer> noteMap;
    private HandlerChain handlerChain;
    public CashInventory() {
        noteMap = new HashMap<>();
        handlerChain = new HandlerChain();
    }

    public void addNote(Note note, int cnt) {
        noteMap.put(note, cnt);
    }

    public void withdraw(int amount) {
        handlerChain.dispense(amount);
    }
}
