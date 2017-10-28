package com.designMode.singleton;

/**
 * Created by LRD on 2017/10/26.
 */
public class Singleton {

    /**
     * 饿加载
     */
    private static Singleton instance = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }


/**
 * 双重检查加锁
 */
//    private volatile static Singleton instance = null;
//    private Singleton(){}
//    public static Singleton getInstance() {
//        if (instance == null) {
//            synchronized(Singleton.class){
//                instance = new Singleton();
//            }
//        }
//        return instance;
//    }

    /**
     * 懒加载
     */
//    private static Singleton instance = null;
//    private Singleton(){}
//    public static Singleton getInstance() {
//        if (instance == null) {                  //line 1
//            instance = new Singleton();          //line 2
//        }
//        return instance;
//    }


    /**
     * 同步锁
     */
//    private static Singleton instance = null;
//    private Singleton(){}
//    public synchronized static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
    public void getName() {
        System.out.println("my name is l-lo");
    }
}
