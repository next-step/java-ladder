package ladder.domain.ladder;

import ladder.domain.Gamer;
import ladder.domain.Gamers;
import ladder.domain.LadderResult;
import ladder.domain.dto.BarMatrixDto;
import ladder.domain.dto.LadderResultDto;
import ladder.domain.ladder.maker.MakeLadderStrategy;
import ladder.domain.ladder.maker.RandomLadderMaker;

import java.util.Map;
import java.util.stream.Collectors;

public class Ladder {
    private static final String INSTANTIATE_ERROR_FORMAT = "Create Ladder failed. " +
            "bars count must be gamers.size() - 1: gamerCount=%d, barsCount=%d";

    private final Gamers gamers;
    private final Lines lines;

    private Ladder(Gamers gamers, Lines lines) {
        this.gamers = gamers;
        this.lines = lines;
    }

    public static Ladder of(Gamers gamers, MakeLadderStrategy ladderMaker) {
        Lines lines = Lines.of(ladderMaker);
        int barsCount = lines.width();
        int gamerCount = gamers.size();
        if (barsCount != gamerCount - 1) {
            throw new IllegalArgumentException(String.format(INSTANTIATE_ERROR_FORMAT, gamerCount, barsCount));
        }

        return new Ladder(gamers, lines);
    }

    public static Ladder ofRandom(Gamers gamers, int height) {
        return of(gamers, RandomLadderMaker.of(gamers.size() - 1, height));
    }

    public BarMatrixDto getBarMatrix() {
        return new BarMatrixDto(lines.getRawMatrix());
    }

    public LadderResultDto getResult(LadderResult ladderResult) {
        Map<String, String> resultMap = gamers.getGamers()
                .stream()
                .collect(Collectors.toMap(Gamer::getName, gamer -> getResult(ladderResult, gamer)));
        return new LadderResultDto(resultMap);
    }

    private String getResult(LadderResult ladderResult, Gamer gamer) {
        LadderNumber ladderNumber = lines.getResultNumber(gamer);
        return ladderResult.getResults().get(ladderNumber.getNumber());
    }
}
