/*
 * Copyright 2014 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.core.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 类ScheduledExecutorServiceTest.java的实现描述：TODO 类实现描述
 * 
 * @author yuci.wyc 2014年7月9日 上午10:04:19
 */
public class ScheduledExecutorServiceTest {

    /**
     * @param args
     */
    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println("begin to do something at :" + sdf.format(new Date()));

        /**
         * schedule(Runnable command, long delay, TimeUnit unit)，schedule方法被用来延迟指定时间后执行某个指定任务。
         */
        // scheduledExecutorService.schedule(new Job(), 1 * 60, TimeUnit.SECONDS);

        /**
         * 创建并执行一个在给定初始延迟后首次启用的定期操作，随后，在每一次执行终止和下一次执行开始之间都存在给定的延迟，如果任务的执行时间超过了廷迟时间（delay），下一个任务则会在
         * （当前任务执行所需时间+delay）后执行。
         */
        // scheduledExecutorService.scheduleWithFixedDelay(new Job(), 1, 2, TimeUnit.SECONDS);

        /**
         * 创建并执行一个在给定初始延迟后首次启用的定期操作，后续操作具有给定的周期；也就是将在 initialDelay 后开始执行，然后在initialDelay+period 后执行，接着在 initialDelay + 2
         * * period 后执行，依此类推。 如果任务的执行时间小于period，将会按上述规律执行。否则，则会按 任务的实际执行时间进行周期执行。
         */
        scheduledExecutorService.scheduleAtFixedRate(new Job(), 1, 2, TimeUnit.SECONDS);

    }
}

class Job implements Runnable {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("do something  at:" + sdf.format(new Date()));

    }

}
