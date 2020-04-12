package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderLine;
import ladder.domain.Line;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ResultView {
    private static final int ZERO = 0;
    private static final int FIRST = 1;
    private static final String LADDER_LINE_MARKER = "|";
    private static final String LINE_MARKER = "-";
    private static final String BLANK_MARKER = " ";
    private static final String NULL_BLANK = "";
    private static final String CARRIAGE_RETURN = "\n";

    private final List<String> participants;
    private final int maxNameLength;

    public ResultView(List<String> participants) {
        this.participants = participants;
        this.maxNameLength = getMaxNameLength();
    }

    public void print(Ladder ladder) {
        long height = getHeight(ladder.getLadder());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(alignNameSpace());
        for (int i = 0; i < height; i++) {
            stringBuilder.append(drawByHeight(i, ladder.getLadder()))
                    .append(CARRIAGE_RETURN);
        }
        System.out.println(stringBuilder.toString());
    }

    private String alignNameSpace() {
        StringBuilder stringBuilder = new StringBuilder();
        String firstName = participants.get(ZERO);
        stringBuilder.append(String.format("%-" + maxNameLength + "s", firstName))
                .append(BLANK_MARKER);
        int countOfPerson = participants.size();
        for (int i = FIRST; i < countOfPerson; i++) {
            String name = participants.get(i);
            stringBuilder.append(String.format("%" + maxNameLength + "s", name))
                    .append(BLANK_MARKER);
        }
        return stringBuilder.append(CARRIAGE_RETURN)
                .toString();
    }

    private long getHeight(List<LadderLine> targetLadder) {
        return targetLadder.get(ZERO)
                .getLines().size();
    }

    private String drawByHeight(int height, List<LadderLine> ladder) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Line> linesAtSameHeight = getLinesAtSameHeight(height, ladder);
        stringBuilder.append(spaceAppend());
        for (Line line : linesAtSameHeight) {
            stringBuilder.append(LADDER_LINE_MARKER);
            stringBuilder.append(markLine(line));
        }
        return stringBuilder.toString();
    }

    private List<Line> getLinesAtSameHeight(int height, List<LadderLine> ladder) {
        return ladder.stream()
                .map(LadderLine::getLines)
                .flatMap(Collection::stream)
                .filter(line -> line.getHeight() == height)
                .collect(toList());
    }

    private String spaceAppend() {
        StringBuilder stringBuilder = new StringBuilder();
        int spaceLength = Math.subtractExact(maxNameLength, FIRST);
        for (int i = 0; i < spaceLength; i++) {
            stringBuilder.append(BLANK_MARKER);
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
