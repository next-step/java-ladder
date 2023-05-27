package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static final int MIN_LINE_HEIGHT = 1;
    private static final int MIN_LINE_WIDTH = 2;
    private List<Line> lines;

    public Lines() {
        lines = new ArrayList<>();
    }

    public Lines(List<Line> lines) {
        validLineHeight(lines.size());
        lines.stream()
                .forEach(line -> validLineWidth(line.size()));
        this.lines = lines;
    }


    public Lines(LadderHeight ladderHeight, int countOfPerson) {
        validLineHeight(ladderHeight.getHeight());
        validLineWidth(countOfPerson);
        lines = IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> drawLine(countOfPerson))
                .collect(Collectors.toList());
    }

    private void validLineHeight(int height) {
        if (height < MIN_LINE_HEIGHT) {
            throw new IllegalArgumentException("사다리의 최소 높이는 1입니다.");
        }
    }

    private static void validLineWidth(int lines) {
        if (lines < MIN_LINE_WIDTH) {
            throw new IllegalArgumentException("게임 진행을 위한 최소 인원 수는 2명입니다.");
        }
    }

    private Line drawLine(int ladderWidth) {
        return Line.of(ladderWidth);
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
