package com.designMode.singleton;

/**
 * Created by LRD on 2017/10/26.
 */
public enum SingletonEnum {
    INSTANCE;
    public static SingletonEnum test()
    {
        System.out.println("The Test!");
        return null;
    }
}
