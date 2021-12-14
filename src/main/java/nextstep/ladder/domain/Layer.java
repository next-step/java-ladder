package nextstep.ladder.domain;

import java.util.Objects;

public class Layer {
    private static final String EXCEPTION_MESSAGE_MIN_TRY_ROUND = "시도 횟수가 1보다 작은 수 입니다.";
    private static final int MIN_INPUT_NUMBER = 1;
    private static final int START_LAYER = 1;

    private final int layer;
    private int nowLayer;

    public Layer(int layer) {
        this(layer, START_LAYER);
    }

    public Layer(int layer, int nowLayer) {
        if (MIN_INPUT_NUMBER > nowLayer) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_MIN_TRY_ROUND);
        }
        this.layer = layer;
        this.nowLayer = nowLayer;
    }

    public void nextLayer() {
        nowLayer++;
    }

    public boolean moreLayer() {
        return layer >= nowLayer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layer layer1 = (Layer) o;
        return layer == layer1.layer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(layer);
    }
}
