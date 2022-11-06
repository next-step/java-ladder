package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Ladder {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_UNDER_ONE_VALUE = "두 항목 이상 필요합니다.";
    private final static String ERROR_ZERO_OR_NEGATIVE_VALUE = "0보다 큰 값만 입력 가능합니다.";
    private final static String ERROR_NOT_EQUAL_PARTICIPANTS_NUMBER = "참여자 수와 동일한 수의 결과가 필요합니다.";
    private final static String SEPARATOR = ",";

    private final List<Name> participants;
    private final List<Line> lines = new ArrayList<>();
    private final List<Prize> prizes;

    public Ladder(final String participants, final int height, final String prizes) {
        validate(participants);
        this.participants = splitParticipants(participants);

        validateHeight(height);
        setLines(height, this.participants.size());

        validate(prizes);
        this.prizes = splitPrizes(prizes);
    }

    private void validate(final String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private List<Name> splitParticipants(final String value) {
        List<Name> result = Arrays.stream(value.split(SEPARATOR))
            .map(Name::new)
            .collect(Collectors.toList());

        if (result.size() <= 1) {
            throw new IllegalArgumentException(ERROR_UNDER_ONE_VALUE);
        }

        return result;
    }

    private void validateHeight(final int input) {
        if (input <= 0) {
            throw new IllegalArgumentException(ERROR_ZERO_OR_NEGATIVE_VALUE);
        }
    }

    private void setLines(final int row, final int column) {
        IntStream.range(0, row)
            .mapToObj(i -> new Line(i, column))
            .forEach(lines::add);
    }

    private List<Prize> splitPrizes(final String value) {
        String[] splited = value.split(SEPARATOR);
        if (splited.length <= 1) {
            throw new IllegalArgumentException(ERROR_UNDER_ONE_VALUE);
        }

        if (splited.length != participants.size()) {
            throw new IllegalArgumentException(ERROR_NOT_EQUAL_PARTICIPANTS_NUMBER);
        }

        return IntStream.range(0, splited.length)
            .mapToObj(i -> new Prize(splited[i], i))
            .collect(Collectors.toList());
    }

    public void draw(final LinkStrategy strategy) {
        lines.forEach(line -> line.link(strategy));
    }

    public List<Name> getParticipants() {
        return participants;
    }

    public List<Line> getLines() {
        return lines;
    }
}
