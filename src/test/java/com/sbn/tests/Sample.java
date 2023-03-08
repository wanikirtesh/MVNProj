package com.sbn.tests;

import org.testng.annotations.Test;

import java.util.*;

public class Sample {
    public static void main(String[] args) {

        String[] servers = {"102","103","104","105"};
        List<List<Integer>> result = new ArrayList<>();
        for(int i=0;i<4;i++){
            result.add(new ArrayList<Integer>());
        }
        for(int i= 20001;i<=20200;i++){
            int j = i%(servers.length);
            System.out.println(i + " : " +servers[j]);
            result.get(j).add(i);

        }
        System.out.println();
    }

}
