package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final int LADDER_POINT_COUNT = 5;
    private final String JOINING_SEPARATOR = "  ";
    private static final Map<Boolean, String> LADDER_SEGMENTS = Map.of(
            true, "-".repeat(LADDER_POINT_COUNT),
            false, " ".repeat(LADDER_POINT_COUNT)
    );

    public void printResult(Gamers gamers, Ladder ladder, GameResult gameResult) {
        validateResult(gamers, ladder);
        System.out.println("\n\n실행 결과\n");

        printGamerNames(gamers);
        printLadder(ladder);
        printGameResult(gameResult);
    }

    private void printGameResult(GameResult gameResult) {
        System.out.println(gameResult.getResults().stream().collect(Collectors.joining(JOINING_SEPARATOR)));
    }

    private void printLadder(Ladder ladder) {
        ladder.getLines().forEach(this::printLadderLine);
    }

    private void printGamerNames(Gamers gamers) {
        System.out.println(gamers.getGamerNames().stream().collect(Collectors.joining(JOINING_SEPARATOR)));
    }

    private void validateResult(Gamers gamers, Ladder ladder) {
        if (gamers.getCountOfPerson() == 0 || ladder.getLines().isEmpty()) {
            throw new IllegalArgumentException("결과를 출력할 수 없습니다. 참가자 또는 사다리 정보가 없습니다.");
        }
    }

    private static void printLadderSegment(Point point) {
        System.out.print(LADDER_SEGMENTS.get(point.getValue()) + "|");
    }

    private void printLadderLine(Line line) {
        System.out.print("    |");
        line.getPoints().forEach(ResultView::printLadderSegment);
        System.out.println();
    }
}
