package step2.domain;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private static final int LINE_START_INDEX = 0;

    private int height;
    private ArrayList<Line> lines = new ArrayList<>();

    public Ladder(int height, int countOfParticipants) {
        this.height = height;
        makeLines(countOfParticipants);
    }

    public Ladder(String heightInput, int countOfParticipants) {
        try {
            height = Integer.parseInt(heightInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다. " + e);
        }
        makeLines(countOfParticipants);
    }

    private void makeLines(int countOfParticipants) {
        this.lines = (ArrayList<Line>) IntStream.range(LINE_START_INDEX, height)
                .mapToObj(index -> new Line(index, countOfParticipants))
                .collect(Collectors.toList());
    }

    public int getHeight() {
        return height;
    }

    public int getLinesSize() {
        return lines.size();
    }

    public ArrayList<Line> getLines() {
        return lines;
    }
}
