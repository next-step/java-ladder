package ladder.domain;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Floor {
    private static final int MIN_PERSON_COUNT = 1;
    private static final String EXCEP_INVLAID_COUNT_PERSON = "입력된 사람 수가 유효하지 않습니다. (최소 값 : %d)";
    private final List<Boolean> lines;

    public Floor(final int countOfParticipants) {
        this(countOfParticipants, GenerateLineMethod.create());
    }

    public Floor(final int countOfParticipants, final Supplier supplier) {
        validate(countOfParticipants);
        lines = generateLines(toLineCount(countOfParticipants), supplier);
    }

    private void validate(final int countOfParticipants) {
        if (countOfParticipants < MIN_PERSON_COUNT) {
            throw new IllegalArgumentException(String.format(EXCEP_INVLAID_COUNT_PERSON, MIN_PERSON_COUNT));
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }

    private int toLineCount(final int countOfParticipants) {
        return countOfParticipants - 1;
    }

    private List<Boolean> generateLines(final int countOfParticipants, Supplier<Boolean> supplier) {
        return Stream.generate(supplier::get)
                .limit(countOfParticipants)
                .collect(Collectors.toList());
    }
}
