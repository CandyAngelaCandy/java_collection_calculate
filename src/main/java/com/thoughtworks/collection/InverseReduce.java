package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {
    }

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {

        List<Integer> divideList = new ArrayList<>();
        int currentDivideNum = number - 2;

        while (currentDivideNum >= 0) {
            divideList.add(currentDivideNum);
            currentDivideNum -= 2;
        }

        return divideList;

    }
}
