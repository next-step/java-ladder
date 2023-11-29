package nextstep.ladder.ui;

import nextstep.ladder.domain.*;

import java.util.List;

import static nextstep.ladder.domain.Direction.RIGHT;

public class OutputView {

    private OutputView() {
    }

    private static final String ALL_PARTICIPATNS = "all";
    private static final String WALL = "|";
    private static final String LINE = "-----";
    private static final String BLANK = "     ";

    public static void printParticipants(Names names) {
        System.out.println();
        System.out.println("사다리 결과");
        System.out.println();

        names.names().forEach(System.out::print);
    }

    public static void printLines(Ladder ladder) {
        System.out.println();
        List<Line> lines = ladder.lines();
        lines.forEach(OutputView::printLine);
    }

    private static void printLine(Line line) {
        System.out.print(BLANK);
        line.directions().directions().forEach(direction -> System.out.print(WALL + judgeLineOrBlank(direction)));
        System.out.println();
    }

    private static String judgeLineOrBlank(Direction direction) {
        if (direction == RIGHT) {
            return LINE;
        }
        return BLANK;
    }

    public static void printPrizes(Prizes prizes) {
        prizes.prizes().forEach(System.out::print);
    }

    public static void printLadderResult(String resultName, LadderResult ladderResult) {
        System.out.println();
        System.out.println("실행 결과");
        if (ALL_PARTICIPATNS.equals(resultName)) {
            participantsResult(ladderResult);
            return;
        }

        System.out.println(ladderResult.result(resultName).prize());
    }

    private static void participantsResult(LadderResult ladderResult) {
        ladderResult.results().forEach((name, prize) ->
                System.out.println(name.name() + " : " + prize.prize())
        );
    }
}
