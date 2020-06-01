package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Players;
import nextstep.ladder.domain.Point;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String EMPTY_SPACE = " ";
    private static final String LADDER_HORIZONTAL_LINE = "-";
    private static final String LADDER_POINT_SEPARATOR = "|";

    private Players players;
    private Ladder ladder;

    public OutputView(Players players, Ladder ladder) {
        this.players = players;
        this.ladder = ladder;
    }

    public String parsePlayerNames() {
        return players.getPlayerNameValues().stream()
                .map(playerNameValue -> generateNameSpace(playerNameValue) + playerNameValue)
                .collect(Collectors.joining());
    }

    public String parseLadder() {
        return ladder.getLines().stream()
                .map(line -> parseLine(line) + System.lineSeparator())
                .collect(Collectors.joining());
    }

    String parseLine(Line line) {
        return line.getPointsValue().stream()
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
