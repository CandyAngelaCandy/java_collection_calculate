package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Comparator;
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
        List<Integer> allEvenNum = arrayList.stream()
                .filter(num ->num%2 == 0)
                .collect(Collectors.toList());

        int mediumIndex = allEvenNum.size()/2;

        double medimuNum;
        if (allEvenNum.size() % 2 == 0) {
            medimuNum = (allEvenNum.get(mediumIndex - 1) +
                    allEvenNum.get(mediumIndex)) / 2;
        } else {
            medimuNum = (double)allEvenNum.get(mediumIndex);
        }

        return medimuNum;
    }

    public double getAverageOfEvenIndex(List<Integer> arrayList) {
        List<Integer> allEvenNum = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        int sumOfEvenIndex = allEvenNum.stream()
                .reduce((sum, ele) -> sum + ele)
                .get();
        double averageOfEvenIndex = sumOfEvenIndex / allEvenNum.size();
        return averageOfEvenIndex;

    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElment) {
        List<Integer> allEvenNum = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        return allEvenNum.contains(specialElment);
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        List<Integer> allEvenNumWioutDuplicate = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .distinct()
                .collect(Collectors.toList());

        return allEvenNumWioutDuplicate;
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> allEvenEle = arrayList.stream()
                .filter(num -> num % 2 == 0)
                .sorted()
                .collect(Collectors.toList());

        List<Integer> allOddEle = arrayList.stream()
                  .filter(num -> num % 2 == 1)
                  .sorted(Comparator.reverseOrder())
                  .collect(Collectors.toList());

        List<Integer> eleSortByEvenAndOdd = new ArrayList<>(allEvenEle);
        eleSortByEvenAndOdd.addAll(allOddEle);
        return  eleSortByEvenAndOdd;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {

        List<List<Integer>> divideGroupList = new ArrayList<>();
        for (int i = 0; i <arrayList.size()-1 ; i+=1) {
            List<Integer> oneGroupList = new ArrayList<>();
            oneGroupList.add(arrayList.get(i));
            oneGroupList.add(arrayList.get(i+1));
            divideGroupList.add(oneGroupList);
        }

        List<Integer> processedList = divideGroupList.stream()
                .map((oneGroupList)->{
                   return (oneGroupList.get(0)+oneGroupList.get(1))*3;
                })
                .collect(Collectors.toList());
        return processedList;
    }
}
