package ladder.view;

import java.util.List;
import java.util.stream.Collectors;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Participant;
import ladder.domain.Participants;

public class OutputView {

    private static final String SPACE = " ";
    private static final String FIRST_SPACE = "    ";
    private static final String BRIDGE_EXIST = "-----";
    private static final String BRIDGE_NOT_EXIST = "     ";
    private static final String LADDER_BAR = "|";

    public static void print(Participants participants, Ladder ladder) {
        System.out.println("실행결과\n");
        participants.getParticipants().forEach(name -> System.out.print(nameFormatting(name.getName())));

        System.out.println();
        printLadder(ladder.getLines());

    }

    private static String nameFormatting(String name) {
        return String.format("%5s", name) + SPACE;
    }

    private static void printLadder(List<Line> lines) {
        for (Line line : lines) {
            System.out.println(FIRST_SPACE + printLine(line));
        }
    }

    private static String printLine(Line line) {
        return line.getPoints().stream().map(predict -> predict ? BRIDGE_EXIST : BRIDGE_NOT_EXIST)
                .collect(Collectors.joining(LADDER_BAR, LADDER_BAR, LADDER_BAR));

    }

}
