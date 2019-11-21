package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int height;
    private Lines lines;

    public Ladder(int height, int countOfParticipants) {
        this.height = height;
        this.lines = new Lines(height, countOfParticipants);
    }

    public Ladder(String heightInput, int countOfParticipants) {
        try {
            this.height = Integer.parseInt(heightInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 입니다. " + e);
        }
        this.lines = new Lines(height, countOfParticipants);
    }

    public int getHeight() {
        return height;
    }

    public Lines getLines() {
        return lines;
    }

    public int move(int position) {
        return lines.move(position);
    }
}
