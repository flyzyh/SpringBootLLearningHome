package com.zyh.springbtest.test1.vo;

import java.io.Serializable;

/**
 *
 */
public class NodeTest implements Serializable {
    String name;

    String age;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getAge () {
        return age;
    }

    public void setAge (String age) {
        this.age = age;
    }

    public NodeTest () {
        super();
    }

    public NodeTest (String name, String age) {
        this.name = name;
        this.age = age;
    }
}
