package com.minfengyu.Day8;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ConcurrentLinkedQueue;

@Data
@AllArgsConstructor
public class Poller {
    private keyAttachment keyAttachment;
    private Poller poller;
    private Niochannel niochannel;
    private static ConcurrentLinkedQueue<PollerEvent> pollers=new ConcurrentLinkedQueue<>();


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
