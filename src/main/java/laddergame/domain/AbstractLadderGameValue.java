package laddergame.domain;

import laddergame.utils.AbstractLadderGameValueValidator;

import java.util.Objects;

abstract public class AbstractLadderGameValue {

    public static final int MAX_LENGTH = 5;

    private final String value;

    public AbstractLadderGameValue(String value) {
        AbstractLadderGameValueValidator.validate(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractLadderGameValue that = (AbstractLadderGameValue) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }

}
