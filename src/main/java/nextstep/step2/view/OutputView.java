package nextstep.step2.view;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;
import nextstep.step2.domain.ParticipantNames;

import java.util.List;

public class OutputView {

    private static final String LADDER_VIEW = "|";
    private static final String LADDER_LINK = "-----";
    private static final String LADDER_SPACE = "     ";

    public static void printParticipantNamesNotification() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
    }

    public static void printLadderHeightNotification() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printGameResult(Ladder ladder) {
        System.out.println("실행결과");

        printNames(ladder);
        printLadders(ladder);
    }

    private static void printNames(Ladder ladder) {
        ParticipantNames participantNames = ladder.getParticipantNames();

        participantNames.getParticipantNames()
                .stream()
                .forEach(participant -> System.out.print(participant.getName() + LADDER_SPACE));
        System.out.println();
    }

    private static void printLadders(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            line.getPoints().stream()
                    .forEach(point -> {
                        if (point.value()) {
                            System.out.print(LADDER_VIEW + LADDER_LINK);
                        } else {
                            System.out.print(LADDER_VIEW + LADDER_SPACE);
                        }
                    });

            System.out.println();
        }
    }
}
