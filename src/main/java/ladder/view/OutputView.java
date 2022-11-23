package ladder.view;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participant;
import ladder.domain.Participants;
import ladder.domain.Point;
import ladder.domain.Prize;
import ladder.domain.Prizes;

public class OutputView {

    private final static String POINT = "|";
    private final static String LINK = "-----";
    private final static String UNLINK = "     ";
    private final static String ALL = "all";
    private final static int PLACE = 5;
    private final static StringBuilder STRING_BUILDER = new StringBuilder();

    private OutputView() {
    }

    public static void printLadderResult(final Participants participants, final Ladder ladder, final Prizes prizes) {
        System.out.println("\n사다리 결과");
        printParticipants(participants.getValue());
        System.out.println();
        ladder.getLines().forEach(OutputView::printLine);
        printPrizes(prizes.getValue());
        System.out.println();
    }

    private static void printParticipants(final List<Participant> participants) {
        participants.forEach(p -> {
            System.out.print(" ".repeat(PLACE - p.toString().length()));
            System.out.print(p + " ");
        });
    }

    private static void printLine(final Line line) {
        STRING_BUILDER.setLength(0);
        STRING_BUILDER.append("\t\t");
        line.getAllIsLinked().forEach(linked -> {
            STRING_BUILDER.append(POINT);
            STRING_BUILDER.append(checkLinked(linked));
        });
        System.out.println(STRING_BUILDER);
    }

    private static String checkLinked(final boolean linked) {
        if (linked) {
            return LINK;
        }

        return UNLINK;
    }

    private static void printPrizes(final List<Prize> prizes) {
        prizes.forEach(p -> {
            System.out.print(" ".repeat(PLACE - p.toString().length()));
            System.out.print(p + " ");
        });
    }

    public static void printGameResult(final String name, final Participants participants, final Prizes prizes) {
        System.out.println("\n실행 결과");
        if (ALL.equals(name)) {
            printAllGameResult(participants, prizes);
            return;
        }

        Participant participant = participants.findByName(name);
        printParticipantResult(participant, prizes.find(participant.getPosition()));
    }

    private static void printAllGameResult(final Participants participants, final Prizes prizes) {
        participants.getValue().forEach(participant -> {
            printParticipantResult(participant, prizes.find(participant.getPosition()));
        });
    }

    private static void printParticipantResult(final Participant participant, final Prize prize) {
        System.out.printf("%s : %s", participant, prize);
        System.out.println();
    }
}
