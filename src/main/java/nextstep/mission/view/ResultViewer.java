package nextstep.mission.view;

import nextstep.mission.domain.Ladder;
import nextstep.mission.domain.Line;
import nextstep.mission.domain.Participants;
import nextstep.mission.domain.Point;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultViewer {

    public static final String LINE = "-----";
    public static final String NO_LINE = "     ";
    public static final String LINE_SHAPE = "|";
    public static final String OUTPUT_FORMAT = "%6s";

    public static final void showLadder(Participants participants, Ladder ladder, List<String> results) {
        System.out.println(participantsToString(participants));

        for (Line line : ladder.getLines()) {
            System.out.println(ResultViewer.lineToString(line));
        }

        System.out.println(resultsToString(results));
    }

    public static final void showSelectResult(Participants participants, Ladder ladder, List<String> results, String target) {
        if (target.equals("all")) {
            showResultAll(participants, ladder, results);
            return;
        }
        showResult(ladder, results, target);
    }

    public static final void showResult(Ladder ladder, List<String> results, String target) {
        System.out.println(selectResult(ladder, results, target));
    }

    public static final String selectResult(Ladder ladder, List<String> results, String target) {
        return results.get(ladder.getResult(target));
    }

    public static final void showResultAll(Participants participants, Ladder ladder, List<String> results) {
        System.out.println(selectAllResult(participants, ladder, results));
    }

    public static final String selectAllResult(Participants participants, Ladder ladder, List<String> results) {
        return IntStream.range(0, participants.size())
                .mapToObj(position -> participants.get(position) + " : " + selectResult(ladder, results, String.valueOf(participants.get(position))))
                .collect(Collectors.joining("\n"));

    }

    public static final String participantsToString(Participants participants) {
        return IntStream.range(0, participants.size())
                .mapToObj(index -> String.format(OUTPUT_FORMAT, participants.get(index)))
                .collect(Collectors.joining());
    }

    public static final String resultsToString(List<String> results) {
        return IntStream.range(0, results.size())
                .mapToObj(index -> String.format(OUTPUT_FORMAT, results.get(index)))
                .collect(Collectors.joining());
    }


    public static final String lineToString(Line line) {
        List<Point> points = line.getPoints();
        return points.stream()
                .limit(points.size())
                .map(value -> value.toBoolean() ? LINE : NO_LINE)
                .collect(Collectors.joining(LINE_SHAPE)) + LINE_SHAPE;
    }
}