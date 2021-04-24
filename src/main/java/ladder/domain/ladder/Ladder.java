package ladder.domain.ladder;

import ladder.domain.participant.Participant;
import ladder.domain.participant.Participants;
import ladder.strategy.LineGenerateStrategy;
import ladder.exception.LineListNullPointerException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Ladder {

    private static final int ZERO = 0;

    private final List<Line> lines;

    public static final Ladder from(final Participants participants, final LadderHeight ladderHeight, final LineGenerateStrategy strategy) {
        return from(IntStream.range(ZERO, ladderHeight.height())
                .mapToObj(i -> Line.of(participants, strategy))
                .collect(Collectors.toList())
        );
    }

    public static final Ladder from(final List<Line> lines) {
        return new Ladder(lines);
    }

    private Ladder(final List<Line> lines) {
        validateNull(lines);
        this.lines = lines;
    }

    private final void validateNull(final List<Line> lines) {
        if (Objects.isNull(lines)) {
            throw new LineListNullPointerException();
        }
    }

    public final Stream<Line> stream() {
        return lines.stream();
    }

    public final LadderResultBoard run(final Participants participants, final LadderResults ladderResults) {
        Map<Participant, String> resultMap = new HashMap<>();
        IntStream.range(ZERO, participants.countOfParticipants())
                .forEach(index -> {
                    final int now = move(index);
                    Participant participant = participants.findByIndex(index);
                    String result = ladderResults.findByIndex(now);
                    resultMap.put(participant, result);
                });
        return LadderResultBoard.of(resultMap);
    }

    private final int move(final int index) {
        int now = index;
        for (int i = ZERO; i < lines.size(); i++) {
            now = lines.get(i).move(now);
        }
        return now;
    }

}
