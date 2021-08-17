package step4.outputView;

import step4.domain.ladder.LadderPoint;

import java.util.Arrays;

public enum LadderShape {
    LEFT("LEFT", "--------|\t\t"),
    RIGHT("RIGHT", "\t\t|-------"),
    NONE("NONE", "\t\t|\t\t");

    private final String key;
    private final String shape;

    LadderShape(String key, String shape) {
        this.key = key;
        this.shape = shape;
    }

    public static LadderShape of(LadderPoint ladderPoint) {
        return Arrays.stream(values())
            .filter(ladderShape -> ladderShape.key.equals(ladderPoint.toString()))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("일치하는 모양이 없습니다."));
    }

    @Override
    public String toString() {
        return shape;
    }
}
