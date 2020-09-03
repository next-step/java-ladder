package nextstep.mission.view;

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

    private final LadderPreset ladderPreset;
    private final LadderMap ladderMap;

    private ResultViewer(LadderPreset ladderPreset) {
        this.ladderPreset = ladderPreset;
        this.ladderMap = LadderMap.make(ladderPreset);
    }

    public static final ResultViewer make(LadderPreset ladderPreset) {
        return new ResultViewer(ladderPreset);
    }

    public final void showLadder() {
        System.out.println(participantsToString(ladderPreset.getParticipants()));

        for (Line line : ladderPreset.getLadder().getLines()) {
            System.out.println(ResultViewer.lineToString(line));
        }

        System.out.println(resultsToString(ladderPreset.getResults()));
    }

    public final void showSelectResult(String target) {
        if (target.equals("all")) {
            System.out.println(selectAllResult(ladderPreset, ladderMap));
            return;
        }
        System.out.println(selectResult(ladderMap, target));
    }

    private static final String selectResult(LadderMap ladderMap, String target) {
        return ladderMap.getResult(target);
    }

    private static final String selectAllResult(LadderPreset ladderPreset, LadderMap ladderMap) {
        Participants participants = ladderPreset.getParticipants();
        return IntStream.range(0, participants.size())
                .mapToObj(position -> participants.get(position) + " : " + selectResult(ladderMap, String.valueOf(participants.get(position))))
                .collect(Collectors.joining("\n"));

    }

    private static final String participantsToString(Participants participants) {
        return IntStream.range(0, participants.size())
                .mapToObj(index -> String.format(OUTPUT_FORMAT, participants.get(index)))
                .collect(Collectors.joining());
    }

    private static final String lineToString(Line line) {
        List<Point> points = line.getPoints();
        return points.stream()
                .limit(points.size())
                .map(value -> value.isLeft() ? LINE : NO_LINE)
                .collect(Collectors.joining(LINE_SHAPE)) + LINE_SHAPE;
    }

    private static final String resultsToString(List<String> results) {
        return IntStream.range(0, results.size())
                .mapToObj(index -> String.format(OUTPUT_FORMAT, results.get(index)))
                .collect(Collectors.joining());
    }
}