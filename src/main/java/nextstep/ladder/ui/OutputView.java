package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.PlayerNames;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final String EMPTY_SPACE = " ";
    private static final String LADDER_HORIZONTAL_LINE = "-";
    private static final String LADDER_POINT_SEPARATOR = "|";

    private PlayerNames playerNames;
    private Ladder ladder;

    public OutputView(PlayerNames playerNames, Ladder ladder) {
        this.playerNames = playerNames;
        this.ladder = ladder;
    }

    public String parsePlayerNames() {
        return playerNames.getPlayerNameValues().stream()
                .map(playerNameValue -> nameSpaceGenerate(playerNameValue) + playerNameValue)
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

    private String parsePoint(boolean isDraw) {
        String pointResult = IntStream.range(0, playerNames.getMaxNameLength())
                .mapToObj(num -> (isDraw) ? LADDER_HORIZONTAL_LINE : EMPTY_SPACE)
                .collect(Collectors.joining());
        return pointResult + LADDER_POINT_SEPARATOR;
    }

    private String nameSpaceGenerate(String playerNameValue) {
        int spaceLength = playerNames.getMaxNameLength() - playerNameValue.length() + 1;
        return IntStream.range(0, spaceLength)
                .mapToObj(num -> EMPTY_SPACE)
                .collect(Collectors.joining());
    }
}
