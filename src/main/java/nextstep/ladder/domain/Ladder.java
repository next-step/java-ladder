package nextstep.ladder.domain;

import nextstep.ladder.exception.LadderException;
import nextstep.ladder.exception.LadderExceptionCode;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final static int MIN_COUNT_OF_LINES = 0;

    private final List<Line> lines;

    public static Ladder init(int countOfLines, Height height) {
        if (countOfLines < MIN_COUNT_OF_LINES) {
            throw new LadderException(LadderExceptionCode.FAIL_LADDER_INITIALIZATION);
        }

        return new Ladder(
                IntStream.range(0, countOfLines)
                        .mapToObj(count -> Line.init(height))
                        .collect(Collectors.toList())
        );
    }

    Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public void create(Height height) {
        lines.stream()
                .reduce(Line.init(height), (prevLine, nextLine) -> {
                    nextLine.createWith(prevLine);
                    return nextLine;
                });
    }

    public List<Line> lines() {
        return lines;
    }

    public void execute(Players players, Height height, List<String> results) {
        players.players()
                .forEach(player -> player.move(lines, height, results));
    }

    public void validateLadder() {
        lines.stream()
                .reduce((prevLine, nextLine) -> {
                    if (prevLine.invalidateWith(nextLine)) {
                        throw new LadderException(LadderExceptionCode.INVALID_LADDER_FORMAT);
                    }
                    return nextLine;
                });
    }

    @Override
    public String toString() {
        return "Ladder{" +
                "lines=" + lines +
                '}';
    }
}
