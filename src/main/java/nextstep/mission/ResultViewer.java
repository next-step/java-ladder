package nextstep.mission;

import java.util.List;
import java.util.stream.Collectors;

public class ResultViewer {

    public static final String LINE = "-----";
    public static final String NO_LINE = "     ";
    public static final String LINE_SHAPE = "|";

    public static final void showResult(List<Participant> participants, Ladder ladder) {
        System.out.println(participantsToString(participants));

        LadderReader ladderReader = new LadderReader(ladder);
        while (ladderReader.hasNext()) {
            System.out.println(ResultViewer.lineToString(ladderReader.getLine()));
        }
    }

    public static final String participantsToString(List<Participant> participants) {
        return participants.stream()
                .map(participant -> String.format("%6s", participant))
                .collect(Collectors.joining());
    }

    public static final String lineToString(Line line) {
        List<Boolean> points = line.getPoints();
        return points.stream()
                .limit(points.size())
                .map(value -> value ? LINE : NO_LINE)
                .collect(Collectors.joining(LINE_SHAPE)) + LINE_SHAPE;
    }
}