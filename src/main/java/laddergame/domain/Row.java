package laddergame.domain;

import laddergame.exception.ErrorCode;
import laddergame.exception.LadderGameException;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Row {
    private final List<State> states;

    public Row(List<State> states) {
        validateContinuous(states);
        this.states = states;
    }

    private void validateContinuous(List<State> states) {
        for (int i = 1; i < states.size(); i++) {
            comparePreviousState(states.get(i - 1), states.get(i));
        }
    }

    private void comparePreviousState(State previous, State now) {
        if (previous.isExist() && now.isExist()) {
            throw new LadderGameException(ErrorCode.LADDER_LINE_EXIT_CONTINOUSLY);
        }
    }

    public Row(Boolean... inputs) {
        this(Arrays.stream(inputs)
                .map(State::valueOf)
                .collect(Collectors.toList()));
    }

    public List<State> getStates() {
        return this.states;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Row row = (Row) o;
        return Objects.equals(states, row.states);
    }

    @Override
    public int hashCode() {
        return Objects.hash(states);
    }

    @Override
    public String toString() {
        return "Row{" +
                "states=" + states +
                '}';
    }
}
