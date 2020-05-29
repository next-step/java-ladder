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

    public String drawLine(Line line) {
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
