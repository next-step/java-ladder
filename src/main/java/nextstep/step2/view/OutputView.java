package nextstep.step2.view;

import nextstep.step2.domain.Ladder;
import nextstep.step2.domain.Line;
import nextstep.step2.domain.ParticipantNames;

import java.util.List;

public class OutputView {

    private static final String LADDER_VIEW = "|";
    private static final String LADDER_LINK = "-";
    private static final String LADDER_SPACE = " ";
    private static final int LADDER_WHITE_SPACE_SIZE = 5;
    private static final int NAME_WHITE_SPACE_SIZE = 6;

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
                .forEach(participant -> System.out.print(participant.getName() +
                        LADDER_SPACE.repeat(NAME_WHITE_SPACE_SIZE - participant.getName().length())));
        System.out.println();
    }

    private static void printLadders(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            line.getLinks().stream()
                    .forEach(link -> {
                        if (link.value()) {
                            System.out.print(LADDER_VIEW + LADDER_LINK.repeat(LADDER_WHITE_SPACE_SIZE));
                        } else {
                            System.out.print(LADDER_VIEW + LADDER_SPACE.repeat(LADDER_WHITE_SPACE_SIZE));
                        }
                    });

            System.out.println();
        }
    }
}
