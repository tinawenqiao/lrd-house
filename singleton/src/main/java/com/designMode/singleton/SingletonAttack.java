package com.designMode.singleton;

import java.lang.reflect.Constructor;

/**
 * Created by LRD on 2017/10/26.
 */
public class SingletonAttack {
    public static void main(String[] args) throws Exception {
        Class<?> classType = Singleton.class;
        Constructor<?> c = classType.getDeclaredConstructor(null);
        c.setAccessible(true);
        Singleton s1 = (Singleton) c.newInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2);
    }
}
