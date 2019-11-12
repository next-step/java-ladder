package step2.domain;

import java.util.ArrayList;

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
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다. " + e);
        }
        makeLines(countOfParticipants);
    }

    private void makeLines(int countOfParticipants) {
        for (int index = LINE_START_INDEX; index < height; index++) {
            lines.add(new Line(index, countOfParticipants));
        }
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
