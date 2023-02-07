package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance = null;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            return new ThreadSafeSingleton();
        }
        return instance;
    }
}
