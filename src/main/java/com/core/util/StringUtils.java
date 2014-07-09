/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 类StringUtils.java的实现描述：TODO 类实现描述
 * 
 * @author yuci.wyc 2014年7月9日 下午2:20:38
 */
public class StringUtils {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        String[] sts = list2array(list);
        array2list(sts);

    }

    @SuppressWarnings("unchecked")
    public static <T> T[] list2array(List<T> list) {
        T[] strings = (T[]) new String[list.size()];
        list.toArray(strings);
        for (T t : strings) {
            System.out.println(t);
        }
        return strings;
    }

    public static void array2list(String[] args) {
        List<String> list = Arrays.asList(args);
        for (String s : list) {
            System.out.println(s);
        }
    }

}
