package laddergame.domain.ladder;

import laddergame.domain.HeightOfLadder;
import laddergame.domain.PlayersAndWinningContents;
import laddergame.domain.ResultOfLadder;
import laddergame.domain.WinningContent;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static laddergame.exception.ExceptionMessage.WRONG_PLAYERS_AND_WINNING_CONTENTS_FOR_LADDER;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder valueOf(List<Line> lines) {
        return new Ladder(lines);
    }

    public static Ladder newLadder(HeightOfLadder heightOfLadder, PlayersAndWinningContents playersAndWinningContents, LinkStrategy linkStrategy) {
        List<Line> generatedLines = Stream.generate(() -> Line.newLine(playersAndWinningContents.numberOfLinks(), linkStrategy))
                .limit(heightOfLadder.height())
                .collect(Collectors.toList());

        return new Ladder(generatedLines);
    }

    public static Ladder newLadder(Line... lines) {
        return new Ladder(List.of(lines));
    }

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public ResultOfLadder resultOfLadder(PlayersAndWinningContents playersAndWinningContents) {
        if (!isValidPlayersAndWinningContents(playersAndWinningContents)) {
            throw new IllegalArgumentException(WRONG_PLAYERS_AND_WINNING_CONTENTS_FOR_LADDER.message());
        }

        List<WinningContent> results = IntStream.range(0, playersAndWinningContents.numberOfPlayers())
                .mapToObj(playerIndex -> playersAndWinningContents.findWinningContentByIndex(indexOfWinningContentOfPlayer(playerIndex)))
                .collect(Collectors.toList());

        return ResultOfLadder.valueOf(results);
    }

    private boolean isValidPlayersAndWinningContents(PlayersAndWinningContents playersAndWinningContents) {
        long numberOfInvalidCase = lines.stream()
                .filter(line -> line.numberOfLinks() != playersAndWinningContents.numberOfLinks())
                .count();
        return numberOfInvalidCase == 0;
    }

    private int indexOfWinningContentOfPlayer(int playerIndex) {
        return IntStream.range(0, lines.size())
                .reduce(playerIndex, (indexOfFrame, indexOfLine) -> lines.get(indexOfLine)
                        .nextIndexOfFrame(indexOfFrame));
    }

}
