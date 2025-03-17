package Lab3.Models;

import java.util.HashMap;
import java.util.Map;

import Lab3.Exceptions.*;

public class ATM {
    private final Map<Integer, Integer> banknotes;
    private final int maxWithdrawalAmount;
    private final int maxWithdrawalNotes;

    public ATM() {
        banknotes = new HashMap<>();
        banknotes.put(1, 0);
        banknotes.put(2, 0);
        banknotes.put(5, 0);
        banknotes.put(10, 0);
        banknotes.put(20, 0);
        banknotes.put(50, 0);
        banknotes.put(100, 0);
        banknotes.put(200, 0);
        banknotes.put(500, 0);
        maxWithdrawalAmount = 50000;
        maxWithdrawalNotes = 50;
    }

    public void loadMoney(int amount) throws InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Сума для завантаження має бути невід'ємною.");
        }
        int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        for (int denomination : denominations) {
            int count = amount / denomination;
            banknotes.put(denomination, banknotes.get(denomination) + count);
            amount %= denomination;
        }
    }

    public void depositMoney(int amount) throws InvalidAmountException {
        loadMoney(amount);
    }

    public Map<Integer, Integer> withdrawMoney(int amount) throws InsufficientFundsException, ExceededMaxWithdrawalException, InvalidAmountException {
        if (amount < 0) {
            throw new InvalidAmountException("Сума для зняття має бути невід'ємною.");
        }
        if (amount > maxWithdrawalAmount) {
            throw new ExceededMaxWithdrawalException("Сума перевищує максимальну суму для видачі.");
        }
        if (amount > getTotalAmount()) {
            throw new InsufficientFundsException("Недостатньо коштів у банкоматі.");
        }

        Map<Integer, Integer> withdrawal = new HashMap<>();
        int[] denominations = {500, 200, 100, 50, 20, 10, 5, 2, 1};
        int totalNotes = 0;

        for (int denomination : denominations) {
            int count = Math.min(amount / denomination, banknotes.get(denomination));
            if (count > 0) {
                withdrawal.put(denomination, count);
                amount -= denomination * count;
                banknotes.put(denomination, banknotes.get(denomination) - count);
                totalNotes += count;
            }
        }

        if (amount > 0 || totalNotes > maxWithdrawalNotes) {
            // Помилка, неможливо видати потрібну суму з доступних банкнот
            // Повертаємо банкноти назад
            for (Map.Entry<Integer, Integer> entry : withdrawal.entrySet()) {
                banknotes.put(entry.getKey(), banknotes.get(entry.getKey()) + entry.getValue());
            }
            if (totalNotes > maxWithdrawalNotes) {
                throw new ExceededMaxWithdrawalException("Кількість банкнот перевищує максимальну кількість для видачі.");
            } else {
                throw new InsufficientFundsException("Недостатньо доступних номіналів для видачі суми.");
            }
        }

        return withdrawal;
    }

    public int getTotalAmount() {
        int total = 0;
        for (Map.Entry<Integer, Integer> entry : banknotes.entrySet()) {
            total += entry.getKey() * entry.getValue();
        }
        return total;
    }
}