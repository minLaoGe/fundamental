package com.minfengyu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private final byte[] a=new byte[23];
    private Integer age=0;
    private String name="sdf";


}
