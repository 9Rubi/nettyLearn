package com.nine.netty.test;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

/**
 * @author : Rubi
 * @version : 2018-11-08 8:52
 */
public class Asd {

    private List<String> strList;

    private List<Integer> intList;

    @Before
    public void init() {

        strList = Arrays.asList(new String[]{"A", "S", "D", "F", "X", "C", "Y", "H", "", null});
        Object object = new Object();
        intList = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 6, 2, 3});
    }

    /**
     * 迭代  forEach
     */
    @Test
    public void testForEach() {
        strList.forEach(System.out::println);
        strList.stream().forEach(System.out::println);
        System.out.println("============");
        strList.stream().forEach(e -> System.out.print(e));
        System.out.println("============");
        strList.forEach(System.out::print);
    }


    /**
     * <p>
     * </p>
     *
     * @param <R> 转换后的泛型
     * @return 转换泛型后的 List
     */
//    @SuppressWarnings("unchecked")
//    public <T, R> List<R> convert(List<T> before, Function<? super T, ? extends R> type) {
//        List<R> after = before.stream().collect();
//        return after;
//    }

    /**
     * 迭代  forEach
     */
    @Test
    public void aaa() {
        List<String> strings = new LinkedList<>();
        for (int i = 0; i < 1000000 ; i++) {
            strings.add(String.valueOf(i));
        }
        List<Integer> integers1 = new LinkedList<>();
        List<Integer> integers =new LinkedList<>();


        System.out.println("========================================");
        long L3= new Date().getTime();
        strings.forEach(i->integers.add(Integer.parseInt(i)));
        long L4= new Date().getTime();
        System.out.println("Lambda ok   :"+(L4-L3));
        System.out.println("========================================");


//        System.out.println("========================================");
//        long L1= new Date().getTime();
//
//        for (String string : strings) {
//            integers1.add(Integer.parseInt(string));
//        }
//        long L2= new Date().getTime();
//
//        System.out.println("Normal ok   :"+(L2-L1));
//        System.out.println("========================================");






   }
}
