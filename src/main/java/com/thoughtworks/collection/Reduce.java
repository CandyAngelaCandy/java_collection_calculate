package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        int maxNum = this.arrayList.stream()
                .max(Comparator.comparingInt(num -> num))
                .get();
        return maxNum;
    }

    public double getMinimum() {
        int minNum = this.arrayList.stream()
                .min(Comparator.comparingInt(num -> num))
                .get();
        return minNum;
    }

    public double getAverage() {
        IntSummaryStatistics stats = this.arrayList.stream()
                .mapToInt(x -> x)
                .summaryStatistics();
        return stats.getAverage();
    }

    public double getOrderedMedian() {

        int mediumIndex = this.arrayList.size() / 2;

        double medimuNum;
        if (this.arrayList.size() % 2 == 0) {
            medimuNum = (double) (this.arrayList.get(mediumIndex - 1) +
                    this.arrayList.get(mediumIndex)) / 2;
        } else {
            medimuNum = (double) this.arrayList.get(mediumIndex);
        }

        return medimuNum;
    }

    public int getFirstEven() {
        int firstEven = this.arrayList.stream()
                .filter((ele) -> ele % 2 == 0)
                .findFirst()
                .get();
        return firstEven;
    }

    public int getIndexOfFirstEven() {

        List<Integer> evenIndex = IntStream.range(0, this.arrayList.size())
                .filter(i -> this.arrayList.get(i) % 2 == 0)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        return evenIndex.get(0);
    }

    public boolean isEqual(List<Integer> arrayList) {
        if (this.arrayList.size() != arrayList.size()) {
            return false;
        }
        boolean isEqualTwoArray = this.arrayList.stream()
                .allMatch(ele -> arrayList.contains(ele) == true);
        return isEqualTwoArray;
    }

    //实现接口SingleLink，然后再此函数内使用
    public Double getMedianInLinkList(SingleLink singleLink) {

        this.arrayList.stream().forEach(singleLink::addTailPointer);

        double medianInLinkList;
        int lenOfSingleLink = this.arrayList.size();
        int mediumIndex = lenOfSingleLink / 2;
        System.out.println(mediumIndex);

        if (lenOfSingleLink % 2 == 0) {
            medianInLinkList = (double) ((int) singleLink.getNode(mediumIndex) +
                    (int) singleLink.getNode(mediumIndex + 1)) / 2;
        } else {
            medianInLinkList = (double) singleLink.getNode(mediumIndex);
        }

        return medianInLinkList;
    }


    public int getLastOdd() {
        List<Integer> oddList = this.arrayList.stream()
                .filter(ele -> ele % 2 == 1)
                .collect(Collectors.toList());
        return oddList.get(oddList.size() - 1);
    }

    public int getIndexOfLastOdd() {
        List<Integer> oddIndex = IntStream.range(0, this.arrayList.size())
                .filter(i -> this.arrayList.get(i) % 2 == 1)
                .mapToObj(i -> i)
                .collect(Collectors.toList());
        return oddIndex.get(oddIndex.size() - 1);
    }
}
