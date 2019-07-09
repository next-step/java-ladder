package com.jaeyeonling.ladder.view.format;

@FunctionalInterface
public interface Formatter<T> {

    String format(final T raw);
}
