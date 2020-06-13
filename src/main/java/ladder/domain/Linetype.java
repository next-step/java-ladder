package ladder.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public enum Linetype {

    VERTICAL("|"),
    BLANK(" "),
    HORIZONTAL("-");

    private String line;
    private static final int MIN_LINE_LENGTH = 3;

    Linetype(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

    public String getLine(int participantCount) {
        if (getLine().equals(Linetype.VERTICAL.getLine())) {
            return getLine();
        }

        int lineLength = participantCount < MIN_LINE_LENGTH ? MIN_LINE_LENGTH : participantCount;

        return IntStream.rangeClosed(0, lineLength)
                .mapToObj(operand -> getLine())
                .collect(Collectors.joining());
    }
}
