package nextstep.ladder.view;

import nextstep.ladder.model.Gamers;
import nextstep.ladder.model.Ladder;
import nextstep.ladder.model.Line;
import nextstep.ladder.model.Point;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {
    private static final int LADDER_POINT_COUNT = 5;
    private final String JOINING_SEPARATOR = "  ,   ";
    private static final Map<Boolean, String> LADDER_SEGMENTS = Map.of(
            true, "-".repeat(LADDER_POINT_COUNT),
            false, " ".repeat(LADDER_POINT_COUNT)
    );

    public void printResult(Gamers gamers, Ladder ladder) {
        validateResult(gamers, ladder);
        System.out.println("\n\n실행 결과\n");
        System.out.println(gamers.getGamerNames().stream().collect(Collectors.joining(JOINING_SEPARATOR)));
        System.out.println();
        ladder.getLines().forEach(this::printLadderLine);
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
        System.out.print("|");
        line.getPoints().forEach(ResultView::printLadderSegment);
        System.out.println();
    }
}
