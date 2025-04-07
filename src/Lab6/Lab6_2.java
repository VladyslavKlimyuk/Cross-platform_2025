package Lab6;

import Lab6.Models.Dictionary;
import Lab6.Models.DictionaryManager;
import Lab6.Models.ConsoleInterface;

public class Lab6_2 {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        DictionaryManager dictionaryManager = new DictionaryManager(dictionary);
        ConsoleInterface consoleInterface = new ConsoleInterface(dictionaryManager);
        consoleInterface.run();
    }
}