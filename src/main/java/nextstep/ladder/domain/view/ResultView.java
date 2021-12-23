package nextstep.ladder.domain.view;

import nextstep.ladder.domain.ladder.Ladder;
import nextstep.ladder.domain.ladder.Line;
import nextstep.ladder.domain.participant.Participants;

public class ResultView {
    public static final String RESULT_MESSAGE = "실행 결과";
    public static final String NEW_LINE = "\n";
    public static final String TAB = "\t";
    public static final String END = "|";

    public static void result(Participants participants, Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RESULT_MESSAGE).append(NEW_LINE).append(NEW_LINE);

        participants.values()
                .forEach(participant -> stringBuilder
                        .append(participant.name())
                        .append(TAB)
                );

        stringBuilder.append(NEW_LINE);

        for (Line line : ladder.lines()) {
            String image = Image.ladderLine(line.points());
            stringBuilder.append(TAB).append(image).append(END).append(NEW_LINE);
        }

        System.out.println(stringBuilder);
    }
}
