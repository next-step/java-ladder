package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderResult;
import ladder.domain.Point;

import java.util.List;

public class OutputView {
    private static final String BLANK = " ";
    private static final String UNIT_HORIZONTAL_LINE = "-";
    private static final String UNIT_VERTICAL_LINE = "|";
    private static final String VIEW_LADDER_GUIDE = "\n사다리 결과\n";
    private static final String VIEW_RESULT_GUIDE = "\n실행 결과";
    private static final String ALL_VIEW_RESULT_FORMAT = "%s : %s";
    private static final String RESCAN_COMMAND_GUIDE = "\n해당 사람은 참가자가 아닙니다. 다시 입력 해주세요.";

    private OutputView() {
    }

    public static void printResultGuide() {
        System.out.println(VIEW_LADDER_GUIDE);
    }

    public static void printParticipants(List<String> participantNames, int maxConnectionLineLength) {
        participantNames.forEach(name -> System.out.print(name + BLANK.repeat(maxConnectionLineLength - name.length())));
        System.out.println();
    }

    public static void printScores(List<String> scores, int maxConnectionLineLength) {
        scores.forEach(score -> System.out.print(score + BLANK.repeat(maxConnectionLineLength - score.length())));
        System.out.println();
    }

    public static void printLine(List<Point> points, int maxConnectionLineLength) {
        points.stream().forEach(point -> {
            if (point.isLast(points.size())) {
                System.out.println(UNIT_VERTICAL_LINE);
                return;
            }
            if (point.isStraight() || point.isLeft()) {
                System.out.print(UNIT_VERTICAL_LINE + BLANK.repeat(maxConnectionLineLength));
                return;
            }
            if (point.isRight()) {
                System.out.print(UNIT_VERTICAL_LINE + UNIT_HORIZONTAL_LINE.repeat(maxConnectionLineLength));
                return;
            }
        });
        System.out.println();
    }

    public static void printLadder(Ladder ladder, int maxConnectionLineLength) {
        ladder.lines().forEach(line -> printLine(line.points(), maxConnectionLineLength));
    }

    public static void printResultView(String command, LadderResult ladderResult) {
        System.out.println(VIEW_RESULT_GUIDE);
        System.out.println(ladderResult.getScore(command));
    }

    public static void printAllResultView(LadderResult ladderResult) {
        System.out.println(VIEW_RESULT_GUIDE);
        ladderResult.ladderResults().forEach((participant, score) -> System.out.println(String.format(ALL_VIEW_RESULT_FORMAT, participant.name(), score.score())));
    }

    public static void printReScanCommand() {
        System.out.println(RESCAN_COMMAND_GUIDE);
    }
}
