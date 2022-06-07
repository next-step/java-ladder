package nextstep.ladder.domain;

import nextstep.ladder.exceptions.OutOfLadderSizeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private final List<Line> lines;

    public Lines(int height, int numberOfParticipants) {
        this.lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            this.lines.add(new Line(numberOfParticipants));
        }
    }

    public boolean lines(int row, int column) {
        if (row < 0
                || row >= this.height()
                || column < 0
                || column >= this.numberOfParticipants() - 1) {
            throw new OutOfLadderSizeException("사다리 범위를 넘는 값 조회입니다.");
        }
        return this.lines.get(row).points().get(column).linked();
    }

    public List<Line> value() {
        return Collections.unmodifiableList(lines);
    }

    public int height() {
        return this.lines.size();
    }

    public int numberOfParticipants() {
        return this.lines.get(0).numberOfParticipants();
    }

}
