package ladder.view;

import ladder.domain.Line;
import ladder.domain.Participant;

import java.util.List;

public class ResultView {

    private final static String SPACE_TEXT = " ";
    private final static int DEFAULT_NAME_SPACE_COUNT = 6;
    private final static String LINE_WITH_BRIDGE = "-----|";
    private final static String LINE_WITH_NO_BRIDGE = "     |";

    public void printParticipants(List<Participant> participants) {
        participants.stream()
                .map(name -> SPACE_TEXT.repeat(DEFAULT_NAME_SPACE_COUNT - name.getNameSize()) + name)
                .forEach(System.out::print);
        System.out.println();
    }

    public void printLadder(List<Line> lines) {
        lines.forEach(this::printLine);
    }

    private void printLine(Line line) {
        line.getPoints()
                .forEach(point -> {
                    String result = LINE_WITH_NO_BRIDGE;
                    if (point) {
                        result = LINE_WITH_BRIDGE;
                    }
                    System.out.print(result);
                });
        System.out.println();
    }
}
