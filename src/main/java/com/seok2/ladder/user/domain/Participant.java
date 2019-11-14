package com.seok2.ladder.user.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Participant {

    private static final int MAX = 5;
    private static final List<String> BLACKLIST = Arrays.asList("all");

    private final String name;

    private Participant(String name) {
        validate(name);
        this.name = name;
    }

    public static Participant of(String name) {
        return new Participant(name);
    }

    private void validate(String name) {
        if (name.length() > MAX) {
            throw new IllegalArgumentException("참가자 이름은 5글자를 초과하여 지정할 수 없습니다.");
        }
        if (BLACKLIST.contains(name.toLowerCase())) {
            throw new IllegalArgumentException("허용 되지 않은 참가자 이름입니다.");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Participant)) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
