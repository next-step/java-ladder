package nextstep.step2.view;

import nextstep.step2.domain.Ladders;
import nextstep.step2.domain.ParticipantNames;

public class OutputView {

    private static final String LADDER_VIEW = "|";
    private static final String LETTER_SPACE = "      ";

    public static void printParticipantNamesNotification() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요.)");
    }

    public static void printLadderHeightNotification() {
        System.out.println();
        System.out.println("최대 사다리 높이는 몇 개인가요?");
    }

    public static void printGameResult(Ladders ladders) {
        System.out.println("실행결과");

        printNames(ladders);
        printLadders(ladders);
    }

    private static void printNames(Ladders ladders) {
        ParticipantNames participantNames = ladders.getParticipantNames();

        participantNames.getParticipantNames()
                .stream()
                .forEach(participant -> System.out.print(participant.getName() + LETTER_SPACE));
        System.out.println();
    }

    private static void printLadders(Ladders ladders) {
        for (int i = 0; i < ladders.getLadders().get(0).getHeight(); i++) {
            ladders.getLadders()
                    .stream()
                    .forEach(ladder -> System.out.print((LADDER_VIEW + LETTER_SPACE)));
            System.out.println();
        }
    }
}
