package com.minfengyu.Day8;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class keyAttachment {
    private PollerEvent pollerEvent;
    private Poller poller;
    private Niochannel niochannel;

    public keyAttachment(Niochannel niochannel) {
        this.niochannel = niochannel;
    }

    public void reset(Poller poller, Niochannel niochannel) {
        this.poller=poller;
        this.niochannel=niochannel;
    }
}
