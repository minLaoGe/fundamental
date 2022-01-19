package com.minfengyu.Day8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Niochannel {
    private String c;

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class E{
     Poller[] pollers=new Poller[23];
     public Poller getPoller9(){
        return pollers[2];
     }
}