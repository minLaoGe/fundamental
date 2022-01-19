package com.minfengyu.day7;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class OrderDelay implements Delayed {
    private String orderId;
    private Long timeout;

    public OrderDelay(String orderId, Long timeout) {
        this.orderId = orderId;
        this.timeout = timeout+System.nanoTime();
    }

    /**
     * 需要实现的接口，获得延迟时间   用过期时间-当前时间
     * @param unit
     * @return
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout-System.nanoTime(),TimeUnit.NANOSECONDS);
    }
    void  print(){
        System.out.println("订单要删除了");
    }
    /**
     * 用于延迟队列内部比较排序   当前时间的延迟时间 - 比较对象的延迟时间
     * @param o
     * @return
     */
    @Override
    public int compareTo(Delayed o) {
        if (o==this){
            return 0;
        }
        OrderDelay t = (OrderDelay) o;

        long d = getDelay(TimeUnit.NANOSECONDS) - t.getDelay(TimeUnit.NANOSECONDS);
        return (d==0)? 0:((d<0)?(-1): 1);
    }
}
