package nextstep.ladder.ui;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.PlayerNames;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    private PlayerNames playerNames;
    private Ladder ladder;

    public OutputView(PlayerNames playerNames, Ladder ladder) {
        this.playerNames = playerNames;
        this.ladder = ladder;
    }

    public String drawPlayerNames() {
        return playerNames.getPlayerNameValues().stream()
                .map(playerNameValue -> {
                    int defaultDivideSize = 6;
                    int spaceLength = defaultDivideSize - playerNameValue.length();
                    String spaces = IntStream.range(0, spaceLength)
                            .mapToObj(num -> " ")
                            .collect(Collectors.joining());

                    return spaces + playerNameValue;
                })
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
