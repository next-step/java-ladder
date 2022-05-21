package nextstep.ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Participants {

    private static final String PARTICIPANTS_NULL_OR_EMPTY_ERROR_MESSAGE = "입력된 참가자들이 없습니다.";

    private final List<Participant> values;

    public Participants(List<Participant> values) {
        this.values = values;
    }

    public Participants(String[] names) {
        this(convertToList(names));
    }

    private static void validateNullAndEmpty(String[] names) {
        if (names == null || names.length == 0) {
            throw new IllegalArgumentException(PARTICIPANTS_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    private static List<Participant> convertToList(String[] names) {
        validateNullAndEmpty(names);

        AtomicInteger index = new AtomicInteger();

        return Arrays.stream(names)
                .map(name -> new Participant(index.getAndIncrement(), name))
                .collect(Collectors.toList());
    }

    public int findPosition(String name) {
        return values.stream()
                .filter(value -> name.equals(value.toString()))
                .findFirst()
                .get()
                .getIndex();
    }


    public List<Participant> getValues() {
        return values;
    }
}
