package com.company.wages.calculation.system.demo.programmeone;

public class LazySimpleSinglton {

    private static LazySimpleSinglton lazySimpleSinglton;

    private LazySimpleSinglton() {

    }

    public static LazySimpleSinglton getInstance() {
        if (lazySimpleSinglton == null) {
            lazySimpleSinglton = new LazySimpleSinglton();
        }
        return lazySimpleSinglton;
    }
}
