package nextstep.ladder.domain;

import java.util.Objects;

public class LadderLayer {
    private static final String EXCEPTION_MESSAGE_MIN_LAYER = "사다리 높이가 1보다 작은 수 입니다.";
    private static final int MIN_INPUT_NUMBER = 1;

    private final int layer;

    public LadderLayer(int layer) {
        validateLayer(layer);
        this.layer = layer;
    }

    private void validateLayer(int layer) {
        if (layer < MIN_INPUT_NUMBER) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_LAYER);
        }
    }

    public int getLayer() {
        return layer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderLayer that = (LadderLayer) o;
        return layer == that.layer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(layer);
    }
}
