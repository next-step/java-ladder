package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import ladder.strategy.LinkStrategy;

public class Ladder {

    private final static String ERROR_EMPTY_VALUE = "입력 값이 누락되었습니다.";

    private final Lines lines;

    public Ladder(final int totalParticipantsNumber, final int height) {
        this.lines = new Lines(height, totalParticipantsNumber);
    }

    public void draw(final LinkStrategy strategy) {
        validateStrategy(strategy);
        lines.draw(strategy);
    }

    private void validateStrategy(final LinkStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    public void play(final Participants participants) {
        validateParticipants(participants);

        List<Point> result = new ArrayList<>();
        IntStream.range(0, participants.size())
            .mapToObj(i -> lines.move(new Point(i)))
            .forEach(result::add);
        participants.move(result);
    }

    private void validateParticipants(final Participants participants) {
        if (participants == null) {
            throw new IllegalArgumentException(ERROR_EMPTY_VALUE);
        }
    }

    public List<Line> getLines() {
        return lines.getValue();
    }
}
