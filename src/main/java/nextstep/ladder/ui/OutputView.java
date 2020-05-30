package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.PlayerNames;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private static final int DEFAULT_PRINT_NAME_SIZE = 6;
    private PlayerNames playerNames;
    private Ladder ladder;

    public OutputView(PlayerNames playerNames, Ladder ladder) {
        this.playerNames = playerNames;
        this.ladder = ladder;
    }

    public String drawPlayerNames() {
        return playerNames.getPlayerNameValues().stream()
                .map(playerNameValue -> nameSpaceGenerate(playerNameValue) + playerNameValue)
                .collect(Collectors.joining());
    }

    private String nameSpaceGenerate(String playerNameValue) {
        int spaceLength = DEFAULT_PRINT_NAME_SIZE - playerNameValue.length();
        return IntStream.range(0, spaceLength)
                .mapToObj(num -> " ")
                .collect(Collectors.joining());
    }

    public String drawLadder() {
        return ladder.getLines().stream()
                .map(line -> drawLine(line) + System.lineSeparator())
                .collect(Collectors.joining());
    }

    String drawLine(Line line) {
        return line.getPointsValue().stream()
                .map(this::drawPoint)
                .collect(Collectors.joining());
    }

    private String drawPoint(boolean isDraw) {
        String pointResult = IntStream.range(0, playerNames.getMaxNameLength())
                .mapToObj(num -> (isDraw) ? "-" : " ")
                .collect(Collectors.joining());
        return pointResult + "|";
    }
}
