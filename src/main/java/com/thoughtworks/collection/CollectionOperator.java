package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        int leftBorder = left, rightBorder = right;
        if (left > right) {
            int temp = left;
            leftBorder = right;
            rightBorder = temp;
        }

        List<Integer> listByInterval = IntStream.range(leftBorder, rightBorder + 1)
                .boxed()
                .collect(Collectors.toList());
        if (left > right) {
            listByInterval = listByInterval.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }
        return listByInterval;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        int leftBorder = left, rightBorder = right;
        if (left > right) {
            int temp = left;
            leftBorder = right;
            rightBorder = temp;
        }

        List<Integer> evenListByIntervals = IntStream.range(leftBorder, rightBorder + 1)
                .boxed()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        if (left > right) {
            evenListByIntervals = evenListByIntervals.stream()
                    .sorted(Comparator.reverseOrder())
                    .collect(Collectors.toList());
        }

        return evenListByIntervals;
    }

    public List<Integer> popEvenElments(int[] array) {

        List<Integer> evenEleList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            evenEleList.add(array[i]);
        }

        evenEleList = evenEleList.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());

        return evenEleList;
    }

    public int popLastElment(int[] array) {

        List<Integer> eleList = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());

        Optional<Integer> lastElement = eleList.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst();

        return lastElement.isPresent() ? lastElement.get() : Integer.parseInt(null);
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        List<Integer> firstList = Arrays.stream(firstArray)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(secondArray)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> commonElement = new ArrayList<>(firstList);
        commonElement.retainAll(secondList);

        return commonElement;

    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {

        List<Integer> firstList = new ArrayList<>(Arrays.asList(firstArray));
        List<Integer> unCommonElement = new ArrayList<>(Arrays.asList(secondArray));

        unCommonElement.removeAll(firstList);
        firstList.addAll(unCommonElement);
        return firstList;
    }
}
