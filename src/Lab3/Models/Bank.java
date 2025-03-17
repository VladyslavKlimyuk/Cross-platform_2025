package Lab3.Models;

import Lab3.Exceptions.*;

public class Bank {
    private ATM[] atms;

    public Bank(int numberOfATMs) {
        this.atms = new ATM[numberOfATMs];
        for (int i = 0; i < atms.length; i++) {
            atms[i] = new ATM();
        }
    }

    public void initializeATM(int atmIndex, int initialAmount) throws InvalidAmountException {
        if (atmIndex < 0 || atmIndex >= atms.length) {
            throw new IllegalArgumentException("Невірний індекс банкомату.");
        }
        atms[atmIndex].loadMoney(initialAmount);
    }

    public ATM getATM(int atmIndex) {
        if (atmIndex < 0 || atmIndex >= atms.length) {
            throw new IllegalArgumentException("Невірний індекс банкомату.");
        }
        return atms[atmIndex];
    }

    public int getTotalAmount() {
        int total = 0;
        for (ATM atm : atms) {
            total += atm.getTotalAmount();
        }
        return total;
    }
}