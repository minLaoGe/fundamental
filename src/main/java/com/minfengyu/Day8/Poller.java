package com.minfengyu.Day8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.concurrent.ConcurrentLinkedQueue;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Poller implements Serializable {
    public final Long serialVersionUID = 1L;
    private keyAttachment keyAttachment;
    private Niochannel niochannel;
    private static ConcurrentLinkedQueue<PollerEvent> pollers=new ConcurrentLinkedQueue<>();


    @Override
    public String toString() {
        keyAttachment s = new keyAttachment();
//        System.out.println(s.getClass().getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
        return "Poller{" +
                "serialVersionUID=" + serialVersionUID +
                ", keyAttachment=" + keyAttachment +
                ", niochannel=" + niochannel +
                '}';
    }

    public void regist(Niochannel niochannel){
        this.niochannel=niochannel;
        com.minfengyu.Day8.keyAttachment attache = new keyAttachment(niochannel);

        //有poller 和 channel
        attache.reset(this,niochannel);
        attache.setPoller(this);
        //有 channel 和 keyattchel
        PollerEvent pollerEvent = new PollerEvent(niochannel, attache);
        pollers.offer(pollerEvent);
    }
}
