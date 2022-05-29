package ladder.domain;

import ladder.pattern.ValueGenerateStrategy;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<LadderLine> ladderLines;

    public Ladder(List<LadderLine> ladderLines) {
        validateLadderLines(ladderLines);
        this.ladderLines = ladderLines;
    }

    private void validateLadderLines(List<LadderLine> ladderLines) {
        if (ladderLines == null) {
            throw new IllegalArgumentException("사다리를 구성하는 라인들은 null 일 수 없습니다.");
        }
    }

    public static Ladder create(int width, int height, ValueGenerateStrategy valueGenerateStrategy) {
        validateHeight(height);
        List<LadderLine> ladderLines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            LadderLine ladderLine = LadderLine.create(width, valueGenerateStrategy);
            ladderLines.add(ladderLine);
        }
        return new Ladder(ladderLines);
    }

    private static void validateHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(String.format("사다리 높이는 최소 1 이상이어야 합니다. 입력 받은 사다리 높이 : %d", height));
        }
    }

    public int finalPosition(int startPosition) {
        int position = startPosition;
        for (LadderLine ladderLine : ladderLines) {
            position = ladderLine.move(position);
        }
        return position;
    }

    public List<LadderLine> ladderLines() {
        return ladderLines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ladder ladder = (Ladder) o;

        return ladderLines.equals(ladder.ladderLines);
    }

    @Override
    public int hashCode() {
        return ladderLines.hashCode();
    }
}
