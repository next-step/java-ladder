package nextstep.ladder.model;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String SPACE = " ";
    private final String name;

    public Name(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 1자 ~ 5자 입니다");
        }
    }

    @Override
    public String toString() {
        return IntStream.range(0, MAX_LENGTH - name.length())
            .mapToObj(i -> SPACE)
            .collect(Collectors.joining("", name, ""));
    }
}
