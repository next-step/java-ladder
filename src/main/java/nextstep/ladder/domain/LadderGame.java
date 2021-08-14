package nextstep.ladder.domain;

import java.util.stream.IntStream;
import nextstep.ladder.domain.common.GameResults;
import nextstep.ladder.domain.common.Name;
import nextstep.ladder.view.dto.PrintHorizontalLinesDto;
import nextstep.ladder.view.dto.PrintPlayerDto;
import nextstep.ladder.view.dto.PrintPlayersDto;
import nextstep.ladder.view.dto.PrintResultsDto;

public class LadderGame {

    private final Players players;
    private final GameResults gameResults;
    private final HorizontalLines lines;

    private LadderGame(final Players players, final GameResults gameResults, final HorizontalLines lines) {
        IntStream.range(0, players.size())
            .forEach(i -> players.updateResult(i, gameResults.get(lines.move(i))));

        this.players = players;
        this.gameResults = gameResults;
        this.lines = lines;
    }

    public static LadderGame of(final Players players, final GameResults gameResults, final int height) {
        return new LadderGame(players, gameResults, HorizontalLines.of(height, players.size()));
    }

    public PrintPlayerDto getPlayerDto(final Name name) {
        return new PrintPlayerDto(players.getByName(name));
    }

    public PrintPlayersDto getPlayersDto() {
        return new PrintPlayersDto(players);
    }

    public PrintHorizontalLinesDto getLinesDto() {
        return new PrintHorizontalLinesDto(lines);
    }

    public PrintResultsDto getGameResultsDto() {
        return new PrintResultsDto(gameResults);
    }
}
