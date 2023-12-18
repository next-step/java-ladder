package nextstep.ladder.view;

import nextstep.ladder.domain.*;

public class ResultView {

    private static final String BLANK = "     ";
    private static final String LINE = "-----";
    private static final String COLUMN = "|";

    private ResultView() { // 인스턴스화 방지
    }

    public static void printParticipantsName(Participants participants) {
        participants.getParticipants().forEach(participant -> System.out.print(String.format("%-8s", participant.getName())));
        enter();
    }
    public static void printLadderWord() {
        System.out.println("사다리 결과");
        enter();
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

    public static void printResultWord() {
        System.out.println("실행결과");
    }

    public static void printResultInfo(ResultInfo resultInfo) {
        resultInfo.getResults().forEach(result -> System.out.print(String.format("%-8s", result)));
        enter();
        enter();
    }

    public static void printResultAll(Participants participants, ResultInfo resultInfo) {
        enter();
        printResultWord();
        for (int i = 0; i < participants.count(); i++) {
            Participant participant = participants.getParticipants().get(i);
            System.out.println(participant.getName()
                    + " : " + resultInfo.getResults().get(participant.getPosition()));
        }
        enter();
    }

    public static void printResultOfParticipant(String result) {
        enter();
        printResultWord();
        System.out.println(result);
        enter();
    }
}
