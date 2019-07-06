package ladder.domain;

import ladder.domain.generator.BooleanGenerator;
import ladder.domain.generator.RandomBooleanGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderGame {

    private static final BooleanGenerator BOOLEAN_GENERATOR = new RandomBooleanGenerator();
    private GameInfo gameInfo;
    private Lines lines;

    public static LadderGame of(GameInfo gameInfo, int ladderHeight) {
        LadderGame ladderGame = new LadderGame();
        ladderGame.gameInfo = gameInfo;
        ladderGame.lines = Lines.of(createLines(gameInfo.getParticipants().size(), ladderHeight));
        return ladderGame;
    }

    private static List<Line> createLines(int width, int height) {
        return IntStream.range(0, height)
                .mapToObj(currentHeight -> Line.of(width, BOOLEAN_GENERATOR))
                .collect(Collectors.toList());
    }

    public GameInfo getGameInfo() {
        return gameInfo;
    }

    public Lines getLines() {
        return lines;
    }
}
