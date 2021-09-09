package ladder.domain;

import ladder.exception.InvalidParticipantsCountException;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LadderFloor {
    private static final int MIN_PERSON_COUNT = 1;
    private final List<Boolean> lines;

    public LadderFloor(final int countOfParticipants, final LadderLineGenerator ladderLineGenerator) {
        validate(countOfParticipants);
        lines = generateLines(toLineCount(countOfParticipants), ladderLineGenerator);
    }

    private void validate(final int countOfParticipants) {
        if (countOfParticipants < MIN_PERSON_COUNT) {
            throw new InvalidParticipantsCountException(countOfParticipants, MIN_PERSON_COUNT);
        }
    }

    public List<Boolean> getLines() {
        return lines;
    }

    private int toLineCount(final int countOfParticipants) {
        return countOfParticipants - 1;
    }

    private List<Boolean> generateLines(final int countOfParticipants, final LadderLineGenerator ladderLineGenerator) {
        return ladderLineGenerator.generate(countOfParticipants);
    }
}
