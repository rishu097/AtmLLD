package CommonEnums;

public enum Note {
    ONE(1),
    FIVE(5),
    TEN(10),
    FIFTY(50);

    private int value;
    Note(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
