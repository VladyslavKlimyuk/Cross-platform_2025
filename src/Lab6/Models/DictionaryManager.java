package Lab6.Models;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class DictionaryManager {
    private Dictionary dictionary;

    public DictionaryManager() {}

    public DictionaryManager(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DictionaryManager that = (DictionaryManager) o;
        return Objects.equals(dictionary, that.dictionary);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dictionary);
    }

    public void addWord(String englishWord, String ukrainianTranslations) {
        List<String> translations = Arrays.asList(ukrainianTranslations.split(",")).stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        dictionary.addWord(englishWord.trim().toLowerCase(), translations);
    }

    public void removeWord(String englishWord) {
        dictionary.removeWord(englishWord.trim().toLowerCase());
    }

    public void addTranslation(String englishWord, String ukrainianTranslation) {
        dictionary.addTranslation(englishWord.trim().toLowerCase(),
                ukrainianTranslation.trim().toLowerCase());
    }

    public void removeTranslation(String englishWord, String ukrainianTranslation) {
        dictionary.removeTranslation(englishWord.trim().toLowerCase(),
                ukrainianTranslation.trim().toLowerCase());
    }

    public void replaceTranslation(String englishWord, String oldUkrainianTranslation,
                                   String newUkrainianTranslation) {
        dictionary.replaceTranslation(englishWord.trim().toLowerCase(),
                oldUkrainianTranslation.trim().toLowerCase(),
                newUkrainianTranslation.trim().toLowerCase());
    }

    public List<String> getTranslations(String englishWord) {
        return dictionary.getTranslations(englishWord.trim().toLowerCase());
    }

    public void replaceWord(String oldEnglishWord, String newEnglishWord, String newUkrainianTranslations) {
        List<String> translations = Arrays.asList(newUkrainianTranslations.split(",")).stream()
                .map(String::trim)
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        dictionary.replaceWord(oldEnglishWord.trim().toLowerCase(),
                newEnglishWord.trim().toLowerCase(), translations);
    }

    public boolean checkWordExists(String englishWord) {
        return dictionary.containsWord(englishWord.trim().toLowerCase());
    }

    public List<Map.Entry<String, Integer>> getTopPopularWords(int limit) {
        return dictionary.getWordFrequencies().entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String, Integer>> getTopUnpopularWords(int limit) {
        return dictionary.getWordFrequencies().entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .limit(limit)
                .collect(Collectors.toList());
    }
}