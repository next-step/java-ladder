package com.jaeyeonling.ladder;

@FunctionalInterface
public interface LineGenerator {

    Line generate(final CountOfUsers countOfUsers);
}
