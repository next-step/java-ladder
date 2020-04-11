package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.Line;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final int FIRST = 1;
    private static final String LADDER_LINE_MARKER = "|";
    private static final String LINE_MARKER = "-";
    private static final String BLANK_MARKER = " ";
    private static final String CARRIAGE_RETURN = "\n";

    private final List<String> participants;
    private final int maxNameLength;

    public ResultView(List<String> participants) {
        this.participants = participants;
        this.maxNameLength = getMaxNameLength();
    }

    public void print(Ladder ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<LadderLine> targetLadder = ladder.getLadder();
        long height = targetLadder.stream()
                .map(LadderLine::getLines)
                .count();
        for (int i = 0; i < height; i++) {
            stringBuilder.append(drawByHeight(i, ladder.getLadder()))
                    .append(CARRIAGE_RETURN);
        }
        System.out.println(stringBuilder.toString());
    }

    private String drawByHeight(int height, List<LadderLine> ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> linesAtSameHeight = ladder.stream()
                .map(LadderLine::getLines)
                .flatMap(Collection::stream)
                .filter(line -> line.getHeight() == height)
                .collect(Collectors.toList());
        for (Line line : linesAtSameHeight) {
            stringBuilder.append(LADDER_LINE_MARKER);
            stringBuilder.append(markLine(line));
        }
        return stringBuilder.toString();
    }

    private int getMaxNameLength() {
        return participants.stream().max(Comparator.comparing(String::length))
                .orElseThrow(IllegalArgumentException::new)
                .length();
    }

    private String markLine(Line line) {
        if (line.isLink()) {
            return draw(LINE_MARKER);
        }
        return draw(BLANK_MARKER);
    }

    public String draw(String marker) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < maxNameLength; i++) {
            stringBuilder.append(marker);
        }
        return stringBuilder.toString();
    }
}
