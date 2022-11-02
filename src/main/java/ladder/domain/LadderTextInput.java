package ladder.domain;

import ladder.exception.InputLengthException;

import java.util.Objects;

public class LadderTextInput {

    private final String text;
    public static final int INPUT_LENGTH_MAX = 5;

    public LadderTextInput(String text) {
        if (text.length() > INPUT_LENGTH_MAX) {
            throw new InputLengthException(INPUT_LENGTH_MAX);
        }
        this.text = text;
    }

    public String text() {
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderTextInput that = (LadderTextInput) o;
        return Objects.equals(text, that.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
