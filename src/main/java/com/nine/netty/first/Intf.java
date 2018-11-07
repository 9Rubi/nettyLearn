package com.nine.netty.first;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : Rubi
 * @version : 2018-10-26 9:58
 */
public class Intf<T> {
    private  T t;

    private String a;


    public static void main(String[] args) {
        Map<String,Object> map =new  HashMap<>();
        map.put("a",12123123);
        map.put("d",new Date());
        map.put("c",new Date());
        map.put("b","asdasdasdas");

        System.out.println("==============================");
        System.out.println(map.get("b"));
        System.out.println("==============================");

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
