package laddergame.domain.ladder;

import laddergame.domain.*;
import laddergame.domain.ladder.strategy.LinkStrategy;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static laddergame.exception.ExceptionMessage.WRONG_PLAYERS_AND_WINNING_CONTENTS_FOR_LADDER_MESSAGE;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
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
            throw new IllegalArgumentException(WRONG_PLAYERS_AND_WINNING_CONTENTS_FOR_LADDER_MESSAGE.message());
        }

        Map<Player, WinningContent> results = new HashMap<>();
        IntStream.range(0, playersAndWinningContents.numberOfPlayers())
                .forEach(playerIndex -> results.put(playersAndWinningContents.findPlayerByIndex(playerIndex), playersAndWinningContents.findWinningContentByIndex(indexOfWinningContentOfPlayer(playerIndex))));

        return new ResultOfLadder(results);
    }

    private boolean isValidPlayersAndWinningContents(PlayersAndWinningContents playersAndWinningContents) {
        long numberOfInvalidCase = lines.stream()
                .filter(line -> line.numberOfLinks() != playersAndWinningContents.numberOfLinks())
                .count();
        return numberOfInvalidCase == 0;
    }

    private int indexOfWinningContentOfPlayer(int playerIndex) {
        return IntStream.range(0, lines.size())
                .reduce(playerIndex, (indexOfColumn, indexOfLine) -> lines.get(indexOfLine)
                        .nextIndexOfColumn(indexOfColumn));
    }
}
