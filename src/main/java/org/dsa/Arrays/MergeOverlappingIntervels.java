package org.dsa.Arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Given a collection of intervals, merge all overlapping intervals.

//Hint: First, try to figure out cases for two intervals to be merged.
//Sort the intervals in an appropriate manner using a custom comparator.

public class MergeOverlappingIntervels {

    /**
     * Definition for an interval.
     * public class Interval {
     *     int start;
     *     int end;
     *     Interval() { start = 0; end = 0; }
     *     Interval(int s, int e) { start = s; end = e; }
     * }
     */
    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2,100));
        intervals.add(new Interval(1,8));
        intervals.add(new Interval(4,7));
        intervals.add(new Interval(5,6));
        intervals.add(new Interval(6,6));
        intervals.add(new Interval(66,94));
        intervals.add(new Interval(84,99));
        intervals.add(new Interval(95,99));
        intervals.add(new Interval(22,100));
        Collections.sort(intervals, Comparator.comparingInt(i -> i.start));




        for(int i = 1 ;i<intervals.size();){
           Interval current = intervals.get(i);
           Interval previous = intervals.get(i-1);
           if(previous.end >= current.start){
               intervals.set(i-1,new Interval(Math.min(previous.start, current.start), Math.max(current.end, previous.end)));
               intervals.remove(i);
           }else{
               i++;
           }
        }

        intervals.forEach(i->{
            System.out.println(i.start+" "+i.end);

        });

    }



}


