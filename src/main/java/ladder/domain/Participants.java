package ladder.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Participants {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_UNDER_ONE_VALUE = "두 사람 이상 참여해야 합니다.";
    private final static String ERROR_NOT_EQUAL_SIZE = "입력 값 크기가 참여자 수와 동일하지 않습니다.";
    private final static String ERROR_NOT_FOUND = "존재하지 않는 사용자입니다.";
    private final static String SEPARATOR = ",";

    private final List<Participant> value;

    public Participants(final String names) {
        validate(names);
        String[] splited = split(names);
        this.value = IntStream.range(0, splited.length)
            .mapToObj(i -> new Participant(splited[i], i))
            .collect(Collectors.toList());
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private String[] split(final String value) {
        String[] result = value.split(SEPARATOR);

        if (result.length <= 1) {
            throw new IllegalArgumentException(ERROR_UNDER_ONE_VALUE);
        }

        return result;
    }

    public int size() {
        return value.size();
    }

    public void move(List<Integer> positions) {
        if (positions == null || positions.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }

        if (value.size() != positions.size()) {
            throw new IllegalArgumentException(ERROR_NOT_EQUAL_SIZE);
        }

        IntStream.range(0, value.size()).forEach(i -> {
            Participant participant = value.get(i);
            participant.changePosition(positions.get(i));
        });
    }

    public Participant findByName(final String name) {
        return value.stream()
            .filter(participant -> participant.isEqualName(name))
            .findFirst()
            .orElseThrow(() -> new NoSuchElementException(ERROR_NOT_FOUND));
    }

    public List<Participant> getValue() {
        return Collections.unmodifiableList(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Participants)) {
            return false;
        }

        return this.value.equals(((Participants) o).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
