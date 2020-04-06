package ladder.domain.ladder;

import ladder.domain.Gamers;
import ladder.domain.dto.LadderResultDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Ladder failed. height must be at least %d: height=%d";
    private static final int MINIMUM_HEIGHT = 1;

    private final List<Line> lines;
    private final Gamers gamers;

    private Ladder(List<Line> lines, Gamers gamers) {
        this.lines = lines;
        this.gamers = gamers;
    }

    public static Ladder of(int height, Gamers gamers) {
        return Optional.of(height)
                .filter(h -> h >= MINIMUM_HEIGHT)
                .map(h -> makeLadder(h, gamers))
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format(INSTANTIATE_ERROR_FORMAT, MINIMUM_HEIGHT, height)));
    }

    private static Ladder makeLadder(int height, Gamers gamers) {
        int lineSize = gamers.getGamerList().size() - 1;
        return new Ladder(Stream.iterate(
                LineMaker.makeLine(lineSize), line -> LineMaker.makeLine(lineSize))
                .limit(height)
                .collect(Collectors.toList()), gamers);
    }

    public List<Line> getLines() {
        return lines;
    }

    public LadderResultDto getResult() {
        return null;
    }
}
