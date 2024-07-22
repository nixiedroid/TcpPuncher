package com.nixiedroid.binder;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Context {
    private static ConcurrentMap<String, Integer> nameToId = new ConcurrentHashMap<>();

}
