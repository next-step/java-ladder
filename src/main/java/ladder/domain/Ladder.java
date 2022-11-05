package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Ladder {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";
    private final static String ERROR_UNDER_ONE_VALUE = "두 사람 이상 참여해야 합니다.";
    private final static String ERROR_ZERO_OR_NEGATIVE_VALUE = "0보다 큰 값만 입력 가능합니다.";
    private final static String SEPARATOR = ",";

    private final List<Name> participants;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(final String participants, final int height) {
        validateParticipants(participants);
        this.participants = split(participants);

        validateHeight(height);
        setLines(height, this.participants.size());
    }

    private void validateParticipants(final String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    private List<Name> split(final String value) {
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

    public void draw(final LinkStrategy strategy) {
        lines.forEach(line -> line.link(strategy));
    }

    public List<Line> getLines() {
        return lines;
    }
}
