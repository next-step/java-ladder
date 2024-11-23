package nextstep.ladder.view;

import nextstep.ladder.config.Const;
import nextstep.ladder.domain.Lines;
import nextstep.ladder.domain.Participants;

import java.util.HashMap;
import java.util.Map;

public class OutputView {

    public static final Map<Boolean, String> POINTS_LINE = new HashMap<>();

    static {
        POINTS_LINE.put(true, outputLineTrue());
        POINTS_LINE.put(false, outputLineFalse());
    }

    public void outputResult(Participants participants, Lines lines) {
        outputParticipants(participants);

        System.out.println();

        lines.getLines().forEach(line -> {
            line.getPoints().forEach(points -> System.out.print(POINTS_LINE.get(points)));
            System.out.println("|");
        });
    }

    private void outputParticipants(Participants participants) {
        participants.getParticipants().forEach(participant -> System.out.print(participant.toString() + " "));
    }

    public static String outputLineTrue() {
        StringBuilder outputLine = new StringBuilder("|");
        for (int i = 0; i < Const.MAX_NAME_LENGTH; i++) {
            outputLine.append("-");
        }
        return outputLine.toString();
    }

    public static String outputLineFalse() {
        StringBuilder outputLine = new StringBuilder("|");
        for (int i = 0; i < Const.MAX_NAME_LENGTH; i++) {
            outputLine.append(" ");
        }
        return outputLine.toString();
    }
}
