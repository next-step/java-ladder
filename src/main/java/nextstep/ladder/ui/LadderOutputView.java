package nextstep.ladder.ui;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.player.Players;
import nextstep.ladder.domain.ladder.Point;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LadderOutputView {
    private static final String EMPTY_SPACE = " ";
    private static final String LADDER_HORIZONTAL_LINE = "-";
    private static final String LADDER_POINT_SEPARATOR = "|";

    private Players players;
    private Ladder ladder;

    public LadderOutputView(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public String parsePlayerNames() {
        return players.getPlayerNameValues().stream()
                .map(playerNameValue -> generateNameSpace(playerNameValue) + playerNameValue)
                .collect(Collectors.joining());
    }

    public String parseLadder() {
        String ladderValue = this.ladder.getLines().stream()
                .map(line -> parseLine(line) + System.lineSeparator())
                .collect(Collectors.joining());
        return ladderValue.substring(0, ladderValue.length() - 1);
    }

    String parseLine(Line line) {
        return line.getPoints().stream()
                .map(this::parsePoint)
                .collect(Collectors.joining());
    }

    private String parsePoint(Point isDraw) {
        String pointResult = IntStream.range(0, players.getMaxNameLength())
                .mapToObj(num -> (isDraw.getValue()) ? LADDER_HORIZONTAL_LINE : EMPTY_SPACE)
                .collect(Collectors.joining());
        return pointResult + LADDER_POINT_SEPARATOR;
    }

    private String generateNameSpace(String playerNameValue) {
        int spaceLength = players.getMaxNameLength() - playerNameValue.length() + 1;
        return IntStream.range(0, spaceLength)
                .mapToObj(num -> EMPTY_SPACE)
                .collect(Collectors.joining());
    }
}
