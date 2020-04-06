package ladder.domain.ladder;

import ladder.domain.Gamers;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.maker.MakeLadderStrategy;

import java.util.List;

public class Ladder {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Ladder failed. " +
            "gamers and ladderMaker.makeBarLines() must have same size entries: gamers=%s, lines=%s";

    private final Gamers gamers;
    private final List<Line> lines;

    private Ladder(Gamers gamers, List<Line> lines) {
        this.gamers = gamers;
        this.lines = lines;
    }

    public static Ladder of(Gamers gamers, MakeLadderStrategy ladderMaker) {
        List<Line> lines = ladderMaker.makeBarLines();
        if (lines.get(0).getBars().size() != gamers.getGamerList().size()) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, gamers, lines));
        }

        return new Ladder(gamers, lines);
    }


    public List<Line> getLines() {
        return lines;
    }

    public LadderResultDto getResult() {
        return null;
    }
}
