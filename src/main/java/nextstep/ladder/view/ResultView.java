package nextstep.ladder.view;

import nextstep.ladder.domain.Line;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static final String LADDER_RESULT = "\n실행결과";
    public static final String LADDER_START = "     |";
    public static final String LADDER_EXIST = "-----|";
    public static final String LADDER_NONE_EXIST = "     |";

    private ResultView() {
    }

    public static void printLadder(Participants participants, Lines lines) {
        printPartiPant(participants);
        printLadder(lines);
    }

    private static void printPartiPant(Participants participants) {
        System.out.println(LADDER_RESULT);
        participants.stream()
                .forEach(participant ->
                        System.out.printf("%5s ", participant.getName())
                );
        System.out.println();
    }

    private static void printLadder(Lines lines) {
        List<Line> listLine = lines.stream()
                .collect(Collectors.toList());

        for (Line line : listLine) {
            StringBuilder sb = new StringBuilder();

            sb.append(LADDER_START);
            line.stream().forEach(ladder -> {
                if (ladder == true) {
                    sb.append(LADDER_EXIST);
                    return;
                }
                sb.append(LADDER_NONE_EXIST);
            });
            System.out.println(sb.toString());
        }
    }
}
