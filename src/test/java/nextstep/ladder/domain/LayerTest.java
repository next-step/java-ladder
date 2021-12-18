package nextstep.ladder.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LayerTest {
    @Test
    void 생성자_비교() {
        Layer layer = new Layer(5, 1);
        assertThat(layer).isEqualTo(new Layer(5));
    }

    @ParameterizedTest(name="{displayName} | 요청값: {0}")
    @ValueSource(ints = {-1, 0})
    void 최소보다_낮은_생성자(int param) {
        assertThatThrownBy(() -> {
            new Layer(param);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다음층_비교() {
        Layer layer = new Layer(5, 2);
        layer.nextLayer();
        assertThat(layer.moreLayer()).isTrue();
    }

    @Test
    void 마지막층_비교() {
        Layer layer = new Layer(5, 5);
        layer.nextLayer();
        assertThat(layer.moreLayer()).isFalse();
    }
}
