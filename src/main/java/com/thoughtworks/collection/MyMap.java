package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MyMap {

    List<Integer> array;
    private String[] letters = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> letterList = Arrays.asList(letters);

    public MyMap(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> getTriple() {
        List<Integer> tripleList = this.array.stream()
                .map((ele) -> ele * 3)
                .collect(Collectors.toList());
        return tripleList;
    }

    public List<String> mapLetter() {

        List<String> numMapToLetter = this.array.stream()
                .map((ele) -> {
                    return letters[ele - 1];
                })
                .collect(Collectors.toList());
        return numMapToLetter;
    }

    public List<String> mapLetters() {
        List<String> numMapToLetters = this.array.stream()
                .map((ele) -> {
                    return getNumToLetters(ele);
                })
                .collect(Collectors.toList());

        return numMapToLetters;
    }

    private String getNumToLetters(int ele) {
        //The length of a string is 1
        String lettersOfNum = "";

        if (ele <= 26) {
            lettersOfNum = letters[ele - 1];
            return lettersOfNum;
        }

        int lenOfLetters = ele / (27 * 26) + 1;//length of string

        //The length of a string is 2
        if (lenOfLetters == 1) {
            lettersOfNum = lenOfStringIsTwo(ele);
            return lettersOfNum;
        }

        //The length of a string is greater than 2
        lettersOfNum = lenOfStringIsGraterThanTwo(ele, lettersOfNum, lenOfLetters);
        return lettersOfNum;

    }

    private String lenOfStringIsGraterThanTwo(int ele, String lettersOfNum, int lenOfLetters) {
        while (lenOfLetters != 0) {
            lettersOfNum = lettersOfNum + "z";
            lenOfLetters--;
        }

        if (ele % (27 * 26) == 0) {
            return lettersOfNum;
        }

        lettersOfNum = lettersOfNum + letters[ele % (27 * 26) - 1];
        return lettersOfNum;
    }

    private String lenOfStringIsTwo(int ele) {
        if (ele % 26 == 0) {
            return letters[ele / 26 - 2] + "z";
        }

        int firstLetterIndex = ele / 26 - 1,
                secondLetterIndex = ele % 26 - 1;

        return letters[firstLetterIndex] + letters[secondLetterIndex];
    }

    public List<Integer> sortFromSmall() {

        List<Integer> sortListFromSmall = this.array.stream()
                .sorted()
                .collect(Collectors.toList());

        return sortListFromSmall;
    }

    public List<Integer> sortFromBig() {

        List<Integer> sortListFromBig = this.array.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return sortListFromBig;
    }
}
