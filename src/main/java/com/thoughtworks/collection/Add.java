package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Add {
    public static void main(String[] args) {
        Add add = new Add();
        System.out.println(add.getSumOfEvens(10,1));
    }

    public int getSumOfEvens(int leftBorder, int rightBorder) {

        int leftMinVal,rightMaxVal;

        if (leftBorder > rightBorder) {
            leftMinVal = rightBorder;
            rightMaxVal = leftBorder;
        } else {
            leftMinVal = leftBorder;
            rightMaxVal = rightBorder;
        }

        List<Integer> numBetweenLeftAndRight = new ArrayList<>();
        for (Integer i = leftMinVal ; i < rightMaxVal + 1; i++) {
            numBetweenLeftAndRight.add(i);
        }

        int sumOfEvens = numBetweenLeftAndRight.stream()
                .filter(e -> e % 2 == 0)
                .reduce((sum, ele) -> sum + ele)
                .get();

        return sumOfEvens;

    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {

        int leftMinVal,rightMaxVal;

        if (leftBorder > rightBorder) {
            leftMinVal = rightBorder;
            rightMaxVal = leftBorder;
        } else {
            leftMinVal = leftBorder;
            rightMaxVal = rightBorder;
        }

        List<Integer> numBetweenLeftAndRight = new ArrayList<>();
        for (Integer i = leftMinVal ; i < rightMaxVal + 1; i++) {
            numBetweenLeftAndRight.add(i);
        }

        int sumOfOdds = numBetweenLeftAndRight.stream()
                .filter(e -> e % 2 == 1)
                .reduce((sum, ele) -> sum + ele)
                .get();

        return sumOfOdds;

    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {

        int sumTripleAndAddTwo = arrayList.stream()
                .map((num) -> {
                    int numOfTripleAndAddTwo = num * 3 + 2;
                    return numOfTripleAndAddTwo;
                })
                .reduce((sum, ele) -> sum + ele)
                .get();

        return sumTripleAndAddTwo;

    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {

        List<Integer> ListOfTripleOfOddAndAddTwo = arrayList.stream()
                .map(num -> {
                    return num % 2 == 0 ? num : num * 3 + 2;
                })
                .collect(Collectors.toList());
        return ListOfTripleOfOddAndAddTwo;

    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {

        int sumOfProcessedOdds = arrayList.stream()
                .filter(num -> num % 2 == 1)
                .map(num -> {
                    return num * 3 + 5;
                })
                .reduce((sum, ele) -> sum + ele)
                .get();
        return sumOfProcessedOdds;

    }

    public double getMedianOfEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        throw new NotImplementedException();
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        throw new NotImplementedException();
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        throw new NotImplementedException();
    }
}
