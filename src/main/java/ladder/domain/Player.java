package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        if(name.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException();

        this.name = name;
    }

    @Override
    public String toString() {
        String str = IntStream.range(0, MAX_NAME_LENGTH - this.name.length())
                .mapToObj(i -> "  ")
                .collect(Collectors.joining("", this.name, " "));

        return str;
    }
}
