package net.chandol.support;

import java.util.function.Supplier;

public class FluentUtil {
    public static boolean not(boolean condition) {
        return !condition;
    }

    public static void validate(boolean condition, Supplier<? extends RuntimeException> e) {
        if (condition) {
            throw e.get();
        }
    }
}
