package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Filter {

    List<Integer> array;

    public Filter(List<Integer> array) {
        this.array = array;
    }

    public List<Integer> filterEven() {
        List<Integer> evenList = array.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        return evenList;
    }

    public List<Integer> filterMultipleOfThree() {

        List<Integer> multipleOfThreeList = array.stream()
                .filter(num -> num % 3 == 0)
                .collect(Collectors.toList());

        return multipleOfThreeList;
    }

    public List<Integer> getCommonElements(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> commonElements = new ArrayList<>(firstList);
        commonElements.retainAll(secondList);
        return commonElements;
    }

    public List<Integer> getDifferentElements() {
        List<Integer> differentElements = array.stream()
                .distinct()
                .collect(Collectors.toList());

        return differentElements;
    }
}