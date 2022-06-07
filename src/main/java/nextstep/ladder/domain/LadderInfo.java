package nextstep.ladder.domain;

import nextstep.ladder.exceptions.OutOfLadderSizeException;

public class LadderInfo {

    private final Lines lines;

    private final int height;

    private final int numberOfParticipants;

    public LadderInfo(int height, int numberOfParticipants) {
        this.height = height;
        this.numberOfParticipants = numberOfParticipants;
        this.lines = new Lines(height, numberOfParticipants);
    }

    public boolean lines(int row, int column) {
        if (row < 0
                || row >= height
                || column < 0
                || column >= numberOfParticipants - 1) {
            throw new OutOfLadderSizeException("사다리 범위를 넘는 값 조회입니다.");
        }
        return this.lines.value().get(row).points().get(column).linked();
    }

    public int height() {
        return height;
    }

    public int numberOfParticipants() {
        return numberOfParticipants;
    }
}
