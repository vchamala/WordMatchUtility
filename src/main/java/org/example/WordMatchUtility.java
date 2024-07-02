package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordMatchUtility {

    public static void main(String[] args) throws IOException {
        WordMatchUtility util = new WordMatchUtility();

        /* 1. Load all the predefined words. */
        String predefinedWordsFile = "../../../resources/predefinedWords.txt"; // can be replaced by your local file for tests.
        Set<String> predefinedWords = util.readPredefinedWords(predefinedWordsFile);

        /* 2. Go through each line of the file and find the matches and pretty prints the matched word and the occurrence count. */
        String inputFile = "../../../resources/inputFile.txt"; // can be replaced by your local file for tests.
        System.out.println("Predefined word     Exact Match Count");
        for (Map.Entry<String, Integer> entry: util.findMatches(inputFile, predefinedWords).entrySet()) {
            // Inclining that the largest number will be of 20 characters.
            System.out.printf("%-20s %d%n", entry.getKey(), entry.getValue());
        }

        System.out.println("Predefined word     Exact Match and Substring Match Count");
        for (Map.Entry<String, Integer> entry: util.findMatchesIncludingSubStrings(inputFile, predefinedWords).entrySet()) {
            // Inclining that the largest number will be of 20 characters.
            System.out.printf("%-20s %d%n", entry.getKey(), entry.getValue());
        }
    }

    /*
    The method reads the predetermined words provided in predterminedWords.txt input file.
    */
    private Set<String> readPredefinedWords(String predefinedWordsFileName) throws IOException {
        Set<String> predefinedWords = new HashSet<>();
        try (BufferedReader br
                = new BufferedReader(new FileReader(predefinedWordsFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                predefinedWords.add(line.trim()); // trim any boundary spaces present in the lines
            }
        } catch (IOException ex) {
            System.err.printf("IOException when processing predefined words: %s%n", ex.getMessage());
            throw ex;
        }
        return predefinedWords;
    }

    /*
    The method finds the exact match of the words present in input file against the predetermined words.
     */
    private Map<String, Integer> findMatches(String inputFileName, Set<String> predefinedWords) throws IOException {
        Map<String, Integer> wordOccurencesMap = new HashMap<>();
        try (BufferedReader br
                = new BufferedReader(new FileReader(inputFileName))) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] lineWords = st.split(" ");
                for (String lineWord: lineWords) {
                    if (predefinedWords.contains(lineWord)) {
                        wordOccurencesMap.put(lineWord, wordOccurencesMap.getOrDefault(lineWord, 0) + 1);
                    }
                }
            }
            return wordOccurencesMap;
        } catch (IOException ex) {
            System.err.printf("IOException when finding matches: %s%n", ex.getMessage());
            throw ex;
        }
    }

    /*
    The method finds the exact matches as well as the substring matches of the input file's words with predetermined words.

    Due to the provided input file could be 20mb (larger file),
    1. we are reading the predetermined words as step1.
    2. we look through each of the word in every line of the file to check if it is a match or a substring match in predetermined words.
     */
    private Map<String, Integer> findMatchesIncludingSubStrings(String inputFileName, Set<String> predefinedWords) throws IOException {
        Map<String, Integer> wordOccurencesMap = new HashMap<>();
        try (BufferedReader br
                     = new BufferedReader(new FileReader(inputFileName))) {
            String st;
            while ((st = br.readLine()) != null) {
                String[] lineWords = st.split(" ");
                for (String lineWord: lineWords) {
                    for (String predefinedWord: predefinedWords) {
                        if (lineWord.contains(predefinedWord)) {
                            wordOccurencesMap.put(predefinedWord, wordOccurencesMap.getOrDefault(predefinedWord, 0) + 1);
                        }
                    }
                }
            }
            return wordOccurencesMap;
        } catch (IOException ex) {
            System.err.printf("IOException when processing predefined words: %s%n", ex.getMessage());
            throw ex;
        } catch (Exception e) {
            System.err.printf("Exception when processing predefined words: %s%n", e.getMessage());
            throw e;
        }
    }

}
