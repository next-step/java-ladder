package ladder.domain.ladder;

import ladder.domain.Gamer;
import ladder.domain.Gamers;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.maker.MakeLadderStrategy;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Ladder failed. " +
            "bars count must be gamers.size() - 1: gamerCount=%d, barsCount=%d";

    private final Gamers gamers;
    private final List<Line> lines;

    private Ladder(Gamers gamers, List<Line> lines) {
        this.gamers = gamers;
        this.lines = lines;
    }

    public static Ladder of(Gamers gamers, MakeLadderStrategy ladderMaker) {
        List<Line> lines = ladderMaker.makeBarLines();
        int barsCount = lines.get(0).size();
        int gamerCount = gamers.getGamerList().size();
        if (barsCount != gamerCount - 1) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, gamerCount, barsCount));
        }

        return new Ladder(gamers, lines);
    }


    public List<Line> getLines() {
        return lines;
    }

    public LadderResultDto getResult(LadderResult ladderResult) {
        Map<String, String> resultMap = gamers.getGamerList()
                .stream()
                .collect(Collectors.toMap(Gamer::getName, gamer -> {
                    LadderNo ladderNo = gamer.getLadderNo();
                    for (Line line : lines) {
                        ladderNo = line.move(ladderNo);
                    }
                    return ladderResult.getResults().get(ladderNo.getLadderNo());
                }));
        return new LadderResultDto(resultMap);
    }
}
