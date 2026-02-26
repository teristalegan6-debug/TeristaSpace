package com.terista.space.core.fake;

import com.terista.space.core.jnihook.ReflectCore;


public class FakeCore {
    public static void init() {
        ReflectCore.set(android.app.ActivityThread.class);
    }
}
