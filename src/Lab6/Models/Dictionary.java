package Lab6.Models;

import java.util.*;

public class Dictionary {
    private Map<String, List<String>> dictionary = new HashMap<>();
    private Map<String, Integer> wordFrequency = new HashMap<>();

    public Dictionary() {}

    public Dictionary(Map<String, List<String>> dictionary, Map<String, Integer> wordFrequency) {
        this.dictionary = dictionary;
        this.wordFrequency = wordFrequency;
    }

    public Map<String, List<String>> getDictionary() {
        return dictionary;
    }

    public void setDictionary(Map<String, List<String>> dictionary) {
        this.dictionary = dictionary;
    }

    public Map<String, Integer> getWordFrequency() {
        return wordFrequency;
    }

    public void setWordFrequency(Map<String, Integer> wordFrequency) {
        this.wordFrequency = wordFrequency;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dictionary that = (Dictionary) o;
        return Objects.equals(dictionary, that.dictionary) && Objects.equals(wordFrequency, that.wordFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dictionary, wordFrequency);
    }

    public void addWord(String word, List<String> translations) {
        dictionary.put(word.toLowerCase(), new ArrayList<>(translations));
        wordFrequency.put(word.toLowerCase(), 0);
    }

    public void removeWord(String word) {
        dictionary.remove(word.toLowerCase());
        wordFrequency.remove(word.toLowerCase());
    }

    public void addTranslation(String word, String translation) {
        dictionary.computeIfAbsent(word.toLowerCase(), k ->
                new ArrayList<>()).add(translation.toLowerCase());
    }

    public void removeTranslation(String word, String translation) {
        if (dictionary.containsKey(word.toLowerCase())) {
            dictionary.get(word.toLowerCase()).remove(translation.toLowerCase());
        }
    }

    public void replaceTranslation(String word, String oldTranslation, String newTranslation) {
        if (dictionary.containsKey(word.toLowerCase())) {
            List<String> translations = dictionary.get(word.toLowerCase());
            int index = translations.indexOf(oldTranslation.toLowerCase());

            if (index != -1) {
                translations.set(index, newTranslation.toLowerCase());
            }
        }
    }

    public List<String> getTranslations(String word) {
        if (dictionary.containsKey(word.toLowerCase())) {
            wordFrequency.compute(word.toLowerCase(), (k, v) -> (v == null) ? 1 : v + 1);
            return new ArrayList<>(dictionary.get(word.toLowerCase()));
        }

        return null;
    }

    public void replaceWord(String oldWord, String newWord, List<String> newTranslations) {
        if (dictionary.containsKey(oldWord.toLowerCase())) {
            Integer frequency = wordFrequency.get(oldWord.toLowerCase());
            dictionary.remove(oldWord.toLowerCase());
            wordFrequency.remove(oldWord.toLowerCase());
            dictionary.put(newWord.toLowerCase(), new ArrayList<>(newTranslations));
            wordFrequency.put(newWord.toLowerCase(), frequency == null ? 0 : frequency);
        }
    }

    public boolean containsWord(String word) {
        return dictionary.containsKey(word.toLowerCase());
    }

    public Map<String, Integer> getWordFrequencies() {
        return new HashMap<>(wordFrequency);
    }
}