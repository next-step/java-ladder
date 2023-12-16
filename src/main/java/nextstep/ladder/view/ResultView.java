package nextstep.ladder.view;

import nextstep.ladder.domain.Ladder;
import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Participants;
import nextstep.ladder.domain.ResultInfo;

public class ResultView {

    private static final String BLANK = "     ";
    private static final String LINE = "-----";
    private static final String COLUMN = "|";

    private ResultView() { // 인스턴스화 방지
    }

    public static void printResultWord() {
        System.out.println("실행결과");
        System.out.println();
    }

    public static void printParticipantsName(Participants participants) {
        participants.getParticipants().forEach(participant -> System.out.print(String.format("%-8s", participant.getName())));
        System.out.println();
    }

    public static void printLadder(Ladder ladder) {
        ladder.getLines().forEach(line -> {
            printPoints(line);
            System.out.println();
        });
    }

    private static void printPoints(Line line) {
        line.getPoints().forEach(point -> {
            System.out.print(point.getCurrent() ? LINE : BLANK);
            System.out.print(COLUMN);
        });
    }

    public static void enter() {
        System.out.println();
    }

    public static void printResultInfo(ResultInfo resultInfo) {
        resultInfo.getResult().forEach(result -> System.out.print(String.format("%-8s", result)));
    }
}
