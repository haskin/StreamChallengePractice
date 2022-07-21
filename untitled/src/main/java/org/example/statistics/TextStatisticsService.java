package org.example.statistics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.example.statistics.model.TextStatistics;

// public class TextStatistics {
//     private int wordCount;
//     private String mostCommonWord;
//     private int longestWordLength;
//     private double averageWordLength;
// }

public class TextStatisticsService {
    public TextStatistics getStatistics(String text) {
        // TODO
        // Please use Streams
        String[] words = text.split("\\s");
        int wordCount = (int) Arrays.stream(words).count();
        Map<String, Integer> wordToWordCount = new HashMap<>();
        Arrays.stream(words).forEach(word -> {
            if (!wordToWordCount.containsKey(word)) {
                wordToWordCount.put(word, 1);
            } else {
                int count = wordToWordCount.get(word);
                wordToWordCount.put(word, count + 1);
            }
        });

        String mostCommonWord = wordToWordCount.keySet().stream().reduce((mostCommon, currentWord) -> {
            if (wordToWordCount.get(mostCommon) < wordToWordCount.get(currentWord)) {
                return currentWord;
            } else {
                return mostCommon;
            }
        }).orElse("");

        int longestWordLength = wordToWordCount.keySet().stream().mapToInt(word -> word.length()).max().orElse(0);

        double averageWordLength = wordToWordCount.keySet().stream().mapToInt(word -> word.length()).average()
                .orElse(0);

        // System.out.println(averageWordLength);
        TextStatistics textStatistics = new TextStatistics();
        textStatistics.setAverageWordLength(averageWordLength);
        textStatistics.setLongestWordLength(longestWordLength);
        textStatistics.setMostCommonWord(mostCommonWord);
        textStatistics.setWordCount(wordCount);
        return textStatistics;
    }

    public static void main(String[] args) {
        TextStatistics textStatistics = new TextStatisticsService().getStatistics("Hello Hello world dinosaur");
        return;
    }
}
