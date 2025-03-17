package Lab3;

import java.util.Map;

import Lab3.Models.Bank;
import Lab3.Models.ATM;
import Lab3.Exceptions.*;

public class Lab3_5 {
    public static void main(String[] args) {
        Bank bank = new Bank(3);
        try {
            bank.initializeATM(0, 10000);
            bank.initializeATM(1, 15000);
            bank.initializeATM(2, 20000);

            System.out.println("Загальна сума в банкоматах: " + bank.getTotalAmount());

            ATM atm1 = bank.getATM(0);
            atm1.depositMoney(5000);
            System.out.println("Сума в банкоматі 1 після внесення: " + atm1.getTotalAmount());
            Map<Integer, Integer> withdrawal1 = atm1.withdrawMoney(7500);
            System.out.println("Видані банкноти з банкомату 1: " + withdrawal1);
            System.out.println("Сума в банкоматі 1 після зняття: " + atm1.getTotalAmount());

            ATM atm2 = bank.getATM(1);
            atm2.depositMoney(2000);
            System.out.println("Сума в банкоматі 2 після внесення: " + atm2.getTotalAmount());
            Map<Integer, Integer> withdrawal2 = atm2.withdrawMoney(10000);
            System.out.println("Видані банкноти з банкомату 2: " + withdrawal2);
            System.out.println("Сума в банкоматі 2 після зняття: " + atm2.getTotalAmount());

            ATM atm3 = bank.getATM(2);
            try {
                atm3.withdrawMoney(30000);
            } catch (InsufficientFundsException | ExceededMaxWithdrawalException | InvalidAmountException e) {
                System.out.println("Помилка при роботі з банкоматом 3: " + e.getMessage());
            }
            System.out.println("Сума в банкоматі 3: " + atm3.getTotalAmount());
        } catch (InsufficientFundsException | ExceededMaxWithdrawalException | InvalidAmountException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}