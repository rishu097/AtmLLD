package UtilClass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String name;
    private String cardNumber;
    private String pin;
    private String accountNumber;
}
