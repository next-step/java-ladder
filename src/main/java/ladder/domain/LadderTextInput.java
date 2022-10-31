package ladder.domain;

import ladder.exception.InputLengthException;

import java.util.Objects;

import static ladder.util.LadderConst.*;

public class LadderTextInput {

    private final String text;

    public LadderTextInput(String text) {
        if (text.length() > INPUT_LENGTH_MAX) {
            throw new InputLengthException(INPUT_LENGTH_MAX);
        }
        this.text = text;
    }

    public String text(){
        return this.text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderTextInput result1 = (LadderTextInput) o;
        return Objects.equals(text, result1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
