package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Linetype {

    VERTICAL("|"),
    BLANK(" "),
    HORIZONTAL("-");

    private String line;

    Linetype(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }
}
