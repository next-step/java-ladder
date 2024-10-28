package nextstep.ladder.view;

import nextstep.ladder.model.*;

import java.util.Map;
import java.util.stream.Collectors;

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

    private void printGamerNames(Gamers gamers) {
        System.out.println(gamers.getGamerNames().stream().collect(Collectors.joining(JOINING_SEPARATOR)));
    }

    private void printLadder(Ladder ladder) {
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

    public void printGamerResult(GamerResult gamerResult, String gamer) {
        String result = gamerResult.getResultByName(gamer);

        System.out.println("실행 결과");

        if (gamer.equals("all")) {
            gamerResult.getResults().forEach((key, value) -> {
                System.out.println(key + " : " + value);
            });
            return;
        }

        if (gamer == null || gamer.isEmpty() || result == null || result.isEmpty()) {
            System.out.println("잘못된 이름입니다. 다시 입력 해주세요.");
            return;
        }

        System.out.println(result);
    }

    public void printGameOver() {
        System.out.println("사다리 게임을 종료합니다.");
    }
}
