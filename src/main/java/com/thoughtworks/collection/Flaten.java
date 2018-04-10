package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        List<Integer> oneDimesionalList = new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {

            oneDimesionalList.addAll(Arrays.asList(array[i]));
        }

       return oneDimesionalList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {

        List<Integer> oneDimesionalList = new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {

            oneDimesionalList.addAll(Arrays.asList(array[i]));
        }

        List<Integer> UnrepeatedOneDimesionalList = oneDimesionalList.stream()
                .distinct()
                .collect(Collectors.toList());

        return  UnrepeatedOneDimesionalList;
    }
}
