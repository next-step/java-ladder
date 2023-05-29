package nextstep.ladder.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lines {

    private static final int MIN_LINE_HEIGHT = 1;
    private static final int MIN_LINE_WIDTH = 2;
    private final List<Line> lines;

    private final int height;

    public Lines() {
        lines = new ArrayList<>();
        height = lines.size();
    }

    public Lines(List<Line> lines) {
        validLineHeight(lines.size());
        lines.stream()
                .forEach(line -> validLineWidth(line.size()));
        this.lines = lines;
        this.height = lines.size();
    }


    public Lines(LadderHeight ladderHeight, int countOfPerson) {
        validLineHeight(ladderHeight.getHeight());
        validLineWidth(countOfPerson);
        lines = IntStream.range(0, ladderHeight.getHeight())
                .mapToObj(i -> drawLine(countOfPerson))
                .collect(Collectors.toList());
        height = lines.size();
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

    public ResultMap getResult(UserNames userNames, String[] resultNames) {
        if (userNames.count() != resultNames.length) {
            throw new IllegalArgumentException();
        }

        Map<String, String> resultMap = new HashMap<>();
        for (int start = 0; start < userNames.count(); start++) {
            int end = move(start);
            resultMap.put(userNames.userName(start), resultNames[end]);
        }

        return new ResultMap(resultMap);
    }

    private int move(int position) {
        for (int height = 0; height < this.height; height++) {
            position = lines.get(height).movePin(position);
        }
        return position;
    }

    public int size() {
        return lines.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
